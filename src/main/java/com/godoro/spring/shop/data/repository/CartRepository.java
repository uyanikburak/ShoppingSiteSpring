package com.godoro.spring.shop.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.godoro.spring.shop.data.entity.Cart;

public interface CartRepository extends CrudRepository<Cart, Long>{

}
