package kr.co.iamtek;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

//		AbstractApplicationContext ctx = new GenericXmlApplicationContext();
//		((GenericXmlApplicationContext) ctx).load("classpath:applicationCTX.xml");;
//		((GenericXmlApplicationContext) ctx).refresh();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		
		ctx.load("classpath:applicationCTX.xml");
		ctx.refresh();
		
		Student student = ctx.getBean("student", Student.class);
		System.out.println("이름 : " + student.getName());
		System.out.println("나이 : " + student.getAge());
		OtherStudent otherStudent = ctx.getBean("otherStudent", OtherStudent.class);
		System.out.println("이름 : " + otherStudent.getName());
		System.out.println("나이 : " + otherStudent.getAge());
		
		ctx.close();
		
	}

}
