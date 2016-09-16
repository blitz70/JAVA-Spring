package com.iamtek.myapp;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

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
		}
		return view;
	}

	@RequestMapping("studentCreate2")	//framework validation
	public String studentCreate2(@Valid Student student, BindingResult result, Model model) {
		String view = "student/studentCreatePass";
		if (result.hasErrors()) {
			view = "student/studentForm";
		}
		return view;
	}
	
	@InitBinder
	protected void iniBinder(WebDataBinder binder) {
		binder.setValidator(new StudentValidator());
	}

}
