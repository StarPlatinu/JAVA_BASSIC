package fa.training.main;

import fa.training.service.DepartmentController;
import fa.training.utils.Validation;

public class DepartmentManage {
	public static void main(String[] args) {
		DepartmentController manager = new DepartmentController();
		Validation validation = new Validation();
		while (true) {
			System.out.println("==========DepartmentManage==========");
			DepartmentController.menu();
			int choice = validation.inputInt("Enter your choice: ", 1, 6);
			switch (choice) {
			case 1:
				System.out.println("----------Create Employee----------");
				manager.create();
				break;
			case 2:
				System.out.println("----------Display Employee----------");
				manager.display();
				break;
			case 3:
				System.out.println("----------Classify Employee----------");
				manager.classify();
				break;
			case 4:
				System.out.println("----------Search Employee----------");
				manager.search();
				break;
			case 5:
				System.out.println("----------Report----------");
				manager.report();
				break;
			case 6:
				System.exit(0);
				break;
			}
		}

	}
}
