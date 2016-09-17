package com.iamtek.myapp;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator{
	
	FormErrors formErrors;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.isAssignableFrom(clazz);		//is clazz == Student?
	}

	@Override
	public void validate(Object target, Errors errors) {

		this.formErrors = new FormErrors();

		//settup before checking
		System.out.println("validate()");
		Student student = (Student) target;
		
		//checking data object
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error");
		String studentName = student.getName();
		if (studentName == null || studentName.trim().isEmpty()) {
			System.out.println("studentName has error");
			errors.rejectValue("name", "error");
			this.formErrors.setField1("name error");
		}
		
		int studentId = student.getId();
		if (studentId == 0) {
			System.out.println("studentId has error");
			errors.rejectValue("id", "error");
			this.formErrors.setField2("id error");
		}
	}

	public FormErrors getFormErrors() {
		return formErrors;
	}

	public void setFormErrors(FormErrors formErrors) {
		this.formErrors = formErrors;
	}
	
}
