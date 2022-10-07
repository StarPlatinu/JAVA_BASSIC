package com.training.main;

import java.util.Scanner;

import com.training.sevices.Manager;
import com.training.validation.Validation;

public class Main {
	public static void main(String[] args) {
		Manager manager = new Manager();
		Validation validate = new Validation();
		Scanner in = new Scanner(System.in);
		String path;
		String word;
		while (true) {
			System.out.println("1. Count Word In File");
			System.out.println("2. Find File By Word");
			System.out.println("3. Exit");
			int choice = validate.checkInputLimit(1, 3);
			switch (choice) {
			case 1:
				System.out.print("Enter Path: ");
				path = in.nextLine();
				System.out.print("Enter Word: ");
				word = in.nextLine();
				int count = manager.countWordInFile(path, word);
				System.out.println("Count: " + count);
				break;
			case 2:
				System.out.print("Enter Path: ");
				path = in.nextLine();
				System.out.print("Enter Word: ");
				word = in.nextLine();
				manager.getFileNameContainsWordInDirectory(path, word);
				break;
			case 3:
				System.exit(0);
				return;
			}
		}
	}
}
