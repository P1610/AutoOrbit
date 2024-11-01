package com.project.carventure;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.carventure.user.LoginDto;
import com.project.carventure.user.User;
import com.project.carventure.user.UserDao;
import com.project.carventure.user.UserException;
import com.project.carventure.user.UserServiceImplementation;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplementationTest {

    @Mock
    private UserDao userDao;

   

    @InjectMocks
    private UserServiceImplementation userService;

    private User user;
    private LoginDto loginDto;


    @BeforeEach
    void setUp() {
        user = new User();
        user.setId(1);
        user.setEmail("test@example.com");
        user.setPassword("password");
        user.setVerified(true);

        loginDto = new LoginDto();
        loginDto.setEmail("test@example.com");
        loginDto.setPassword("password");

    }

    @Test
    void testAddNewUser_UserAlreadyExists() {
        when(userDao.findUserByEmail(user.getEmail())).thenReturn(user);

        UserException exception = assertThrows(UserException.class, () -> {
            userService.addNewUser(user);
        });

        assertEquals("Email already exists", exception.getMessage());
    }

    @Test
    void testAddNewUser_Success() {
        when(userDao.findUserByEmail(user.getEmail())).thenReturn(null);
        when(userDao.save(user)).thenReturn(user);

        User savedUser = userService.addNewUser(user);

        assertEquals(user, savedUser);
    }

    @Test
    void testLogin_UserNotFound() {
        when(userDao.findUserByEmail(loginDto.getEmail())).thenReturn(null);

        UserException exception = assertThrows(UserException.class, () -> {
            userService.login(loginDto);
        });

        assertEquals("Incorrect email or password", exception.getMessage());
    }

    @Test
    void testLogin_UserNotVerified() {
        user.setVerified(false);
        when(userDao.findUserByEmail(loginDto.getEmail())).thenReturn(user);

        UserException exception = assertThrows(UserException.class, () -> {
            userService.login(loginDto);
        });

        assertEquals("Please verify your email.", exception.getMessage());
    }

    @Test
    void testLogin_IncorrectPassword() {
        user.setPassword("wrongpassword");
        when(userDao.findUserByEmail(loginDto.getEmail())).thenReturn(user);

        UserException exception = assertThrows(UserException.class, () -> {
            userService.login(loginDto);
        });

        assertEquals("Incorrect email or password", exception.getMessage());
    }

    @Test
    void testLogin_Success() {
        when(userDao.findUserByEmail(loginDto.getEmail())).thenReturn(user);

        User loggedInUser = userService.login(loginDto);

        assertEquals(user, loggedInUser);
    }

  
}
