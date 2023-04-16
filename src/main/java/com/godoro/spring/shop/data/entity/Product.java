package com.godoro.spring.shop.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

 @Entity
public class Product {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	private String productName;
	private double salesPrice;
	private long categoryId;
	private String imagePath;
	
	
	public Product() {
	
	}
	public Product(long productId, String productName, double salesPrice, long categoryId, String imagePath) {
	
		this.productId = productId;
		this.productName = productName;
		this.salesPrice = salesPrice;
		this.categoryId = categoryId;
		this.imagePath = imagePath;
	}
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getSalesPrice() {
		return salesPrice;
	}
	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	

}
