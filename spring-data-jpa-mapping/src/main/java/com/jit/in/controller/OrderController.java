package com.jit.in.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

                Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	
	 

	
	@PostMapping(value = "/placeOrder",consumes= {("application/json")})
	public ResponseEntity<Customer> placeOrder(@RequestBody OrderRequest od) {
 
		logger.debug("placeOrder method execution started");
   	return new ResponseEntity<>(service.AddCustomer(od.getCustomer()),HttpStatus.CREATED);
		
	}
	//demo
	@GetMapping("/findCustomer/{id}")
	public ResponseEntity<Customer> findCustById(@PathVariable Integer id){
		Customer customer = service.findCustomer(id);
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	
	@GetMapping("/findAllOrders")
	public ResponseEntity<List<Customer>> findAllOrders(){
		logger.debug("findAllOrders method execution started");
		return new ResponseEntity<>(service.findAllCustOrders(),HttpStatus.OK);
	}
	
	@GetMapping("/getInfo")
	public ResponseEntity<List<String[]>> getJoinInformation(){
		logger.debug("getJoinInformation method execution started");
		return new ResponseEntity<>(service.getJoinInfo(),HttpStatus.OK);
	}
	
	@GetMapping("/getJoinData")
	public ResponseEntity<List<OrderResponse>> getJoinData(){
		return new ResponseEntity<>(service.getJoinData(),HttpStatus.OK);
	}
	

}
