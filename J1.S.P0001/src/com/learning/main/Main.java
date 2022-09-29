package com.learning.main;

//Bubble sort
public class Main {
	public static void main(String[] args) {
		Validation v = new Validation();
		System.out.print("Enter number of an array: ");
		int n = v.getInteger();
		System.out.println("Fill your data to the cell below");
		int[] arr = v.fillData(n);
		System.out.print("\nOriginal Array: ");
		v.display(arr);	
		v.sortArrayByBubbleSort(arr);
		System.out.print("\nArray After Sort By Bubble Sort: ");
		v.display(arr);
	}
}
