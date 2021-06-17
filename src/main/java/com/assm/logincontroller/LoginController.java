package com.assm.logincontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.assm.entity.User;
import com.assm.libs.HashUtil;
import com.assm.repository.UserRepository;

@Controller
public class LoginController {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private HttpServletResponse response;
	
	@GetMapping("/login")
	public String getLoginForm() {
		return "login/login";
	}
	
	@PostMapping("/login")
	public String login(
		@RequestParam("email") String email,
		@RequestParam("password") String password
	) {
		User entity = this.userRepo.finByEmail(email);
		boolean checkPwd = false;
		
		if (entity != null) {
			checkPwd = HashUtil.verify(password, entity.getPassword());
		}
		
		if (entity == null || !checkPwd) {
			request.getSession().setAttribute("errorMessage", "Sai email hoặc password");
			return "redirect:/login";
		}

		request.getSession().setAttribute("user", entity);
		//tạo 1 listproduct
		return "redirect:/admin/user/";
	}
}
