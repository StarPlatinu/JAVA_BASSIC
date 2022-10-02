package Controller;

import java.util.Scanner;

public class Validation {

	private Scanner sc = new Scanner(System.in);

	/**
	 * Get a integer from user, with max min
	 *
	 * @param mess   message
	 * @param input  get data from user
	 * @param number change data type to integer
	 * @return number integer
	 */

	public int inputInt(String mess, int min, int max) {
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

	/**
	 * Get a double from user, with max min
	 *
	 * @param mess   message
	 * @param input  get data from user
	 * @param number change data type to double
	 * @return number integer
	 */

	public double inputDouble(String mess, double min, double max) {
		System.out.print(mess);
		while (true) {
			String input = sc.nextLine();
			try {
				double number = Double.parseDouble(input);
				// check range of number
				if (number < min || number > max) {
					System.out.print("Please input between " + min + ", " + max + ": ");
					continue;
				}
				return number;
			} catch (Exception e) {
				System.out.print("Please input an double number: ");
			}
		}
	}

	/**
	 * Get data from user with regex
	 *
	 * @param mess  message
	 * @param regex regular expression condition
	 * @return number integer
	 */

	public String inputString(String mess, String regex) {
		System.out.print(mess);
		while (true) {
			String input = sc.nextLine();
			if (!input.matches(regex)) {
				System.out.print("Please input match regex(" + regex + ").");
				continue;
			}
			return input;
		}
	}

	/**
	 * Check Yes No from user
	 *
	 * @param mess   message
	 * @param result get data from user
	 * @return boolean type
	 */

	public boolean checkInputYN(String mess) {
		System.out.println(mess);
		while (true) {
			String result = sc.nextLine();

			if (result.equalsIgnoreCase("Y")) {
				return true;
			}

			if (result.equalsIgnoreCase("N")) {
				return false;
			}
			System.err.println("Please input y/Y or n/N.");
			System.out.print("Enter again: ");
		}
	}

}
