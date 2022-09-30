package Excercise_2;

import java.util.Scanner;

public class Validation {
	final Scanner sc = new Scanner(System.in);

	public int getInteger() {
		int result;
		while (true) {
        try {
			result = Integer.parseInt(sc.nextLine());
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
}
