package com.project.carventure.application;

import java.util.Collection;

public interface ApplicationService {

	public Application sellerApplication(Application application, Integer userId);

	public Collection<Application> viewApplications();

	public Boolean rejectApplication(Application app, Integer appId);

	public Application ViewApplication(Integer appId);

	public Boolean initialOffer(Application app, Integer appId);

	public Boolean closeApplication(Application app, Integer appId);

	public Boolean finalOffer(FinalOfferDto finalOffer, Integer appId);

	public Collection<Application> viewUserApplications(Integer userId);

}
