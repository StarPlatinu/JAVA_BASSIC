package fa.training.entities;

import java.time.LocalDate;

public class Item {

	private int id;
	private String name;
	private int quantity;
	private float price;
	private LocalDate createdOn;
	private LocalDate modifiedDate;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Item(int id, String name, int quantity, float price, LocalDate createdOn, LocalDate modifiedDate) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.createdOn = createdOn;
		this.modifiedDate = modifiedDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDate getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDate modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + ", createdOn="
				+ createdOn + ", modifiedDate=" + modifiedDate + "]";
	}

	
}
