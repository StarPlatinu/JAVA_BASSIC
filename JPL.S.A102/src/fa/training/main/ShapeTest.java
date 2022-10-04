package fa.training.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fa.training.entities.Rectangle;
import fa.training.entities.ShapeManagerment;

public class ShapeTest {
	public static void main(String[] args) {
		ShapeManagerment manager = new ShapeManagerment();
		int n = manager.getInteger("Enter number of Rectangle you want to create: ");
		int choise;
		while (true) {
			manager.menu();
			choise = manager.getIntegerWithBound("Enter your choise:", 5, 1);
			switch (choise) {
			case 1:
				manager.getRectangle(n);
				break;
			case 2:
                manager.displayRectangle();
				break;
			case 3:
				manager.getMaxArea();
				break;
			case 4:
				manager.getMinArea();
				break;
			case 5:
				System.out.println("Good bye!");
                System.exit(0);
				break;
			}

		}

	}
}
