package com.shopezly.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopezly.dto.LoginDTO;
import com.shopezly.exceptions.LoginException;
import com.shopezly.model.CurrentUserSession;
import com.shopezly.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<CurrentUserSession> logInCustomer(@RequestBody LoginDTO dto) throws LoginException {
		
		CurrentUserSession result = loginService.logIntoAccount(dto);
		
		return new ResponseEntity<>(result, HttpStatus.OK);	
	}
	
	@PostMapping("/logout")
	public ResponseEntity<CurrentUserSession> logoutCustomer(@RequestParam(required = false) String key) throws LoginException {
		
		CurrentUserSession result = loginService.logOutFromAccount(key);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
		
	}
	
	
	
}
