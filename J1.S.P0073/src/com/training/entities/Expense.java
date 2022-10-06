package com.training.entities;

public class Expense {
	private int Id;
	private String date, content;
	private double amount;

	public Expense() {
		// TODO Auto-generated constructor stub
	}

	public Expense(int id, String date, String content, double amount) {
		this.Id = id;
		this.date = date;
		this.content = content;
		this.amount = amount;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		String out = String.format("%-4d%-15s%-15.2f%-20s", Id, date, amount, content);
		return out;
	}

}
