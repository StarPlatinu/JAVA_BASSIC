package Excercise_1;

public class Main {
public static void main(String[] args) {
	Validation v = new Validation();
	System.out.println("=====Calculator Shape Program=====");
	System.out.println("Please input side width of Rectangle:");
	double width = v.getDouble();
	System.out.println("Please input length of Rectangle:");
	double length = v.getDouble();
	System.out.println("Please input radius of Circle:");
	double radius = v.getDouble();
	double sideA,sideB,sideC;
	while(true) {
		System.out.println("Please input side A of Triangle:");
		 sideA = v.getDouble();
		System.out.println("Please input side B of Triangle:");
		 sideB = v.getDouble();
		System.out.println("Please input side C of Triangle:");
		 sideC = v.getDouble();
		if(v.checkTriangle(sideA, sideB, sideC)) {
			break;
		}else {
			System.out.println("Three side above not satisfy condition to created a Triangle.");		
		    continue;
		}
	}
	
	Rectangle r = new Rectangle(width, length);
	r.printResult();
	Circle c = new Circle(radius);
	c.printResult();
	Triangle t = new Triangle(sideA, sideB, sideC);
	t.printResult();
	
	
	
}
}
