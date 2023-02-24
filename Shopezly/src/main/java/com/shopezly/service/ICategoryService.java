package com.shopezly.service;

import java.util.List;

import com.shopezly.dto.CategoryDTO;
import com.shopezly.exceptions.CategoryNotFoundException;
import com.shopezly.model.Category;

public interface ICategoryService {
	   
	   public Category addCategory(Category category);
	   
	   public Category updateCategory(Category category);
	   
	   public Category viewCategory(String categoryId) throws CategoryNotFoundException;
	   
	   public List<Category> viewAllCategories();
	   
	   public void removeCategory(String categoryId) throws CategoryNotFoundException;

	   public List<CategoryDTO> findAll();
	    
	   public CategoryDTO findById(Long id);
	    
	   public CategoryDTO create(CategoryDTO categoryDTO);
	    
	   public void deleteById(Long id);
	}

