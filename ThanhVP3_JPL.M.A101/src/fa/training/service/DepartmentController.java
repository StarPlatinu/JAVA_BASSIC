package fa.training.service;

import fa.training.entities.Department;
import fa.training.entities.HourlyEmployee;
import fa.training.entities.SalesEmployee;
import fa.training.utils.Validation;
import java.util.*;

/**
 * 
 * @author thanh
 *
 */

public class DepartmentController {

	Validation validation = new Validation();
	public static List<Department> departments = new ArrayList<>();

	private static final String EMAIL_VALID = "[A-Za-z]\\w+@\\w+(\\.\\w+){1,3}$";
	private static final String PHONE_VALID = "(0[3|5|7|8|9])+([0-9]{8})";
	private static final String STRING_VALID = "[A-Za-z\\s]+";
	/*
	 * Where: ^ represents the starting of the string. (?!666|000|9\\d{2})\\d{3}
	 * represents the first 3 digits should not start with 000, 666, or between 900
	 * and 999. – represents the string followed by a hyphen (-). (?!00)\\d{2}
	 * represents the next 2 digits should not start with 00 and it should be any
	 * from 01-99. – represents the string followed by a hyphen (-). (?!0{4})\\d{4}
	 * represents the next 4 digits can’t 0000 and it should be any from 0001-9999.
	 * $ represents the ending of the string. EX: 856-45-6789
	 */
	private static final String SNN_VALID = "^(?!666|000|9\\d{2})\\d{3}-(?!00)\\d{2}-(?!0{4})\\d{4}$";

	public static void menu() {
		System.out.println("1. Create a new employee.");
		System.out.println("2. Display employees.");
		System.out.println("3. Classify employees.");
		System.out.println("4. Employee Search.");
		System.out.println("5. Report.");
		System.out.println("6. Exist.");
	}

	public void create() {
		int numberOfDepartment = validation.inputInt("Please enter number of department: ", 1, Integer.MAX_VALUE);
		int count = 0;
		for (int i = 0; i < numberOfDepartment; i++) {
			String departmentName = validation.inputString("Enter department " + (i+1) + ": ", STRING_VALID);
			departments.add(new Department(departmentName));
		}
		for (int i = 0; i < numberOfDepartment; i++) {
			System.out.println("Enter employee in " + departments.get(i).departmentName + ": ");
			while (true) {
				String snn;
				while (true) {
					snn = validation.inputString("Enter SNN(Social Security Number): ", SNN_VALID);
					if (validation.checkIdExist(departments, snn)) {
						break;
					} else {
						System.out.println("SNN exist.");
					}
				}
				String firstName = validation.inputString("Enter first name: ", STRING_VALID);
				String lastName = validation.inputString("Enter last name: ", STRING_VALID);
				String birthDate = validation.inputDate("Enter birthdate: ");
				String address = validation.inputString("Enter address: ", STRING_VALID);
				String phone = validation.inputString("Enrer phone: ", PHONE_VALID);
				String email = validation.inputString("Enter email: ", EMAIL_VALID);
				System.out.println("=====Employee Disboard=====");
				System.out.println("1.Hourly Employee");
				System.out.println("2.Sales Employee");
				int type = validation.inputInt("Enter type of employee you want to input: ", 1, 2);
				switch (type) {
				case 1:
					double rate = validation.inputDouble("Enter rate: ", 0, 5);
					double workingHours = validation.inputDouble("Enter working hours: ", 0, 24 * 30);
					departments.get(i).employees.add(new HourlyEmployee(snn, firstName, lastName, address, birthDate,
							phone, email, rate, workingHours));
					break;
				case 2:
					int numberUnits = validation.inputInt("Enter numberofUnits: ", 0, Integer.MAX_VALUE);
					departments.get(i).employees.add(
							new SalesEmployee(snn, firstName, lastName, address, birthDate, phone, email, numberUnits));
					break;
				}
				System.out.print("Do you want to continue (Y/N): ");
				if (!validation.checkInputYN()) {
					count++;
					break;
				}
				if (departments.size() == count) {
					return;
				}
			}

		}
	}

	public void display() {
		if (departments.isEmpty()) {
			System.out.println("Don't have any department.");
			return;
		}
		System.out.println("======All Employee In Each Department======");
		for (int i = 0; i < departments.size(); i++) {
			System.out.println(departments.get(i).departmentName);
			for (int j = 0; j < departments.get(i).employees.size(); j++) {
				System.out.println(departments.get(i).employees.get(j).toString());
			}
		}
	}

	public void classify() {
		if (departments.isEmpty()) {
			System.out.println("Don't have any department.");
			return;
		}
		System.out.println("Sales Employee: ");

		for (int i = 0; i < departments.size(); i++) {
			for (int j = 0; j < departments.get(i).employees.size(); j++) {
				if (departments.get(i).employees.get(j) instanceof SalesEmployee) {
					System.out.println(departments.get(i).employees.get(j).toString());
				}
			}
		}
		System.out.println("Hourly Employee: ");
		for (int i = 0; i < departments.size(); i++) {
			for (int j = 0; j < departments.get(i).employees.size(); j++) {
				if (departments.get(i).employees.get(j) instanceof HourlyEmployee) {
					System.out.println(departments.get(i).employees.get(j).toString());
				}
			}
		}
	}

	public void search() {
		while (true) {
			String search = validation.inputString("Enter department you want to search: ", STRING_VALID);
			for (int i = 0; i < departments.size(); i++) {
				if (departments.get(i).departmentName.toLowerCase().contains(search.toLowerCase())) {
					for (int j = 0; j < departments.get(i).employees.size(); j++) {
						System.out.println(departments.get(i).employees.get(j).toString());
					}
					String ename = validation.inputString("Enter student you want to search: ", STRING_VALID);
					for (int j = 0; j < departments.get(i).employees.size(); j++) {
						if (departments.get(i).employees.get(j).getFirstName().equals(ename)
								|| departments.get(i).employees.get(j).getLastName().equals(ename)
								|| ename.equals(departments.get(i).employees.get(j).getFirstName() + " "
										+ departments.get(i).employees.get(j).getLastName())) {
							System.out.println(departments.get(i).employees.get(j).toString());
						}else {
							System.out.println("Not found employee.");
							break;
						}
					}
				}
			}
			System.out.print("Do you want to continue (Y/N): ");
			if (!validation.checkInputYN()) {
				return;
			}
		}
	}

	public void report() {
		for (int i = 0; i < departments.size(); i++) {
			System.out.format("%s |%d \n ",departments.get(i).departmentName,departments.get(i).employees.size());
			System.out.println();
		}      
	}

}
