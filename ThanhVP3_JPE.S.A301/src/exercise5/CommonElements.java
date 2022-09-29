package exercise5;

import java.util.ArrayList;
import java.util.Scanner;

public class CommonElements {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter the length of array1: ");
	int len=Integer.parseInt(sc.nextLine());
	int[] myIntArray1 = new int[len];
	System.out.println("Entry data in array1: ");
	for(int i=0;i<myIntArray1.length;i++)
	{
		System.out.print("myIntArray1["+i+"] = ");
		myIntArray1[i]= Integer.parseInt(sc.nextLine());				
		
	}
	
	System.out.print("Enter the length of array2: ");
	int len2=Integer.parseInt(sc.nextLine());
	int[] myIntArray2 = new int[len2];
	System.out.println("Entry data in array2: ");
	for(int i=0;i<myIntArray2.length;i++)
	{
		System.out.print("myIntArray2["+i+"] = ");
		myIntArray2[i]= Integer.parseInt(sc.nextLine());				
		
	}
	 ArrayList<Integer> myNumbers = new ArrayList<Integer>();
	for (int i = 0; i < myIntArray1.length; i++) {
		for (int j = 0; j < myIntArray2.length; j++) {
			if(myIntArray1[i]==myIntArray2[j]) {
				myNumbers.add(myIntArray1[i]);
			}
		}
	}
    System.out.print("Common elements:{");
   for (int i = 0; i < myNumbers.size(); i++) {
	   if(i==myNumbers.size()-1) 
		   System.out.print(myNumbers.get(i));
	   else
	    System.out.print(myNumbers.get(i)+",");
}
   System.out.println("}");
	sc.close();
}
}
