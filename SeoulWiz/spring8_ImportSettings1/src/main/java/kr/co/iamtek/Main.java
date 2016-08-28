package kr.co.iamtek;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class Main {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx1 = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx1.getEnvironment();
		MutablePropertySources psrc= env.getPropertySources();
		try {
			psrc.addLast(new ResourcePropertySource("classpath:admin.properties"));
			System.out.println("Environment==============");
			System.out.println("admin ID : " + env.getProperty("admin.id"));
			System.out.println("admin PW : " + env.getProperty("admin.pw"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		GenericXmlApplicationContext ctx2 = (GenericXmlApplicationContext) ctx1;
		ctx2.load("classpath:applicationCTX.xml");
		ctx2.refresh();
		AdminConnection adminConnection = ctx2.getBean("adminConnection", AdminConnection.class);
		System.out.println("Bean=====================");
		System.out.println("admin ID : " + adminConnection.getAdminId());
		System.out.println("admin PW : " + adminConnection.getAdminPw());
		
		ctx2.close();
		ctx1.close();
	}

}
