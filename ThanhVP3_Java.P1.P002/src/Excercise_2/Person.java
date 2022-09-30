package Excercise_2;

public class Person {
	private int bill;
    Validation v = new Validation();
	public int getBill() {
		return bill;
	}

	public void setBill(int bill) {
		this.bill = bill;
	}

	public int calcTotal(int[] bills) {
		int total = 0;
		for (int i = 0; i < bills.length; i++) {
			total += bills[i];
		}
		return total;
	}
}
