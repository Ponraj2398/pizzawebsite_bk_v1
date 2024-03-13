package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="userlogin")
public class Register {
	@Id
	@GeneratedValue
	private int id;
   private String email;
   private String username;
   private String password;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
   
   
/**
 * @param id
 * @param firstname
 * @param lastname
 * @param username
 * @param password
 */
//public Register(int id, String firstname, String lastname, String username, String password) {
//	super();
//	this.id = id;
//	this.firstname = firstname;
//	this.lastname = lastname;
//	this.username = username;
//	this.password = password;
//}

}
