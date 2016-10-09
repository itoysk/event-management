package kevin.traveller;
import java.text.ParseException;
import java.util.Date;

//Done
public class SportPerson extends Traveller{


	//Attributes
	private String clubInsurer;
	private int insuranceNum;
	private String sport;
	
	//Constructor
	public SportPerson(String name, String birthday, String passportNumber, String nationality) throws ParseException {
		super(name, birthday, passportNumber, nationality);
	}
	
	/*String name, String address, String contactNumber ,String passportNumber, String nationality*/
	public SportPerson(String name, String birth ,String passportNumber , String nationality, String address, String contactNumber ,
			String clubInsurer, int insuranceNum,String sport) throws ParseException{
		
		super(name, birth, passportNumber, nationality, address, contactNumber , "SportPerson");
		this.setClubInsurer(clubInsurer);
		this.setInsuranceNum(insuranceNum);
		this.setSport(sport);
	}
	
	
	//Functions
	
	public String getClubInsurer() {
		return clubInsurer;
	}

	public void setClubInsurer(String clubInsurer) {
		this.clubInsurer = clubInsurer;
	}

	public int getInsuranceNum() {
		return insuranceNum;
	}

	public void setInsuranceNum(int insuranceNum) {
		this.insuranceNum = insuranceNum;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}


	public String toString() {
		return "SportPerson [clubInsurer=" + clubInsurer + ", insuranceNum=" + insuranceNum + ", sport=" + sport + "]";
	}
	
	
	
	
}
