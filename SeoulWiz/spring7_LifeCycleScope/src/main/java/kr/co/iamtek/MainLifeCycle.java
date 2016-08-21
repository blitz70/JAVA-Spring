package kr.co.iamtek;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainLifeCycle {

	public static void main(String[] args) {
 
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext();
//		((GenericXmlApplicationContext) ctx).load("classpath:applicationCTX1.xml");;
//		((GenericXmlApplicationContext) ctx).refresh();
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		
		ctx.load("classpath:applicationCTX1.xml");
		ctx.refresh();
		
		StudentAnnotation student1 = ctx.getBean("student1", StudentAnnotation.class);
		System.out.println("이름 : " + student1.getName());
		System.out.println("나이 : " + student1.getAge());
		StudentInterface student2 = ctx.getBean("student2", StudentInterface.class);
		System.out.println("이름 : " + student2.getName());
		System.out.println("나이 : " + student2.getAge());
		
		ctx.close();
		
	}

}
