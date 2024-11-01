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


import com.project.carventure.address.UserAddress;
import com.project.carventure.admin.Admin;
import com.project.carventure.admin.AdminDao;
import com.project.carventure.admin.AdminException;
import com.project.carventure.admin.AdminServiceImplementation;
import com.project.carventure.admin.LoginDto;

@ExtendWith(MockitoExtension.class)
public class AdminServiceTest {

    @Mock
    private AdminDao adminDao; 

    @InjectMocks
    private AdminServiceImplementation adminService;

    private Admin admin;
    private LoginDto loginDto;

    @BeforeEach
    public void setUp() {
        admin = new Admin();
        admin.setId(1);
        admin.setEmail("admin@example.com");
        admin.setPassword("adminpass");
        admin.setPhone("1234567890");

        loginDto = new LoginDto();
        loginDto.setEmail("admin@example.com");
        loginDto.setPassword("adminpass");

    }

    // Test for the login method
//    @Test
//    public void testAdminLogin_Success() {
//        when(adminDao.findAdminByEmail(loginDto.getEmail())).thenReturn(admin);
//
//        Admin result = adminService.login(loginDto);
//
//        assertNotNull(result);
//        assertEquals("admin@example.com", result.getEmail());
//        verify(adminDao, times(1)).findAdminByEmail(loginDto.getEmail());
//    }

    @Test
    public void testAdminLogin_Failure_InvalidEmail() {
        when(adminDao.findAdminByEmail(loginDto.getEmail())).thenReturn(null);

        Exception exception = assertThrows(AdminException.class, () -> {
            adminService.login(loginDto);
        });

        assertEquals("Incorrect email or password", exception.getMessage());
        verify(adminDao, times(1)).findAdminByEmail(loginDto.getEmail());
    }

    @Test
    public void testAdminLogin_Failure_InvalidPassword() {
        loginDto.setPassword("wrongpass");
        when(adminDao.findAdminByEmail(loginDto.getEmail())).thenReturn(admin);

        Exception exception = assertThrows(AdminException.class, () -> {
            adminService.login(loginDto);
        });

        assertEquals("Incorrect email or password", exception.getMessage());
        verify(adminDao, times(1)).findAdminByEmail(loginDto.getEmail());
    }


}
