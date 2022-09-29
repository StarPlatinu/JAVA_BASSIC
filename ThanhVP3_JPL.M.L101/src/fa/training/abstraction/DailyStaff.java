package fa.training.abstraction;

import java.util.Scanner;

import fa.training.validation.Validation;

public class DailyStaff extends Employee {
	private static final int WAGE_DAY = 15;

	private double numbeOfWorkday;

	@Override
	public double calcSalary() {
		return numbeOfWorkday * WAGE_DAY;
	}

	@Override
	protected void inputData(Scanner scanner) {
		/*
		 * Call inputData method from parent class.
		 */
		super.inputData(scanner);
		System.out.println("Enter number of workday: ");
		numbeOfWorkday = Validation.getDouble();
		System.out.println("---------------------------");
	}

	@Override
	protected void display() {
		// Call method of parent class
		super.display();

		System.out.print("\t" + numbeOfWorkday + "\t" + this.calcSalary() + "\n");
	}
}
