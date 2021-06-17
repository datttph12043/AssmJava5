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

import com.assm.dto.CategoriesDTO;
import com.assm.dto.UserDTO;
import com.assm.entity.Categories;
import com.assm.entity.User;
import com.assm.mapper.CategoriesMapper;
import com.assm.repository.CategoriesRepository;

@Controller
@RequestMapping("/admin/categories")
public class CategoriesController {
	@Autowired
	private CategoriesRepository CategoriesRepo;
	
	@Autowired
	private CategoriesMapper mapper;
	
	@GetMapping(value="/")
	public String index(Model model) {
		List<Categories> listCategories = this.CategoriesRepo.findAll();
		model.addAttribute("listCategories",listCategories);
		return "admin/categories/indexCategories";
	}
	
	@GetMapping(value="/create")
	public String create() {
		return "admin/categories/createCategories";
	}
	
	@PostMapping(value="/store")
	public String store(Model model, @Valid CategoriesDTO categories, BindingResult result) {
		Categories entity = mapper.convertToEntity(categories);
		this.CategoriesRepo.save(entity);
		return "redirect:/admin/categories/";
	}
	
	@GetMapping(value="/edit/{id}")
	public String edit(@PathVariable("id") Categories entity,Model model) {
		CategoriesDTO categoriesDTO = mapper.convertToDTO(entity);
		model.addAttribute("categories", categoriesDTO);
		return "admin/categories/editCategories";
	}
	@PostMapping(value="/update/{id}")
	public String update(Model model, @Valid CategoriesDTO categories, BindingResult result) {
		if ( result.hasErrors() ) {
			List<ObjectError> errors = result.getAllErrors();
			System.out.println(categories.getId());
			System.out.println("true" + errors.get(0).getDefaultMessage());

			model.addAttribute("errors", errors);
			return "redirect:/admin/categories/edit/"+categories.getId();
		} else {
			Categories entity = mapper.convertToEntity(categories);
			this.CategoriesRepo.save(entity);
			return "redirect:/admin/categories/";
		}
	}
	@GetMapping(value = "delete/{id}")
	public String delete(@PathVariable("id") Categories entity) {
		this.CategoriesRepo.delete(entity);
		return "redirect:/admin/categories/";
	}
	
}
