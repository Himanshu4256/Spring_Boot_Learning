package com.jpa.test;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.jpa.entity.Product;
import com.jpa.repository.ProductRepository;

public class ProductRepositoryTest {
	
	@Autowired
	private ProductRepository productRepository;

	
void saveMethod() {
	Product product = new Product();
	product.setName("product 1");
	product.setDescription("product 1 description");
	product.setSku("100ABC");
	product.setPrice(new BigDecimal(100));
	product.setActive(true);
	product.setImageUrl(null);
	
	Product savedObject = productRepository.save(product);
	
	//display product info 
	System.out.println(savedObject.getId());
	System.out.println(savedObject.toString());
	
}
}
