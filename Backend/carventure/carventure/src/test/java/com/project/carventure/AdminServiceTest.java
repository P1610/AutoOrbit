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
import com.project.carventure.address.UserAddress;
import com.project.carventure.admin.Admin;
import com.project.carventure.admin.AdminDao;
import com.project.carventure.admin.AdminDto;
import com.project.carventure.admin.AdminException;
import com.project.carventure.admin.AdminPasswordDto;
import com.project.carventure.admin.AdminServiceImplementation;
import com.project.carventure.admin.LoginDto;

@ExtendWith(MockitoExtension.class)
public class AdminServiceTest {

	@Mock
	private AdminDao adminDao; // Mock for AdminDao

	@Mock
	private AddressDao addressDao; // Mock for AddressDao

	@InjectMocks
	private AdminServiceImplementation adminService; // Service under test

	private Admin admin;
	private AdminDto adminDto;
	private LoginDto loginDto;
	private AdminPasswordDto pwdDto;

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

		adminDto = new AdminDto();
		adminDto.setEmail("updatedadmin@example.com");
		adminDto.setPhone("0987654321");
		adminDto.setUsername("UpdatedAdmin");
		adminDto.setAddress(new UserAddress());

		pwdDto = new AdminPasswordDto();
		pwdDto.setPassword("newpass");
	}

	// Test for the updateAdmin method
	@Test
    public void testUpdateAdmin_Success() {
        when(adminDao.findById(1)).thenReturn(Optional.of(admin));
        when(adminDao.save(admin)).thenReturn(admin);
        when(addressDao.save(adminDto.getAddress())).thenReturn(adminDto.getAddress());

        Admin result = adminService.updateAdmin(adminDto, 1);

        assertNotNull(result);
        assertEquals("updatedadmin@example.com", result.getEmail());
        verify(adminDao, times(1)).findById(1);
        verify(adminDao, times(1)).save(admin);
    }

	@Test
    public void testUpdateAdmin_Failure_AdminNotFound() {
        when(adminDao.findById(1)).thenReturn(Optional.empty());

        Exception exception = assertThrows(AdminException.class, () -> {
            adminService.updateAdmin(adminDto, 1);
        });

        assertEquals("Admin not found", exception.getMessage());
        verify(adminDao, times(1)).findById(1);
    }

	// Test for the changePassword method
	@Test
    public void testChangePassword_Success() {
        when(adminDao.findById(1)).thenReturn(Optional.of(admin));
        when(adminDao.save(admin)).thenReturn(admin);

        Admin result = adminService.changePassword(pwdDto, 1);

        assertNotNull(result);
        assertEquals("newpass", result.getPassword());
        verify(adminDao, times(1)).findById(1);
        verify(adminDao, times(1)).save(admin);
    }

	@Test
    public void testChangePassword_Failure_AdminNotFound() {
        when(adminDao.findById(1)).thenReturn(Optional.empty());

        Exception exception = assertThrows(AdminException.class, () -> {
            adminService.changePassword(pwdDto, 1);
        });

        assertEquals("Admin not found", exception.getMessage());
        verify(adminDao, times(1)).findById(1);
    }

	// Test for the fetchAdmin method
	@Test
    public void testFetchAdmin_Success() {
        when(adminDao.findById(1)).thenReturn(Optional.of(admin));

        Admin result = adminService.fetchAdmin(1);

        assertNotNull(result);
        assertEquals("admin@example.com", result.getEmail());
        verify(adminDao, times(1)).findById(1);
    }

	@Test
    public void testFetchAdmin_Failure_AdminNotFound() {
        when(adminDao.findById(1)).thenReturn(Optional.empty());

        Exception exception = assertThrows(AdminException.class, () -> {
            adminService.fetchAdmin(1);
        });

        assertEquals("Admin not found", exception.getMessage());
        verify(adminDao, times(1)).findById(1);
    }
}
