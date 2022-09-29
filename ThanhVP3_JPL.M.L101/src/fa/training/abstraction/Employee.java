package fa.training.abstraction;

import java.util.Date;
import java.util.Scanner;

import fa.training.validation.Validation;

public abstract class Employee {
	private String employeeName;
	private Date dateOfBirth;
	private String address;
	private static String companyName;

	public static String getCompanyName() {
		return companyName;
	}

	public static void setCompanyName(String companyName) {
		Employee.companyName = companyName;
	}

	protected void inputData(Scanner scanner) {

		System.out.println("Enter name: ");
		employeeName = Validation.getString();
		System.out.println("Enter birth date: ");
		dateOfBirth = Validation.getDate();

		System.out.println("Address: ");
		address = Validation.getString();
	}

	/**
	 * Display data to console.
	 */
	protected void display() {
		System.out.print(employeeName + "\t" + dateOfBirth + "\t" + address + "\t" + companyName);
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public abstract double calcSalary();
}
