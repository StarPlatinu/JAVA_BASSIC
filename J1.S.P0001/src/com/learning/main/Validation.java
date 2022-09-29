package com.learning.main;

import java.util.Scanner;

public class Validation {
	public final Scanner in = new Scanner(System.in);

	// check user input a number integer
	public int getInteger() {
		// loop until user input correct
		while (true) {
			try {
				int result = Integer.parseInt(in.nextLine().trim());
				return result;
			} catch (NumberFormatException e) {
				System.err.println("Please input number");
			}
		}
	}

	// allow user input value of array

	public int[] fillData(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.print("Enter a[" + i + "]: ");
			a[i] = getInteger();
		}
		return a;
	}

	// swap 2 number
	public void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

	// Display an array to screen
	public void display(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	// sort array by bubble sort
	public void sortArrayByBubbleSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		System.out.println();
	}

}
