package com.training.entities;

public class History extends Worker {
	private String status;
	private String date;

	public History() {
		// TODO Auto-generated constructor stub
	}

	public History(String id, String name, int age, double salary, String workLocation, String status, String date) {
		super(id, name, age, salary, workLocation);
		this.status = status;
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	

}
