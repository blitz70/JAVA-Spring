package kr.co.iamtek;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainJava {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(ApplicationCTX.class);
		ctx.refresh();
		
		AdminConnection con = ctx.getBean("adminConnection", AdminConnection.class);
		
		System.out.println("adminID : " + con.getAdminId());
		System.out.println("adminPW : " + con.getAdminPw());
		System.out.println("subAdminID : " + con.getSubAdminId());
		System.out.println("subAdminPW : " + con.getSubAdminPw());
		
		ctx.close();
		
	}

}
