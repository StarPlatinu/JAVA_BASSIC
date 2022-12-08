package model;

public class TransactionHistory {
private int amount;
private String account_receive;
private String account_transfer;

public TransactionHistory() {
	// TODO Auto-generated constructor stub
}

public TransactionHistory(int amount, String account_receive, String account_transfer) {
	super();
	this.amount = amount;
	this.account_receive = account_receive;
	this.account_transfer = account_transfer;
}

public int getAmount() {
	return amount;
}

public void setAmount(int amount) {
	this.amount = amount;
}

public String getAccount_receive() {
	return account_receive;
}

public void setAccount_receive(String account_receive) {
	this.account_receive = account_receive;
}

public String getAccount_transfer() {
	return account_transfer;
}

public void setAccount_transfer(String account_transfer) {
	this.account_transfer = account_transfer;
}

}
