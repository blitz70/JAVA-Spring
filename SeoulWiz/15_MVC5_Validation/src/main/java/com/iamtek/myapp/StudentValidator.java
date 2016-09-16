package com.iamtek.myapp;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.isAssignableFrom(clazz);		//is clazz == Student?
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		//settup before checking
		System.out.println("validate()");
		Student student = (Student) target;
		
		//checking data object
//		String studentName = student.getName();
//		if (studentName == null || studentName.trim().isEmpty()) {
//			System.out.println("studentName has error");
//			errors.rejectValue("name", "error");
//		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error");
		
		int studentId = student.getId();
		if (studentId == 0) {
			System.out.println("studentId has error");
			errors.rejectValue("id", "error");
		}
		
	}

}
