package fa.training.entities;

import java.util.Date;

public class Worker extends Person {
	private String woId;
	private int workerLevel;

	public Worker() {
		// TODO Auto-generated constructor stub
	}

	public Worker(String woId, int workerLevel, String fullName, String dateOfBirth, String gender, String address) {
		super(fullName, dateOfBirth, gender, address);
		this.woId = woId;
		this.workerLevel = workerLevel;
	}

	public int getWorkerLevel() {
		return workerLevel;
	}

	public void setWorkerLevel(int workerLevel) {
		this.workerLevel = workerLevel;
	}

	public String getWoId() {
		return woId;
	}

	public void setWoId(String woId) {
		this.woId = woId;
	}

	@Override
	public String toString() {
		return "woId=" + woId + ", workerLevel=" + workerLevel + ", " + super.toString();
	}

}
