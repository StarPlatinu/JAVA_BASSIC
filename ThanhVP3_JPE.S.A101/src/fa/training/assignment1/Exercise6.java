package fa.training.assignment1;

import java.util.Scanner;

public class Exercise6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float width, height, area, perimeter;
		System.out.print("Width = ");
		width = sc.nextFloat();
		System.out.print("Height = ");
		height = sc.nextFloat();		
		perimeter = 2 * (width + height);
		area = width * height;
		System.out.format("\nArea is %.1f*%.1f = %.2f", width, height, area);
		System.out.format("\n\nParimeter is 2*(%.1f + %.1f) = %.2f", width, height, perimeter);
        sc.close();
        System.out.println();
	}
}
