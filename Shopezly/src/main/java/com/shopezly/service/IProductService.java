package com.shopezly.service;

import java.util.List;

import com.shopezly.dto.ProductDTO;
import com.shopezly.exceptions.CategoryNotFoundException;
import com.shopezly.exceptions.ProductNotFoundException;
import com.shopezly.model.Product;

public interface IProductService {
	   
	   public Product addProduct(Product product);
	   
	   public Product updateProduct(Product product);
	   
	   public Product viewProduct(String productId) throws ProductNotFoundException;
	   
	   public List<Product> viewProductByCategory(String categoryName) throws CategoryNotFoundException;
	   
	   public void removeProduct(String productId) throws ProductNotFoundException;

	   public List<ProductDTO> findAll();
	   
	   public ProductDTO findById(Long id);
	   
	   public ProductDTO create(ProductDTO productDTO);
	   
	   public void deleteById(Long id);
	   
	   public List<ProductDTO> findByCategoryId(Long categoryId);
	}

