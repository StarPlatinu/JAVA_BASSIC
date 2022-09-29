package com.training.main;

public class Main {
	public static void main(String[] args) {
		Validation v = new Validation();
		System.out.print("Enter number of array:");
		int n = v.getInteger();
		int[] arr = v.randomData(n);
		System.out.print("Original array: ");
		v.display(arr);
		v.sort(arr);
		System.out.print("\nArray After Sort: ");
		v.display(arr);
	}
}
