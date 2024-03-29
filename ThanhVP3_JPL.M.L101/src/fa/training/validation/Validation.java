package fa.training.validation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validation {
	public final static Scanner sc = new Scanner(System.in);
	final static String DATE_FORMAT = "dd-MM-yyyy";

	public static double getDouble() {
		while(true) {
			try {
			double result = Double.parseDouble(sc.nextLine().trim());	
			return result;
			} catch (NumberFormatException e) {
				System.out.println("Please enter a number.Enter again: ");
				continue;
			}
		}
	}

	public static String getString() {
		while (true) {
			String result = sc.nextLine().trim();
			if (result.equals("") || result.isEmpty()) {
				System.out.println("Your input can't be empty. Please enter again: ");
			} else {
				return result;
			}
		}
	}
	
	public static Date getDate() 
	{
	       while(true) {
	    	   try {
		        	String date = sc.nextLine();
		            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		            df.setLenient(false);
		            Date result =  df.parse(date);
		            return result;
		        } catch (ParseException e) {
		          System.out.println("Please Enter Date Follow The Format dd-MM-yyyy.");
		        }
	       }
	}
}
