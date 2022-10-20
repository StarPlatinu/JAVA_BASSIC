package fa.training.entities;

import java.util.Date;

public class Person {
	private String fullName;
	private String dateOfBirth;
	private String gender;
	private String address;


	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String fullName, String dateOfBirth, String gender, String address) {
		super();
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.address = address;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "fullName=" + fullName + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", address=" + address;
	}

}
