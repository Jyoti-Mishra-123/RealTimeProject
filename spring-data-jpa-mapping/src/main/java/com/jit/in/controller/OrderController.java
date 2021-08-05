package com.jit.in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jit.in.dto.OrderRequest;
import com.jit.in.dto.OrderResponse;
import com.jit.in.entity.Customer;
import com.jit.in.repo.CustomerRepo;
import com.jit.in.repo.ProductRepo;
import com.jit.in.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@Autowired
	private CustomerRepo crepo;
	
	@Autowired
	private ProductRepo prepo;
	
	@PostMapping(value = "/placeOrder",consumes= {("application/json")})
	public ResponseEntity<Customer> placeOrder(@RequestBody OrderRequest od) {
		return new ResponseEntity<>(service.AddCustomer(od.getCustomer()),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/findAllOrders")
	public ResponseEntity<List<Customer>> findAllOrders(){
		return new ResponseEntity<>(crepo.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/getInfo")
	public ResponseEntity<List<String[]>> getJoinInformation(){
		return new ResponseEntity<>(crepo.getJoinInformation(),HttpStatus.OK);
	}
	
	@GetMapping("/getInformation")
	public ResponseEntity<List<OrderResponse>> getJoinData(){
		return new ResponseEntity<>(crepo.getJoinInfo(),HttpStatus.OK);
	}
	

}
