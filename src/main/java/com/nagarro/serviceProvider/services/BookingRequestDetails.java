package com.nagarro.serviceProvider.services;

import com.nagarro.serviceProvider.entities.BookService;
import com.nagarro.serviceProvider.entities.ProviderDetailsWithBooking;

public interface BookingRequestDetails {
	void bookingRequest(BookService bookingRequestDetails);
	void serviceProviderAvailable(String bookingRefNum);
	void serviceProviderNotAvailable(String bookingRefNum);
	void acceptOrReject(BookService bookingRequestDetails);
	ProviderDetailsWithBooking getProviderDetailsByBookingRefNum(String bookingRefNum); 


}
