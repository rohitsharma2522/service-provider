package com.nagarro.serviceProvider.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nagarro.serviceProvider.entities.ProviderDetailsWithBooking;
import com.nagarro.serviceProvider.entities.ServiceProviderEntity;
import com.nagarro.serviceProvider.services.ServiceProvider;


@Service
public class ServiceProviderImpl implements ServiceProvider  {

	Map<Integer, List<ServiceProviderEntity>> serviceLocationMap = new HashMap<Integer, List<ServiceProviderEntity>>();
	@Override
	public List<ServiceProviderEntity> getAllServiceProvider() {
		List<ServiceProviderEntity> serviceProvider = new ArrayList<>();
		serviceProvider.add(new ServiceProviderEntity("1234", "Rohit", "9779333315", "001", "Y"));
		serviceProvider.add(new ServiceProviderEntity("4568", "Mohit", "9779333315", "002", "Y"));
		serviceProvider.add(new ServiceProviderEntity("7897", "Vibhav", "9779333315", "003", "Y"));
		serviceProvider.add(new ServiceProviderEntity("8777", "Raj", "9779333315", "004", "Y"));
		serviceProvider.add(new ServiceProviderEntity("8989", "Sahil", "9779333315", "001", "Y"));
		serviceProvider.add(new ServiceProviderEntity("2424", "Sobish", "9779333315", "002", "Y"));
		return serviceProvider;
	}

	@Override
	public ServiceProviderEntity getServiceProviderById(String serviceProviderId) {
		Optional<ServiceProviderEntity> result = getAllServiceProvider().stream().filter(p -> serviceProviderId.equals(p.getServiceProviderId()))
				.findFirst();
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
		
	}

}
