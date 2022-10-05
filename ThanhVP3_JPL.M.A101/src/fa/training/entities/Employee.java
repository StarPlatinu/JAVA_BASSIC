package fa.training.entities;

public abstract class Employee {
//fields: ssn, firstName, lastName, address,birthDate, phone, email;
	private String ssn;
	private String firstName;
	private String lastName;
	private String address;
	private String birthDate;
	private String phone;
	private String email;

	public Employee() {
	}

	public Employee(String ssn, String firstName, String lastName, String address, String birthDate, String phone,
			String email) {
		this.ssn = ssn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.birthDate = birthDate;
		this.phone = phone;
		this.email = email;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
		public boolean equals(Object obj) {
			if(obj instanceof Employee) {
				Employee other = (Employee) obj;
				return (other.ssn.equals(ssn)&&other.firstName.equals(firstName)
						&&other.lastName.equals(lastName)
						&&other.address.equals(address)&&other.birthDate.equals(birthDate)
						&&other.phone.equals(phone)&&email.equals(email));
			}
			return false;
		}
	@Override
		public int hashCode() {
		 return ssn.hashCode() * firstName.hashCode() * lastName.hashCode() 
				 * address.hashCode() * birthDate.hashCode() * phone.hashCode() * email.hashCode();
		}
	

	@Override
	public String toString() {
		return "ssn=" + ssn + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", birthDate=" + birthDate + ", phone=" + phone + ", email=" + email ;
	}

}
