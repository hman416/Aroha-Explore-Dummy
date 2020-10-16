package application;

public class Flight extends Product{
	private String airline;
	private String departure;
	private String destination;
	
	public Flight(String al, String dep, String des, double num) {
		super(num);
		airline = al;
		departure = dep;
		destination = des;
	}
	
	public String toString() {
		return "Flight: " + airline + " from " + departure + " to " + destination;
	}

}
