package fa.training.entities;

public class TotalPrice {
 private int CustomerId;
 private double Total_Price;
 
 public TotalPrice() {
	// TODO Auto-generated constructor stub
}

public TotalPrice(int customerId, double total_Price) {
	super();
	CustomerId = customerId;
	Total_Price = total_Price;
}

public int getCustomerId() {
	return CustomerId;
}

public void setCustomerId(int customerId) {
	CustomerId = customerId;
}

public double getTotal_Price() {
	return Total_Price;
}

public void setTotal_Price(double total_Price) {
	Total_Price = total_Price;
}

@Override
public String toString() {
	return "TotalPrice [CustomerId=" + CustomerId + ", Total_Price=" + Total_Price + "]";
}
 
}
