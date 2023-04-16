package com.godoro.spring.shop.business.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.godoro.spring.shop.data.entity.Product;
import com.godoro.spring.shop.data.repository.ProductRepository;
import com.godoro.spring.shop.layer.business.dto.ProductDto;

@Service
public class ProductServiceImpl implements ProductService{
	
	private ProductRepository productRepository;
	
	private ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	@Override
	public ProductDto find(long productId) {
		
		Optional<Product> optional = productRepository.findById(productId);
		if(optional.isPresent()) {
			return toProductDto(optional.get());
		}
		return null;
	}

	@Override
	public List<ProductDto> list(long categoryId) {
		List<ProductDto> productDtoList = new ArrayList<>();
		for(Product product : productRepository.findByCategoryId(categoryId)) {
			productDtoList.add(toProductDto(product));
		}

		return productDtoList;		
	}
	
	private ProductDto toProductDto(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setCategoryId(product.getCategoryId());
		productDto.setProductId(product.getProductId());
		productDto.setProductName(product.getProductName());
		productDto.setSalesPrice(product.getSalesPrice());
		productDto.setImagePath(product.getImagePath());
		return productDto;
	}
	
	private Product toProduct(ProductDto productDto) {
		Product product = new Product();
		product.setCategoryId(productDto.getCategoryId());
		product.setProductId(productDto.getProductId());
		product.setProductName(productDto.getProductName());
		product.setSalesPrice(productDto.getSalesPrice());
		product.setImagePath(productDto.getImagePath());

		return product;
	}
	
	

}
