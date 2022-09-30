package Excercise_1;

public class Triangle extends Shape{
	
	private double sideA;
	private double sideB;
	private double sideC;
	
	

	public double getSideA() {
		return sideA;
	}

	public void setSideA(double sideA) {
		this.sideA = sideA;
	}

	public double getSideB() {
		return sideB;
	}

	public void setSideB(double sideB) {
		this.sideB = sideB;
	}

	public double getSideC() {
		return sideC;
	}

	public void setSideC(double sideC) {
		this.sideC = sideC;
	}
	
	

	public Triangle(double sideA, double sideB, double sideC) {
		super();
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}
	
	

	@Override
	public String toString() {
		return "-----Triangle-----"
				+ "\nSideA: " + sideA 
				+ "\nSideB: " + sideB 
				+ "\nSideC: " + sideC 				
				+ "\nArea: " + getArea() 
				+ "\nPerimeter: "+ getPerimeter() ;
	}

	@Override
	double getPerimeter() {
		return sideA+sideB+sideC;
	}

	@Override
	double getArea() {
		double p = getPerimeter()/2;
		return Math.sqrt(p*(p-sideA)*(p-sideB)*(p-sideC));
	}

	@Override
	void printResult() {
	System.out.println(toString());		
	}

}
