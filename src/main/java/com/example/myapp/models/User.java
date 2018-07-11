package com.example.myapp.models;

import javax.persistence.*;

@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String username;
  private String password;
  private String first_name;
  private String last_name;
  private String phone;
  private String role;
  private String email;
  private String date_of_birth;
  
  public void set(User newUser) {
		this.username = newUser.username != null ?
	newUser.username : this.username; 
		this.password = newUser.password != null ?
	newUser.password : this.password; 
		this.first_name = newUser.first_name != null ?
	newUser.first_name : this.first_name; 
		this.last_name = newUser.last_name != null ?
	newUser.last_name : this.last_name; 
	}


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

   public String getEmail() {
     return email;
   }

   public void setEmail(String email) {
     this.email = email;
   }

   public String getPhone() {
     return phone;
   }

   public void setPhone(String phone) {
     this.phone = phone;
   }

   public String getRole() {
     return role;
   }

   public void setRole(String role) {
     this.role = role;
   }

  public String getDate_of_birth() {
  	return date_of_birth;
  }

  public void setDate_of_birth(String date_of_birth) {
  	this.date_of_birth = date_of_birth;
  }

  public String getFirst_name() {
  	return first_name;
  }

  public void setFirst_name(String first_name) {
  	this.first_name = first_name;
  }

  public String getLast_name() {
  	return last_name;
  }

  public void setLast_name(String last_name) {
  	this.last_name = last_name;
  }
}
