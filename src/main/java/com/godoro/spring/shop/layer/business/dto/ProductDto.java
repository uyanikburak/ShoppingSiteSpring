package com.godoro.spring.shop.layer.business.dto;

public class ProductDto {
	
	private long productId;
	private String productName;
	private double salesPrice;
	private long categoryId;
	private String imagePath;
	
	public ProductDto() {
	
	}
	public ProductDto(long productId, String productName, double salesPrice, long categoryId,String imagePath) {
	
		this.productId = productId;
		this.productName = productName;
		this.salesPrice = salesPrice;
		this.categoryId = categoryId;
		this.setImagePath(imagePath);
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
