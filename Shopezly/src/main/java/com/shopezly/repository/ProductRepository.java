package com.shopezly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopezly.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}

