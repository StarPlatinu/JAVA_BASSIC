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
	 int partition(int arr[], int left, int right) {
	        int i = left, j = right;
	        int tmp;
	        int pivot = arr[(left + right) / 2];

	        while (i <= j) {
	            while (arr[i] < pivot) {
	                i++;
	            }
	            while (arr[j] > pivot) {
	                j--;
	            }
	            if (i <= j) {
	                tmp = arr[i];
	                arr[i] = arr[j];
	                arr[j] = tmp;
	                i++;
	                j--;
	            }
	        };
	        return i;
	    }

	    void quickSort(int arr[], int left, int right) {
	        int index = partition(arr, left, right);
	        if (left < index - 1) {
	            quickSort(arr, left, index - 1);
	        }
	        if (index < right) {
	            quickSort(arr, index, right);
	        }
	    }
	
}