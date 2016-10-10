package com.iamtek.myapp;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	@RequestMapping("/user")
	public String login(Locale locale, Model model) {
		return "security/user";
	}

	@RequestMapping("/admin")
	public String admin(Locale locale, Model model) {
		return "security/admin";
	}

	@RequestMapping("/loginForm")
	public String loginForm(Locale locale, Model model) {
		return "security/loginForm";
	}

}
