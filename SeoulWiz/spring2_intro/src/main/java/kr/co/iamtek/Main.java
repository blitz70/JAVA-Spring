package kr.co.iamtek;

public class Main {

	public static void main(String[] args) {
		
		Calculation calc = new Calculation();
		calc.setFirstNum(10);
		calc.setSecondNum(2);
		
		calc.add();
		calc.sub();
		calc.mult();
		calc.div();
		
	}

}
