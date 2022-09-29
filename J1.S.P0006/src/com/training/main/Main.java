package com.training.main;

public class Main {
public static void main(String[] args) {
	Validation v = new Validation();
	System.out.print("Enter number of an array: ");
	int length = v.getInteger();
	System.out.print("Enter data to search:");
	int data = v.getInteger();
	int[] arr = v.randomData(length);
	System.out.print("Original array: ");
	v.display(arr);
	v.bubbleSort(arr);
	System.out.print("\nArray After Sort: ");
	v.display(arr);	 
	 int foundIndex = v.binarySearch(arr, data, 0, length - 1);
     System.out.println("\nFound " + data + " at index: " + foundIndex);
}
}
