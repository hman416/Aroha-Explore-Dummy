package application;

public class Sale {
	private String product;
	private String employee;
	private String buyer;
	private String date;
	
	public Sale (String p, String e, String b, String d) {
		product = p;
		employee =  e;
		buyer = b;
		date = d;
	}
	
	@Override
	public String toString() {
		return product + " sold by " + employee + " to " + buyer + " on " + date;
	}
}
