package kr.co.iamtek;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainXML {

	public static void main(String[] args) {

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		
		Student student = ctx.getBean("student", Student.class);
		student.getStudentInfo();
		Worker worker = ctx.getBean("worker", Worker.class);
		worker.getWorkerInfo();
	
		ctx.close();

	}

}
