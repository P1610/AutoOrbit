package com.project.carventure;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.carventure.car.Car;
import com.project.carventure.car.CarDao;
import com.project.carventure.car.CarException;
import com.project.carventure.car.CarServiceImplementation;
import com.project.carventure.car.ImageRequestDto;

@ExtendWith(MockitoExtension.class)
public class CarServiceImplementationTest {

    @Mock
    private CarDao carDao;

    @InjectMocks
    private CarServiceImplementation carService;

    private Car car;
    private ImageRequestDto imageRequestDto;

    @BeforeEach
    void setUp() {
        car = new Car();
        car.setId(1);
        car.setImage(new ArrayList<>());

        imageRequestDto = new ImageRequestDto();
        imageRequestDto.setImage("http://example.com/image.jpg");
    }

    @Test
    void testUpdateCarImages_CarNotFound() {
        when(carDao.findById(car.getId())).thenReturn(Optional.empty());

        CarException exception = assertThrows(CarException.class, () -> {
            carService.updateCarImages(car.getId(), imageRequestDto);
        });

        assertEquals("car not found", exception.getMessage());
    }

    @Test
    void testUpdateCarImages_Success() {
        when(carDao.findById(car.getId())).thenReturn(Optional.of(car));
        when(carDao.save(car)).thenReturn(car);

        Car updatedCar = carService.updateCarImages(car.getId(), imageRequestDto);

        assertNotNull(updatedCar);
        assertTrue(updatedCar.getImage().contains(imageRequestDto.getImage()));
    }

    @Test
    void testDeleteCarImage_CarNotFound() {
        when(carDao.findById(car.getId())).thenReturn(Optional.empty());

        CarException exception = assertThrows(CarException.class, () -> {
            carService.deleteCarImage(car.getId(), imageRequestDto);
        });

        assertEquals("car not found", exception.getMessage());
    }

    @Test
    void testDeleteCarImage_Success() {
        car.getImage().add(imageRequestDto.getImage());
        when(carDao.findById(car.getId())).thenReturn(Optional.of(car));
        when(carDao.save(car)).thenReturn(car);

        Car updatedCar = carService.deleteCarImage(car.getId(), imageRequestDto);

        assertNotNull(updatedCar);
        assertFalse(updatedCar.getImage().contains(imageRequestDto.getImage()));
    }
}

