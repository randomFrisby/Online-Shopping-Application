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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopezly.exceptions.CustomerException;
import com.shopezly.exceptions.LoginException;
import com.shopezly.exceptions.MyErrorDetails;
import com.shopezly.exceptions.ProductNotFoundException;
import com.shopezly.model.Orders;
import com.shopezly.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customer")
public class OrderController {
	
	@Autowired
	OrderService orderService;

	@PostMapping("/addOrder")
	public ResponseEntity<Orders> addOrder(@Valid @RequestBody Orders order, @RequestParam String key) 
			throws LoginException, CustomerException, ProductNotFoundException {
		
		Orders newOrder = orderService.addOrder(order, key);
		
		return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
	}
	
	@GetMapping("/orders")
	public ResponseEntity<List<Orders>> getAllOrders(String key) throws LoginException, CustomerException {
		
		List<Orders> orders = orderService.viewAllOrder(key);
		
		return new ResponseEntity<>(orders, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/orders/{id}")
	public ResponseEntity<Orders> viewOrderById(@PathVariable("id") Integer orderId, @RequestParam String key) 
			throws LoginException, CustomerException {
		
		Orders myOrder = orderService.viewOrderById(orderId, key);
		
		return new ResponseEntity<>(myOrder, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<MyErrorDetails> removeOrderById(@PathVariable("id") Integer orderId, @RequestParam String key) 
			throws LoginException, CustomerException {
		
		String res = orderService.removeOrder(orderId, key);
		
		MyErrorDetails response = new MyErrorDetails();
		response.setTimestamp(LocalDateTime.now());
		response.setMessage(res);
		response.setDetails("delete operation on orders");
		
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
}
	
