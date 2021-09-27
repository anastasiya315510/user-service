/*
 author Anastasiya
 created on 26/09/2021
 */


package com.degel.lotus.userservice.service.details;

import com.degel.lotus.userservice.entity.User;
import com.degel.lotus.userservice.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = Optional.ofNullable(userRepository.findByEmail(email))
                .orElseThrow(()->new UsernameNotFoundException("There is no user with such user name " + email));

        CustomUserDetails customUserDetails = CustomUserDetails.builder().build();
        customUserDetails.setUser(user);

        return customUserDetails;
    }

}
