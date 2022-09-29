package fa.training.assignment1;

import java.util.Iterator;

public class Demo {
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	public static int[] arimetic(String ar) {
		String arr[] = ar.split("+-/*+%.");
	     int [] number = new int[100];
		for (int i = 0; i < arr.length; i++) {
		if(isNumeric(arr[i])) {
			int temp = Integer.parseInt(arr[i]);
           number[i] =temp;
		}	
		}	
		return number;
	}
	
	public static void main(String[] args) {
		 String z = "5 + 15 / 3 * 2 - 8 % 3";
		 int[] result = arimetic(z);
		
	}
	
	
}
