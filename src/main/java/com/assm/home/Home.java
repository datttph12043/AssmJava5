package com.assm.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assm.entity.Product;
import com.assm.repository.ProductRepositories;

@Controller
@RequestMapping("/home")
public class Home {
	@Autowired private ProductRepositories productRepo;
	
	@GetMapping(value="/")
	public String home(Model model) {
		List<Product> listProduct = this.productRepo.findAll();
		model.addAttribute("listProduct", listProduct);
		return "home/home";
	}
}

