package com.springboot.npci.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.npci.model.Customer;
import com.springboot.npci.service.CustomerService;



@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	//build create customer REST API
	@PostMapping()
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
		return new ResponseEntity<Customer>(customerService.saveCustomer(customer), HttpStatus.CREATED);
			
	}
	
	// build get all customer REST API
	@GetMapping
	public List<Customer> getAllCustomer(){
		return customerService.getAllCustomers();
	}
	
	// build get customer by id REST API
		// http://localhost:8080/api/customers/1
		@GetMapping("{id}")
		public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long customerId){
			return new ResponseEntity<Customer>(customerService.getCustomerById(customerId), HttpStatus.OK);
		}
		
		// build delete customer REST API
		// http://localhost:8080/api/customers/1
		@DeleteMapping("{id}")
		public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id){
			
			// delete customer from DB
			customerService.deleteCustomer(id);
			
			return new ResponseEntity<String>("Customer deleted successfully!.", HttpStatus.OK);
		}
	
}
