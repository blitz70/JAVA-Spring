package com.iamtek.myproject;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {

	@RequestMapping("confirm")
	public String confirm() {
		return "confirm/confirm";
	}

	@RequestMapping("confirmChk")
	public String confirmChk(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		if (id.equals("abc")) {
			return "redirect:studentPass";		//goes to another RequestMapping
		}
		return "redirect:studentFail";
	}
	
	@RequestMapping("studentPass")
	public String studentPass() {
		return "confirm/studentPass";
	}
	
	@RequestMapping("studentFail")
	public String studentFail() {
		return "confirm/studentFail";
	}
	
	@RequestMapping("redirectURL1")
	public String redirectURL1() {
		return "redirect:http://localhost:8080/myproject/redirectURL1.jsp";	//goes to actual file
	}

	@RequestMapping("redirectURL2")
	public String redirectURL2() {
		return "redirect:redirect/redirectURL2";
	}

	@RequestMapping("redirect/redirectURL2")
	public String redirectURL22() {
		return "redirect:http://localhost:8080/myproject/redirectURL2.jsp";
	}

}
