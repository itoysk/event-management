package kevin.person;
//Done
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Person {
	
	//Attributes
	private String name;
	private String address;
	private Date dateOfBirth;
	private String contactNumber;
	
	//Constructors
	public Person(String name) {
		this.setName(name);
		this.setAddress("Unknown");
		this.setContactNumber("Unknown");		
	}
	
	public Person(String name, String birthday) throws ParseException{
		this.setName(name);
		//String[] DOBbreak = birthday.split("-"); 
		//new SimpleDateFormat("yyyy-MM-dd").parse(fileScanner.nextLine());
		//this.setDateOfBirth(new Date(Integer.parseInt(DOBbreak[0])-1900,Integer.parseInt(DOBbreak[1]),Integer.parseInt(DOBbreak[2])));
		this.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
	}
	
	
	
	public Person(String name, String address,  String contactNumber){
		
		this.setName(name);
		this.setAddress(address);
		this.setContactNumber(contactNumber);	
	}
	
	
	
	
	
	public Person(String name, String address, String dateOfBirth, String contactNumber) throws ParseException {
		super();
		this.name = name;
		this.address = address;
		this.dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth);
		this.contactNumber = contactNumber;
	}

	// Functions  
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
		
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", address=" + address + ", dateOfBirth=" + dateOfBirth + ", contactNumber="
				+ contactNumber + "]";
	}
	
	
	

}
