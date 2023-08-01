package com.luv2code.demo.dao;

import java.util.List;

import com.luv2code.demo.Entity.Product;

public interface Repo {

	List<Product> findAll();
	void  save(Product p);
	
	void delete(int id);
	
}
