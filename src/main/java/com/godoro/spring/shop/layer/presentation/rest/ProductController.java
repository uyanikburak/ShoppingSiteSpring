package com.godoro.spring.shop.layer.presentation.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.godoro.spring.shop.business.service.ProductService;
import com.godoro.spring.shop.business.service.ProductServiceImpl;
import com.godoro.spring.shop.layer.business.dto.ProductDto;

@RestController
@RequestMapping("/")
public class ProductController {
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/products/{categoryid}")
	public List<ProductDto> getProducts(@PathVariable("categoryid") long categoryId){
		return productService.list(categoryId);
	}
	
	@GetMapping("/product/{id}")
	public ProductDto getProduct(@PathVariable("id") long id){
		return productService.find(id);
	}

}
