package DongyangJiang.traveller;
import java.text.ParseException;
import java.util.Date;

import DongyangJiang.person.Person;

//Done
/* import java.util.Date; */

public class Traveller extends Person {

	//Attribute
	private String passportNumber;
	private String nationality;
	private String type;
	

	public Traveller(String name) {
		super(name);
	}
	
	////Constructor without parameters
	public Traveller(String name, String birthday, String passportNumber, String nationality) throws ParseException{
		super(name, birthday);
		this.setPassportNumber(passportNumber);
		this.setNationality(nationality);
	}
	
	
	//Constructor with parameters
	public Traveller(String name, String birthday, String passportNumber, String nationality , String address , String contactNumber , String type) throws ParseException{
		super(name, address, birthday, contactNumber);
		this.setPassportNumber(passportNumber);
		this.setNationality(nationality);
		this.setType(type);
	}
	
	//Constructor with parameters
		public Traveller(String name , String passportNumber, String nationality) throws ParseException {
			super(name);
			this.setNationality(nationality);
			this.setPassportNumber(passportNumber);
		}
	
	

	
	//Functions
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return (super.toString() + "Traveller [passportNumber=" + passportNumber + ", naionality=" + nationality + "]");
	}
	
	
	
}




