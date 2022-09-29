package com.training.main;
//Quick sort algorithm.

public class Main {
	public static void main(String[] args) {
		Validation v = new Validation();
		System.out.print("Enter number of array:");
		int n = v.getInteger();
		int[] arr = v.randomData(n);
		System.out.print("Original array: ");
		v.display(arr);
		v.quickSort(arr, 0, n - 1);
		System.out.print("\nArray After Sort: ");
		v.display(arr);
	}
}