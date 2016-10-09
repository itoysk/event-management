package DongyangJiang.traveller;
//Done
/*import java.awt.List;*/

import java.util.ArrayList;

public class TourGroup {
	
	//ArrayList
	private ArrayList<Traveller> members = new ArrayList<Traveller>();
	
	public TourGroup() {
		// TODO Auto-generated constructor stub
	}
	
	
	//Functions
	public void addPerson(Traveller t) {
		members.add(t);
	}
	
//	public void removeTraveller(Traveller t) {
//		for (Traveller traveller : members) {
//			if (traveller == t) {
//				members.remove(t);
//			}
//		}
//	}
//
	public ArrayList<Traveller> getAllTravellers() {
		return members;
	}
//
//	public void setAllTraveller(ArrayList<Traveller> allTraveller) {
//		this.members = allTraveller;
//	}

	@Override
	public String toString() {
		return "TourGroup [allTraveller=" + members + "]";
	}
	
	
	

	
}
