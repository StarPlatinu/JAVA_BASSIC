package fa.training.assignment1;

import java.util.ArrayList;

public class Exercise1_Superme {
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
	public static int arimetic(String ar) {
		String arr[] = ar.split("()\t");
	     int [] number = new int[100];
		int result = 0;
		String[] operator = new String[100];
		for (int i = 0; i < arr.length; i++) {
		if(isNumeric(arr[i])) {
			int temp = Integer.parseInt(arr[i]);
           number[i] =temp;
		}
		if(!isNumeric(arr[i])) {
			int flag = 0;
			switch(arr[i]) {
			case "+":
				result += number[flag];
				break;
			case "-":
				result -= number[flag];
				break;
			case "*":
				result *= number[flag];
				break;
			case "/":
				result /= number[flag];
				break;
			case "%":
				result %= number[flag];
				break;
			}
			flag++;
		}
		}
		
		return result;
	}
public static void main(String[] args) {
	 String w = "-5 + 8 * 6";
	 String x = "(55 + 9) % 9";
	 String y = "20 + (-3 * 5 / 8)";
	 String z = "5 + 15 / 3 * 2 - 8 % 3";
	 
	int result1 = arimetic(w);
	int result2 = arimetic(x);
	int result3 = arimetic(y);
	int result4 = arimetic(z);
	
	System.out.println(result1);
	System.out.println(result2);
	System.out.println(result3);
	System.out.println(result4);
}
}
