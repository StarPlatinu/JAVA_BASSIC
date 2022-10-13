package com.training.main;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CheckString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Pattern p = Pattern.compile("^[0-9]$"); 1 ky tu
		//Pattern p = Pattern.compile("^[0-9]{6}$"); 6 ky tu
		//Pattern p = Pattern.compile("^[0-9]{6,}$"); //lon hon 6 ky tu
		//Pattern p = Pattern.compile("^[0-9]{6,10}$");// tu 6 - 10 ky tu
		//Nhap ky tu
		//Pattern p = Pattern.compile("^[a-zA-Z]+$");
		//Nhap ky tu ,so va them dau cach
		Pattern p = Pattern.compile("^[a-zA-Z0-9 ]+$");
		while(true) {
			System.out.print("input txt: ");
			String txt = sc.nextLine();
			System.out.println("txt: " + txt);
			// VD1 chi nhan 1 so
			if (p.matcher(txt).find()) {
				System.out.println("OK");
				break;
			} else {				
				System.out.println("Not OK");		
			}
		}
	}
}
