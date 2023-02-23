package com.shopezly.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopezly.model.CurrentUserSession;

public interface CurrentSessionRepo extends JpaRepository<CurrentUserSession, Integer> {

	public CurrentUserSession findByUuid(String uuid);
}
