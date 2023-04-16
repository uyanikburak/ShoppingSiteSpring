package com.godoro.spring.shop.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		private long categoryId;
		private String categoryName;
		
		
		public Category() {
			
		}
		
		public Category(long categoryId, String categoryName) {
			
			this.categoryId = categoryId;
			this.categoryName = categoryName;
		}

		
		public long getCategoryId() {
			return categoryId;
		}
		public void setCategoryId(long categoryId) {
			this.categoryId = categoryId;
		}
		public String getCategoryName() {
			return categoryName;
		}
		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}
		
}
