package com.sample.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.login.service.AccountService;

@Controller
public class AccountController {

	private AccountService service;
	
	@RequestMapping("/")
	public String mainPage(HttpServletRequest request) {
		return "../../WEB_INF/jsp/main.jsp";
	}
	
	@RequestMapping("/login")
	public String checkUser(HttpServletRequest request) {
		String username = request.getParameter("userId");
		String userpwd = request.getParameter("userPwd");
		//service.loadUserByUsername(username);
		return "login/login.tiles";
	}
	
}
