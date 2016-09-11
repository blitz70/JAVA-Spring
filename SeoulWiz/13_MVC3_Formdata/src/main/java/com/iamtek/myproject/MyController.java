package com.iamtek.myproject;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

	@RequestMapping("confirmForm")
	public String confirmForm() {
		return "confirmForm";
	}

	@RequestMapping("joinForm")
	public String joinForm() {
		return "joinForm";
	}
	
	@RequestMapping("board/confirm1")
	public String confirm1(HttpServletRequest request, Model model) {
		String method = request.getParameter("form_method");
		String id = request.getParameter("form_id");
		String pw = request.getParameter("form_pw");
		model.addAttribute("model_method", method);
		model.addAttribute("model_id", id);
		model.addAttribute("model_pw", pw);
		return "board/confirm";
	}

	@RequestMapping("board/confirm2")
	public String confirm2(@RequestParam("form_method") String method, @RequestParam("form_id") String id, @RequestParam("form_pw") String pw, Model model) {
		model.addAttribute("model_method", method);
		model.addAttribute("model_id", id);
		model.addAttribute("model_pw", pw);
		return "board/confirm";
	}

	@RequestMapping("board/join1")
	public String join1(@RequestParam("form_method") String method, @RequestParam("form_name") String name, @RequestParam("form_id") String id, @RequestParam("form_pw") String pw, @RequestParam("form_email") String email, Model model) {
		Member member = new Member();
		member.setName(name);
		member.setId(id);
		member.setPw(pw);
		member.setEmail(email);
		model.addAttribute("model_method", method);
		model.addAttribute("model_member", member);
		return "board/join";
	}

	@RequestMapping("board/join2")
	public String join2(@RequestParam("method") String method, Member member, Model model) {
		model.addAttribute("method", method);
		return "board/join2";
	}
	
	@RequestMapping("student/{studentId}")
	public String getStudent(@PathVariable String studentId, Model model) {
		model.addAttribute("studentId", studentId);
		return "student";
	}

}
