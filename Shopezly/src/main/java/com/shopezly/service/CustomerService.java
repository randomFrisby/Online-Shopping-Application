package com.shopezly.service;

import java.util.List;

import com.shopezly.exceptions.CustomerException;
import com.shopezly.model.Customer;

public interface CustomerService {

	public Customer addCustomer(Customer customer);
	
	public List<Customer> getAllCustomers() throws CustomerException;
	
	public Customer getCustomerById(Integer customerId) throws CustomerException;
	
	public Customer updateCustomer(Integer customerId, Customer customer) throws CustomerException;
	
	public Customer deleteCustomer(Integer customerId) throws CustomerException;
	
}
