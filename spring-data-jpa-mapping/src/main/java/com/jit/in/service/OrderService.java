package com.jit.in.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jit.in.entity.Customer;
import com.jit.in.repo.CustomerRepo;
import com.jit.in.repo.ProductRepo;

@Service
public class OrderService {
	
	@Autowired
	private CustomerRepo crepo;
	
	@Autowired
	private ProductRepo prepo;
	
	public Customer AddCustomer(Customer cust) {
		
		return crepo.save(cust);
	}

}
