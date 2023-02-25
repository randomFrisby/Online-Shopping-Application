package com.shopezly.service;

import java.util.List;

import com.shopezly.exceptions.CategoryNotFoundException;
import com.shopezly.exceptions.CustomerException;
import com.shopezly.exceptions.LoginException;
import com.shopezly.exceptions.ProductNotFoundException;
import com.shopezly.model.Product;

public interface ProductService {
	   
	   public Product addProduct(Product product, String key) throws LoginException, CustomerException;
	   
	   public Product updateProduct(Integer productId, Integer quantity, String key) throws LoginException, CustomerException, ProductNotFoundException;
	   
	   public Product viewProductById(Integer productId, String key) throws LoginException, CustomerException, ProductNotFoundException;
	   
	   public List<Product> viewAllProduct(String key) throws LoginException, CustomerException, ProductNotFoundException;  
	   
	   public List<Product> viewProductByCategory(String categoryName, String key) throws LoginException, CustomerException, ProductNotFoundException, CategoryNotFoundException;
	   
	   public String removeProduct(Integer productId, String key) throws LoginException, CustomerException, ProductNotFoundException;

}

