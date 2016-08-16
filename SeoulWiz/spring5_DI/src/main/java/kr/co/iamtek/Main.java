package kr.co.iamtek;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		PersonInfo personInfo;
		Person person;
		
		String xml = "classpath:applicationCTX.xml";
		AbstractApplicationContext container = new GenericXmlApplicationContext(xml);

		personInfo = container.getBean("personInfo1", PersonInfo.class);
		personInfo.getPersonInfo();
		
		personInfo = container.getBean("personInfo2", PersonInfo.class);
		personInfo.getPersonInfo();

		person = container.getBean("person3", Person.class);
		personInfo.setPerson(person);
		personInfo.getPersonInfo();

		container.close();
		
	}

}
