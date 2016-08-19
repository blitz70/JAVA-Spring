package kr.co.iamtek;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationCTX {

	@Bean
	public Student student1() {

		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("수영");
		hobbies.add("요리");
		Student student = new Student("홍길동", "20", hobbies);
		student.setHeight(180);
		student.setWeight(80);
		
		return student;
	
	}
	
}
