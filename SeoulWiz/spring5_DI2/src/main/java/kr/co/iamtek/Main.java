package kr.co.iamtek;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		//setup IOC container
		String beanContainerConfig = "classpath:beanContainerConfig.xml";
		AbstractApplicationContext beanContainer = new GenericXmlApplicationContext(beanContainerConfig);
		
		//use beans
		Pencil pencil = beanContainer.getBean("pencil", Pencil.class);
		pencil.use();
		
		//close container
		beanContainer.close();
		
	}

}
