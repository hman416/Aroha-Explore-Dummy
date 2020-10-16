package application;

public abstract class Product {
	private double price;
	
	public Product(double num) {
		price = num;
	}
	
	public double getPrice() {
		return price;
	}
}
