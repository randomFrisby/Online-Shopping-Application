package com.shopezly.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopezly.enums.Role;
import com.shopezly.exceptions.CustomerException;
import com.shopezly.model.Customer;
import com.shopezly.repository.CustomerRepo;
import com.shopezly.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		
		if (customer.getRole() != Role.CUSTOMER)
			throw new CustomerException("Enter a valid role for customer");
			
		return customerRepo.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() throws CustomerException {
		List<Customer> customers = customerRepo.findAll();
		
		if (customers.isEmpty())
			throw new CustomerException("no customers found");
		
		return customers;
	}

	@Override
	public Customer getCustomerById(Integer customerId) throws CustomerException {
		
		Customer existingCustomer = customerRepo.findById(customerId).orElseThrow(() -> new CustomerException("Customer not found with id " + customerId));
		
		return existingCustomer;
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		Customer existingCustomer = customerRepo.findById(customer.getUserId())
				.orElseThrow(() -> new CustomerException("Customer not found with id " + customer.getUserId()));

		if(customer.getRole() != Role.CUSTOMER)
			throw new CustomerException("Enter a valid role for customer");
		
		return customerRepo.save(customer);
	}

	@Override
	public String deleteCustomer(Integer customerId) throws CustomerException {
		Customer existingCustomer = customerRepo.findById(customerId).orElseThrow(() -> new CustomerException("Customer not found with id " + customerId));
		
		customerRepo.delete(existingCustomer);
		
		return "Customer deleted with id: " + customerId;
	}

}
