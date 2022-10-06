package com.training.main;

import com.training.services.Manager;
import com.training.utils.Validation;

public class Main {
	public static void main(String[] args) {
		Manager manager = new Manager();
		Validation validation = new Validation();
		while (true) {
			System.out.println("========== Worker Management ==========");
			System.out.println("1. Add worker.");
			System.out.println("2. Increase salary for worker.");
			System.out.println("3. Decrease for worker");
			System.out.println("4. Show adjusted salary worker information");
			System.out.println("5. Exist");
			int choice = validation.inputInt("Enter your choice: ", 1, 5);
			switch (choice) {
			case 1:
				System.out.println("---------- Add Worker ----------");
				manager.addWorker();
				break;
			case 2:
				System.out.println("---------- Up Salary ----------");
				manager.changeSalary("UP");
				break;
			case 3:
				System.out.println("---------- Down Salary ----------");
                manager.changeSalary("DOWN");
				break;
			case 4:
				System.out.println("---------------------- Display Information Salary --------------------");
                manager.printListHistory();
				break;
			case 5:
                System.exit(0);
				break;
			}

		}
	}
}
