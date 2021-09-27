/*
 author Anastasiya
 created on 22/09/2021
 */


package com.degel.lotus.userservice.entity;

import lombok.*;
import org.bson.BsonType;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Document("users")
public class User {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private long id;
    private String userName;
    private String userPassword;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate birthDate;

    private Role role;
}
