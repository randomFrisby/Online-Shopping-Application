package com.shopezly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopezly.model.Admin;
import com.shopezly.service.AdminService;

import jakarta.validation.Valid;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/addAdmin")
	public ResponseEntity<Admin> createAdminHandler(@Valid @RequestBody Admin admin) throws Exception {
		
		Admin newAdmin = adminService.createAdmin(admin);
		
		return new ResponseEntity<>(newAdmin, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/admins")
	public ResponseEntity<List<Admin>> createUserHandler() throws Exception {
		
		List<Admin> admins = adminService.getAllAdmin();
		
		return new ResponseEntity<>(admins, HttpStatus.CREATED);
		
	}
}
