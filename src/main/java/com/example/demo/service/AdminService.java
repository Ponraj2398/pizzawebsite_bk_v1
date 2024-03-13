package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Admin;

public interface AdminService {
	
	Admin findById(int id);
//	Admin updateProduct(int id, String name, String description, double price);
	public List<Admin> getAdminProduct();

}
