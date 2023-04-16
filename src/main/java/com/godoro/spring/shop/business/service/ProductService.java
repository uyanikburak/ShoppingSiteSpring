package com.godoro.spring.shop.business.service;

import java.util.List;

import com.godoro.spring.shop.layer.business.dto.ProductDto;

public interface ProductService {
	
	ProductDto find(long productId);
	
	List<ProductDto> list(long categoryId);
}
