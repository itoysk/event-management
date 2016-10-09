package DongyangJiang.client;

public class SchoolClient extends Client {
	double discount;
	
	public SchoolClient(String name) {
		super(name);
	}
	
	public SchoolClient(String name, String address, String contactNumber, double discount) {
		super(name, address, contactNumber);
		this.discount = discount;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	
	
}
