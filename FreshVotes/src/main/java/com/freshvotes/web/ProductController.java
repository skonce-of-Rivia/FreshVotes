package com.freshvotes.web;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.freshvotes.domain.Product;
import com.freshvotes.domain.User;
import com.freshvotes.service.ProductService;

import javassist.NotFoundException;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public String getProducts() {
		return "product";
	}
	
	@GetMapping("products/{productId}")
	public String getProduct(@PathVariable Long productId, ModelMap model, HttpServletResponse response) throws NotFoundException, IOException {
		Optional<Product> maybeProduct = productService.findProductById(productId);
		if(maybeProduct.isPresent()){
			Product product = maybeProduct.get();
			model.put("product", product);
		} else {
			response.sendError(HttpStatus.NOT_FOUND.value(), "Product with id " + productId + " was not found");
			return "product";
		}
		return "product";
	}
	
	@PostMapping("/products")
	public String createProduct(@AuthenticationPrincipal User user) {
		
		productService.saveProduct(user);
		return "redirect:/products";
	}
}
