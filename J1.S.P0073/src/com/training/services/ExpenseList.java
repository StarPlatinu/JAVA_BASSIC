package com.training.services;

import java.util.ArrayList;
import java.util.List;

import com.training.entities.Expense;
import com.training.utils.Validation;

public class ExpenseList {
	private List<Expense> list = new ArrayList<>();
	private Validation check = new Validation();

	public void addExpense() {
		int Id;
		if (list.isEmpty()) {
			Id = 1;
		} else {
			Id = list.get((list.size() - 1)).getId() + 1;
		}
		String date = check.inputDate("Enter Date: ");
		double amount = check.inputDouble("Enter Amount: ", 0, Double.MAX_VALUE);
		String content = check.inputString("Enter Content: ", "[A-Za-z0-9\\s]+");
		Expense e = new Expense(Id, date, content, amount);
		list.add(e);
		System.out.println("Add new expense successfully");
	}

	public void removeExpense() {
		int ID = check.inputInt("Enter ID: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
		for (Expense expense : list) {
			if (expense.getId() == ID) {
				list.remove(expense);
				System.out.println("Delete an expense successful");
				return;
			}
		}
		System.out.println("Delete an expense fail");
	}

	public void display() {
		double total = 0;
		System.out.println(String.format("%-4s%-15s%-15s%-20s", "ID", "Date", "Amount", "Content"));
		for (Expense e : list) {
			System.out.println(e);
			total = total + e.getAmount();
		}
		System.out.println("\t\tTotal: " + total);
	}

}
