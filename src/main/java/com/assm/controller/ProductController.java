package com.assm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.assm.dto.CategoriesDTO;
import com.assm.dto.ProductDTO;
import com.assm.entity.Categories;
import com.assm.entity.Product;
import com.assm.mapper.ProductMapper;
import com.assm.repository.ProductRepositories;
//import com.it15306.util.UploadUtil;

@Controller
@RequestMapping("/admin/product")
public class ProductController {
	
	@Autowired ProductRepositories productRepo;
	@Autowired ProductMapper mapper;
	
	@GetMapping(value="/")
	public String index(Model model) {
		List<Product> listProduct = this.productRepo.findAll();
		model.addAttribute("listProduct", listProduct);
		return "admin/product/indexProduct";
	}
	
	@GetMapping(value="/create")
	public String create() {
		return "admin/product/createProduct";
	}
	
	@PostMapping(value="/store")
	public String store(Model model, @Valid ProductDTO productDTO, BindingResult result) {
		Product entity = mapper.convertToEntity(productDTO);
		String time = java.time.LocalDateTime.now()+"";
		entity.setCreatedate(time);
		this.productRepo.save(entity);
		return "redirect:/admin/product/";
	}
	
	@GetMapping(value="/edit/{id}")
	public String edit(@PathVariable("id") Product entity, Model model) {
		ProductDTO productDTO = mapper.convertToDTO(entity);
		model.addAttribute("product", productDTO);
		return "admin/product/editProduct";
	}
	
	@PostMapping(value="/update/{id}")
	public String update(Model model, @Valid ProductDTO productDTO, BindingResult result) {
		if ( result.hasErrors() ) {
			List<ObjectError> errors = result.getAllErrors();
			System.out.println(productDTO.getId());
			System.out.println("true" + errors.get(0).getDefaultMessage());

			model.addAttribute("errors", errors);
			return "redirect:/admin/product/edit/"+productDTO.getId();
		} else {
			String time = java.time.LocalDateTime.now()+"";
			productDTO.setCreatedate(time);
			Product entity = mapper.convertToEntity(productDTO);
			this.productRepo.save(entity);
			return "redirect:/admin/product/";
		}
	}
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable("id") Product entity) {
		this.productRepo.delete(entity);
		return "redirect:/admin/product/";
	}
}
