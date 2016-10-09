package kevin.start;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.security.PublicKey;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Scanner;

import kevin.client.Client;
import kevin.event.BusinessTrip;
import kevin.event.Event;
import kevin.event.FootyHolidayTour;
import kevin.event.SchoolHikeEvent;
import kevin.traveller.BusinessExec;
import kevin.traveller.SportPerson;
import kevin.traveller.Student;
import kevin.traveller.TourGroup;
import kevin.traveller.Traveller;

public class TestSystem {
	public static int noOfEvent;
	
	//Load data from file
	public static ArrayList<Event> readEvents(String eventFilePath) {
		Scanner fileScanner = null;
		ArrayList<Event> events = new ArrayList<>();
		try {
			File file = new File(eventFilePath);

			if (file.exists()) {
				fileScanner = new Scanner(file); // Open it
				
				noOfEvent = fileScanner.nextInt(); 

				while (fileScanner.hasNextLine()) {
					String currentLine = fileScanner.nextLine();
					if (currentLine.trim().equals("FootyHolidayTour") || currentLine.trim().equals("BusinessTrip") || currentLine.trim().equals("SchoolHikeEvent")) {
					
						String name = fileScanner.nextLine();
						String eventHostName = fileScanner.nextLine();
						//String[] date1 = fileScanner.nextLine().split("\\s");
						//String[] date2 = fileScanner.nextLine().split("\\s");
						Date departureDate = new SimpleDateFormat("yyyy-MM-dd").parse(fileScanner.nextLine());
						Date arrivalDate = new SimpleDateFormat("yyyy-MM-dd").parse(fileScanner.nextLine());
						
						//Date departureDate = new Date(Integer.parseInt(date1[0]), Integer.parseInt(date1[1]), Integer.parseInt(date1[2]));
						//Date arrivaleDate = new Date(Integer.parseInt(date2[0]), Integer.parseInt(date2[1]), Integer.parseInt(date2[2]));
						String destination = fileScanner.nextLine();
						String description = fileScanner.nextLine();
						Client bookingClient = new Client(fileScanner.nextLine());
						
						int travellerNumbers = Integer.parseInt(fileScanner.nextLine());
						TourGroup tourGroup = new TourGroup();
						System.out.println("count: "+travellerNumbers);
						for (int i = 0; i < travellerNumbers; i++) {
							tourGroup.addPerson(readTraveller(fileScanner.nextLine()));
						}
						
						
						if (currentLine.trim().equals("FootyHolidayTour")) {
							String clubName = fileScanner.nextLine();
							FootyHolidayTour event = new FootyHolidayTour(name, eventHostName, departureDate, arrivalDate, destination, description, bookingClient, clubName);
							event.setTourGroup(tourGroup);
							events.add(event);
						} else if (currentLine.trim().equals("BusinessTrip")) {
							BusinessTrip event = new BusinessTrip(name, eventHostName, departureDate, arrivalDate, destination, description, bookingClient);
							event.setTourGroup(tourGroup);
							events.add(event);					
						} else if (currentLine.trim().equals("SchoolHikeEvent")) {
							Traveller supervisor = readTraveller(fileScanner.nextLine());
							int additionalSupervisorsReqd = Integer.parseInt(fileScanner.nextLine());
							SchoolHikeEvent event = new SchoolHikeEvent(name, eventHostName, departureDate, arrivalDate, destination, description, bookingClient, supervisor, additionalSupervisorsReqd);
							event.setTourGroup(tourGroup);
							events.add(event);
						}
					}
				}
				
				for (Event event : events) {
					System.out.println(event.getTravellersDetails());
				}

			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		//sort
		Collections.sort(events);
		return events;
	}
	
	public static Traveller readTraveller(String s) throws ParseException {
		String[] travelInfo = s.split(",");
//		Traveller traveller = new Traveller(travelInfo[0],travelInfo[1],travelInfo[2],travelInfo[3]);
//		traveller.setAddress(travelInfo[4]);
//		traveller.setContactNumber(travelInfo[5]);
//		traveller.setType(travelInfo[6]);
		
		//if length > 6 , then just return travellers 
		if(travelInfo.length > 6){
			String travellerType = travelInfo[6];
			if("Student".equals(travellerType)){
				Student student = new Student(travelInfo[0],travelInfo[1],travelInfo[2],travelInfo[3],travelInfo[4],travelInfo[5],travelInfo[7],Integer.valueOf(travelInfo[8]));

				return student;
			}
			if("BusinessExec".equals(travellerType)){
				BusinessExec businessExec = new BusinessExec(travelInfo[0],travelInfo[1],travelInfo[2],travelInfo[3],travelInfo[4],travelInfo[5],travelInfo[7],Integer.valueOf(travelInfo[8]),travelInfo[9]);
				return businessExec;
			}
			if("SportPerson".equals(travellerType)){
				SportPerson sportPerson = new SportPerson(travelInfo[0],travelInfo[1],travelInfo[2],travelInfo[3],travelInfo[4],travelInfo[5],travelInfo[7],Integer.valueOf(travelInfo[8]),travelInfo[9]);
				return sportPerson;
			}
		}
		else{//if length <= 6 , then just return supervisor 
			Traveller supervisor = new Traveller(travelInfo[0],travelInfo[1],travelInfo[2],travelInfo[3]);
			supervisor.setAddress(travelInfo[4]);
			supervisor.setContactNumber(travelInfo[5]);
			return supervisor;
		}
		return null;
	}
	
	//Save Data to file
	public static boolean saveEvents(ArrayList<Event> events) {
		boolean succeeded = true; // Assume it will succeed.
		BufferedWriter writer = null;
        try {
            //create a temporary file
            File logFile = new File("Eventdata.txt");
            writer = new BufferedWriter(new FileWriter(logFile));
            
            //Print the 
            writer.write(noOfEvent+"\n\n");
            
            // This will output the full path where the file will be written to...
            
    		for (Event event : events) {
    			if(event instanceof FootyHolidayTour) {
    				writer.write("FootyHolidayTour\n");
    			} else if(event instanceof BusinessTrip) {
    				writer.write("BusinessTrip\n");
    			} else if (event instanceof SchoolHikeEvent) {
    				writer.write("SchoolHikeEvent\n");
				}
    			
				writer.write(event.getName() + "\n");
				writer.write(event.getEventHostName() + "\n");
				writer.write((new SimpleDateFormat("yyyy-MM-dd")).format(event.getDepartureDate()) + "\n");
				writer.write((new SimpleDateFormat("yyyy-MM-dd")).format(event.getArrivaleDate()) + "\n");
				writer.write(event.getDestination() + "\n");
				writer.write(event.getDescription() + "\n");
				writer.write(event.getBookingClient().getName() + "\n");	//WRONG			
				writer.write(event.getTourGroup().getAllTravellers().size()+ "\n");

				for(Traveller traveller :  event.getTourGroup().getAllTravellers()) {
					if(("Student").equals(traveller.getType())){
						writer.write(traveller.getName() + "," +(new SimpleDateFormat("yyyy-MM-dd")).format(traveller.getDateOfBirth())
								+ "," + traveller.getPassportNumber() 
								+","+ traveller.getNationality() + "," + traveller.getAddress() + "," + traveller.getContactNumber() + "," + traveller.getType() 
								+ "," + ((Student)traveller).getInsurer() + "," + ((Student)traveller).getInsuranceNumber()
								+ "\n");
					}
					
					if(("BusinessExec").equals(traveller.getType())){
						writer.write(traveller.getName() + "," +(new SimpleDateFormat("yyyy-MM-dd")).format(traveller.getDateOfBirth())
								+ "," + traveller.getPassportNumber() 
								+","+ traveller.getNationality() + "," + traveller.getAddress() + "," + traveller.getContactNumber() + "," + traveller.getType() 
								+ "," + ((BusinessExec)traveller).getAbnNumber() + "," + ((BusinessExec)traveller).getCompanying()
								+ "," + ((BusinessExec)traveller).getCompanyCreditCard()
								+ "\n");
					}
					if(("SportPerson").equals(traveller.getType())){
						writer.write(traveller.getName() + "," +(new SimpleDateFormat("yyyy-MM-dd")).format(traveller.getDateOfBirth())
								+ "," + traveller.getPassportNumber() 
								+","+ traveller.getNationality() + "," + traveller.getAddress() + "," + traveller.getContactNumber() + "," + traveller.getType() 
								+ "," + ((SportPerson)traveller).getClubInsurer() + "," + ((SportPerson)traveller).getInsuranceNum()
								+ "," + ((SportPerson)traveller).getSport()
								+ "\n");
					}
					
					
				}
				

    			if(event instanceof FootyHolidayTour) {
    				//clubName
    				writer.write(((FootyHolidayTour) event).getClubName() +"\n");
    				
    			} 
    			
    			else if(event instanceof BusinessTrip) {
    				
    				
    			} 
    			
    			else if (event instanceof SchoolHikeEvent) {
   				
    				writer.write(((SchoolHikeEvent) event).supervisor.getName()+","+
    						(new SimpleDateFormat("yyyy-MM-dd")).format(((SchoolHikeEvent) event).supervisor.getDateOfBirth())+","+ 
    						((SchoolHikeEvent) event).supervisor.getPassportNumber() + "," +
    						((SchoolHikeEvent) event).supervisor.getNationality()+ "," +
    						((SchoolHikeEvent) event).supervisor.getAddress() + "," +
    						((SchoolHikeEvent) event).supervisor.getContactNumber() + "\n");
    				writer.write(((SchoolHikeEvent) event).additionalSupervisorsReqd+"\n");
				}				
				
				writer.write("\n");
    		}

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } 
            catch (Exception e) {
            }
        }

		return succeeded;
	}
	
	//Print Report
	public static boolean DisplayReport(ArrayList<Event> events) {
		boolean succeeded = true; // Assume it will succeed.
		BufferedWriter writer = null;
		
		System.out.println("====================================================");
		System.out.println("                       Report                       ");
		
        try {
            //create a temporary file
            File logFile = new File("savedEvent.txt");
            writer = new BufferedWriter(new FileWriter(logFile));
            
            //Print the 
            System.out.println(noOfEvent+"\n\n");
            
            // This will output the full path where the file will be written to...
            
    		for (Event event : events) {
    			System.out.println("====================================================");	
    			if(event instanceof FootyHolidayTour) {
    				System.out.println("FootyHolidayTour\n");
    			} else if(event instanceof BusinessTrip) {
    				System.out.println("BusinessTrip\n");
    			} else if (event instanceof SchoolHikeEvent) {
    				System.out.println("SchoolHikeEvent\n");
				}
    			//this.destination = destination;
    			//this.description = description;
    			
    			System.out.println(event.getName() + "\n");
    			System.out.println(event.getEventHostName() + "\n");
    			System.out.println((new SimpleDateFormat("yyyy-MM-dd")).format(event.getDepartureDate()) + "\n");
    			System.out.println((new SimpleDateFormat("yyyy-MM-dd")).format(event.getArrivaleDate()) + "\n");
    			System.out.println(event.getDestination() + "\n");
    			System.out.println(event.getDescription() + "\n");
    			System.out.println(event.getBookingClient().getName() + "\n");	//WRONG			
    			System.out.println(event.getTourGroup().getAllTravellers().size()+ "\n");

				for(Traveller traveller :  event.getTourGroup().getAllTravellers()) {
					
					System.out.println(traveller.getName() + "," +(new SimpleDateFormat("yyyy-MM-dd")).format(traveller.getDateOfBirth())
					+ "," + traveller.getPassportNumber() 
					+","+ traveller.getNationality() + "\n");
				}
				
		
    			if(event instanceof FootyHolidayTour) {
    				//clubName
    				System.out.printf("ClubName:%s\n",((FootyHolidayTour) event).getClubName());
    				
    			} 
    			
    			else if(event instanceof BusinessTrip) {
    				
    			} 
    			
    			else if (event instanceof SchoolHikeEvent) {
    				//Supervisor
    				System.out.printf("SupervisorName:%s,DateOfBirth:%tD,PassportNo:%s,Nation:%s",
    						((SchoolHikeEvent) event).supervisor.getName(),((SchoolHikeEvent) event).supervisor.getDateOfBirth(),
    						((SchoolHikeEvent) event).supervisor.getPassportNumber(),((SchoolHikeEvent) event).supervisor.getNationality());	
				
    			System.out.println("\n\n");
    		}

        }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }
		
			
		System.out.println("====================================================");	
		return succeeded;
	}
	
	
	
	//addTraveller
	public static boolean addTraveller(String eventFilePath , Event event) {
		boolean succeeded = true; // Assume it will succeed.
		ArrayList<Event> events = readEvents(eventFilePath);
		for(int i = 0; i < events.size(); i++){
			if(events.get(i).getName().equals(event.getName())){
				events.remove(i);
				events.add(event);
				break;
			}
		}
		File file = new File(eventFilePath);
		file.delete();
		saveEvents(events);
		return succeeded;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void setUpTestData(){
		
	}
	
	
	
}
