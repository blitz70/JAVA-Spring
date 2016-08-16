package kr.co.iamtek;

import java.util.ArrayList;

public class MyInfo {

	private String name;
	private double height;
	private double weight;
	private ArrayList<String> hobbies;
	private BMICalculator bmiCalculator;
	
	public void getInfo() {
		System.out.println("이름 : " + name + ", 키 : " + height + ", 몸무게 : " + weight + ", 취미 : " + hobbies);
		bmiCalculation();
	}
	public void bmiCalculation() {
		bmiCalculator.bmiCalculation(weight, height);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public ArrayList<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(ArrayList<String> hobbies) {
		this.hobbies = hobbies;
	}
	public BMICalculator getBmiCalculator() {
		return bmiCalculator;
	}
	public void setBmiCalculator(BMICalculator bmiCalculator) {
		this.bmiCalculator = bmiCalculator;
	}
	
}
