/*
 author Anastasiya
 created on 26/09/2021
 */

package com.degel.lotus.userservice.service;

import com.degel.lotus.userservice.entity.User;

public interface AdminService {
    User updateUserRole(String email, String role);

}
