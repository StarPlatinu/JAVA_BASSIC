package com.training.validation;

import java.util.Scanner;

public class Validation {
	private static Scanner in = new Scanner(System.in);

	public static int checkInputLimit(int min, int max) {
		try {
			System.out.print("Enter your choice: ");
			int choice = Integer.parseInt(in.nextLine());
			if (choice < min || choice > max) {
				throw new NumberFormatException();
			}
			return choice;
		} catch (NumberFormatException ex) {
			System.err.println("Re-input");
		}
		return 0;
	}
}
