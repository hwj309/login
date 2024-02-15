package com.sample.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.login.service.AccountService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AccountController {

	private AccountService service;
	
	@RequestMapping("/")
	public String mainPage() {
		return "/";
	}
	
	@RequestMapping("/login")
	public void checkUser(HttpServletRequest request) {
		String username = request.getParameter("userId");
		String userpwd = request.getParameter("userPwd");
		service.loadUserByUsername(username);
	}
	
}
