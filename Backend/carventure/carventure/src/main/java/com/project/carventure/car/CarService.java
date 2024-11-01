package com.project.carventure.car;

import java.util.List;
import java.util.Map;

public interface CarService {

	Car updateCarImages(Integer carId, ImageRequestDto image);

	Car deleteCarImage(Integer carId, ImageRequestDto imageDelete);

}
