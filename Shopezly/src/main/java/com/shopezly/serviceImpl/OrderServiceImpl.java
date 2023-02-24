package com.shopezly.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopezly.exceptions.CustomerException;
import com.shopezly.exceptions.LoginException;
import com.shopezly.model.Customer;
import com.shopezly.model.Orders;
import com.shopezly.repository.OrderRepo;
import com.shopezly.service.OrderService;
import com.shopezly.utility.LoginUtil;


@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private LoginUtil loginUtil;
	

	@Override
	public Orders addOrder(Orders order, String key) throws LoginException, CustomerException {
		Customer existingCustomer  = loginUtil.provideExistingCustomer(key);
		
		existingCustomer.getOrders().add(order);
		
		order.setCustomer(existingCustomer);
		
		return orderRepo.save(order);
	}

	@Override
	public Orders updateOrder(Orders order, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeOrder(Integer orderId, String key) throws LoginException, CustomerException {
		Customer existingCustomer  = loginUtil.provideExistingCustomer(key);
		
		
		Boolean flag = false;
		for (Orders ord: existingCustomer.getOrders()) {
			if (ord.getOrderId() == orderId) {
				flag = true;
				orderRepo.delete(ord);
			}
		}
		
		if(!flag)
			throw new CustomerException("Order not available to delete with id " + orderId);
		
	

		return "Order deleted successfully with id " + orderId;
	}

	@Override
	public Orders viewOrderById(Integer orderId, String key) throws LoginException, CustomerException {
		Customer existingCustomer  = loginUtil.provideExistingCustomer(key);
		
		List<Orders> orders = existingCustomer.getOrders();
		
		for (Orders ord: orders) {
			if (ord.getOrderId() == orderId) {
				return ord;
			}
		}
		
		throw new CustomerException("Order not found with id: " + orderId);
	}

	@Override
	public List<Orders> viewAllOrder(String key) throws LoginException, CustomerException {
		Customer existingCustomer  = loginUtil.provideExistingCustomer(key);
		
		List<Orders> orders = existingCustomer.getOrders();
		
		if (orders.isEmpty())
			throw new CustomerException("No orders found for Customer " +  existingCustomer.getFirstName());
		
		return orders;
	}

	@Override
	public List<Orders> viewAllByLocation(String location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> viewOrderByDate(LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

}
