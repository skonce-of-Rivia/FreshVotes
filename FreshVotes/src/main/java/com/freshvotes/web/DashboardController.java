package com.freshvotes.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.freshvotes.domain.Product;
import com.freshvotes.domain.User;
import com.freshvotes.service.ProductService;

@Controller
public class DashboardController {

	@Autowired
	ProductService productService;

	@GetMapping("/")
	public String rootView() {
		return "index";
	}

	@GetMapping("/dashboard")
	public String dashboard(@AuthenticationPrincipal User user, ModelMap model) {
			List<Product> products = productService.findProductsByUser(user);
			model.put("products", products);
		return "dashboard";
	}

}
