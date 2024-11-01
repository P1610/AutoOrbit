package com.project.carventure.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImplementation implements LocationService {

	@Autowired
	private LocationDao locationDao;

	@Override
	public Location addNewLocation(Location location) {
		return this.locationDao.save(location);
	}

	@Override
	public Location getLocation() {
		return this.locationDao.findFirstByOrderByIdAsc();
	}

}
