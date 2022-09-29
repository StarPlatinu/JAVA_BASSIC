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
	
	private int[] array;
    private int[] tempMergArr;
    private int length;

    public void sort(int inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
    }

    private void doMergeSort(int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }

    private void mergeParts(int lowerIndex, int middle, int higherIndex) {

        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
    }
	
	
	
}
