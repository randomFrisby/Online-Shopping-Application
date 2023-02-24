package com.shopezly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopezly.model.Category;
import com.shopezly.model.Product;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByName(String name);
    List<Category> findAllByOrderByNameAsc();
}

