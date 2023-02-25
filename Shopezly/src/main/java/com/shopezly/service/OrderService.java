package com.shopezly.service;

import java.time.LocalDate;
import java.util.List;

import com.shopezly.exceptions.CustomerException;
import com.shopezly.exceptions.LoginException;
import com.shopezly.exceptions.ProductNotFoundException;
import com.shopezly.model.Orders;

public interface OrderService {

	public Orders addOrder(Orders order, String key) throws LoginException, CustomerException, ProductNotFoundException;
	
	public Orders updateOrder(Orders order, String key) throws LoginException, CustomerException;
	
	public String removeOrder(Integer orderId, String key) throws LoginException, CustomerException;
	
	public Orders viewOrderById(Integer orderId, String key) throws LoginException, CustomerException;
	
	public List<Orders> viewAllOrder(String key) throws LoginException, CustomerException;
	
	public List<Orders> viewAllByLocation(String location) throws LoginException, CustomerException;
	
	public List<Orders> viewOrderByDate(LocalDate date) throws LoginException, CustomerException;
}
