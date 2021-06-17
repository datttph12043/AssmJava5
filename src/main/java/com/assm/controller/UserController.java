package com.assm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

import com.assm.dto.UserDTO;
import com.assm.entity.User;
import com.assm.libs.HashUtil;
import com.assm.mapper.UserMapper;
import com.assm.repository.UserRepository;
//import com.assm.util.UploadUtil;

@Controller
@RequestMapping("/admin/user")
public class UserController {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserMapper mapper;
	
//	@Autowired
//	private UploadUtil uploadUtil;
	
	@GetMapping(value="/")
	public String index(Model model) {
		List<User> listUser = this.userRepo.findAll();
		model.addAttribute("listUser", listUser);
		return "admin/user/index";
	}
	
	@GetMapping(value="/{id}")
	public String show(
		Model model,
		@PathVariable(name="id") User entity
	) {
		UserDTO userDTO = mapper.convertToDTO(entity);		
		model.addAttribute("user", userDTO);
		return "";
	}

	@GetMapping(value="/create")
	public String create()
	{
		return "admin/user/create";
	}
	
	@PostMapping(value="/store")
	public String store(
		Model model,
		@Valid UserDTO user,
		BindingResult result
	) {
		// kiểm tra lỗi
		User entity = mapper.convertToEntity(user);
		System.out.println(entity.getId());
		String hashedPwd = HashUtil.hash(user.getPassword());
		entity.setPassword(hashedPwd);

		this.userRepo.save(entity);
		return "redirect:/admin/user/";
	}

	@GetMapping(value="/edit/{id}")
	public String edit(
		@PathVariable("id") User entity,
		Model model
	) {
		UserDTO userDTO = mapper.convertToDTO(entity);		
		model.addAttribute("user", userDTO);
		
		return "admin/user/edit";
	}

	@PostMapping(value="/update/{id}")
	public String update(
		Model model,
		@Valid UserDTO user,
		BindingResult result
	) {
		if ( result.hasErrors() ) {
			List<ObjectError> errors = result.getAllErrors();

			System.out.println("true" + errors.get(0).getDefaultMessage());

			model.addAttribute("errors", errors);
//			return "redirect:/users/edit/1";
			return "admin/users/edit";
		} else {
			User entity = mapper.convertToEntity(user);

			this.userRepo.save(entity);
			return "redirect:/admin/user/";
		}
	}

	@PostMapping(value="/delete/{id}")
	public String delete(@PathVariable("id") User entity)
	{
		this.userRepo.delete(entity);
		return "redirect:/admin/user/";
	}
}
