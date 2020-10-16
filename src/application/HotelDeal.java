package application;

public class HotelDeal extends Product{
	private String hotelName;
	private String duration;
	
	public HotelDeal(String hName, String dur, double num) {
		super(num);
		hotelName = hName;
		duration = dur;
	}
	
	public String toString() {
		return hotelName + " : $" + super.getPrice() + " for " + duration + " days";
	}
}
