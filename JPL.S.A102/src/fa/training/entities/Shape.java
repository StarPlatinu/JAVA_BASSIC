package fa.training.entities;

interface Shape {
	   abstract int calculatePerimeter();
	   abstract int calculateArea();
	   abstract int getLength();
	   abstract int getWidth();
	   abstract void setLengthWidth(int len, int width);
}
