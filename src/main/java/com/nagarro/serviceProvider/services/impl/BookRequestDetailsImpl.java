package com.nagarro.serviceProvider.services.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.nagarro.serviceProvider.entities.BookService;
import com.nagarro.serviceProvider.entities.ProviderDetailsWithBooking;
import com.nagarro.serviceProvider.entities.ServiceProviderEntity;
import com.nagarro.serviceProvider.services.BookingRequestDetails;
import com.nagarro.serviceProvider.services.ServiceProvider;

@Service
public class BookRequestDetailsImpl implements BookingRequestDetails {

	Map<String, ProviderDetailsWithBooking> details = new HashMap<String, ProviderDetailsWithBooking>();
	@Autowired
	private ServiceProvider serviceProvider;
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Override
	@JmsListener(destination="BookingRequest")
	public void bookingRequest(BookService bookingRequestDetails) {
		System.out.println("Message recieved "+ bookingRequestDetails);
		String serviceId = bookingRequestDetails.getServiceId();
		System.out.println(serviceProvider.getAllServiceProvider().toString());
		//Check availability of Service Providers
		// We can also use random picking of providers on the basis of availability
		Optional<ServiceProviderEntity> result = serviceProvider.getAllServiceProvider().stream()
				.filter(p -> serviceId.equals(p.getServiceId()) && p.getAvailablity().equals("Y")).findFirst();
		System.out.println("result is "+ result.isPresent());
		if (result.isPresent()) {
			serviceProviderAvailable(bookingRequestDetails.getBoookingRefNum());	
		} else {
			serviceProviderNotAvailable(bookingRequestDetails.getBoookingRefNum());
		}
	}
	public void serviceProviderAvailable(String bookingRefNum) {
		jmsTemplate.convertAndSend("ServiceProviderAvailable", bookingRefNum);
	}

	public void serviceProviderNotAvailable(String bookingRefNum) {
		jmsTemplate.convertAndSend("ServiceProviderNotAvailable", bookingRefNum);
	}
	
	@Override
	@JmsListener(destination="AcceptOrReject")
	public void acceptOrReject(BookService bookingRequestDetails) {
		ServiceProviderEntity serviceProviderDetails;
		System.out.println("Message recieved for accept or reject"+ bookingRequestDetails);
		Optional<ServiceProviderEntity> result = serviceProvider.getAllServiceProvider().stream()
				.filter(p -> bookingRequestDetails.getServiceId().equals(p.getServiceId()) && p.getAvailablity().equals("Y")).findFirst();
		//Fetch Provider details
		if (result.isPresent()) {
			serviceProviderDetails = serviceProvider.getServiceProviderById(result.get().getServiceProviderId());
			System.out.println("serviceProviderDetails "+ result.get().getServiceProviderId() + serviceProviderDetails);
			ProviderDetailsWithBooking providerDetails = new ProviderDetailsWithBooking(bookingRequestDetails.getBoookingRefNum(), serviceProviderDetails);
			details.put(bookingRequestDetails.getBoookingRefNum(), providerDetails);
			System.out.println("Booking confirmed");
			jmsTemplate.convertAndSend("BookingConfirmed", providerDetails);
		} else {
			serviceProviderDetails = null;
			System.out.println("Booking rejected");
			jmsTemplate.convertAndSend("BookingRejected", bookingRequestDetails.getBoookingRefNum());
		}
		
	}
	
	@Override
	public ProviderDetailsWithBooking getProviderDetailsByBookingRefNum(String bookingRefNum) {
		return this.details.get(bookingRefNum);
	}



}
