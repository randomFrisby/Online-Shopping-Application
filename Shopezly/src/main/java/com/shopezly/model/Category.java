package com.shopezly.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {

   @Id
   private String categoryId;
   private String categoryName;

   @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
   private List<Product> products;

public Category(String categoryId, String categoryName, List<Product> products) {
	super();
	this.categoryId = categoryId;
	this.categoryName = categoryName;
	this.products = products;
}

public Category() {
	super();
	// TODO Auto-generated constructor stub
}

public String getCategoryId() {
	return categoryId;
}

public void setCategoryId(String categoryId) {
	this.categoryId = categoryId;
}

public String getCategoryName() {
	return categoryName;
}

public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}

public List<Product> getProducts() {
	return products;
}

public void setProducts(List<Product> products) {
	this.products = products;
}

@Override
public String toString() {
	return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", products=" + products + "]";
}

}

