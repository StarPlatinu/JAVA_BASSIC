package fa.training.util;

import java.util.Scanner;

public class UserInputUtil {
	/**
	 * Get value type integer from console.
	 * 
	 * @method inputTypeInt
	 * @param value
	 */

	public static int inputTypeInt(String value) {
		int intValue = 0;
		do {
			try {
				intValue = Integer.parseInt(value);
			} catch (Exception e) {
				System.out.println("Please input int value!");
			}
			break;
		} while (true);
		return intValue;
	}

	/**
	 * Get value float from console
	 * 
	 * @method onputTypeFloat
	 * @return
	 */
	public static float inputTypeOfFloat(String value) {
		float floatValue = 0;
		do {
			try {
				floatValue = Float.parseFloat(value);
			} catch (Exception e) {
				System.out.println("Please input float value!");
			}
			break;
		} while (true);
		return floatValue;
	}

	/**
	 * Get value type double from console.
	 *
	 * @method inputTypeDouble
	 * @param value .
	 */
	public static double inputTypeDouble(String value) {
		double doubleValue = 0;
		do {
			try {
				doubleValue = Double.parseDouble(value);
			} catch (Exception e) {
				System.out.println("Please input double value!");
			}
			break;
		} while (true);
		return doubleValue;
	}

	/**
	 * Get a valid bill code from console.
	 *
	 * @method checkBillCode
	 * @param scanner
	 * @return
	 */
	public static String checkBillCode(Scanner scanner) {
		String billCode;
		System.out.println("Enter bill code:");
		billCode = scanner.nextLine();
		while (!Validator.isValidBillCode(billCode)) {
			System.out.println("Invalid bill code: (example: B0000)");
			billCode = scanner.nextLine();
		}

		return billCode;
	}

}
