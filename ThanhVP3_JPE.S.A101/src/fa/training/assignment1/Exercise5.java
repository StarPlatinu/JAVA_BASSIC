package fa.training.assignment1;

import java.util.Scanner;

public class Exercise5 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	float radius,area,perimeter;
	System.out.print("Radius = ");
	radius = sc.nextFloat();
	perimeter = (float)(2 * Math.PI * radius);
	area = (float)(Math.PI * Math.pow(radius, 2));
	System.out.println("Perimeter is = "+perimeter);
	System.out.println("Area is = "+area);
	sc.close();
}
}
