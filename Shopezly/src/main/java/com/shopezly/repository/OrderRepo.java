package com.shopezly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopezly.model.Orders;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Integer>{

}
