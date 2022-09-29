package exercise2;

import java.util.Scanner;

public class ArrayContains {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter length of an array: ");
	int len = Integer.parseInt(sc.nextLine());
	String[] stringArray = new String[len];
	System.out.print("Enter element in array");
	for(int i=0;i<stringArray.length;i++)
	{
		System.out.print("stringArray["+i+"] = ");
		stringArray[i]= sc.nextLine();				
	}
	System.out.print("Enter String value: ");
	String sValue = sc.nextLine();
	int flag = 0;
	for (int i = 0; i < stringArray.length; i++) {
		if(stringArray[i].equalsIgnoreCase(sValue)) {				
			flag ++;
		}	
	}
	if(flag > 0 ) {
		System.out.println("Check '"+sValue+"' in Array: Contained!");
	}else {
		System.out.println("Check '"+sValue+"' in Array: No Contain");	
	}
	sc.close();
}
}
