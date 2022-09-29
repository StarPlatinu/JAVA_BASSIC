package com.training.main;

import java.util.Scanner;

public class validation {
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
	
	public void display(int[] a) {
		  for (int i = 0; i < a.length; i++) {
	            System.out.print(a[i] + " ");
	        }
	}
	
	public void SortAnArrayBySelectionSort(int[] a) {
        int len = a.length;     
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = a[minIndex];
                a[minIndex] = a[i];
                a[i] = temp;
            }
             if(i==1) break;
        }
        System.out.println();
    }
}
