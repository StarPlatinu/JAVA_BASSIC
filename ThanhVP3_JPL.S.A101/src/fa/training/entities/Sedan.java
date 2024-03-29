package fa.training.entities;


public class Sedan extends Car{
	private int length;
	
	public Sedan(int speed, double regularPrice, String color,int length) {
		super(speed,regularPrice,color);
		this.length = length;
	}

	@Override
	public double getSalePrice() {
		if(this.length>20) {
			return super.getRegularPrice() - super.getRegularPrice()*0.05;
		}else {
			return super.getRegularPrice() - super.getRegularPrice()*0.1;
		}
	}

	@Override
	public String toString() {
		return "Sedan [Speed=" + super.getSpeed() 
		+ ", regularPrice=" + super.getRegularPrice() 
		+ ", color=" + super.getColor() +",length="+length+  ", SalePrice = "+getSalePrice()+ "]";
	}
	

}
