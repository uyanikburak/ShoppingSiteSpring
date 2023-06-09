package com.godoro.spring.shop.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CartProduct {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cartProductId;
	private long cartId;
	private long productId;
	private long salesQuantity;

	public CartProduct() {
	}
	public CartProduct(long cartProductId, long cartId, long productId, long salesQuantity) {
		this.cartProductId = cartProductId;
		this.cartId = cartId;
		this.productId = productId;
		this.salesQuantity = salesQuantity;
	}
	public long getCartProductId() {
		return cartProductId;
	}
	public void setCartProductId(long cartProductId) {
		this.cartProductId = cartProductId;
	}
	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public long getSalesQuantity() {
		return salesQuantity;
	}
	public void setSalesQuantity(long salesQuantity) {
		this.salesQuantity = salesQuantity;
	}
	

}
