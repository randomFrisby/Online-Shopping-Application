package com.shopezly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopezly.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    
}

