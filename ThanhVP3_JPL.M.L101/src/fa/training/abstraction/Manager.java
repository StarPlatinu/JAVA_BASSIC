package fa.training.abstraction;

import java.util.Scanner;

import fa.training.validation.Validation;

public class Manager extends Employee {
	private double wage;
	private double basicSalary;

	@Override
	public double calcSalary() {
		return wage * basicSalary;
	}

	@Override
	protected void inputData(Scanner scanner) {

		super.inputData(scanner);

		System.out.println("Enter wage: ");
		wage = Validation.getDouble();

		System.out.println("Enter basic salary: ");
		basicSalary = Validation.getDouble();

		System.out.println("---------------------------");
	}

	@Override
	protected void display() {
		// Call method of parent class
		super.display();

		System.out.print("\t" + wage + "\t" + basicSalary + "\t" + this.calcSalary() + "\n");
	}
}
