package com.training.main;

import java.util.Scanner;
import java.util.regex.Pattern;
public class checkPhoneNumber {
	public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      while(true) {
    	  System.out.print("input phone: ");
          String phone = sc.nextLine();
          //^[0-9]{10}$ 
          //^[0-9]{3}-[0-9]{3}-[0-9]{4}$
          Pattern p = Pattern.compile("^[0-9]{3}-[0-9]{3}-[0-9]{4}$");
          if(p.matcher(phone).find()) {
        	  System.out.println("phone is ok");
        	  break;
          }else {
        	  System.out.println("phone is not oke");
          }
      }
      
	}
}
