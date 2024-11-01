package com.project.carventure;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
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

import com.project.carventure.application.Application;
import com.project.carventure.application.ApplicationDao;
import com.project.carventure.application.ApplicationException;
import com.project.carventure.application.ApplicationServiceImplementation;
import com.project.carventure.application.FinalOfferDto;
import com.project.carventure.car.Car;
import com.project.carventure.car.CarDao;
import com.project.carventure.inventory.Inventory;
import com.project.carventure.inventory.InventoryDao;
import com.project.carventure.user.User;
import com.project.carventure.user.UserDao;
import com.project.carventure.user.UserException;

@ExtendWith(MockitoExtension.class)
public class ApplicationServiceImplementationTest {

    @Mock
    private CarDao carDao;

    @Mock
    private ApplicationDao applicationDao;

    @Mock
    private UserDao userDao;

    @Mock
    private InventoryDao inventoryDao;

    @InjectMocks
    private ApplicationServiceImplementation applicationService;

    private User user;
    private Car car;
    private Application application;
    private FinalOfferDto finalOffer;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setId(1);
        user.setEmail("test@example.com");

        car = new Car();
        car.setId(1);
        car.setModel("Test Model");

        application = new Application();
        application.setId(1);
        application.setCar(car);
        application.setUser(user);

        finalOffer = new FinalOfferDto();
        finalOffer.setStatus("Approved");
        finalOffer.setFinal_offer(10000);
        finalOffer.setInventory_price(12000);
        finalOffer.setUsername("testuser");
        finalOffer.setEmail("testuser@example.com");
    }

    @Test
    void testSellerApplication_UserNotFound() {
        when(userDao.findById(user.getId())).thenReturn(Optional.empty());

        UserException exception = assertThrows(UserException.class, () -> {
            applicationService.sellerApplication(application, user.getId());
        });

        assertEquals("user not found", exception.getMessage());
    }

    @Test
    void testSellerApplication_Success() {
        when(userDao.findById(user.getId())).thenReturn(Optional.of(user));
        when(carDao.save(car)).thenReturn(car);
        when(applicationDao.save(application)).thenReturn(application);

        Application savedApplication = applicationService.sellerApplication(application, user.getId());

        assertNotNull(savedApplication);
        assertEquals(application, savedApplication);
    }

    @Test
    void testViewApplications() {
        Collection<Application> applications = new ArrayList<>();
        applications.add(application);

        when(applicationDao.findPendingOrApprovedApplications()).thenReturn((List<Application>) applications);

        Collection<Application> result = applicationService.viewApplications();

        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    void testRejectApplication_ApplicationNotFound() {
        when(applicationDao.findById(application.getId())).thenReturn(Optional.empty());

        ApplicationException exception = assertThrows(ApplicationException.class, () -> {
            applicationService.rejectApplication(application, application.getId());
        });

        assertEquals("Application not found", exception.getMessage());
    }

    @Test
    void testRejectApplication_Success() {
        when(applicationDao.findById(application.getId())).thenReturn(Optional.of(application));
        when(applicationDao.save(application)).thenReturn(application);

        Boolean result = applicationService.rejectApplication(application, application.getId());

        assertTrue(result);
    }

    @Test
    void testViewApplication_ApplicationNotFound() {
        when(applicationDao.findById(application.getId())).thenReturn(Optional.empty());

        ApplicationException exception = assertThrows(ApplicationException.class, () -> {
            applicationService.ViewApplication(application.getId());
        });

        assertEquals("Application not found", exception.getMessage());
    }

    @Test
    void testViewApplication_Success() {
        when(applicationDao.findById(application.getId())).thenReturn(Optional.of(application));

        Application foundApplication = applicationService.ViewApplication(application.getId());

        assertNotNull(foundApplication);
        assertEquals(application, foundApplication);
    }

    @Test
    void testInitialOffer_ApplicationNotFound() {
        when(applicationDao.findById(application.getId())).thenReturn(Optional.empty());

        ApplicationException exception = assertThrows(ApplicationException.class, () -> {
            applicationService.initialOffer(application, application.getId());
        });

        assertEquals("Application not found", exception.getMessage());
    }

    @Test
    void testInitialOffer_Success() {
        when(applicationDao.findById(application.getId())).thenReturn(Optional.of(application));
        when(applicationDao.save(application)).thenReturn(application);

        Boolean result = applicationService.initialOffer(application, application.getId());

        assertTrue(result);
    }

    @Test
    void testCloseApplication_ApplicationNotFound() {
        when(applicationDao.findById(application.getId())).thenReturn(Optional.empty());

        ApplicationException exception = assertThrows(ApplicationException.class, () -> {
            applicationService.closeApplication(application, application.getId());
        });

        assertEquals("Application not found", exception.getMessage());
    }

    @Test
    void testCloseApplication_Success() {
        when(applicationDao.findById(application.getId())).thenReturn(Optional.of(application));
        when(applicationDao.save(application)).thenReturn(application);

        Boolean result = applicationService.closeApplication(application, application.getId());

        assertTrue(result);
    }

    @Test
    void testFinalOffer_ApplicationNotFound() {
        when(applicationDao.findById(application.getId())).thenReturn(Optional.empty());

        ApplicationException exception = assertThrows(ApplicationException.class, () -> {
            applicationService.finalOffer(finalOffer, application.getId());
        });

        assertEquals("Application not found", exception.getMessage());
    }

    @Test
    void testFinalOffer_Success() {
        when(applicationDao.findById(application.getId())).thenReturn(Optional.of(application));
        when(inventoryDao.save(any(Inventory.class))).thenReturn(new Inventory());
        when(applicationDao.save(application)).thenReturn(application);

        Boolean result = applicationService.finalOffer(finalOffer, application.getId());

        assertTrue(result);
    }

    @Test
    void testViewUserApplications_UserNotFound() {
        when(userDao.findById(user.getId())).thenReturn(Optional.empty());

        UserException exception = assertThrows(UserException.class, () -> {
            applicationService.viewUserApplications(user.getId());
        });

        assertEquals("user not found", exception.getMessage());
    }

    @Test
    void testViewUserApplications_Success() {
        when(userDao.findById(user.getId())).thenReturn(Optional.of(user));

        Collection<Application> result = applicationService.viewUserApplications(user.getId());

        assertNotNull(result);
    }
}

