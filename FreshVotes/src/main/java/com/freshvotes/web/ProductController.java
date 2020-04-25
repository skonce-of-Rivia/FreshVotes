package com.freshvotes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.freshvotes.domain.User;
import com.freshvotes.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public String getProducts() {
		return "product";
	}
	
	@PostMapping("/products")
	public String createProduct(@AuthenticationPrincipal User user) {
		
		productService.saveProduct(user);
		return "redirect:/products";
	}
}
