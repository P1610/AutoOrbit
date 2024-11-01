package com.project.carventure;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.carventure.car.Car;
import com.project.carventure.inventory.Inventory;
import com.project.carventure.inventory.InventoryDao;
import com.project.carventure.inventory.InventoryException;
import com.project.carventure.testdrive.StatusDto;
import com.project.carventure.testdrive.TestDrive;
import com.project.carventure.testdrive.TestDriveDao;
import com.project.carventure.testdrive.TestDriveException;
import com.project.carventure.testdrive.TestDriveServiceImplementation;
import com.project.carventure.user.User;
import com.project.carventure.user.UserDao;
import com.project.carventure.user.UserException;

@ExtendWith(MockitoExtension.class)
public class TestDriveServiceImplementationTest {

    @Mock
    private TestDriveDao testDriveDao;

    @Mock
    private UserDao userDao;

    @Mock
    private InventoryDao inventoryDao;

    @InjectMocks
    private TestDriveServiceImplementation testDriveService;

    private User user;
    private Inventory inventory;
    private Car car;
    private TestDrive testDrive;
    private StatusDto status;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setId(1);
        user.setEmail("test@example.com");

        car = new Car();
        car.setId(1);
        car.setModel("Test Model");

        inventory = new Inventory();
        inventory.setId(1);
        inventory.setCar(car);

        testDrive = new TestDrive();
        testDrive.setId(1);
        testDrive.setCar(car);
        testDrive.setUser(user);
    }

    @Test
    void testViewTestDrives() {
        Collection<TestDrive> testDrives = new ArrayList<>();
        testDrives.add(testDrive);

        when(testDriveDao.findAll()).thenReturn((List<TestDrive>) testDrives);

        Collection<TestDrive> result = testDriveService.viewTestDrives();

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    void testChangeStatus_TestDriveNotFound() {
        when(testDriveDao.findById(testDrive.getId())).thenReturn(Optional.empty());

        TestDriveException exception = assertThrows(TestDriveException.class, () -> {
            testDriveService.changeStatus(status, testDrive.getId());
        });

        assertEquals("Test drive not found with the Id", exception.getMessage());
    }

  

    @Test
    void testAddTestDrive_UserNotFound() {
        when(userDao.findById(user.getId())).thenReturn(Optional.empty());

        UserException exception = assertThrows(UserException.class, () -> {
            testDriveService.addTestDrive(testDrive, inventory.getId(), user.getId());
        });

        assertEquals("user not found with the Id", exception.getMessage());
    }

    @Test
    void testAddTestDrive_InventoryNotFound() {
        when(userDao.findById(user.getId())).thenReturn(Optional.of(user));
        when(inventoryDao.findById(inventory.getId())).thenReturn(Optional.empty());

        InventoryException exception = assertThrows(InventoryException.class, () -> {
            testDriveService.addTestDrive(testDrive, inventory.getId(), user.getId());
        });

        assertEquals("Inventory not found with the Id ", exception.getMessage());
    }

    @Test
    void testAddTestDrive_Success() {
        when(userDao.findById(user.getId())).thenReturn(Optional.of(user));
        when(inventoryDao.findById(inventory.getId())).thenReturn(Optional.of(inventory));
        when(testDriveDao.save(testDrive)).thenReturn(testDrive);

        TestDrive createdTestDrive = testDriveService.addTestDrive(testDrive, inventory.getId(), user.getId());

        assertNotNull(createdTestDrive);
        assertEquals(testDrive, createdTestDrive);
    }

    @Test
    void testGetAllTestDrivesByUserId_UserNotFound() {
        when(userDao.findById(user.getId())).thenReturn(Optional.empty());

        UserException exception = assertThrows(UserException.class, () -> {
            testDriveService.getAllTestDrivesByUserId(user.getId());
        });

        assertEquals("user not found", exception.getMessage());
    }

    @Test
    void testGetAllTestDrivesByUserId_Success() {
        Collection<TestDrive> testDrives = new ArrayList<>();
        testDrives.add(testDrive);

        when(userDao.findById(user.getId())).thenReturn(Optional.of(user));
        when(testDriveDao.findByUserId(user.getId())).thenReturn(testDrives);

        Collection<TestDrive> result = testDriveService.getAllTestDrivesByUserId(user.getId());

        assertNotNull(result);
        assertEquals(1, result.size());
    }
}

