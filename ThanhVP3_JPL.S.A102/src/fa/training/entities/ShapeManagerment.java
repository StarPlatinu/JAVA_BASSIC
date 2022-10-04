package fa.training.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShapeManagerment {
	static Scanner sc = new Scanner((System.in));
	static List<Rectangle> list = new ArrayList<>();

	public static int getInteger(String mess) {
		int result;
		while (true) {
			System.out.print(mess);
			try {
				result = Integer.parseInt(sc.nextLine());
				return result;
			} catch (NumberFormatException e) {
				System.out.println(e);
			}
		}
	}

	public static int getIntegerWithBound(String mess, int max, int min) {
		System.out.print(mess);
		while (true) {
			String input = sc.nextLine();
			try {
				int number = Integer.parseInt(input);
				// check range of number
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

	public static void menu() {
		System.out.println("=====================================================");
		System.out.println("1.Input the length and the width for the rectangle.");
		System.out.println("2.Display the info of the previous rectangle.");
		System.out.println("3.Display the rectangle hasthe maximum area.");
		System.out.println("4.Display the rectangle hasthe maximum perimeter.");
		System.out.println("5.Exist.");
		System.out.println("=====================================================");
	}

	public static boolean checkRectabgleExist(int n) {
		if (list.size() == n) {
			return true;
		}
		return false;
	}

	public static void getRectangle(int n) {
		while (true) {
			if (!checkRectabgleExist(n)) {
				System.out.println("Enter rectangle "+(list.size()+1)+" :");
				int len = getInteger("Enter length: ");
				int width = getInteger("Enter width: ");
				Rectangle r = new Rectangle(len, width);
				list.add(r);
				continue;
			} else {
				System.out.println("Already has " + list.size() + " rectangles");
				break;
			}
		}
	}
	
	public static void displayRectangle() {
		if(list.isEmpty()) {
			System.out.println("Don't have any data to display.");
		}
		for (int i = 0; i < list.size(); i++) {
			if(i==list.size()-1) {
				System.out.println(list.get(i).toString());
			}
		}
	}

	
	public void getMaxArea() {
		if(list.isEmpty()) {
			System.out.println("Don't have any data to display.");
		}else {
			int maxArea =list.get(0).calculateArea();
			int flag = 0;
			for (int i = 0; i < list.size(); i++) {
		      if(maxArea<list.get(i).calculateArea()) {
		    	  maxArea = list.get(i).calculateArea();
		    	  flag = i;
		      }		    
			}
			System.out.println(list.get(flag).toString());
		}
		
	}
	
	public void getMinArea() {
		if(list.isEmpty()) {
			System.out.println("Don't have any data to display.");
		}else {
			int minArea =list.get(0).calculateArea();
			int flag = 0;
			for (int i = 0; i < list.size(); i++) {
		      if(minArea>list.get(i).calculateArea()) {
		    	  minArea = list.get(i).calculateArea();
		    	  flag = i;
		      }
			}	
			System.out.println(list.get(flag).toString());
		}
		
	}
	
	
	
	

}
