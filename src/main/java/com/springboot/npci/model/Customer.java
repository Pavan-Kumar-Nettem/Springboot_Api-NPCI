package com.springboot.npci.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="customer")
public class Customer {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;
	
	@Column(name = "aadhar_number", nullable = false)
     private long aadhar_number;
	
	@Column(name="age")
     private long age;
	
	@Column(name="email_id")
     private String email_id;
     
	@Column(name="first_name")
     private String first_name;
     
	@Column(name="last_name")
     private String last_name;
     
	@Column(name="phone_number")
     private long phone_number;
     
	@Column(name="sex")
     private String sex;
     
}
