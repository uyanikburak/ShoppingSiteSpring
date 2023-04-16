package com.godoro.spring.shop.layer.presentation.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.godoro.spring.shop.business.service.CategoryService;
import com.godoro.spring.shop.business.service.CategoryServiceImpl;
import com.godoro.spring.shop.layer.business.dto.CategoryDto;

@RestController
@RequestMapping("/category")
public class CategoryController {
	private CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping("/list")
	public List<CategoryDto> getCategories(){
		return categoryService.list();
	}
	
}
