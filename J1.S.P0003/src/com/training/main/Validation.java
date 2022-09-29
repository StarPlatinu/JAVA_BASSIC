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
	
	public void display(int[] a) {
		  for (int i = 0; i < a.length; i++) {
	            System.out.print(a[i] + " ");
	        }
	}
	
	public void sortByInsertionSort(int[] a) {
		int len = a.length;
		 for (int i = 1; i < len; i++) {
	            for (int j = i; j < len; j++) {
	                if (a[j] < a[j - 1]) {
	                    int temp = a[j];
	                    a[j] = a[j - 1];
	                    a[j - 1] = temp;
	                }
	            }
	        }
	        System.out.println();
	}
	
	
	
}
