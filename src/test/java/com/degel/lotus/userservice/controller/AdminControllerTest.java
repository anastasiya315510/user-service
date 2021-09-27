package com.degel.lotus.userservice.controller;

import com.degel.lotus.userservice.repo.UserRepository;
import com.degel.lotus.userservice.service.AdminServiceImpl;
import com.degel.lotus.userservice.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static com.degel.lotus.userservice.values.Variables.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AdminControllerTest {
    @InjectMocks
    AdminController adminController;

    @Mock
    AdminServiceImpl adminService;

    @Mock
    UserRepository userRepository;

    @Test
    void getAllUsers() {

    }

    @Test
    void updateUserRole() {
//        when(adminService.updateUserRole("1@email.com", "admin")).thenReturn(newUserForRole);
////        assertEquals(adminService.updateUserRole("1@email.com", "admin").getUserName(), user.getUserName());
//        assertEquals(adminService.updateUserRole("1@email.com", "admin").getBirthDate(), user.getBirthDate() );
//        assertEquals(adminService.updateUserRole("1@email.com", "admin").getLastName(), user.getLastName() );
//        assertEquals(adminService.updateUserRole("1@email.com", "admin").getEmail(), user.getEmail() );
//        assertEquals(adminService.updateUserRole("1@email.com", "admin").getPhoneNumber(), user.getPhoneNumber() );
//        assertNotEquals(adminService.updateUserRole("1@email.com", "admin").getRole(), user.getRole());
//        assertEquals(adminService.updateUserRole("1@email.com", "admin").getRole(), newUserForRole.getRole());
    }
}