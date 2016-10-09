package kevin.client;

import kevin.person.Person;

//Need Help
public class Client extends Person {

	//Attributes
	
	static int nextClientID = 0;
	int clientID;
	String clientName;
	String clientAddress;
	String clientPhone;
	
	public Client(String name) {
		super(name);
		clientID = nextClientID++;
		
	}
	
	public Client(String name, String address, String contactNumber) {
		super(name,address,contactNumber);
		clientID = nextClientID++;
	}
	
	
	//Functions - Get&Set
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName(name);
	}
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}
	

	public void setAddress(String address) {
		// TODO Auto-generated method stub
		super.setAddress(address);
	}
	public String getAddress() {
		// TODO Auto-generated method stub
		return super.getAddress();
	}
	
	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}
	public String getClientPhone() {
		return clientPhone;
	}

	
	
	
	
	
	
}
