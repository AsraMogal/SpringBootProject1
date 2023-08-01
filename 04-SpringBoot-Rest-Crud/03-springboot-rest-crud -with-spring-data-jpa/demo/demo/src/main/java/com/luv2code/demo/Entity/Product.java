package com.luv2code.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private int productId;
	
	@Column(name="product_amount")
	private int productAmount;

	public Product()
	{
		
	}

	public Product(int productId, int productAmount) {
		super();
		this.productId = productId;
		this.productAmount = productAmount;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getproductAmount() {
		return productAmount;
	}

	public void setproductAmount(int productAmount) {
		this.productAmount = productAmount;
	}
	
	@Override
	public String toString() {
		return "Product [productid=" + productId + ", productAmount=" + productAmount + "]";
	}
}
