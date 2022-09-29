package fa.training.main;

import java.util.ArrayList;
import java.util.Scanner;

import fa.training.entities.Ford;
import fa.training.entities.Sedan;
import fa.training.entities.Truck;

public class MyOwnAutoShop {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Ford> listFord = new ArrayList();
		ArrayList<Sedan> listSedan = new ArrayList();
		ArrayList<Truck> listTruck = new ArrayList();
		System.out.println("----------Wellcome to Car AutoShop----------");
		System.out.print("Speed:");
		int speed = sc.nextInt();
		System.out.print("RegularPrice:");
		double regularPrice = sc.nextDouble();
		System.out.print("Color:");
		String color = sc.next();
		int choice;
		do {
			System.out.println("Choose type of car");
			System.out.println("1.Sedan");
			System.out.println("2.Ford");
			System.out.println("3.Truck");
			System.out.println("Enter other number to exist.");
			System.out.println("Enter your choose:");
			choice = sc.nextInt();
			switch (choice) {
			case 1:		
				System.out.print("Enter Length:");
				int length = sc.nextInt();
				Sedan sedan = new Sedan(speed, regularPrice, color, length);
				listSedan.add(sedan);
				break;
			case 2:
				System.out.print("Enter Year:");
				int year = sc.nextInt();
				System.out.print("ManufacturerDiscount:");
				int manufacturerDiscount = sc.nextInt();
				Ford ford = new Ford(speed, regularPrice, color, year, manufacturerDiscount);
				listFord.add(ford);
				break;
				
			case 3:
				System.out.print("Enter Weight: ");
				int weight = sc.nextInt();
				Truck truck = new Truck(speed, regularPrice, color, weight);
				listTruck.add(truck);
				break;
			default:
				for (Ford x : listFord) {
					System.out.println(x);
				}
				for (Sedan y : listSedan) {
					System.out.println(y);
				}
				for (Truck z : listTruck) {
					System.out.println(z);
				}
				break;
			}
		} while (choice <= 3);
		sc.close();
	}
}
