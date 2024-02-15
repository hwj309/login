package com.sample.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.login.service.AccountService;

@Controller
public class AccountController {

	private AccountService service;
	
	@RequestMapping("/")
	public String mainPage(Model model) {
		return "/main";
	}
	
	@RequestMapping("/login")
	public String checkUser(HttpServletRequest request) {
		String username = request.getParameter("userId");
		String userpwd = request.getParameter("userPwd");
		//service.loadUserByUsername(username);
		return "login/login";
	}
	
}
