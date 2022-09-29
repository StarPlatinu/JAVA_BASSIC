package com.training.main;

import java.util.Random;
import java.util.Scanner;

public class Validation {
Scanner sc = new Scanner(System.in);
	
	public int getInteger() {
		  while (true) {
	            try {
	                int result = Integer.parseInt(sc.nextLine().trim());
	                return result;
	            } catch (NumberFormatException e) {
	                System.err.println("Please input number");
	            }
	    }
	}
	
	public int[] getArray(int n) {
		 int[] a = new int[n];
	        for (int i = 0; i < n; i++) {
	            System.out.print("Enter a[" + i + "]: ");
	            a[i] = getInteger();
	        }
	        return a;
	}
	public int[] randomData(int n) {
		Random r = new Random();
		int[] a = new int[n];
        for (int i = 0; i < n; i++) {     
            a[i] = r.nextInt(10);
        }
        return a;
	}
	
	public void display(int[] arr) {
		 System.out.print("[");
	        for (int i = 0; i < arr.length; i++) {
	            System.out.print(arr[i]);
	            if (i < arr.length - 1) {
	                System.out.print(", ");
	            }
	        }
	        System.out.print("]");
	}
	
	  public void bubbleSort(int[] arr) {
	        boolean swapped = true;
	        int j = 0;
	        int tmp;
	        while (swapped) {
	            swapped = false;
	            j++;
	            for (int i = 0; i < arr.length - j; i++) {
	                if (arr[i] > arr[i + 1]) {
	                    tmp = arr[i];
	                    arr[i] = arr[i + 1];
	                    arr[i + 1] = tmp;
	                    swapped = true;
	                }
	            }
	        }
	    }
	  
	  int binarySearch(int[] array, int value, int left, int right) {
	        if (left > right) {
	            return -1;
	        }
	        int middle = (left + right) / 2;
	        if (array[middle] == value) {
	            return middle;
	        } else if (array[middle] > value) {
	            return binarySearch(array, value, left, middle - 1);
	        } else {
	            return binarySearch(array, value, middle + 1, right);
	        }
	    }
	
	
}
