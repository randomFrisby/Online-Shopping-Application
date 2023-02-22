package com.shopezly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopezly.exceptions.CustomerException;
import com.shopezly.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
