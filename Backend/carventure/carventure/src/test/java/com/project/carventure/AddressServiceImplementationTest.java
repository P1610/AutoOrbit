package com.project.carventure;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.carventure.address.AddressDao;
import com.project.carventure.address.AddressServiceImplementation;
import com.project.carventure.address.UserAddress;
import com.project.carventure.user.User;
import com.project.carventure.user.UserDao;
import com.project.carventure.user.UserException;

@ExtendWith(MockitoExtension.class)
public class AddressServiceImplementationTest {

    @Mock
    private AddressDao addressDao;

    @Mock
    private UserDao userDao;

    @InjectMocks
    private AddressServiceImplementation addressService;

    private User user;
    private UserAddress address;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setId(1);
        user.setEmail("test@example.com");

        address = new UserAddress();
        address.setId(1);
        address.setStreetName("123 Main St");
    }

    @Test
    void testAddAddress_UserNotFound() {
        when(userDao.findById(user.getId())).thenReturn(Optional.empty());

        UserException exception = assertThrows(UserException.class, () -> {
            addressService.addAddress(address, user.getId());
        });

        assertEquals("user not found", exception.getMessage());
    }

    @Test
    void testAddAddress_Success() {
        when(userDao.findById(user.getId())).thenReturn(Optional.of(user));
        when(addressDao.save(address)).thenReturn(address);
        when(userDao.save(user)).thenReturn(user);

        Boolean result = addressService.addAddress(address, user.getId());

        assertTrue(result);
        assertEquals(address, user.getUserAddress());
    }
}
