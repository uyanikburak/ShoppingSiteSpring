package com.godoro.spring.shop.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.godoro.spring.shop.data.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findByCategoryId(long categoryId);
}
