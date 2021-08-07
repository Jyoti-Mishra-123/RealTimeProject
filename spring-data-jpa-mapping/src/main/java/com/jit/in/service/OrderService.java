package com.jit.in.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jit.in.dto.OrderResponse;
import com.jit.in.entity.Customer;
import com.jit.in.exception.NoDataFoundException;
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
	
	
	public Customer findCustomer(Integer id) {
		Optional<Customer> optional = crepo.findById(id);
		
		if(optional.isPresent()) {
		return optional.get();
		}
		else
		 throw new NoDataFoundException("No customer found with this id");
	}
		

   public List<Customer> findAllCustOrders(){

    return crepo.findAll();
    
}
   
   public List<String[]> getJoinInfo(){
	   return crepo.getJoinInformation();
   }
   
   public List<OrderResponse> getJoinData(){
	   return crepo.getJoinInfo();
   }

}
