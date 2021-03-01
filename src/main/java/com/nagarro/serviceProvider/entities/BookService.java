package com.nagarro.serviceProvider.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.nagarro.serviceProvider.constants.BookingStatus;

public class BookService implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Users user;
	String serviceId;
	String boookingRefNum;
	LocalDateTime timestamp;
	BookingStatus bookingStatus;

	public BookService() {
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getBoookingRefNum() {
		return boookingRefNum;
	}
	public void setBoookingRefNum(String boookingRefNum) {
		this.boookingRefNum = boookingRefNum;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	@Override
	public String toString() {
		return "BookService [user=" + user + ", serviceId=" + serviceId + ", boookingRefNum=" + boookingRefNum
				+ ", timestamp=" + timestamp + ", bookingStatus=" + bookingStatus + "]";
	}

	public BookService(Users user, String serviceId, String boookingRefNum, LocalDateTime timestamp,
			BookingStatus bookingStatus) {
		super();
		this.user = user;
		this.serviceId = serviceId;
		this.boookingRefNum = boookingRefNum;
		this.timestamp = timestamp;
		this.bookingStatus = bookingStatus;
	}


	
}
