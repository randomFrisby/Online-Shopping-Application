package com.shopezly.serviceImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopezly.exceptions.AddressException;
import com.shopezly.exceptions.CustomerException;
import com.shopezly.exceptions.LoginException;
import com.shopezly.model.Address;
import com.shopezly.model.Customer;
import com.shopezly.repository.AddressRepo;
import com.shopezly.service.AddressService;
import com.shopezly.utility.LoginUtil;

@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	private AddressRepo addressRepo;

	@Autowired
	private LoginUtil loginUtil;


	@Override
	public Address createAddress(Address addr, String key) throws LoginException, AddressException, CustomerException {
		
		
		Customer existingCustomer  = loginUtil.provideExistingCustomer(key);
		
		
		Set<Address> addresses = existingCustomer.getAddresses();
		
		if (addresses.contains(addr))
			throw new AddressException("Address is already present");
		
		addresses.add(addr);
		
		addr.setCustomer(existingCustomer);

		return addressRepo.save(addr);
	}

	@Override
	public String removeAddress(Integer addrId, String key) throws LoginException, CustomerException, AddressException {
		
		Customer existingCustomer  = loginUtil.provideExistingCustomer(key);
		
		
		System.out.println(existingCustomer.getFirstName());
		
		Boolean flag = false;
		for (Address addr: existingCustomer.getAddresses()) {
			if (addr.getAddressId() == addrId) {
				flag = true;
				addressRepo.delete(addr);
			}
		}
		
		if(!flag)
			throw new AddressException("Address not available to delete with id " + addrId);
		
	

		return "Address deleted successfully with id " + addrId;

	}

	@Override
	public Address updateAddress(Address addr, String key) throws LoginException, CustomerException, AddressException {
		
		Customer existingCustomer  = loginUtil.provideExistingCustomer(key);
		
		
		existingCustomer.getAddresses().add(addr);
		
		addr.setCustomer(existingCustomer);
		
		return addressRepo.save(addr);
	}

	@Override
	public Address viewAddress(Integer addressId, String key) throws LoginException, CustomerException, AddressException {
		
		Customer existingCustomer  = loginUtil.provideExistingCustomer(key);
		
		Set<Address> addresses = existingCustomer.getAddresses();
		
		for (Address addr: addresses) {
			if (addr.getAddressId() == addressId) {
				return addr;
			}
		}
		
		throw new AddressException("Address not found with id: " + addressId);
	}

	@Override
	public Set<Address> viewAllAddressOfCustomer(String key) throws LoginException, CustomerException, AddressException {
		
		Customer existingCustomer  = loginUtil.provideExistingCustomer(key);
		
		Set<Address> addresses = existingCustomer.getAddresses();
	
		if (addresses.isEmpty())
			throw new AddressException("No address available");
		
		
		return addresses;
	}
	

}
