package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.UnknownHttpStatusCodeException;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Admin;
import com.example.demo.repos.AdminRepo;
import com.example.demo.service.AdminService;

import jakarta.websocket.server.PathParam;


@RestController
@RequestMapping("/product")

public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AdminRepo adminRepo;
	
//	@GetMapping("/set")
////	public ResponseEntity<?> setProduct(@RequestParam int id,  @RequestParam String name, @RequestParam String description, @RequestParam double price){
//	public ResponseEntity<?> setProduct(@RequestParam String name, @RequestParam String description, @RequestParam double price){
//		
////		Admin product = new Admin(id, name, description, price);
//		
//		Admin admin = new Admin();
////		admin.setId(id);
//		admin.setName(name);
//		admin.setDescription(description);
//		admin.setPrice(price);
//		
//		
//		Admin savedEntity = adminRepo.save(admin);
//	
//	
//		return ResponseEntity.status(HttpStatus.OK)
//				.body(savedEntity);
//	}
	
	@PostMapping("/set")
//	public ResponseEntity<?> setProduct(){
	public ResponseEntity<?> setProduct(@RequestBody Admin admin){
		Admin savedEntity = adminRepo.saveAndFlush(admin);
		return ResponseEntity.status(HttpStatus.OK)
				.body(savedEntity);
	}
	@GetMapping("/getadmindata")
	public ResponseEntity<?> getAdminProduct(){
	List<Admin> savedEntity = adminService.getAdminProduct();
	return ResponseEntity.status(HttpStatus.OK).body(savedEntity);
	}
	@GetMapping("/delete")
	public ResponseEntity<?> deleteProduct(@RequestParam int id){
		Admin product =  adminRepo.findById(id).get();
		adminRepo.delete(product);
	
	
		return ResponseEntity.status(HttpStatus.OK)
				.body("Deleted");
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<?> findById(@PathVariable int id){
		
		Admin product = adminService.findById(id);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(product);
		
	}
	
	@GetMapping("/findByPrice")
	public ResponseEntity<?> findByPrice(@RequestParam double price){
		List<Admin> products = adminRepo.findByPrice(price);
	
		return ResponseEntity.status(HttpStatus.OK)
				.body(products);
	}
	
	@GetMapping("/findBetweenPrice")
	public ResponseEntity<?> findBetweenPrice(@RequestParam double p1, @RequestParam double p2){
		List<Admin> products = adminRepo.findBetweenPrice(p1, p2);
	
		return ResponseEntity.status(HttpStatus.OK)
				.body(products);
	}
	
//	@GetMapping("/update")
//	public ResponseEntity<?> updateProduct(@RequestParam int id, @RequestParam String name, @RequestParam String description, @RequestParam String price){
//
//		Admin product = adminService.updateProduct(id, name, description, price);
//	
//		return ResponseEntity.status(HttpStatus.OK)
//				.body(product);
//	}
	
//	@GetMapping("/get")
//	public ResponseEntity<?> getProduct() {
//		Admin p1 = new Admin();
//		p1.setId(1);
//		p1.setName("Coffee");
//		p1.setDescription("Narasus Coffee");
//		p1.setPrice(105.50);	
//		ResponseEntity.BodyBuilder builder = ResponseEntity.status(HttpStatus.OK);		
//		ResponseEntity response = builder.body(p1);
//		return(response);
//		
//	}
//	@GetMapping("/list")
//	public ResponseEntity<?>  getProducts() {
//		Admin p1 = new Admin(1, "Coffee" , "Narasus Coffee", 105.50);
//		Admin p2 = new Admin(2, "Tea", "Tajmahal Tea", 89.50);
//		Admin p3 = new Admin(3, "Oil", "Sunflower Oil", 205.50);
//		
//		
//		List<Admin> list = new ArrayList<Admin>();
//		list.add(p1);
//		list.add(p2);
//		list.add(p3);
//		return ResponseEntity.status(HttpStatus.NOT_FOUND)
//				.body(list);
//				
//
//	}
}
