package fa.training.main;

import java.sql.Date;
import java.util.List;

import fa.training.entities.Customer;
import fa.training.entities.LineItem;
import fa.training.entities.Order;
import fa.training.services.CustomerService;
import fa.training.services.EmployeeService;
import fa.training.services.LineItemService;
import fa.training.services.OrderService;
import fa.training.services.ProductService;
import fa.training.utils.*;

public class SaleManagement {

	public static void main(String[] args) {

		CustomerService cs = new CustomerService();
		OrderService os = new OrderService();
		LineItemService line = new LineItemService();
		Validation v = new Validation();
		boolean flag;
		while (true) {
			v.SaleManagementMenu();
			int choise = v.inputInt("Please choose function you'd like to do:", 1, 11);
			switch (choise) {
			case 1:
				System.out.println("----------Add a customer into the database-------------");
				String customerName = v.inputString("Enter customer name: ", "[A-Za-z\\\\s]+");
				flag = false;
				while (!(flag = cs.addCustomer(customerName))) {
					System.out.println("Add failed!!");
					System.out.println("input y/Y to continue or n/N to exits= to main screen.");
					if (!v.checkInputYN()) {
						break;
					}
					customerName = v.inputString("Enter customer name: ", "[A-Za-z\\\\s]+");
				}
				if (flag) {
					System.out.println("Add successfully");
				}
				break;
			case 2:
				System.out.println("----------Create an order into the database---------");
				flag = false;
				int step = 0;
				System.out.print("Enter order date(MM/dd/yyyy): ");
				Date newOrderOrderDate = (Date) v.inputDate();
				step++;
				int newOrderCustomerId = v.inputInt("Enter customer id: ", 0, Integer.MAX_VALUE);
				while (flag = (new CustomerService().getCustomerById(newOrderCustomerId) == null)) {
					System.out.println("Can not find customer!!");
					System.out.println("input y/Y to continue or n/N to exits= to main screen.");
					if (!v.checkInputYN()) {
						break;
					}
					System.out.print("Enter customer id: ");
					newOrderCustomerId = v.inputInt("Enter customer id: ", 0, Integer.MAX_VALUE);
				}
				if (!flag) {
					step++;
				}
				int newOrderEmployeeId = v.inputInt("Enter employee id: ", 0, Integer.MAX_VALUE);
				while (flag = (new EmployeeService().getEmployeeById(newOrderEmployeeId) == null)) {
					System.out.println("Can not find employee!!");
					System.out.println("input y/Y to continue or n/N to exits= to main screen.");
					if (!v.checkInputYN()) {
						break;
					}
					System.out.print("Enter employee id:");
					newOrderEmployeeId = v.inputInt("Enter employee id: ", 0, Integer.MAX_VALUE);
				}
				if (!flag) {
					step++;
				}
				if (step == 3) {
					Order newOrder = new Order(newOrderCustomerId, newOrderEmployeeId, newOrderOrderDate);
					System.out.println(os.addOrder(newOrder) ? "Add successfully" : "Add failed");
				}
				break;
			case 3:
				System.out.println("----------Create a lineitem into the database-----------");
				int st = 0;
				boolean fl = false;
				int newItemOrderId = v.inputInt("Enter Order id: ", 0, Integer.MAX_VALUE);
				while (fl = (new OrderService().getOrderById(newItemOrderId) == null)) {
					System.out.println("Can not find order id!!");
					System.out.println("input y/Y to continue or n/N to exits= to main screen.");
					if (!v.checkInputYN()) {
						break;
					}
					newItemOrderId = v.inputInt("Enter Order id: ", 0, Integer.MAX_VALUE);
				}
				if (!fl) {
					st++;
				}
				System.out.print("Enter product id: ");
				int newItemProductId = v.inputInt("Enter product id: ", 0, Integer.MAX_VALUE);
				while (fl = (new ProductService().getProductById(newItemProductId) == null)) {
					System.out.println("Can not find product id!!");
					System.out.println("input y/Y to continue or n/N to exits= to main screen.");
					if (!v.checkInputYN()) {
						break;
					}
					newItemProductId = v.inputInt("Enter product id: ", 0, Integer.MAX_VALUE);
				}
				if (!fl) {
					st++;
				}
				int newItemQuantity = v.inputInt("Enter quantity: ", 0, Integer.MAX_VALUE);
				st++;
				if (st == 3) {
					LineItem newItem = new LineItem(newItemOrderId, newItemProductId, newItemQuantity);
					System.out.println(line.addLineItem(newItem) ? "Add successfully"
							: "Add failed, duplicate pair order id and product id");
				}
				break;

			case 4:
				System.out.println("---------List all orders consist of order----------");
				int customerId = v.inputInt("Enter customer id to find: ", 0, Integer.MAX_VALUE);
				List<Order> orders = null;
				while ((orders = os.getAllOrderByCustomerId(customerId)) == null) {
					System.out.println("Can not find any order belong to input customer!!");
					System.out.println("input y/Y to continue or n/N to exits= to main screen.");
					if (!v.checkInputYN()) {
						break;
					}
					System.out.print("Enter customer id to find: ");
					customerId = v.inputInt("Enter customer id to find: ", 0, Integer.MAX_VALUE);
				}
				if (orders != null) {
					for (Order order : orders) {
						System.out.println(order.toString());
					}
				}
				break;
			case 5:
				System.out.println("----------List all lineitems for an order----------");
				int orderId = v.inputInt("Enter order id to find items: ", 0, Integer.MAX_VALUE);
				List<LineItem> lineItems = null;
				while ((lineItems = line.getAllLineItemById(orderId)) == null) {
					System.out.println("Can not find any items in this order id!!");
					System.out.println("input y/Y to continue or n/N to exits= to main screen.");
					if (!v.checkInputYN()) {
						break;
					}
					orderId = v.inputInt("Enter order id to find items: ", 0, Integer.MAX_VALUE);
				}
				if (lineItems != null) {
					for (LineItem lineItem : lineItems) {
						System.out.println(lineItem.toString());
					}
				}
				break;
			case 6:
				System.out.println(
						"----------List all customers consist of customer id, customer name in the database----------");
				List<Customer> customers = cs.getAllCustomer();
				if (customers != null) {
					for (Customer customer : customers) {
						System.out.println(customer.toString());
					}
				}
				break;
			case 7:
				System.out.println(
						"----------List customer name, supervisor name and all orders of this customer----------");
                
				break;
			case 8:
				System.out
						.println("----------Compute order total (named as total_price) for a given order id----------");

				break;
			case 9:
				System.out.println("----------Update a customer in the database----------");

				break;
			case 10:
				System.out.println("----------Delete a customer from the database----------");

				break;
			case 11:
				System.out.println("Good Bye!!");
				System.exit(0);
				break;

			}

		}
	}
}
