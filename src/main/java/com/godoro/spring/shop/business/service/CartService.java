package com.godoro.spring.shop.business.service;


public interface CartService {

	boolean get(long cartId);
	boolean checkout(long cartId, String customerName, long cardNumber);

}
