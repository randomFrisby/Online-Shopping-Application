package com.shopezly.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopezly.exceptions.CustomerException;
import com.shopezly.exceptions.MyErrorDetails;
import com.shopezly.model.Customer;
import com.shopezly.service.CustomerService;

import jakarta.validation.Valid;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomerHandler(@Valid @RequestBody Customer customer) throws CustomerException {
		
		Customer newCustomer = customerService.addCustomer(customer);
		
		return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerByIdHandler(@PathVariable("id") Integer customerId) throws CustomerException {
		
		Customer existingCustomer = customerService.getCustomerById(customerId);
		
		return new ResponseEntity<>(existingCustomer, HttpStatus.ACCEPTED);
	}
	

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomerHandler() throws CustomerException {
		
		List<Customer> customers = customerService.getAllCustomers();
		
		return new ResponseEntity<>(customers, HttpStatus.ACCEPTED);
	}
	
	
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomerHandler(@Valid @RequestBody Customer customer) throws CustomerException {
		
		Customer updatedCustomer = customerService.updateCustomer(customer);
		
		return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
	}
	
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<MyErrorDetails> deleteCustomerHandler(@PathVariable("id") Integer customerId) throws CustomerException {
		
		String res = customerService.deleteCustomer(customerId);
		
		MyErrorDetails response = new MyErrorDetails();
		response.setTimestamp(LocalDateTime.now());
		response.setMessage(res);
		response.setDetails("delete operation");
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
