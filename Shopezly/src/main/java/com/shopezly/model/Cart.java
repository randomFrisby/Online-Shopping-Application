package com.shopezly.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private String cartId;
	private Customer customer;

//	private Map<Product, Integer> orderedProducts = new HashMap<>();
}
