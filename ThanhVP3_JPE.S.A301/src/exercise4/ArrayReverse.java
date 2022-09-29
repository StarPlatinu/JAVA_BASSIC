package exercise4;

import java.util.Scanner;

public class ArrayReverse {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter the length of array: ");
	int len=Integer.parseInt(sc.nextLine());
	int a[] = new int[len];
	System.out.println("Entry data in array: ");
	for(int i=0;i<a.length;i++)
	{
		System.out.print("a["+i+"] = ");
		a[i]= Integer.parseInt(sc.nextLine());				
		
	}
	System.out.print("Original array: ");
	for(int i=0;i<a.length;i++)
	{
		System.out.print(a[i] +" ");
	}
	System.out.println();
	System.out.print("Reversed Array:");
	for(int i=a.length -1;i >=0 ;i--)
	{
		System.out.print(a[i] +" ");
	}
	System.out.println();
	sc.close();
}
}
