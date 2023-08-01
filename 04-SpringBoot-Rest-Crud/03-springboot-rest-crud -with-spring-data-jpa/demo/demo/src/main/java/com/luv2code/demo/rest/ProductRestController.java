package com.luv2code.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.demo.Entity.Product;
import com.luv2code.demo.dao.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductRestController {
	
	ProductRepository repo;
	
	@Autowired
	public ProductRestController(ProductRepository repo)
	{
		this.repo = repo;
	}
	
	@GetMapping("/products")
	public List<Product> findAll()
	{
		return repo.findAll();
	}
	
	
	@PostMapping("/product/{id}/{amount}")
	public void saveProduct(@PathVariable int id, @PathVariable int amount)
	{
		Product p = new Product();
		p.setProductId(id);
		p.setproductAmount(amount);
		repo.save(p);
	}
	
	@DeleteMapping("/product/{id}")
	public void  delete(@PathVariable int id)
	{
		repo.delete(id);
	}

}
