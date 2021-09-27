package com.degel.lotus.userservice.controller;

import com.degel.lotus.userservice.entity.User;
import com.degel.lotus.userservice.repo.UserRepository;
import com.degel.lotus.userservice.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static com.degel.lotus.userservice.values.Variables.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class UserServiceControllerTest {



    @InjectMocks
    UserServiceController userServiceController;

    @Mock
    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addNewUser() {
        when(userService.addNewUser(userDTO)).thenReturn(user);
        boolean addNewUser = userServiceController.addNewUser(userDTO);
        assertTrue(addNewUser);
        assertEquals(userService.addNewUser(userDTO).getUserName(), user.getUserName());
        assertEquals(userService.addNewUser(userDTO).getBirthDate(), userDTO.getBirthDate() );
        assertEquals(userService.addNewUser(userDTO).getLastName(), userDTO.getLastName() );
        assertEquals(userService.addNewUser(userDTO).getEmail(), userDTO.getEmail() );
        assertEquals(userService.addNewUser(userDTO).getPhoneNumber(), userDTO.getPhoneNumber() );
    }

    @Test
    void updateUser() {
        when(userService.updateUser(newUserDTO)).thenReturn(newUser);
        User updateUser = userService.updateUser(newUserDTO);
        assertEquals(updateUser.getUserName(), newUserDTO.getUserName());
        assertNotEquals(updateUser.getPhoneNumber(), newUserDTO.getPhoneNumber());
        assertEquals(updateUser.getEmail(), newUserDTO.getEmail());
        assertEquals(updateUser.getBirthDate(), newUserDTO.getBirthDate());
    }

    @Test
    void deleteUser() {

        mock(UserServiceController.class, CALLS_REAL_METHODS);

        doNothing().when(userService).deleteUser(user.getEmail());
        userService.deleteUser(user.getEmail());
        verify(userService,times(1)).deleteUser(user.getEmail());

    }

    @Test
    void findByEmail() {
        when(userService.findByEmail(anyString())).thenReturn(List.of(user));
        List<User> byEmail = userServiceController.findByEmail(user.getEmail());
        assertNotNull(byEmail);
        assertEquals(byEmail.get(0), user);
        assertEquals(byEmail.get(0).getUserName(), userDTO.getUserName() );
        assertEquals(byEmail.get(0).getLastName(), userDTO.getLastName() );
        assertEquals(byEmail.get(0).getEmail(), userDTO.getEmail() );
        assertEquals(byEmail.get(0).getPhoneNumber(), userDTO.getPhoneNumber() );
    }

    @Test
    void findByPhone() {
        when(userService.findByPhone(anyString())).thenReturn(List.of(user));
        List<User> byPhone = userServiceController.findByPhone("0546285738");
        assertNotNull(byPhone);
        assertEquals(byPhone.get(0), user);
        assertEquals(byPhone.get(0).getUserName(), userDTO.getUserName() );
        assertEquals(byPhone.get(0).getLastName(), userDTO.getLastName() );
        assertEquals(byPhone.get(0).getEmail(), userDTO.getEmail() );
        assertEquals(byPhone.get(0).getPhoneNumber(), userDTO.getPhoneNumber() );
    }
}