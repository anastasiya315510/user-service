/*
 author Anastasiya
 created on 26/09/2021
 */


package com.degel.lotus.userservice.service;

import com.degel.lotus.userservice.entity.Role;
import com.degel.lotus.userservice.entity.User;
import com.degel.lotus.userservice.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User updateUserRole(String email, String role) {
        User user = userRepository.findByEmail(email);

        if(role.toLowerCase().startsWith("a")) user.setRole(Role.ADMIN);
        else if(role.toLowerCase().startsWith("m")) user.setRole(Role.MODERATOR);
        else user.setRole(Role.USER);

        userRepository.save(user);
        return user;
    }
}
