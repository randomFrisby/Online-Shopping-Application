package com.shopezly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopezly.model.Admin;
import com.shopezly.model.Customer;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {
	
}
