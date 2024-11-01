package com.project.carventure.application;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService;

	@PostMapping("/application/{userId}")
	public Application sellerApplication(@RequestBody Application application, @PathVariable Integer userId) {
		return this.applicationService.sellerApplication(application, userId);
	}

	@GetMapping("/applications")
	public Collection<ApplicationDto> viewAllApplications() {
		Collection<Application> app = this.applicationService.viewApplications();
		return app.stream().map(application -> {
			ApplicationDto applicationDto = new ApplicationDto();
			applicationDto.setId(application.getId());
			applicationDto.setStatus(application.getStatus());
			applicationDto.setAsking_price(application.getAsking_price());
			applicationDto.setInitial_offer(application.getInitial_offer());
			applicationDto.setFinal_offer(application.getFinal_offer());
			applicationDto.setDate_of_application(application.getDate_of_application());
			applicationDto.setDate_of_purchase(application.getDate_of_purchase());
			applicationDto.setInventory_price(application.getInventory_price());
			applicationDto.setRejection_reason(application.getRejection_reason());
			applicationDto.setCar(application.getCar());
			applicationDto.setUsername(application.getUser().getUsername());
			return applicationDto;
		}).collect(Collectors.toList());
	}

	@PatchMapping("/reject/{appId}")
	public Boolean rejectApplicationById(@RequestBody Application app, @PathVariable Integer appId) {
		return this.applicationService.rejectApplication(app, appId);
	}

	@GetMapping("/application/{appId}")
	public ApplicationDto ViewApplication(@PathVariable Integer appId) {
		Application app = applicationService.ViewApplication(appId);

		return new ApplicationDto(appId, app.getStatus(), app.getAsking_price(), app.getInitial_offer(),
				app.getFinal_offer(), app.getDate_of_application(), app.getDate_of_purchase(), app.getInventory_price(),
				app.getRejection_reason(), app.getCar(), app.getUser().getUsername(), app.getUser().getEmail());

	}

	@PatchMapping("/applicationioffer/{appId}")
	public Boolean initialOffer(@RequestBody @Valid Application app, @PathVariable Integer appId) {
		return this.applicationService.initialOffer(app, appId);
	}

	@PatchMapping("/closedeal/{appId}")
	public Boolean closeApplicationById(@RequestBody Application app, @PathVariable Integer appId) {
		return this.applicationService.rejectApplication(app, appId);
	}

	@PatchMapping("/applicationfoffer/{appId}")
	public Boolean finalOffer(@RequestBody FinalOfferDto finalOffer, @PathVariable Integer appId) {
		return this.applicationService.finalOffer(finalOffer, appId);
	}

	@GetMapping("/applications/{userId}")
	public Collection<Application> viewUserApplications(@PathVariable Integer userId) {
		return this.applicationService.viewUserApplications(userId);
	}
}
