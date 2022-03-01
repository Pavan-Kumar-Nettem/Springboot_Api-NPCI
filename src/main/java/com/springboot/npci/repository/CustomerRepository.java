package com.springboot.npci.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.springboot.npci.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

	
	
}
