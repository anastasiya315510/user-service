/*
 author Anastasiya
 created on 22/09/2021
 */


package com.degel.lotus.userservice.dto;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserDTO {
    private String userName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate birthDate;
    private String userPassword;
}
