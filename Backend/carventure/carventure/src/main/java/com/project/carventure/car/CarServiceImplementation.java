package com.project.carventure.car;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImplementation implements CarService {

	@Autowired
	private CarDao carDao;

	@Override
	public Car updateCarImages(Integer carId, ImageRequestDto image) {

		String foundImage = image.getImage();
		Car car = carDao.findById(carId).orElseThrow(() -> new CarException("car not found"));
		car.getImage().add(foundImage);
		return carDao.save(car);
	}

	@Override
	public Car deleteCarImage(Integer carId, ImageRequestDto imageDelete) {
		String imageUrl = imageDelete.getImage();
		Car car = carDao.findById(carId).orElseThrow(() -> new CarException("car not found"));
		if (car.getImage().contains(imageUrl)) {
			car.getImage().remove(imageUrl);
		}
		return carDao.save(car);
	}

}
