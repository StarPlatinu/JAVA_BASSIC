package fa.training.entities;

import java.util.Date;

public class Manager extends Person {
	private String mnId;
	private String department;

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getMnId() {
		return mnId;
	}

	public void setMnId(String mnId) {
		this.mnId = mnId;
	}

	public Manager(String mnId, String fullName, String dateOfBirth, String gender, String address, String department) {
		super(fullName, dateOfBirth, gender, address);
		this.mnId = mnId;
		this.department = department;
	}

	public Manager() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "mnId=" + mnId + ", " + super.toString() + ", department=" + department;
	}

}
