package kr.co.iamtek;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		String config = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(config);
		
		Student student1 = ctx.getBean("student1", Student.class);
		System.out.println("이름 : " + student1.getName());
		System.out.println("나이 : " + student1.getAge());
		System.out.println("취미 : " + student1.getHobbies());
		System.out.println("신장 : " + student1.getHeight());
		System.out.println("몸무게 : " + student1.getWeight());

		Student student2 = ctx.getBean("student2", Student.class);
		System.out.println("이름 : " + student2.getName());
		System.out.println("나이 : " + student2.getAge());
		System.out.println("취미 : " + student2.getHobbies());
		System.out.println("신장 : " + student2.getHeight());
		System.out.println("몸무게 : " + student2.getWeight());

		ctx.close();
	}
	
}
