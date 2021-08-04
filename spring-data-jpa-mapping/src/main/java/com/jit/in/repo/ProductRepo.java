package com.jit.in.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jit.in.entity.Product;

public interface ProductRepo extends JpaRepository<Product,Integer> {

}
