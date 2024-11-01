package com.project.carventure.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
public class LocationController {

	@Autowired
	private LocationService locationService;

	@PostMapping("/location")
	public Location addLocation(@RequestBody Location location) {
		return this.locationService.addNewLocation(location);
	}

	@GetMapping("/getlocation")
	public Location getLocation() {
		return this.locationService.getLocation();
	}

}
