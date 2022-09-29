package fa.training.entities;

public class Ford extends Car{
	private int year;
	private int manufacturerDiscount;
	
	public Ford(int speed, double regularPrice, String color,int year, int manufacturerDiscount) {
		super(speed,regularPrice,color);
		this.year = year;
		this.manufacturerDiscount = manufacturerDiscount;
	}

	@Override
	public double getSalePrice() {
		return super.getRegularPrice() - manufacturerDiscount; 
	}

	@Override
	public String toString() {
		return "Ford [Speed="+ super.getSpeed() +", regularPrice=" 
	+ super.getRegularPrice() +", color=" + super.getColor() +", year=" + year 
	+ ", manufacturerDiscount=" + manufacturerDiscount + ", SalePrice = "+getSalePrice()+ "]";
	}
	
	
}
