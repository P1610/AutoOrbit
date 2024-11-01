package com.project.carventure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.carventure.car.Car;
import com.project.carventure.car.CarDao;
import com.project.carventure.inventory.Inventory;
import com.project.carventure.inventory.InventoryDao;
import com.project.carventure.inventory.InventoryException;
import com.project.carventure.inventory.InventoryServiceImplementation;
import com.project.carventure.transaction.Transaction;
import com.project.carventure.transaction.TransactionDao;
import com.project.carventure.user.User;
import com.project.carventure.user.UserDao;
import com.project.carventure.user.UserException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class InventoryServiceTest {

    @Mock
    private UserDao userDao;

    @Mock
    private TransactionDao transactionDao;

    @Mock
    private CarDao carDao;

    @Mock
    private InventoryDao inventoryDao;

    @InjectMocks
    private InventoryServiceImplementation inventoryService;

    private Inventory inventory;
    private Inventory updatedInventory;
    private User user;
    private Transaction transaction;
    private Car car;
    private Car updatedCar;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        car = new Car();
        car.setBrand("Toyota");
        car.setModel("Corolla");
        car.setYear(2020);
        car.setTransmission("Automatic");
        car.setFuel_type("Petrol");
        car.setMileage(15000);
        car.setColor("White");
        car.setKm_driven(15000);
        car.setNo_of_owners(1);
        car.setReg_id("KA01AB1234");
        car.setDescription("Well maintained");
        car.setImage(List.of("image_url"));

        inventory = new Inventory();
        inventory.setId(1);
        inventory.setAskingPrice(10000);
        inventory.setBoughtPrice(8000);
        inventory.setIsSold(false);
        inventory.setCar(car);

        updatedCar = new Car();
        updatedCar.setBrand("Honda");
        updatedCar.setModel("Civic");
        updatedCar.setYear(2021);
        updatedCar.setTransmission("Manual");
        updatedCar.setFuel_type("Diesel");
        updatedCar.setMileage(10000);
        updatedCar.setColor("Black");
        updatedCar.setKm_driven(10000);
        updatedCar.setNo_of_owners(1);
        updatedCar.setReg_id("KA02CD5678");
        updatedCar.setDescription("Like new");
        updatedCar.setImage(List.of("new_image_url"));

        updatedInventory = new Inventory();
        updatedInventory.setAskingPrice(12000);
        updatedInventory.setBoughtPrice(9000);
        updatedInventory.setIsSold(true);
        updatedInventory.setCar(updatedCar);

        user = new User();
        user.setId(1);
        user.setUsername("John Doe");
        user.setBoughtCars(new ArrayList<>());

        transaction = new Transaction();
        transaction.setDiscount_percentage(10);
        transaction.setAmount(9000);
    }

    // Test cases for each method will follow
    
    @Test
    public void testViewAllInventories_Success() {
        List<Inventory> inventories = List.of(inventory);
        when(inventoryDao.findAll()).thenReturn(inventories);

        Collection<Inventory> result = inventoryService.viewAllInventories();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertTrue(result.contains(inventory));
    }

    @Test
    public void testViewAllInventories_Empty() {
        when(inventoryDao.findAll()).thenReturn(new ArrayList<>());

        InventoryException exception = assertThrows(InventoryException.class, () -> {
            inventoryService.viewAllInventories();
        });

        assertEquals("inventory is null", exception.getMessage());
    }
    
    @Test
    public void testViewInventory_Success() {
        when(inventoryDao.findById(1)).thenReturn(Optional.of(inventory));

        Inventory result = inventoryService.viewInventory(1);

        assertNotNull(result);
        assertEquals(inventory, result);
    }

    @Test
    public void testViewInventory_NotFound() {
        when(inventoryDao.findById(1)).thenReturn(Optional.empty());

        InventoryException exception = assertThrows(InventoryException.class, () -> {
            inventoryService.viewInventory(1);
        });

        assertEquals("Inventory not found", exception.getMessage());
    }
    
    
    @Test
    public void testUpdateInventory_Success() {
        when(inventoryDao.findById(1)).thenReturn(Optional.of(inventory));
        when(carDao.save(any(Car.class))).thenReturn(updatedCar);
        when(inventoryDao.save(any(Inventory.class))).thenReturn(inventory);

        Inventory result = inventoryService.updateInventory(1, updatedInventory);

        assertNotNull(result);
        assertEquals(12000, result.getAskingPrice());
        assertEquals(9000, result.getBoughtPrice());
        assertTrue(result.getIsSold());
        assertEquals("Honda", result.getCar().getBrand());
        assertEquals("Civic", result.getCar().getModel());
        assertEquals(2021, result.getCar().getYear());
        assertEquals("Manual", result.getCar().getTransmission());
        assertEquals("Diesel", result.getCar().getFuel_type());
        assertEquals(10000, result.getCar().getMileage());
        assertEquals("Black", result.getCar().getColor());
        assertEquals(10000, result.getCar().getKm_driven());
        assertEquals(1, result.getCar().getNo_of_owners());
        assertEquals("KA02CD5678", result.getCar().getReg_id());
        assertEquals("Like new", result.getCar().getDescription());
        assertEquals("new_image_url", result.getCar().getImage().get(0));
    }

    @Test
    public void testUpdateInventory_NotFound() {
        when(inventoryDao.findById(1)).thenReturn(Optional.empty());

        InventoryException exception = assertThrows(InventoryException.class, () -> {
            inventoryService.updateInventory(1, updatedInventory);
        });

        assertEquals("Inventory not found with the Id", exception.getMessage());
    }
    
    @Test
    public void testSellCar_Success() {
        when(inventoryDao.findById(1)).thenReturn(Optional.of(inventory));
        when(userDao.findById(1)).thenReturn(Optional.of(user));
        when(transactionDao.save(any(Transaction.class))).thenReturn(transaction);

        Boolean result = inventoryService.sellCar(transaction, 1, 1);

        assertTrue(result);
        assertTrue(inventory.getIsSold());
        assertNotNull(inventory.getTransaction());
        assertEquals(transaction, inventory.getTransaction());
        assertTrue(user.getBoughtCars().contains(transaction));
    }

    @Test
    public void testSellCar_InventoryNotFound() {
        when(inventoryDao.findById(1)).thenReturn(Optional.empty());

        InventoryException exception = assertThrows(InventoryException.class, () -> {
            inventoryService.sellCar(transaction, 1, 1);
        });

        assertEquals("Inventory not found with the Id", exception.getMessage());
    }


}
   
  
