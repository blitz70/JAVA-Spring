package kr.co.iamtek;

public class Calculator {
	
	public void addition(int f, int s) {
		int result = f + s;
		System.out.println("addition() :\t\t" + f + " + " + s + " = " + result);
	}
	public void subtraction(int f, int s) {
		int result = f - s;
		System.out.println("subtraction() :\t" + f + " - " + s + " = " + result);
	}
	public void multiplication(int f, int s) {
		int result = f * s;
		System.out.println("multiplication() :\t" + f + " * " + s + " = " + result);
	}
	public void division(int f, int s) {
		int result = f / s;
		System.out.println("division() :\t\t" + f + " / " + s + " = " + result);
	}
	
}
