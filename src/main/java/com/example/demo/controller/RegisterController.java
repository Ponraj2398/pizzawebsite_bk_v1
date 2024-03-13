package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repos.RegisterRepo;
import com.example.demo.model.Register;

@RestController
@RequestMapping("/register")
public class RegisterController {
   @Autowired
   private RegisterRepo rgRepo;
   @PostMapping("/add")
   public ResponseEntity<?> addPerson(@RequestBody Register register){
	   if(rgRepo.existsByUsername(register.getUsername())) {
		   return ResponseEntity.status(HttpStatus.FOUND).body("User name already exists");
	   }
	   else {
		   Register savedEntity = rgRepo.saveAndFlush(register);
		   return ResponseEntity.status(HttpStatus.OK).body(savedEntity);   
	   }
   }
   @GetMapping("/check")
   public ResponseEntity<?> RegisterId(@RequestParam String username, @RequestParam String password){
	   Optional<Register> register = rgRepo.findByUsernameAndPassword(username, password);
	   if (register.isPresent()) {
	        // User with the given username and password exists
	        return ResponseEntity.status(HttpStatus.OK).body(register.get());
	    } else {
	        // User with the given username and password does not exist
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
	    }
   }
}

