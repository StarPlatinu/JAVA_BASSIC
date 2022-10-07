package fa.training.entities;

public class SalesEmployee extends Employee {
	private final float UNIT_PRICE = 100;
	private final float EXTRA_PAY = 50;
	private int numberUnits;

	public SalesEmployee(String ssn, String firstName, String lastName, String address, String birthDate, String phone,
			String email, int numberUnits) {
		super(ssn, firstName, lastName, address, birthDate, phone, email);
		this.numberUnits = numberUnits;
	}

	public int getNumberUnits() {
		return numberUnits;
	}

	public void setNumberUnits(int numberUnits) {
		this.numberUnits = numberUnits;
	}

	@Override
	public String toString() {
		return super.toString()+", numberUnits=" + numberUnits;
	}
}
