package com.godoro.spring.shop.data.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;

@Entity
public class Cart {
	@Id 
	private long cartId;
	private String customerName;
	private long cardNumber;
	private Status cartStatus;
	
	public Cart() {
		
	}
	public Cart(long cartId, String customerName, long cardNumber, Status catStatus) {
		
		this.cartId = cartId;
		this.customerName = customerName;
		this.cardNumber = cardNumber;
		this.cartStatus = catStatus;
	}
	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Status getCartStatus() {
		return cartStatus;
	}
	public void setCartStatus(Status catStatus) {
		this.cartStatus = catStatus;
	}
	
	
	
}
