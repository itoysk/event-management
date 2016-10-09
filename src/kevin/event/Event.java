package kevin.event;

//Need Help
import java.util.Date;

import kevin.client.Client;
import kevin.person.Person;
import kevin.traveller.TourGroup;
import kevin.traveller.Traveller;

public class Event implements  Comparable<Event> {

	// Attributes
	private String type;
	private String name;
	public String eventHostName;

	public Date departureDate;
	public Date arrivaleDate;
	public String destination;
	public String description;

	// Class Attributes
	public Person eventManager;
	private Client bookingClient;
	public TourGroup group;
	private double eventTotalCost = 0;
	private double singleCost = 0;
	
	public Event() {
		// TODO Auto-generated constructor stub
	}

	public Event(String type,String name, String eventHostName, Date departureDate, Date arrivaleDate, String destination,
			String description, Client bookingClient) {
		this.type = type;
		this.name = name;
		this.eventHostName = eventHostName;
		this.departureDate = departureDate;
		this.arrivaleDate = arrivaleDate;
		this.destination = destination;
		this.description = description;
		this.bookingClient = bookingClient;
		group = new TourGroup();
		
	}

	// Functions
	public void AddClientInformation(Client client, String name, String address, String contactNumber) {
		client.setName(name);
		client.setAddress(address);
		// client.setDateOfBirth(dateOfBirth);
		client.setContactNumber(contactNumber);

	}

	// Functions -Get&Set

	//type
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
		//Name
	public String getName() {
		return name;
	}

	public void setName(String name){
		this.name = name;
	}
	
		//EventHostName
	public String getEventHostName() {
		return eventHostName;
	}
	public void setEventHostName(String eventHostName){
		this.eventHostName = eventHostName;
	}
	
		//DepartureDate
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

		//ArrivaleDate
	public Date getArrivaleDate() {
		return arrivaleDate;
	}
	public void setArrivaleDate(Date arrivaleDate) {
		this.arrivaleDate = arrivaleDate;
	}
	
		//Destination
	public String getDestination(){
		return destination;
	}
	public void setDestination(String destination){
		this.destination = destination;
	}
	
		//Description
	public String getDescription(){
		return description;
	}
	public void setDescription(String description){
		this.description = description;
	}
		
		//EventTotalCost
	public double getEventTotalCost() {
		return eventTotalCost;
	}

	public void setEventTotalCost(double eventTotalCost) {
		this.eventTotalCost = eventTotalCost;
	}
		
		//SingleCost
	public double getSingleCost() {
		return singleCost;
	}
	public void setSingleCost(double singleCost) {
		this.singleCost = singleCost;
	}
	
		//BookingClient
	public Client getBookingClient() {
		return bookingClient;
	}
	public void setBookingClient(Client bookingClient) {
		this.bookingClient = bookingClient;
	}

		//TourGroup
	public TourGroup getTourGroup() {
		return group;
	}
	public void setTourGroup(TourGroup tourGroup) {
		this.group = tourGroup;
		eventTotalCost = group.getAllTravellers().size() * singleCost ; //step 6 update cost
	}

	
	public void produceReport(String report) {

	}
	
	public void addTraveller(Traveller t) {
		group.addPerson(t);
		eventTotalCost = group.getAllTravellers().size() * singleCost ; //step 6 update cost
	}
	
	public String getTravellersDetails() {
		String information = "";
		for (Traveller t : group.getAllTravellers()) {
			information = information + " " + t.toString() + "\n";
		}
		
		return information;
	}

	@Override
	public String toString() {
		return "Event [bookingClient=" + bookingClient + ", tourGroup=" + group + "]";
	}

	@Override
	public int compareTo(Event o) {
		// TODO Auto-generated method stub
		return getName().compareTo(o.getName());
	}

}
