/*
 author Anastasiya
 created on 22/09/2021
 */


package com.degel.lotus.userservice.service;

import com.degel.lotus.userservice.dto.UserDTO;
import com.degel.lotus.userservice.entity.Role;
import com.degel.lotus.userservice.sequence.SequenceGeneratorService;
import com.degel.lotus.userservice.entity.User;
import com.degel.lotus.userservice.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.degel.lotus.userservice.entity.User.SEQUENCE_NAME;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private SequenceGeneratorService idGenerator;

    @Autowired
    private UserRepository repo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public User addNewUser(UserDTO userDTO) {
        User user = convertUserDtoToUser(userDTO);
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        return repo.save(user);
    }

    @Override
    public User updateUser(UserDTO user) {
        User userToChange = repo.findByEmail(user.getEmail());
        log.info(this.getClass().getSimpleName()+" updateUser from: "+userToChange+" to: "+user);

        User userRes = setUserFields(user, userToChange);
        repo.save(userRes);

        return userToChange;
    }


    @Override
    public void deleteUser(String email) {
        User user = repo.findByEmail(email);
        log.info("User for delete: "+user.toString());

        repo.delete(user);
    }

    @Override
    public List<User> findByEmail(String email) {
        log.info(this.getClass().getSimpleName()+"  findByEmail:  "+email);

        return repo.findAllByEmail(email);
    }

    @Override
    public List<User> findByPhone(String phone) {
        log.info(this.getClass().getSimpleName()+"  findByPhone:  "+phone);
        return repo.findAllByPhoneNumber(phone);
    }

    private User convertUserDtoToUser(UserDTO userDTO) {
        return User.builder()
                .id(idGenerator.getSequenceNumber(SEQUENCE_NAME))
                .birthDate(userDTO.getBirthDate())
                .userName(userDTO.getUserName())
                .lastName(userDTO.getLastName())
                .email(userDTO.getEmail())
                .phoneNumber(userDTO.getPhoneNumber())
                .userPassword(userDTO.getUserPassword())
                .build();
    }

    private User setUserFields(UserDTO user, User userToChange) {
        if(user.getUserName()!=null && !user.getUserName().isBlank()){
            userToChange.setUserName(user.getUserName());
        }
        if(user.getLastName()!=null && !user.getLastName().isBlank()){
            userToChange.setLastName(user.getLastName());
        }
        if(user.getPhoneNumber()!=null && !user.getPhoneNumber().isBlank()){
            userToChange.setPhoneNumber(user.getPhoneNumber());
        }
        if(user.getBirthDate()!=null){
            userToChange.setBirthDate(user.getBirthDate());
        }
        userToChange.setRole(Role.ADMIN);
        return userToChange;
    }

}
