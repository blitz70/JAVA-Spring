package kr.co.iamtek;

import java.util.ArrayList;

public class Student {
	
	private String name;
	private String age;
	private ArrayList<String> hobbies;
	private double height;
	private double weight;
	
	public Student(String name, String age, ArrayList<String> hobbies) {
		super();
		this.name = name;
		this.age = age;
		this.hobbies = hobbies;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public ArrayList<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(ArrayList<String> hobbies) {
		this.hobbies = hobbies;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
}
