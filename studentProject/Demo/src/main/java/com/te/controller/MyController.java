package com.te.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.te.dto.Student;
import com.te.service.ServiceLayer;

@Controller
public class MyController {
	
	@Autowired
	ServiceLayer service;
	
	@GetMapping("/register")
	public String home() {
		return "registerPage";
	}
	
	@PostMapping("/registered")
	public String welcome(ModelMap map, Student student) {
		if(service.validate(student)) {
			map.addAttribute("student",student);
		}
		else {
			map.addAttribute("message","Register Failed");
		}

		return "welcome";
		
	}
	
	
	@GetMapping("/login")
	public String login() {
		return "loginPage";
	}
	
	@GetMapping("/logging")
	public String logging(ModelMap map,HttpServletRequest req , @RequestParam String name, @RequestParam String password) {
		
		if(service.authenticate(name, password)) {
			HttpSession session = req.getSession();
			session.setAttribute("name", name);
			return "studentMain";
		}
		
		return "loginPage";
	}
	
	@GetMapping("/logout")
	public String logOut(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		session.invalidate();
		
		return "logout";
	}
	
	

}
