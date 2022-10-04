package fa.training.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ValidationRule {
	public static boolean checkIsbn(String isbn) {
		return isbn.matches("\\d{10,17}");
	}
	
	public static LocalDate convertStringToDate(String dateStr) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(dateStr,formatter);
		return date;
	}
}
