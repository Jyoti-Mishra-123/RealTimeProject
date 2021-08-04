package com.jit.in.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Product {
	
	@Id
	private int pid;//here i want to add pid manually
	private String pname;
	private int qty;
	private int price;
	
	

}
