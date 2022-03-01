package com.springboot.npci.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.npci.exception.ResourceNotFoundException;
import com.springboot.npci.model.Customer;
import com.springboot.npci.repository.CustomerRepository;
import com.springboot.npci.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	private CustomerRepository customerRepository;
	
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}


	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}


	@Override
	public List<Customer> getAllCustomers() {
		
		return customerRepository.findAll();
	}


	@Override
	public Customer getCustomerById(long id) {
		return customerRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Customer", "Id", id));
		
	}
	
	
	@Override
	public void deleteCustomer(long id) {
		
		// check whether a employee exist in a DB or not
		customerRepository.findById(id).orElseThrow(() -> 
								new ResourceNotFoundException("Customer", "Id", id));
		customerRepository.deleteById(id);
	}
	
}
