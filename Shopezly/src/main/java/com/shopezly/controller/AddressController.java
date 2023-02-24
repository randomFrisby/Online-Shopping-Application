package com.shopezly.controller;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopezly.exceptions.AddressException;
import com.shopezly.exceptions.CustomerException;
import com.shopezly.exceptions.LoginException;
import com.shopezly.exceptions.MyErrorDetails;
import com.shopezly.model.Address;
import com.shopezly.service.AddressService;

import jakarta.validation.Valid;

@RestController("/customers")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@PostMapping("/addAddress")
	public ResponseEntity<Address> addAddressHandler(@Valid @RequestBody Address addr, @RequestParam("key") String key)
			throws LoginException, AddressException, CustomerException {

		Address newAddr = addressService.createAddress(addr, key);

		return new ResponseEntity<>(newAddr, HttpStatus.CREATED);
	}

	@DeleteMapping("/addresses/{id}")
	public ResponseEntity<MyErrorDetails> removeAddressHandler(@PathVariable("id") Integer addrId, @RequestParam("key") String key)
			throws LoginException, AddressException, CustomerException {

		String res = addressService.removeAddress(addrId, key);
		
		MyErrorDetails response = new MyErrorDetails();
		response.setTimestamp(LocalDateTime.now());
		response.setMessage(res);
		response.setDetails("delete operation");

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping("/addresses")
	public ResponseEntity<Address> updatedAddressHandler(@Valid @RequestBody Address addr, @RequestParam("key") String key)
			throws LoginException, AddressException, CustomerException {

		Address updatedAddress = addressService.updateAddress(addr, key);

		return new ResponseEntity<>(updatedAddress, HttpStatus.OK);
	}

	@GetMapping("/addresses/{id}")
	public ResponseEntity<Address> viewAddressHandler(@PathVariable("id") Integer addressId, @RequestParam("key") String key)
			throws LoginException, AddressException, CustomerException {
		
		Address address = addressService.viewAddress(addressId, key);

		return new ResponseEntity<>(address, HttpStatus.OK);
	}

	@GetMapping("/addresses")
	public ResponseEntity<Set<Address>> viewAllAddressHandler(@RequestParam("key") String key)
			throws LoginException, CustomerException, AddressException {
		
		Set<Address> addresses = addressService.viewAllAddressOfCustomer(key);
		
		return new ResponseEntity<>(addresses, HttpStatus.OK);
	}
	
	
	
}
