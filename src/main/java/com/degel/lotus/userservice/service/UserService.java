/*
 author Anastasiya
 created on 22/09/2021
 */

package com.degel.lotus.userservice.service;

import com.degel.lotus.userservice.dto.UserDTO;
import com.degel.lotus.userservice.entity.User;

import java.util.List;

public interface UserService {
    User addNewUser(UserDTO user);

    User updateUser(UserDTO user);

    void deleteUser(String email);

    List<User> findByEmail(String email);

    List<User> findByPhone(String phone);

}
