package DongyangJiang.event;
import java.util.Date;

import DongyangJiang.client.Client;

//Need Help
public class BusinessTrip extends Event {
	public BusinessTrip() {}

	public BusinessTrip(String name, String eventHostName, Date departureDate, Date arrivaleDate, String destination,
			String description, Client bookingClient) {
		super("BusinessTrip",name, eventHostName, departureDate, arrivaleDate, destination, description, bookingClient);
		super.setSingleCost(100);
	}
	

	
	
}
