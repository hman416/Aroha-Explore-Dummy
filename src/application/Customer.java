package application;

public class Customer {
	String _name;
	String _email;
	String _contactNum;
	String _cCNum;
	String _address;
	
	public Customer(String name, String email, String conNum, String cCNum, String address) {
		_name=name;
		_email=email;
		_contactNum = conNum;
		_cCNum = cCNum;
		_address = address;
	}
	
	public void modifyCustomer(String name, String email, String conNum, String cCNum, String address) {
		_name=name;
		_email=email;
		_contactNum = conNum;
		_cCNum = cCNum;
		_address = address;
	}
	
	public String getName() {
		return _name;
	}
	public String getEmail() {
		return _email;
	}
	public String getContact() {
		return _contactNum;
	}
	public String getCCNum() {
		return _cCNum;
	}
	public String getAddress() {
		return _address;
	}
	
	@Override
	public String toString() {
		return _name;
	}
}
