package com.project.carventure.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@PostMapping("/address/{userId}")
	public Boolean addAddress(@RequestBody UserAddress address, @PathVariable Integer userId) {
		return this.addressService.addAddress(address, userId);
	}

}
