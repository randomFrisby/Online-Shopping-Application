package com.shopezly.service;

import org.springframework.stereotype.Repository;

import com.shopezly.dto.LoginDTO;
import com.shopezly.exceptions.LoginException;
import com.shopezly.model.CurrentUserSession;

@Repository
public interface LoginService {

	public CurrentUserSession logIntoAccount(LoginDTO dto) throws LoginException;

	public CurrentUserSession logOutFromAccount(String key) throws LoginException;
}
