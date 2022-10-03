package Excercise_2_Vertion2;

public class Person {
private Wallet wallet;

public Wallet getWallet() {
	return wallet;
}

public void setWallet(Wallet wallet) {
	this.wallet = wallet;
}

public boolean Payment(float totalBills) {
	return (wallet.getMoney() - totalBills)>=0;
}


}
