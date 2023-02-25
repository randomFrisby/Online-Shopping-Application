package com.shopezly.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopezly.exceptions.CustomerException;
import com.shopezly.exceptions.LoginException;
import com.shopezly.exceptions.ProductNotFoundException;
import com.shopezly.model.Customer;
import com.shopezly.model.Orders;
import com.shopezly.model.Product;
import com.shopezly.repository.OrderRepo;
import com.shopezly.repository.ProductRepo;
import com.shopezly.service.OrderService;
import com.shopezly.utility.LoginUtil;


@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private LoginUtil loginUtil;
	
	@Autowired
	private ProductRepo productRepo;
	

	@Override
	public Orders addOrder(Orders order, String key) throws LoginException, CustomerException, ProductNotFoundException {
		Customer existingCustomer  = loginUtil.provideExistingCustomer(key);
		
		Map<Product, Integer> products = order.getOrderedProducts();
		
		List<Integer> ids = order.getProductIds();
		List<Integer> qtys = order.getProductQty();
		
		if (ids.isEmpty() || qtys.isEmpty() || ids.size() != qtys.size())
			throw new CustomerException("Please provide apporpriate product ids and their quantity");
		
		for (int i = 0; i < ids.size(); i++) {
			Integer id = ids.get(i);
			Integer qty = qtys.get(i);
			
			Product product = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with id " + id));
			
			if (product.getQuantity() < qty) 
				throw new ProductNotFoundException("Not enough product available , you require " + qty + " but only " + product.getQuantity() + " are available");
			
		}
		
		for (int i = 0; i < ids.size(); i++) {
			
			Integer id = ids.get(i);
			Integer qty = qtys.get(i);
			
			Product product = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with id " + id));
			
			products.put(product, qty);
			
			product.setQuantity(product.getQuantity() - qty);
			
			Product updateProduct = productRepo.save(product);
			
		}
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
