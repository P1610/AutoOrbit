package com.project.carventure.application;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.carventure.car.Car;
import com.project.carventure.car.CarDao;
import com.project.carventure.inventory.Inventory;
import com.project.carventure.inventory.InventoryDao;
import com.project.carventure.user.User;
import com.project.carventure.user.UserDao;
import com.project.carventure.user.UserException;

@Service
public class ApplicationServiceImplementation implements ApplicationService {

	@Autowired
	private CarDao carDao;

	@Autowired
	private ApplicationDao applicationDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private InventoryDao inventoryDao;

	@Override
	public Application sellerApplication(Application application, Integer userId) {
		User foundUser = userDao.findById(userId).orElseThrow(() -> new UserException("user not found"));
		Car car = carDao.save(application.getCar());
		application.setCar(car);
		application.setUser(foundUser);
		Application savedApplication = applicationDao.save(application);
		foundUser.getApplications().add(savedApplication);
		userDao.save(foundUser);
		return savedApplication;
	}

	@Override
	public Collection<Application> viewApplications() {
		return this.applicationDao.findPendingOrApprovedApplications();
	}

	@Override
	public Boolean rejectApplication(Application app, Integer appId) {
		Application foundApplication = this.applicationDao.findById(appId)
				.orElseThrow(() -> new ApplicationException("Application not found"));

		foundApplication.setStatus(app.getStatus());
		foundApplication.setRejection_reason(app.getRejection_reason());
		this.applicationDao.save(foundApplication);
		return true;
	}

	@Override
	public Application ViewApplication(Integer appId) {
		return this.applicationDao.findById(appId).orElseThrow(() -> new ApplicationException("Application not found"));
	}

	@Override
	public Boolean initialOffer(Application app, Integer appId) {
		Application foundApp = this.applicationDao.findById(appId)
				.orElseThrow(() -> new ApplicationException("Application not found"));
		foundApp.setStatus(app.getStatus());
		foundApp.setInitial_offer(app.getInitial_offer());
		this.applicationDao.save(foundApp);
		return true;
	}

	@Override
	public Boolean closeApplication(Application app, Integer appId) {
		Application foundApplication = this.applicationDao.findById(appId)
				.orElseThrow(() -> new ApplicationException("Application not found"));

		foundApplication.setStatus(app.getStatus());
		foundApplication.setRejection_reason(app.getRejection_reason());
		this.applicationDao.save(foundApplication);
		return true;
	}

	@Override
	public Boolean finalOffer(FinalOfferDto finalOffer, Integer appId) {
		Application foundApplication = this.applicationDao.findById(appId)
				.orElseThrow(() -> new ApplicationException("Application not found"));
		foundApplication.setStatus(finalOffer.getStatus());
		foundApplication.setDate_of_purchase(LocalDate.now());
		foundApplication.setFinal_offer(finalOffer.getFinal_offer());
		foundApplication.setInventory_price(finalOffer.getInventory_price());
		Car car = foundApplication.getCar();
		Inventory inventory = new Inventory();
		inventory.setSellerName(finalOffer.getUsername());
		inventory.setSellerEmail(finalOffer.getEmail());
		inventory.setBoughtPrice(finalOffer.getFinal_offer());
		inventory.setCar(car);
		inventory.setAskingPrice(finalOffer.getInventory_price());
		inventory.setDate_of_purchase(LocalDate.now());
		this.inventoryDao.save(inventory);
		this.applicationDao.save(foundApplication);
		return true;
	}

	@Override
	public Collection<Application> viewUserApplications(Integer userId) {
		User foundUser = this.userDao.findById(userId).orElseThrow(() -> new UserException("user not found"));
		return foundUser.getApplications();

	}

}
