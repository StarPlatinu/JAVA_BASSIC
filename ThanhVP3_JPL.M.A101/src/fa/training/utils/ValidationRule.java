package fa.training.utils;

public class ValidationRule {
public static boolean checkIsbn(String isbn) {
	return isbn.matches("\\d{10,17}");
}
}
