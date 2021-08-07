package com.jit.in.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Customer {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	private String email;
	private String gender;
	@OneToMany(targetEntity =Product.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "cp_fk",referencedColumnName = "id")//customer id will act as a foreign key in the product table
	private List<Product> product;

}
