package fa.training.util;

import java.util.regex.Pattern;

public class Validator {
	/**
	 * Check bill code follow the pattern.
	 * 
	 * @method isValidBillCode
	 * @param billCode
	 * @return true if bill code is valid, else false
	 */
	public static boolean isValidBillCode(String billCode) {
		return Pattern.matches("^(B)[0-9]{4}$", billCode);
	}
}
