package com.godoro.spring.shop.business.service;

import java.util.List;

import com.godoro.spring.shop.layer.business.dto.CartProductDto;

public interface CartProductService {
	CartProductDto add(long cartId, long productId);
	void remove(long cartId, long productId );
	List<CartProductDto> list(long cartId);

}
