package com.iamtek.myproject;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	@RequestMapping("index")
	public String index() {
		return "student/index";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "student1")
	public String goStudent1(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		model.addAttribute("id", id);
		return "student/studentId";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "student2")
	public String goStudent2(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		model.addAttribute("id", id);
		return "student/studentId";
	}

	@RequestMapping(method = RequestMethod.POST, value = "student2")	//overloading
	public ModelAndView goStudent2(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		String id = request.getParameter("id");
		mv.setViewName("student/studentId");
		mv.addObject("id", id);
		return mv;
	}

	@RequestMapping("form")
	public String form() {
		return "student/form";
	}
	
	@RequestMapping("studentView")
	public String studentView(@ModelAttribute("studentInfo") StudentInformation studentInfo1) {
		return "student/studentView";
	}
	
}
