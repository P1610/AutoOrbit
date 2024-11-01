package com.project.carventure.car;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
public class CarController {

	@Autowired
	private CarService carService;

	@PatchMapping("/{carId}/images")
	public Car updateCarImages(@PathVariable Integer carId, @RequestBody ImageRequestDto image) {
		return this.carService.updateCarImages(carId, image);
	}

	@PatchMapping("/{carId}/images/delete")
	public Car deleteCarImage(@PathVariable Integer carId, @RequestBody ImageRequestDto imageDelete) {
		return carService.deleteCarImage(carId, imageDelete);
	}

}
