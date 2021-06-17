package com.assm.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assm.entity.Product;
import com.assm.repository.ProductRepositories;
import com.assm.service.CartService;

@Controller
@RequestMapping("/home")
public class Home {
	
	@Autowired 
	private ProductRepositories productRepo;
	
	@Autowired 
	private CartService cartService;
	

	@GetMapping(value="/")
	public String home(Model model) {
		List<Product> listProduct = loadProductToSale();
		model.addAttribute("listProduct", listProduct);
		return "/WEB-INF/views/home/home.jsp";
	}
	
	
	@GetMapping(value="/addToCard/{productId}")
	public String addToCart(@PathVariable Integer productId, Model model) throws Exception {
		
		// them vao gio hang
		cartService.addToCart(productId);
		
		// thuc hien load lai trang
		List<Product> listProduct = loadProductToSale();
		model.addAttribute("listProduct", listProduct);
		return "/WEB-INF/views/home/home.jsp";
	}
	
	
	public List<Product> loadProductToSale() {
		return this.productRepo.findAll();
	}
}

