package com.iamtek.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController1 {

	@RequestMapping("studentForm")
	public String studentForm(){
		return "student/studentForm";
	}
	
	@RequestMapping("studentCreate1")	//direct validation
	public String studentCreate1(Student student, BindingResult result, Model model) {
		String view = "student/studentCreatePass";
		StudentValidator validator = new StudentValidator();
		validator.validate(student, result);
		if (result.hasErrors()) {
			view = "student/studentForm";
			model.addAttribute("errors", validator.getFormErrors());
		}
		return view;
	}

}
