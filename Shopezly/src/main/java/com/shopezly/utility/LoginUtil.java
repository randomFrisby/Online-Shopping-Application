package com.shopezly.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopezly.exceptions.CustomerException;
import com.shopezly.exceptions.LoginException;
import com.shopezly.model.CurrentUserSession;
import com.shopezly.model.Customer;
import com.shopezly.repository.CurrentSessionRepo;
import com.shopezly.repository.CustomerRepo;

@Component
public class LoginUtil {
	
	@Autowired
	CurrentSessionRepo currentSessionRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	
	public Customer provideExistingCustomer (String key) throws LoginException, CustomerException {
		
		CurrentUserSession currentSession = currentSessionRepo.findByUuid(key);
	
		
		if (currentSession == null)
			throw new LoginException("login before adding address");
			
		
		Customer existingCustomer = customerRepo.findById(currentSession.getUserId())
				.orElseThrow(() -> new CustomerException("Customer not found with id " + currentSession.getUserId()));
		
		
		return existingCustomer;
	}
}
