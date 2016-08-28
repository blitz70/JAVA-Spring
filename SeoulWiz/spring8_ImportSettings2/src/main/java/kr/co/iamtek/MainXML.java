package kr.co.iamtek;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainXML {

	public static void main(String[] args) {

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		AdminConnection con = ctx.getBean("adminConnection", AdminConnection.class);
		
		System.out.println("adminID : " + con.getAdminId());
		System.out.println("adminPW : " + con.getAdminPw());
		System.out.println("subAdminID : " + con.getSubAdminId());
		System.out.println("subAdminPW : " + con.getSubAdminPw());
		
		ctx.close();
		
	}

}
