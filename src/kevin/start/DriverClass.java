package kevin.start;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import kevin.event.Event;
import kevin.gui.MainGUI;

//Need Help
public class DriverClass {
	
	public DriverClass() {
		// TODO Auto-generated constructor stub
		
		
	}
	
	TestSystem test = new TestSystem();
	
	public static void main(String[] args){
//		TestSystem.setUpTestData();
		
//		TestSystem testSystem = new TestSystem();  
		
	
//		testSystem.loadEvents("Eventdata.txt");
//		testSystem.DisplayReport(testSystem.events);
//		testSystem.saveEvents(testSystem.events);
		
		List<Event> list = readEvents();
		MainGUI.startUI(list);;
		
	}
	
	public static List<Event> readEvents(){
		List<Event> list = TestSystem.readEvents("Eventdata.txt");
		return list;
	}
	
	public static void addTraveller(Event event) {
		TestSystem.addTraveller("Eventdata.txt", event);
	}


	public void showMenu() {
		Scanner scan = new Scanner(System.in);
		String Input = scan.nextLine();
		

		// TODO Auto-generated method stub
		System.out.println("=============================================");
		System.out.println("              Menu                           ");
		System.out.println("=============================================");
		System.out.println("1.Read Data From File.");
		System.out.println("2.Save Data To File.");
		System.out.println("3.Display Report");
		System.out.println("Enter the number to use the program.");
		System.out.println("=============================================");

		UserInput(Input);
		

	}
	
	public void UserInput(String Input) {

		Scanner scan = new Scanner(System.in);
		String eventName = scan.nextLine();
		TestSystem testSystem= new TestSystem();
		
		if (Input == "1") {
			// Read Data
//			 testSystem.loadEvents("C:/input.txt");
		} else if (Input == "2") {
			// Save Data

		} else if (Input == "3") {
			// Display Report
			System.out.println("Please Enter your eventName");
			// Scan
			// DisplayReport(String eventName);
		} else {
			System.out.println("Wrong Input.Please enter a vaild number");
			showMenu();

		}

	}
	
	
	
	
}
