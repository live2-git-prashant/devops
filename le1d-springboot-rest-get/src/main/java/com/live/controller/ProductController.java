package com.live.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.live.model.Product;

@RestController
public class ProductController {	
	public ProductController() {
		products.add(new Product(100l, "SpringBoot.", "Book", 500.50f));
		products.add(new Product(101l, "Angular", "Book", 555.50f));
	}
	List<Product> products = new ArrayList<Product>();
	@GetMapping("/products")
	public List<Product> getProducts() {
		// ideally connect to service, from service to repo, repo to db and fetch the
		// data.
		// for convenience create a stub collection
		return products;
	}
	
	@PostMapping("/products")
	public Product createProduct(@RequestBody Product product) {
		product.setProductId(1000L);
		products.add(product);
		return product;
	}
	
	//Lab Practice 
	// Implement the @PutMapping
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable(value="id") long productId) {
		Product productVar = null;
		int index = -1;
		for(Product product1: products) {
			index++;
			if(product1.getProductId() == productId){
				products.remove(index);
			}
			break;
		}
	}
}
