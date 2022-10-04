package fa.training.entities;

public class Rectangle implements Shape {

	private int length;
	private int width;
	
	

	public Rectangle(int length, int width) {
		super();
		this.length = length;
		this.width = width;
	}

	@Override
	public int calculatePerimeter() {
		return 2 * (this.length + this.width);
	}

	@Override
	public int calculateArea() {
		return this.length * this.width;
	}

	@Override
	public int getLength() {
		return this.length;
	}

	@Override
	public int getWidth() {
		return this.width;
	}

	@Override
	public void setLengthWidth(int len, int width) {
		this.length = len;
		this.width = width;
	}

	@Override
	public String toString() {
		return "Rectangle [length=" + length + ", width=" + width + ", Perimeter=" + calculatePerimeter()
				+ ", Area=" + calculateArea() + "]";
	}
	
	

}
