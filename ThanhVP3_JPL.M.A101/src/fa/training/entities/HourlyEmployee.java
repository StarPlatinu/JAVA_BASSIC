package fa.training.entities;

public class HourlyEmployee extends Employee {
	private double rate;
	private double workingHours;

	public HourlyEmployee(String ssn, String firstName, String lastName, String address, String birthDate, String phone,
			String email, double rate, double workingHours) {
		super(ssn, firstName, lastName, address, birthDate, phone, email);
		this.rate = rate;
		this.workingHours = workingHours;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(double workingHours) {
		this.workingHours = workingHours;
	}
	
	@Override
	public String toString() {
		return super.toString()+", rate="+rate+", workingHours="+workingHours;
	}
	

}
