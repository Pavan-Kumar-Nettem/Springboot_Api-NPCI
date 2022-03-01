package com.springboot.npci.service;

import java.util.List;

import com.springboot.npci.model.Customer;

public interface CustomerService {

	 Customer saveCustomer(Customer customer);
	 List<Customer> getAllCustomers();
	 Customer getCustomerById(long id);
	 void deleteCustomer(long id);
}