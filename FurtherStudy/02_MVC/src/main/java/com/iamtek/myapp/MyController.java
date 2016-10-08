package com.iamtek.myapp;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	@RequestMapping("/login.html")
	public String login(Locale locale, Model model) {
		return "security/login";
	}

	@RequestMapping("/welcome.html")
	public String welcome(Locale locale, Model model) {
		return "security/welcome";
	}

	@RequestMapping("/loginForm.html")
	public String loginForm(Locale locale, Model model) {
		return "security/loginForm";
	}
	
}
