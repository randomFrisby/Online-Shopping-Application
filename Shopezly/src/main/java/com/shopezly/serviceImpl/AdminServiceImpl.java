package com.shopezly.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopezly.model.Admin;
import com.shopezly.repository.AdminRepo;
import com.shopezly.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepo adminRepo;

	@Override
	public List<Admin> getAllAdmin() throws Exception {

		List<Admin> admins = adminRepo.findAll();
		
		if (admins.isEmpty()) {
			throw new Exception("no admin found");
		}
		
		return admins;
	}

	@Override
	public Admin getAdminById(Integer adminId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin createAdmin(Admin admin) {
		
		return adminRepo.save(admin);
	}

}
