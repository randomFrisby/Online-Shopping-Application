package com.shopezly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopezly.exceptions.CustomerException;
import com.shopezly.exceptions.LoginException;
import com.shopezly.exceptions.ProductNotFoundException;
import com.shopezly.model.Product;
import com.shopezly.service.ProductService;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class ProductController {
    
	@Autowired
    private ProductService productService;
	


    @GetMapping("/products")
    public ResponseEntity<List<Product>> viewAllProductHandler(String key) 
    		throws LoginException, CustomerException, ProductNotFoundException {
    	
    	List<Product> products = productService.viewAllProduct(key);
    	
    	return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    	
    }


    @PostMapping("/products")
    public ResponseEntity<Product> addProductHandler(@Valid @RequestBody Product product, String key) 
    		throws LoginException, CustomerException {
        
    	System.out.println(product.getColor());
    	
    	
    	System.out.println("hi!");
    	
    	Product newProduct = productService.addProduct(product, key);
    	
    	return new ResponseEntity<Product>(newProduct, HttpStatus.CREATED);
    }

}

