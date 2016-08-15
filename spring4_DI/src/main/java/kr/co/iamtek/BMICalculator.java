package kr.co.iamtek;

public class BMICalculator {
	
	private double underWeight;
	private double normalWeight;
	private double overWeight;
	private double obesity;
	
	public void bmiCalculation(double weight, double height) {
		
		double h = height * 0.01;
		double result = weight / (h*h);
		
		System.out.println("BMI 지수 : " + (int)result);
		
		if (result > obesity) {
			System.out.println("비만 입니다. 운동을 필히 하세요.");
		} else if (result > overWeight) {
			System.out.println("과체중 입니다. 운동을 권합니다.");
		} else if (result > normalWeight) {
			System.out.println("정상 입니다.");
		} else {
			System.out.println("저체중 입니다. 식사 열량을 늘리세요.");
		}
	}

	public double getUnderWeight() {
		return underWeight;
	}
	public void setUnderWeight(double underWeight) {
		this.underWeight = underWeight;
	}
public double getNormalWeight() {
		return normalWeight;
	}
	public void setNormalWeight(double normalWeight) {
		this.normalWeight = normalWeight;
	}
	public double getOverWeight() {
		return overWeight;
	}
	public void setOverWeight(double overWeight) {
		this.overWeight = overWeight;
	}
	public double getObesity() {
		return obesity;
	}
	public void setObesity(double obesity) {
		this.obesity = obesity;
	}

}
