package com.godoro.spring.shop.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.godoro.spring.shop.data.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
