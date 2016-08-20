package kr.co.iamtek;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Student implements InitializingBean, DisposableBean{
	
	private String name;
	private int age;
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Interface DisposableBean destroy()");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Interface InitializingBean afterPropertiesSet()");
	}

}
