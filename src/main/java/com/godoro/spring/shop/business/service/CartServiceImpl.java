package com.godoro.spring.shop.business.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.godoro.spring.shop.data.repository.CartRepository;
import com.godoro.spring.shop.layer.business.dto.CartDto;
import com.godoro.spring.shop.data.entity.Cart;
import com.godoro.spring.shop.data.entity.Status;

@Service
public class CartServiceImpl implements CartService {
	
	private CartRepository cartRepository;

	public CartServiceImpl(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}
	@Override
	public boolean get(long cartId) {
		Optional<Cart> optional = cartRepository.findById(cartId);
		if(optional.isPresent()) {
			if(optional.get().getCartStatus() == Status.NEW)
			return true;
		}		
		CartDto cartDto = new CartDto(cartId,"",0,Status.NEW,null);
		Cart cart = toCart(cartDto);
		Cart cartTemp = cartRepository.save(cart);
		return false;
		
	}
	
	@Override
	public boolean checkout(long cartId, String customerName, long cardNumber) {
		
		Optional<Cart> optional = cartRepository.findById(cartId);
		if(optional.isPresent()) {
			if(optional.get().getCartStatus() == Status.NEW) {
				Cart cart = new Cart();
				cart.setCardNumber(cardNumber);
				cart.setCartId(cartId);
				cart.setCustomerName(customerName);
				cart.setCartStatus(Status.COMPLETED);
				cartRepository.save(cart);
				return true;
			}
		}
	return false;
	}
	
	public Cart toCart(CartDto cartDto) {
		Cart cart = new Cart();
		cart.setCardNumber(cartDto.getCardNumber());
		cart.setCartId(cartDto.getCartId());
		cart.setCartStatus(cartDto.getCartStatus());
		cart.setCustomerName(cartDto.getCustomerName());
		
		return cart;
	}
	
	public CartDto toCartDto(Cart cart) {
		CartDto cartDto = new CartDto();
		cartDto.setCardNumber(cart.getCardNumber());
		cartDto.setCartId(cart.getCartId());
		cartDto.setCartStatus(cart.getCartStatus());
		cartDto.setCustomerName(cart.getCustomerName());
		
		return cartDto;
	}


	
}
