package kevin.event;
import java.util.Date;

import kevin.client.Client;

public class FootyHolidayTour extends Event {

	//Attributes
	
	public String clubName;

	public FootyHolidayTour(String name, String eventHostName, Date departureDate, Date arrivaleDate,
			String destination, String description, Client bookingClient, String clubName) {
		super("FootyHolidayTour",name, eventHostName, departureDate, arrivaleDate, destination, description, bookingClient);
		this.clubName = clubName;
		super.setSingleCost(75);
	}
	
	
	public String getClubName(){		
		return clubName;
	}
	public void setClubName(String clubName){
		this.clubName = clubName;
	}
	

}
