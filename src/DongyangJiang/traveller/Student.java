package DongyangJiang.traveller;
import java.text.ParseException;
import java.util.Date;

import DongyangJiang.person.Person;

//
//import java.util.Date;

public class Student extends Traveller {

	//Attribute
	private Person parent;
		
	private String insurer;
	private int insuranceNo;
	/*
	private String name;
	private String address;
	private Date dateOfBirth;
	private String contactNumber;
	private String passportNumber;
	private String nationality;*/
	
	
	//Constructor without parameters
	public Student(String name, String birthday, String passportNumber, String nationality) throws ParseException {
		super(name, birthday, passportNumber, nationality);
	}
	
	//Constructor without parameters
		public Student(String name, String birthday, String passportNumber, String nationality , String insurer , int insuranceNo) throws ParseException {
			super(name, birthday, passportNumber, nationality);
			this.setInsurer(insurer);
			this.setInsuranceNumber(insuranceNo);
		}
	
	

	//Constructor with parameters
	public Student(String name , String birth , String passportNumber , String nationality , String address , String contactNumber , String insurer , int insuranceNo) throws ParseException {
		
		
		super(name, birth, passportNumber, nationality, address, contactNumber, "Student");

		this.insurer = insurer;	
		this.insuranceNo = insuranceNo;
//		parent = new Person(){};
//		this.parent.setName(parentName);
//		this.parent.setAddress(parentAddress);
////		this.parent.setDateOfBirth(parentDOB);
//		this.parent.setContactNumber(parentContect);
		
	}
	
	//Functions - Get&Set
	public Person getParent() {
		return parent;
	}

	public void setParent(Person parent) {
		this.parent = parent;
	}

	public String getInsurer() {
		return insurer;
	}

	public void setInsurer(String insurer) {
		this.insurer = insurer;
	}

	public int getInsuranceNumber() {
		return insuranceNo;
	}

	public void setInsuranceNumber(int insuranceNumber) {
		this.insuranceNo = insuranceNumber;
	}

	//Functions - toString
	@Override
	public String toString() {
		return "Student [parent=" + parent + ", insurer=" + insurer + ", insuranceNumber=" + insuranceNo + "]";
	}
	
	
	
	
}
