package com.shopezly.service;

import java.util.List;

import com.shopezly.model.Admin;

public interface AdminService {

	public List<Admin> getAllAdmin() throws Exception;
	
	public Admin getAdminById(Integer adminId);
	
	public Admin createAdmin(Admin admin) throws Exception;
}
