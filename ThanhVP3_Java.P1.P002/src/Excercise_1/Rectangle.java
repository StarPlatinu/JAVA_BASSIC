package Excercise_1;

public class Rectangle extends Shape{
	private double width;
	private double length;
	
	public Rectangle(double width, double length) {
		super();
		this.width = width;
		this.length = length;
	}
	
	

	public double getWidth() {
		return width;
	}



	public void setWidth(double width) {
		this.width = width;
	}



	public double getLength() {
		return length;
	}



	public void setLength(double length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "-----Rectangle-----"
				+ "\nWidth: " + width 
				+ "\nLength: " + length 
				+ "\ntArea: " + getArea()
				+ "\nPerimeter: " + getPerimeter();
	}



	@Override
	double getPerimeter() {
		return 2*(width+length);
	}
	@Override
	double getArea() {
     	return width * length;
	}

	@Override
	void printResult() {
	   System.out.println(toString());
	}

}
