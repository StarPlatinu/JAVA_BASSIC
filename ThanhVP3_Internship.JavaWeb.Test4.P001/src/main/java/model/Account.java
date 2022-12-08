package model;

public class Account {
private String account;
private String password;
private String phone;
private int balance;

public Account() {
	// TODO Auto-generated constructor stub
}

public Account(String account, String password, String phone, int balance) {
	super();
	this.account = account;
	this.password = password;
	this.phone = phone;
	this.balance = balance;
}

public String getAccount() {
	return account;
}

public void setAccount(String account) {
	this.account = account;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public int getBalance() {
	return balance;
}

public void setBalance(int balance) {
	this.balance = balance;
}

}
