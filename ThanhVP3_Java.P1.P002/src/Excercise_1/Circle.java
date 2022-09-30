package Excercise_1;

public class Circle extends Shape {
	private double radius;
	
	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	

	@Override
	public String toString() {
		return "-----Circle-----"
				+ "\nRradius: " + radius 
				+ "\nArea" + getArea()
				+ "\nPerimeter: " + getPerimeter();
				
	}

	@Override
	double getPerimeter() {
		return Math.PI*2*radius;
	}

	@Override
	double getArea() {
		return Math.PI*radius*radius;
	}

	@Override
	void printResult() {
	System.out.println(toString());
	}

}
