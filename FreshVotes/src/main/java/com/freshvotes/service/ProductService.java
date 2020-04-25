package com.freshvotes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freshvotes.domain.Product;
import com.freshvotes.domain.User;
import com.freshvotes.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public Product saveProduct(User user) {
		
		Product product = new Product();
		product.setIsPublished(false);
		product.setUser(user);
			
		return productRepository.save(product);	
		
	}
	
	public Optional<Product> findProductById(Long id) {
		return productRepository.findById(id);
	}
}
