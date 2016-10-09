package kevin.start;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import kevin.event.Event;

public class MainTestMenu {

	// Attributes
	Event myTestEvent;



	// Functions
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

	//Have not finish
	public void UserInput(String Input) {

		Scanner scan = new Scanner(System.in);
		String eventName = scan.nextLine();
		TestSystem testSystem= new TestSystem();
		
		if (Input == "1") {
			// Read Data
//			 testSystem.loadEvents("Eventdata.txt");
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

	// Set up data for test

	/*
	 * public void DisplayReport(String eventName) {
	 
		// Display
		System.out.println("=========================================");
		System.out.println("			Report");
		System.out.println("=========================================");
			}
	 */
	
	


}
