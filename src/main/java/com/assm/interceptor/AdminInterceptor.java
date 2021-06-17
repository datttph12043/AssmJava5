package com.assm.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.assm.entity.User;

@Component
public class AdminInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object handler
		) throws IOException {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			
			if (user.getAdmin() != 1) {
				response.sendRedirect( request.getContextPath() + "/home/" );
				return false;
			}

			return true;
		}
}
