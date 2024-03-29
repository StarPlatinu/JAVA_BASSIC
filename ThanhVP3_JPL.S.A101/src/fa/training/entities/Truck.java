package fa.training.entities;

public class Truck extends Car{
	public int weight;
	public Truck(int speed, double regularPrice, String color,int weight) {
		super(speed,regularPrice,color);
		this.weight = weight;
	}
	

	public int getWeight() {
		return weight;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public double getSalePrice() {
		if(this.weight>2000) {
		return super.getRegularPrice()-super.getRegularPrice()*0.1;
		}else {
	    return super.getRegularPrice()-super.getRegularPrice()*0.2;
		}		
	}

	@Override
	public String toString() {
		return "Truck [speed=" + super.getSpeed() 
		+ ", regularPrice=" + super.getRegularPrice() 
		+ ", color=" + super.getColor() +", weight =" +weight+  ", SalePrice = "+getSalePrice()+"]";
	}	
}
