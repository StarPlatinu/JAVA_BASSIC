package fa.training.main;

import fa.training.service.DepartmentController;
import fa.training.utils.Validation;

public class DepartmentManage {
	public static void main(String[] args) {
		DepartmentController manager = new DepartmentController();
		Validation validation = new Validation();
		while (true) {
			DepartmentController.menu();
			int choice = validation.inputInt("Enter your choice: ", 1, 6);
			switch (choice) {
			case 1:
				manager.create();
				break;
			case 2:
				manager.display();
				break;
			case 3:
				manager.classify();
				break;
			case 4:
				manager.search();
				break;
			case 5:
				manager.report();
				break;
			case 6:
				System.exit(0);
				break;
			}
		}

	}
}
