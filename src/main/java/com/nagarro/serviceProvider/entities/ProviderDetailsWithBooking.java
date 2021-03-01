package com.nagarro.serviceProvider.entities;

public class ProviderDetailsWithBooking {
	String bookingRefNum;
	ServiceProviderEntity serviceProvider;
	public ProviderDetailsWithBooking () {}
	
	public String getBookingRefNum() {
		return bookingRefNum;
	}
	public void setBookingRefNum(String bookingRefNum) {
		this.bookingRefNum = bookingRefNum;
	}
	public ServiceProviderEntity getServiceProvider() {
		return serviceProvider;
	}
	public void setServiceProvider(ServiceProviderEntity serviceProvider) {
		this.serviceProvider = serviceProvider;
	}
	public ProviderDetailsWithBooking(String bookingRefNum, ServiceProviderEntity serviceProvider) {
		super();
		this.bookingRefNum = bookingRefNum;
		this.serviceProvider = serviceProvider;
	}
}
