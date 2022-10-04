package fa.training.main;

import fa.training.service.ShapeManagerment;

public class ShapeTest {
	public static void main(String[] args) {
		ShapeManagerment manager = new ShapeManagerment();
		int n = ShapeManagerment.getInteger("Enter number of Rectangle you want to create: ");
		int choise;
		while (true) {
			ShapeManagerment.menu();
			choise = ShapeManagerment.getIntegerWithBound("Enter your choise:", 5, 1);
			switch (choise) {
			case 1:
				ShapeManagerment.getRectangle(n);
				break;
			case 2:
                ShapeManagerment.displayRectangle();
				break;
			case 3:
				manager.getMaxArea();
				break;
			case 4:
				manager.getMinPerimeter();
				break;
			case 5:
				System.out.println("Good bye!");
                System.exit(0);
				break;
			}

		}

	}
}
