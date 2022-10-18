package fa.training.main;

import fa.training.services.CustomerService;
import fa.training.services.LineItemService;
import fa.training.services.OrderService;
import fa.training.utils.*;

public class SaleManagement {

	public static void main(String[] args) {
		CustomerService cs = new CustomerService();
		OrderService os = new OrderService();
		LineItemService line = new LineItemService();
		Validation v = new Validation();
		while (true) {
			v.SaleManagementMenu();
			int choise = v.inputInt("Please choose function you'd like to do:", 1, 11);
			switch (choise) {
			case 1:
				System.out.println("----------Add A New Book-------------");

				break;
			case 2:
				System.out.println("----------Add A New Megagine---------");

				break;
			case 3:
				System.out.println("----------Display Books And Megazines-----------");

				break;

			case 4:
				System.out.println("---------Add Author To Book----------");

				break;
			case 5:
				System.out.println("----------Display Top 10 Of Magazines By Volumns----------");

				break;
			case 6:
				System.out.println("----------Search Book By (isbn, author, publisher)----------");

				break;
			case 7:
				System.out.println("----------Search Book By (isbn, author, publisher)----------");

				break;
			case 8:
				System.out.println("----------Search Book By (isbn, author, publisher)----------");

				break;
			case 9:
				System.out.println("----------Search Book By (isbn, author, publisher)----------");

				break;
			case 10:
				System.out.println("----------Search Book By (isbn, author, publisher)----------");

				break;
			case 11:
				System.out.println("Good Bye!!");
				System.exit(0);
				break;

			}

		}
	}
}
