package kr.co.iamtek;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main{

	public static void main(String[] args) {

		String config1 = "classpath:beanContainerConfig1.xml";
		String config2 = "classpath:beanContainerConfig2.xml";
		AbstractApplicationContext container = new GenericXmlApplicationContext(config1, config2);
		
		Student student1 = container.getBean("student1", Student.class);
		System.out.println(student1.getName() + " : " + student1.getHobbies());
		
		StudentInfo studentInfo = container.getBean("studentInfo1", StudentInfo.class);
		Student student2 = studentInfo.getStudent();
		System.out.println(student2.getName() + " : " + student2.getHobbies());
		if(student1.equals(student2)) {
			System.out.println("student1 == student2");
		} else {
			System.out.println("student1 != student2");
		}
		
		Student student3 = container.getBean("student3", Student.class);
		System.out.println(student3.getName() + " : " + student3.getHobbies());
		if(student1.equals(student3)) {
			System.out.println("student1 == student3");
		} else {
			System.out.println("student1 != student3");
		}
		
		Family family = container.getBean("family", Family.class);
		String papa = family.getPapaName();
		String mama = family.getMamaName();
		String sister = family.getSisterName();
		String brother = family.getBrotherName();
		System.out.println(papa + " : " + mama + " : " + sister + " : " + brother);
		
		container.close();
	}

}
