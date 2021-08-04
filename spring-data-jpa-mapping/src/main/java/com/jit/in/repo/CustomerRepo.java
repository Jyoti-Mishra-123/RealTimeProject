package com.jit.in.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jit.in.dto.OrderResponse;
import com.jit.in.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	@Query("SELECT c.name,p.pname FROM Customer c INNER JOIN c.product p")
	public List<String[]> getJoinInformation();
	
	@Query("SELECT new com.jit.in.dto.OrderResponse(c.name,p.pname,p.qty) FROM Customer c INNER JOIN c.product p")
	public List<OrderResponse> getJoinInfo();
		
	 

}
