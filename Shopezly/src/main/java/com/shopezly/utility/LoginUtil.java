package com.shopezly.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopezly.exceptions.CustomerException;
import com.shopezly.exceptions.LoginException;
import com.shopezly.model.Admin;
import com.shopezly.model.CurrentUserSession;
import com.shopezly.model.Customer;
import com.shopezly.repository.AdminRepo;
import com.shopezly.repository.CurrentSessionRepo;
import com.shopezly.repository.CustomerRepo;

@Component
public class LoginUtil {
	
	@Autowired
	private CurrentSessionRepo currentSessionRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private AdminRepo adminRepo;
	
	
	public Customer provideExistingCustomer (String key) throws LoginException, CustomerException {
		
		CurrentUserSession currentSession = currentSessionRepo.findByUuid(key);
	
		
		if (currentSession == null)
			throw new LoginException("User as customer need to login to perfrom this operation");
			
		
		Customer existingCustomer = customerRepo.findById(currentSession.getUserId())
				.orElseThrow(() -> new CustomerException("Customer not found with id " + currentSession.getUserId()));
		
		
		return existingCustomer;
	}
	
	public Admin provideExistingAdmin (String key) throws LoginException, CustomerException {
		
		CurrentUserSession currentSession = currentSessionRepo.findByUuid(key);
	
		
		if (currentSession == null)
			throw new LoginException("User as admin need to login to perfrom this operation");
			
		
		Admin existingAdmin = adminRepo.findById(currentSession.getUserId())
				.orElseThrow(() -> new CustomerException("Admin not found with id " + currentSession.getUserId()));
		
		
		return existingAdmin;
	}
}
