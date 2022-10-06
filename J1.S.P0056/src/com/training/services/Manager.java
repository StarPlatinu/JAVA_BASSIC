package com.training.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.training.entities.History;
import com.training.entities.Worker;
import com.training.utils.Validation;

public class Manager {
	ArrayList<Worker> workers = new ArrayList<>();
	ArrayList<History> history = new ArrayList<>();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Calendar calendar = Calendar.getInstance();
	String date = dateFormat.format(calendar.getTime());
	Validation validation = new Validation();

	/**
	 * get Worker by id
	 * 
	 * @param id
	 * @return
	 */
	public Worker getWorkerByCode(String id) {
		for (Worker worker : workers) {
			if (id.equalsIgnoreCase(worker.getId())) {
				return worker;
			}
		}
		return null;
	}

	/**
	 * add worker to list and check if id exist -> enter new id
	 */
	public void addWorker() {
		String id;
		while (true) {
			id = validation.inputString("Enter id: ");
			Worker worker = getWorkerByCode(id);
			if (worker == null) {
				break;
			} else {
				System.out.println("This id is existed");
			}
		}
		String name = validation.inputString("Enter name: ");
		int age = validation.inputInt("Enter age: ", 18, 50);
		double salary = validation.inputDouble("Enter salary: ", 1, Double.MAX_VALUE);
		String workLocation = validation.inputString("Enter work location: ");
		workers.add(new Worker(id, name, age, salary, workLocation));
		history.add(new History(id, name, age, salary, workLocation, "UP", date));
	}

	/**
	 * Change salary
	 * 
	 * @param status
	 */
	public void changeSalary(String status) {
		String id = validation.inputString("Enter id: ");
		Worker worker = getWorkerByCode(id);
		if (worker == null) {
			System.err.println("Not exist worker.");
		} else {
			if (worker.getSalary() == 1 && status.equals("DOWN")) {
				System.out.println("Can't down this worker salary anymore");
			} else if (worker.getSalary() == Double.MAX_VALUE && status.equals("UP")) {
				System.out.println("Can't up this worker salary anymore");
			} else {
				double salaryCurrent = worker.getSalary();
				double salaryUpdate;
				while (true) {
					double salary = validation.inputDouble("Enter salary: ", 1, Double.MAX_VALUE);
					if (status.equals("UP")) {
						salaryUpdate = salaryCurrent + salary;
						break;
					} else {
						if (salary > salaryCurrent) {
							System.out.println("You should input smaller than current salary(" + salaryCurrent + ").");
						} else {
							salaryUpdate = salaryCurrent - salary;
							break;
						}
					}
				}
				history.add(new History(worker.getId(), worker.getName(), worker.getAge(), salaryUpdate,
						worker.getWorkLocation(), status, date));
				worker.setSalary(salaryUpdate);
				System.err.println("Update successfully.");
			}

		}
	}

	/**
	 * Display history
	 */
	public void printListHistory() {
		if (history.isEmpty()) {
			System.out.println("No history");
			return;
		}
		System.out.printf("\n%-10s|%-20s|%-15s|%-15s|%-15s|%-20s|", "Code", "Name", "Age", "Salary", "Status", "Date");
		for (History history : history) {
			System.out.printf("\n%-10s|%-20s|%-15s|%-15s|%-15s|%-20s|\n", history.getId(), history.getName(), history.getAge(),
					history.getSalary(), history.getStatus(), history.getDate());
		}
	}

}
