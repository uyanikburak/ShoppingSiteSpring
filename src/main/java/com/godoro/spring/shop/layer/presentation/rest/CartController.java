package com.godoro.spring.shop.layer.presentation.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.godoro.spring.shop.business.service.CartProductService;
import com.godoro.spring.shop.business.service.CartService;
import com.godoro.spring.shop.layer.business.dto.CartDto;
import com.godoro.spring.shop.layer.business.dto.CartProductDto;

@RestController
@RequestMapping("/cart")
public class CartController {

	private CartService cartService;
	private CartProductService cartProductService;

	public CartController(CartService cartService,CartProductService cartProductService) {
		this.cartService = cartService;
		this.cartProductService = cartProductService;
	}
	
	
	@GetMapping("/get/{cartid}")
	public List<CartProductDto> getCart(@PathVariable("cartid") long cartId) {
		cartService.get(cartId);
		return cartProductService.list(cartId);
	}
	

	@PostMapping("/add/{cartid}/{productid}")
	public long addCart(@PathVariable("cartid") long cartId, @PathVariable("productid") long productId) {
		cartProductService.add(cartId, productId);
		return cartId;	
	}
	
	@CrossOrigin
	@DeleteMapping("/remove/{cartid}/{productid}")
	public long removeCart(@PathVariable("cartid") long cartId, @PathVariable("productid") long productId) {
		cartProductService.remove(cartId, productId);
		return cartId;	
	}
	
	@CrossOrigin
	@PutMapping("/checkout")
	public boolean checkoutCart(@RequestBody ObjectNode json) {
		long cartId = json.get("cartId").asLong();
		String customerName = json.get("customerName").asText();
		long cardNumber = json.get("cardNumber").asLong();
		
		return cartService.checkout(cartId, customerName, cardNumber);
	}
	
	
	
}
