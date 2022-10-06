package com.training.utils;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Validation {
	 private Scanner sc = new Scanner(System.in);
	    
	 /**
	  * get input integer number between min and max
	  * 
	  * @param mess
	  * @param min
	  * @param max
	  * @return
	  */
	    public int inputInt(String mess, int min, int max) {
	        System.out.print(mess);
	        //force user input exectly integer number
	        while(true) {
	            String input = sc.nextLine();
	            try {
	                int number = Integer.parseInt(input);
	                //check range of number
	                if (number < min || number > max) {
	                    System.out.print("Please input between " + min + ", " + max + ": ");
	                    continue;
	                }
	                return number;
	            } catch (Exception e) {
	                System.out.print("Please input an integer number: ");
	            }
	        }
	    }
	    
	    /**
	     * get input double number between min and max
	     * 
	     * @param mess
	     * @param min
	     * @param max
	     * @return
	     */
	    public double inputDouble(String mess, double min, double max) {
	        System.out.print(mess);
	        //force user input exectly double number
	        while(true) {
	            String input = sc.nextLine();
	            try {
	                double number = Double.parseDouble(input);
	                //check range of number
	                if (number < min || number > max) {
	                    System.out.print("Please input between " + min + ", " + max + ": ");
	                    continue;
	                }
	                return number;
	            } catch (Exception e) {
	                System.out.print("Please input an double number: ");
	            }
	        }
	    }
	    
	    /**
	     * get non-empty string
	     * 
	     * @param mess
	     * @param regex
	     * @return
	     */
	    public String inputString(String mess,String regex) {
	        System.out.print(mess);
	        //force user input exectly non-empty string
	        while(true) {
	            String input = sc.nextLine();
	            if(!input.matches(regex)){
	                System.out.print("Please input match regex: "+regex);
	                continue;
	            }
	            if (input.trim().isEmpty()) {
	                System.out.print("Please input a non-empty string: ");
	                continue;
	            }
	            return input;
	        }
	    }
	    
	    /**
	     * get valid date
	     * 
	     * @param mess
	     * @return
	     */
	    public String inputDate(String mess) {
	        System.out.print(mess);
	        //set format of date
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        dateFormat.setLenient(false);
	        //force user input exectly a date
	        while(true) {
	            String input = sc.nextLine();
	            try {
	                Date date = (Date) dateFormat.parse(input);
	                //get current date
	                Date curDate = (Date) Calendar.getInstance().getTime();
	                //check range of date
	                if (curDate.compareTo(date) < 0) {
	                    System.out.print("Please input date that before current date: ");
	                    continue;
	                }
	                dateFormat = new SimpleDateFormat("dd/MMM-/yyy");
	                return dateFormat.format(date);
	            } catch (Exception e) {
	                System.out.print("Please input valid date (dd/MM/yyyy): ");
	            }
	        }
	    }
}
