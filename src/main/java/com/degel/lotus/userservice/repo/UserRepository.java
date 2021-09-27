/*
 author Anastasiya
 created on 22/09/2021
 */

package com.degel.lotus.userservice.repo;

import com.degel.lotus.userservice.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

    User findByEmail(String email);

    List<User> findAllByEmail(String email);

    List<User> findAllByPhoneNumber(String phone);

}
