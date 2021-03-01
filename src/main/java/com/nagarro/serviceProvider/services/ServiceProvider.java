package com.nagarro.serviceProvider.services;

import java.util.List;

import com.nagarro.serviceProvider.entities.ProviderDetailsWithBooking;
import com.nagarro.serviceProvider.entities.ServiceProviderEntity;

public interface ServiceProvider {
	List<ServiceProviderEntity> getAllServiceProvider();

	ServiceProviderEntity getServiceProviderById(String serviceProviderId);
	
}
