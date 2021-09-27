/*
 author Anastasiya
 created on 22/09/2021
 */


package com.degel.lotus.userservice.sequence;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "database_sequences")
@Getter
@Setter
//This class was created for id auto generated value for MongoDB database;
public class DatabaseSequence {
    @Id
    private String id;
    private long seq;
}

