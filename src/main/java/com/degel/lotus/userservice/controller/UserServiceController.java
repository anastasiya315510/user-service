/*
 author Anastasiya
 created on 22/09/2021
 */


package com.degel.lotus.userservice.controller;

import com.degel.lotus.userservice.dto.UserDTO;
import com.degel.lotus.userservice.entity.Role;
import com.degel.lotus.userservice.entity.User;
import com.degel.lotus.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



@RestController
@Slf4j
public class UserServiceController {
   @Autowired
   UserService userhandler;


    @PostMapping("/register")
    public boolean addNewUser(@RequestBody UserDTO user) {

        if(isUserValid(user)) {
            log.info(user.toString() + " user valid " + this.getClass().getName());
            userhandler.addNewUser(user);
            return true;
        }
            return false;
    }




    @PutMapping("/user/update")
    public String updateUser(@RequestBody UserDTO user){
        if(user==null) return "You should pass the field, that you want to update";
        else{
            userhandler.updateUser(user);
            return "Succeeded";
        }
    }

    @DeleteMapping("/user/delete/{email}")
    public void deleteUser(@PathVariable("email") String email){
        if(email.isBlank()) {
            log.error("email is blank");
            return;
        }
        log.info(this.getClass().getSimpleName()+" method deleteUser "+email);
        userhandler.deleteUser(email);
    }


    @GetMapping("/user/findByEmail/{email}")
    public List<User> findByEmail(@PathVariable("email") String email){
        if(email.isBlank()) {
            log.error(this.getClass().getSimpleName()+" method findByEmail, email: is Blank! -"+email);
            return new ArrayList<>();
        }
        log.info(this.getClass().getSimpleName()+" method findByEmail, email: "+email);
        return userhandler.findByEmail(email);
    }

    @GetMapping("/user/findByPhone/{phone}")
    public List<User> findByPhone(@PathVariable("phone") String phone){
        if(phone.isBlank()) {
            log.error(this.getClass().getSimpleName()+" method findByPhone, phone: is Blank! -"+phone);
            return new ArrayList<>();
        }
        log.info(this.getClass().getSimpleName()+" method findByPhone, phone: "+phone);
        return userhandler.findByPhone(phone);
    }

    private boolean isUserValid(UserDTO user) {

            if (user == null) {
                log.error("User is null");
                return false;
            }
            else if (user.getLastName().isBlank()) {
                log.error("The field 'lastname' cannot be empty");
                return false;

            }
            else if (user.getEmail().isBlank()) {
                log.error("The field 'email' cannot be empty");
                return false;

            }
            else if (user.getPhoneNumber().isBlank()){
                log.error("The field 'phone' cannot be empty");
                return false;

            }
            else if (user.getUserName().isBlank()){
                log.error("The field 'name' cannot be empty");
                return false;

            }
            else if (checkIfPhoneIsValid(user.getPhoneNumber())){
                log.error("The telephone should contains just 9 numbers");
                return false;

            }
            else if (checkIfMailAlreadyExists(user.getEmail())){
                log.error("Mail already exists");
                return false;
            }
        return true;
    }


    private boolean checkIfPhoneIsValid(String phoneNumber) {
        Pattern pattern = Pattern.compile("^\\d{9}$");
        Matcher matcher = pattern.matcher(phoneNumber);

        log.info("Phone is correct: "+matcher.matches());

       return matcher.matches();
    }

    private boolean checkIfMailAlreadyExists(String email) {
        return findByEmail(email).size()>0;
    }
}
