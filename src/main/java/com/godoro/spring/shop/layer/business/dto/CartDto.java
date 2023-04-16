package com.godoro.spring.shop.layer.business.dto;


import java.util.List;

import com.godoro.spring.shop.data.entity.Status;



public class CartDto {
	private long cartId;
	private String customerName;
	private long cardNumber;
	private Status cartStatus;
	private List<CartProductDto> cartProducts;
	
	public CartDto() {
		
	}
	public CartDto(long cartId, String customerName, long cardNumber, Status cartStatus, List<CartProductDto> cartProducts) {
		
		this.cartId = cartId;
		this.customerName = customerName;
		this.cardNumber = cardNumber;
		this.cartStatus = cartStatus;
		this.cartProducts = cartProducts;
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
	public void setCartStatus(Status cartStatus) {
		this.cartStatus = cartStatus;
	}
	public List<CartProductDto> getCartProducts() {
		return cartProducts;
	}
	public void setCartProducts(List<CartProductDto> cartProducts) {
		this.cartProducts = cartProducts;
	}
	
	
	
	
}
