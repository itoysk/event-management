package DongyangJiang.client;

public class CorporateClient extends Client {

	private String abnNumber;
	
	public CorporateClient(String name, String address, String contactNumber, String abnNumber) {
		
		// TODO Auto-generated constructor stub
		super(name,address,contactNumber);
		this.abnNumber = abnNumber;
	}
	
}
