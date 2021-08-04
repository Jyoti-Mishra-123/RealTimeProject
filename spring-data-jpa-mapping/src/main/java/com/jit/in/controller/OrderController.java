package com.jit.in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jit.in.dto.OrderRequest;
import com.jit.in.dto.OrderResponse;
import com.jit.in.entity.Customer;
import com.jit.in.repo.CustomerRepo;
import com.jit.in.repo.ProductRepo;

@RestController
public class OrderController {
	
	@Autowired
	private CustomerRepo crepo;
	
	@Autowired
	private ProductRepo prepo;
	
	@PostMapping(value = "/placeOrder",consumes= {("application/json")})
	public Customer placeOrder(@RequestBody OrderRequest od) {
		return crepo.save(od.getCustomer());
		
	}
	
	@GetMapping("/findAllOrders")
	public List<Customer> findAllOrders(){
		return crepo.findAll();
	}
	
	@GetMapping("/getInfo")
	public List<String[]> getJoinInformation(){
		return crepo.getJoinInformation();
	}
	
	@GetMapping("/getInformation")
	public List<OrderResponse> getJoinData(){
		return crepo.getJoinInfo();
	}
	

}
