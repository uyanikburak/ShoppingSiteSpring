package com.godoro.spring.shop.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

import com.godoro.spring.shop.data.entity.Category;
import com.godoro.spring.shop.data.repository.CategoryRepository;
import com.godoro.spring.shop.layer.business.dto.CategoryDto;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository categoryRepository;
	
	private CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<CategoryDto> list() {

		List<CategoryDto> categoryDtoList = new ArrayList<>();
		for (Category category : categoryRepository.findAll()) {
			categoryDtoList.add(toCategoryDto(category));
		}

		return categoryDtoList;
	}

	private CategoryDto toCategoryDto(Category category) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setCategoryId(category.getCategoryId());
		categoryDto.setCategoryName(category.getCategoryName());
		return categoryDto;
	}

	private Category toCategory(CategoryDto categoryDto) {
		Category category = new Category();
		category.setCategoryId(categoryDto.getCategoryId());
		category.setCategoryName(categoryDto.getCategoryName());
		return category;
	}
}
