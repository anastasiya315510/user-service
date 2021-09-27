/*
 author Anastasiya
 created on 26/09/2021
 */


package com.degel.lotus.userservice.controller;

import com.degel.lotus.userservice.entity.User;
import com.degel.lotus.userservice.repo.UserRepository;
import com.degel.lotus.userservice.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private AdminService adminService;


    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PutMapping("/update/{role}")
    public User updateUserRole(@RequestParam String email, @PathVariable("role") String role){
        if(email.isBlank() || role.isBlank()) {
            log.error(this.getClass().getSimpleName()+" method findByEmail, email: is Blank! -"+email);
        }

        log.info(this.getClass().getSimpleName()+"  method findByEmail and updateUserRole, email: "+email);

        return  adminService.updateUserRole(email, role);
    }
}
