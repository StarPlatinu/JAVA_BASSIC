package com.training.main;

//Insertion sort algorithm.
/*
1. Display a screen to prompt users to input a positive decimal number.

o Users run the program, display a screen to ask users to enter a positive decimal number.

o Users input a positive decimal number. Then, perform Function 2.

2. Display & sort array.

o Generate random integer in number range for each array element.

o Display array before and after sorting
 */
public class Main {
public static void main(String[] args) {
	Validation v = new Validation();
	 System.out.print("Enter number of array:");
	 int n = v.getInteger();
	 int[] arr = v.randomData(n);
	 System.out.print("Original array: ");
	 v.display(arr);
	 v.sortByInsertionSort(arr);
	 System.out.print("Array After Sort: ");
	 v.display(arr);
}
}
