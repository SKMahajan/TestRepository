package com.techm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techm.entity.Customer;
import com.techm.exception.CustomerNotFoundException;
import com.techm.service.CustomerService;

@EnableScheduling
@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomerList(){
		List<Customer> custList = customerService.getCustomerList();
		return custList;
	}
	
	@GetMapping("/customers/{id}")
	public Customer getCustomerById(@PathVariable Long id) {
		Customer customer = customerService.getCustomerById(id);
		if(customer == null) {
			throw new CustomerNotFoundException("Customer not found with id = "+id);
		}
		return customer;
	}
	
	@PostMapping("/customers")
	public Customer createCustomer(@Valid @RequestBody Customer cust) {
		Customer createdCustomer = customerService.createCustomer(cust);
		return createdCustomer;
	}
	
	@DeleteMapping("/customers/{id}")
	public void deleteCustomer(Long id) {
		customerService.deleteCustomer(id);
	}
}
