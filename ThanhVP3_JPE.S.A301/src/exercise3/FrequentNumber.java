package exercise3;

import java.util.Scanner;

public class FrequentNumber {
public static void main(String[] args) {
	// TODO Auto-generated method stub		
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter the length of array: ");
			int len=Integer.parseInt(sc.nextLine());
			int a[] = new int[len];
			System.out.println("Entry data in array: ");
			for(int i=0;i<a.length;i++)
			{
				System.out.print("a["+i+"] = ");
				a[i]= Integer.parseInt(sc.nextLine());			
				String bol;
				if(i!=a.length-1) {
					System.out.println("Do you want to continue(y/n)?");
					bol = sc.nextLine();
					if(bol.equalsIgnoreCase("n")) {
						break;
					}
					if(bol.equalsIgnoreCase("y")) {
						continue;
					}
				}
				
			}
			System.out.print("Element in array: ");
			for(int i=0;i<a.length;i++)
			{
				System.out.print(a[i] +" ");
			}
			System.out.println();
			int count=0;
			System.out.print("Enter x: ");
			int x=sc.nextInt();
			for(int i=0;i<a.length;i++)
			{
				if(x==a[i])
				{
					count++;
				
			}
			}
			System.out.println("\nAmount of frequence: "+count);
			System.out.println();
			System.out.print("Index: ");
			for(int i=0;i<a.length;i++)
			{
				if(x==a[i])
				{			
					System.out.print(i+"\t");
				}
			}
			System.out.println();
             sc.close();
 }
}
