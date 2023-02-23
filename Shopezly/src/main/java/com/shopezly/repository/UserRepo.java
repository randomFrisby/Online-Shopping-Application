package com.shopezly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopezly.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	public User findByEmail(String email);
}
