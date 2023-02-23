package com.shopezly.service;

import java.util.Set;

import com.shopezly.exceptions.AddressException;
import com.shopezly.exceptions.CustomerException;
import com.shopezly.exceptions.LoginException;
import com.shopezly.model.Address;

public interface AddressService {
	
	public Address createAddress(Address addr, String key) throws LoginException, AddressException, CustomerException;

	public String removeAddress(Integer addressId, String key) throws LoginException, CustomerException, AddressException;

	public Address updateAddress(Address addr, String key) throws LoginException, CustomerException, AddressException;

	public Address viewAddress(Integer addrId, String key) throws LoginException, CustomerException, AddressException;

	public Set<Address> viewAllAddressOfCustomer(String key) throws LoginException, CustomerException, AddressException;

}
