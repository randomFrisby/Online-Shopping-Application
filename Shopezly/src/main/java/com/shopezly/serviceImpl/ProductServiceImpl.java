package com.shopezly.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopezly.exceptions.CategoryNotFoundException;
import com.shopezly.exceptions.CustomerException;
import com.shopezly.exceptions.LoginException;
import com.shopezly.exceptions.ProductNotFoundException;
import com.shopezly.model.Admin;
import com.shopezly.model.Product;
import com.shopezly.repository.ProductRepo;
import com.shopezly.service.ProductService;
import com.shopezly.utility.LoginUtil;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private LoginUtil loginUtil;

	@Override
	public Product addProduct(Product product, String key) throws LoginException, CustomerException {
		Admin existingAdmin = loginUtil.provideExistingAdmin(key);
		
		System.out.println(existingAdmin);
		System.out.println("hello");
		
		existingAdmin.getProducts().add(product);
		
		return productRepo.save(product);
	}

	@Override
	public Product updateProduct(Product product, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product viewProductById(Integer productId, String key) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> viewAllProduct(String key) throws LoginException, CustomerException, ProductNotFoundException {
		Admin existingAdmin = loginUtil.provideExistingAdmin(key);
		
		List<Product> products = productRepo.findAll();
		
		if (products.isEmpty())
			throw new ProductNotFoundException("No products found");
		
		return products;
	}

	@Override
	public List<Product> viewProductByCategory(String categoryName, String key) throws CategoryNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeProduct(Integer productId, String key) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		
	}

}
