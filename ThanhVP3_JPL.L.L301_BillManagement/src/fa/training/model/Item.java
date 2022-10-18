package fa.training.model;

import java.io.Serializable;

public class Item implements Serializable {
	private static final long serialVersionUID = 1L;
	private String productName;
	private String billCode;
	private int quantity;
	private double price;

	public Item() {
		super();
	}

	public Item(String productName, String billCode, int quantity, double price) {
		super();
		this.productName = productName;
		this.billCode = billCode;
		this.quantity = quantity;
		this.price = price;
	}
	// getter and setter

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBillCode() {
		return billCode;
	}

	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// overide toString() method
	@Override
	public String toString() {
		return "Item [productName=" + productName + ", billCode=" + billCode + ", quantity=" + quantity + ", price="
				+ price + "]";
	}

}