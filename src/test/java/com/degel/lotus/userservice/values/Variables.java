/*
 author Anastasiya
 created on 26/09/2021
 */


package com.degel.lotus.userservice.values;

import com.degel.lotus.userservice.dto.UserDTO;
import com.degel.lotus.userservice.entity.Role;
import com.degel.lotus.userservice.entity.User;

import java.time.LocalDate;

public class Variables {
    public static UserDTO userDTO = UserDTO.builder().userName("Ella").userPassword("123456").phoneNumber("0546285738").lastName("Bi").email("1@email.com").birthDate(LocalDate.now()).build();

    public static User user = User.builder().userName("Ella").userPassword("123456").lastName("Bi").phoneNumber("0546285738").email("1@email.com").birthDate(LocalDate.now()).role(Role.USER).build();

    public static User newUser = User.builder().userName("Anna").userPassword("123").phoneNumber("0546285738").lastName("Bo").email("1@email.com").birthDate(LocalDate.now()).build();
    public static User newUserForRole = User.builder().userName("Anna").userPassword("123").phoneNumber("0546285738").lastName("Bo").email("1@email.com").birthDate(LocalDate.now()).role(Role.ADMIN).build();

    public static UserDTO newUserDTO = UserDTO.builder().userName("Anna").userPassword("123").phoneNumber("05462").lastName("Bo").email("1@email.com").birthDate(LocalDate.now()).build();

}
