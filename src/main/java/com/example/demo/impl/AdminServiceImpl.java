package com.example.demo.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Admin;
import com.example.demo.repos.AdminRepo;
import com.example.demo.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminRepo adminRepo;

	@Override
	public Admin findById(int id) {
		
		Optional<Admin> tproduct = adminRepo.findById(id);
		
		if(!tproduct.isEmpty())
			return tproduct.get();			
		else
			return null;	
	}
	
//	@Override
//	public Admin updateProduct(int id, String name, String description, String price) {
//		
//		Admin product = adminRepo.findById(id).get();		
//		product.setName(name);
//		product.setDescription(description);
//		product.setPrice(price);
//		
//		
//		Admin savedEntity = adminRepo.save(product);
//		
//		return savedEntity;
//	}

	@Override
	public List<Admin> getAdminProduct() {
		List<Admin> savedEntity = adminRepo.findAll();
		return savedEntity;
	}

}
