package Excercise_2;

public class Wallet {
	private int money;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public boolean Payment(int total) {
		if (total > getMoney()) {
			return false;
		} else {
			return true;
		}
	}
}
