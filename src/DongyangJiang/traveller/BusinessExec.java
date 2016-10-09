package DongyangJiang.traveller;

import java.text.ParseException;

//Done
public class BusinessExec extends Traveller {

	//Attribute
	private String abnNumber;
	private int companyPaying;
	private String companyCreditCard;
	
	//Constructor without parameters
	public BusinessExec(String name){
		super(name);
		this.setAbnNumber("Unknown");
		this.setCompanying(companyPaying);
	}
	
	//Constructor with parameters
	public BusinessExec(String name,String birth ,String passportNumber,
			String nationality, String address, String contactNumber , String abnNumber,int companyPaying , String card) throws ParseException{
		
		super(name, birth, passportNumber, nationality, address, contactNumber,"BusinessExec");
		this.setAbnNumber(abnNumber);
		this.setCompanying(companyPaying);
		this.setcompanyCreditCard(card);
	}
	
	
	// Functions - get&set
	public String getAbnNumber() {
		return abnNumber;
	}
	public void setAbnNumber(String abnNumber) {
		this.abnNumber = abnNumber;
	}
	
	public int getCompanying() {
		return companyPaying;
	}
	public void setCompanying(int companyPaying) {
		this.companyPaying = companyPaying;
	}
	
	public String getCompanyCreditCard() {
		return companyCreditCard;
	}
	public void setcompanyCreditCard(String companyCreditCard) {
		this.companyCreditCard = companyCreditCard;
	}
	
	
	// Functions - toString
	@Override
	public String toString() {
		return "Executive [abnNumber=" + abnNumber + ", company=" + companyPaying + "]";
	}
	
	
}
