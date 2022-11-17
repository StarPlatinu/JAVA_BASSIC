package fa.training.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Validation {
	private final static Scanner sc = new Scanner(System.in);

	/**
	 * Get input integer number between min and max
	 * 
	 * @param mess
	 * @param min
	 * @param max
	 * @return
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
	 * Get input double number between min and max
	 * 
	 * @param mess
	 * @param min
	 * @param max
	 * @return
	 */
	public double inputDouble(String mess, double min, double max) {
		System.out.print(mess);
		// force user input exectly double number
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
	 * get non-empty string
	 * 
	 * @param mess
	 * @param regex
	 * @return
	 */
	public String inputString(String mess, String regex) {
		System.out.print(mess);
		// force user input exectly non-empty string
		while (true) {
			String input = sc.nextLine();
			if (!input.matches(regex)) {
				System.out.println("Please input matches regex:" + regex);
				continue;
			}
			if (input.equals("")) {
				System.out.print("Please input a non-empty string: ");
				continue;
			}
			return input;
		}
	}

	/**
	 * get valid date
	 * 
	 * @param mess
	 * @param dateFormat format date
	 * @return
	 */
	public Date inputDate() {
		while (true) {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			sdf.setLenient(false);
			String inputDate = sc.nextLine();
			try {
				java.util.Date parsed = sdf.parse(inputDate); // parse to format MM/dd/yyyy
				java.sql.Date dateConvert = new java.sql.Date(parsed.getTime()); // try to convert to sql Date
				return dateConvert;
			} catch (Exception e) {
				System.err.println(inputDate + " is not a valid Date");
				continue;
			}
		}
	}

	/**
	 * check user input y/Y or n/N
	 * 
	 * @return
	 */
	public boolean checkInputYN() {
		// loop until user input correct
		while (true) {
			String result = sc.nextLine();
			// check user input y/Y or n/N
			if (result.equalsIgnoreCase("Y")) {
				return true;
			} else if (result.equalsIgnoreCase("N")) {
				return false;
			}
			System.err.println("Please input y/Y or n/N.");
			System.out.print("Enter again: ");
		}
	}

	public void SaleManagementMenu() {
		System.out.println("==========SaleManagement FUNCTION==========");
		System.out.println("1) Add a customer into the database. \r\n"
				+ "2) Create an order into the database.\r\n"
				+ "3) Create a lineitem into the database .\r\n"
				+ "4) List all orders consist of order id, order date, customer id, employee id, total for a customer.\r\n"
				+ "5) List all lineitems for an order.\r\n"
				+ "6) List all customers consist of customer id, customer name in the database.\r\n"
				+ "7) List customer name, supervisor name and all orders of this customer.\r\n"
				+ "8) Compute order total (named as total_price) for a given order id.\r\n"
				+ "9) Update a customer in the database.\r\n"
				+ "10) Delete a customer from the database.\r\n"
				+ "11) Exit.\n");		
	}
}
