package kevin.event;
import java.util.Date;

import kevin.client.Client;
import kevin.traveller.Traveller;

//Need Help
public class SchoolHikeEvent extends Event{

	//Attribute
	
	public Traveller supervisor;
	public int additionalSupervisorsReqd;
	
	public SchoolHikeEvent(String name, String eventHostName, Date departureDate, Date arrivaleDate, String destination,
			String description, Client bookingClient, Traveller supervisor, int additionalSupervisorsReqd) {
		super("SchoolHikeEvent",name, eventHostName, departureDate, arrivaleDate, destination, description, bookingClient);
		this.supervisor = supervisor;
		this.additionalSupervisorsReqd = additionalSupervisorsReqd;
		super.setSingleCost(50);
	}
	

	 
	
	
	
	
}
