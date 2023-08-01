package com.luv2code.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Repository;

import com.luv2code.demo.Entity.Product;

@Repository
public class ProductRepository implements Repo{

	List<Product> productlist = new ArrayList<Product>();

	
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productlist;
	}


	@Override
	public void save(Product p) {
		// TODO Auto-generated method stub
		productlist.add(p);
	}


	@Override
	public void delete(int id) {
		
		ListIterator<Product> iterator = productlist.listIterator();
		
		while(iterator.hasNext())
		{
			Product p1=iterator.next();
			if(p1.getProductId()==id)
			{
				productlist.remove(p1);
			}
		}
		/*
		 * for(Product p:productlist) {
		 * 
		 * if(p.getProductId()==id) { productlist.remove(p); } }
		 */
		
	}

}
