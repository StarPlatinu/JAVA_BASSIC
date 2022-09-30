package Excercise_1;

import java.util.Scanner;

public class Validation {
	final Scanner sc = new Scanner(System.in);

	public double getDouble() {

		double result;
		while (true) {
			try {
				result = Double.parseDouble(sc.nextLine());
				if(result < 0) {
					System.out.println("Please enter positive number.");
					continue;
				}
				return result;
			} catch (Exception e) {
				System.out.println("Please enter a number.");
			}
		}
	}

	public boolean checkTriangle(double a, double b, double c) {
		if (a <= 0 || b <= 0 || c <= 0)
			return false;
		else if (a >= (b + c) || c >= (b + a) || b >= (a + c))
			return false;
		else
			return true;
	}
}
