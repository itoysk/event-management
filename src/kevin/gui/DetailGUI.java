package kevin.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kevin.event.Event;
import kevin.start.DriverClass;
import kevin.start.TestSystem;
import kevin.traveller.BusinessExec;
import kevin.traveller.SportPerson;
import kevin.traveller.Student;
import kevin.traveller.Traveller;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class DetailGUI extends JFrame {

	private JPanel contentPane;
	private JLabel hostName;
	private JTextField travellerNameText;
	private JTextField passportNumberText;
	private JTextField nationalityText;
	private ButtonGroup buttonGroup;
	private JRadioButton rdbtnStudent;
	private JRadioButton rdbtnCorporateExecutive;
	private JRadioButton rdbtnSportingPerson;
	private JButton addBtn;
	private JButton travellersBtn;
	private JButton reportBtn;
	private JLabel lblBirth;
	private JTextField bitrhText;
	private JTextArea travellers;
	private JTextField contactText;
	private JTextField addressText;

	

	

	/**
	 * Create the frame.
	 */
	public DetailGUI() {
		setTitle("event FootyHolidayTour Manage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1278, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Event Host");
		lblNewLabel.setBounds(21, 24, 66, 15);
		contentPane.add(lblNewLabel);
		
		hostName = new JLabel("hostName");
		hostName.setForeground(Color.BLUE);
		hostName.setBounds(88, 24, 54, 15);
		contentPane.add(hostName);
		
		JLabel lblNewLabel_1 = new JLabel("Enter new Traveller details Traveller name");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(152, 24, 302, 15);
		contentPane.add(lblNewLabel_1);
		
		travellerNameText = new JTextField();
		travellerNameText.setBounds(456, 24, 66, 21);
		contentPane.add(travellerNameText);
		travellerNameText.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Passport Number");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(532, 27, 111, 15);
		contentPane.add(lblNewLabel_2);
		
		passportNumberText = new JTextField();
		passportNumberText.setBounds(649, 24, 66, 21);
		contentPane.add(passportNumberText);
		passportNumberText.setColumns(10);
		
		JLabel lblNationality = new JLabel("Nationality");
		lblNationality.setFont(new Font("宋体", Font.PLAIN, 13));
		lblNationality.setBounds(725, 27, 91, 15);
		contentPane.add(lblNationality);
		
		nationalityText = new JTextField();
		nationalityText.setColumns(10);
		nationalityText.setBounds(809, 24, 66, 21);
		contentPane.add(nationalityText);
		
		JLabel lblNewLabel_3 = new JLabel("select traveller type");
		lblNewLabel_3.setBounds(21, 63, 148, 15);
		contentPane.add(lblNewLabel_3);
		
		rdbtnStudent = new JRadioButton("Student");
		rdbtnStudent.setBounds(175, 59, 75, 23);
		contentPane.add(rdbtnStudent);
		
		rdbtnCorporateExecutive = new JRadioButton("Corporate Executive");
		rdbtnCorporateExecutive.setBounds(258, 59, 148, 23);
		contentPane.add(rdbtnCorporateExecutive);
		
		rdbtnSportingPerson = new JRadioButton("Sporting Person");
		rdbtnSportingPerson.setBounds(411, 59, 122, 23);
		contentPane.add(rdbtnSportingPerson);
		

		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnStudent);
		buttonGroup.add(rdbtnCorporateExecutive);
		buttonGroup.add(rdbtnSportingPerson);
		
		addBtn = new JButton("Add Traveller");
		
		addBtn.setBounds(530, 59, 111, 23);
		contentPane.add(addBtn);
		
		JButton showAllBtn = new JButton("Show all Travellers");
		showAllBtn.setBounds(651, 59, 155, 23);
		contentPane.add(showAllBtn);
		
		travellersBtn = new JButton("Travellers");
		travellersBtn.setBounds(816, 59, 111, 23);
		contentPane.add(travellersBtn);
		
		JButton closeBtn = new JButton("Close");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		closeBtn.setBounds(935, 59, 111, 23);
		contentPane.add(closeBtn);
		
		reportBtn = new JButton("Get Report");
		reportBtn.setBounds(1056, 59, 111, 23);
		contentPane.add(reportBtn);
		
		travellers = new JTextArea();
		travellers.setBounds(197, 149, 577, 231);
		contentPane.add(travellers);
		
		lblBirth = new JLabel("Birth");
		lblBirth.setFont(new Font("宋体", Font.PLAIN, 13));
		lblBirth.setBounds(879, 27, 54, 15);
		contentPane.add(lblBirth);
		
		bitrhText = new JTextField();
		bitrhText.setColumns(10);
		bitrhText.setBounds(920, 24, 66, 21);
		contentPane.add(bitrhText);
		
		JLabel lblContactnum = new JLabel("ContactNum");
		lblContactnum.setFont(new Font("宋体", Font.PLAIN, 13));
		lblContactnum.setBounds(993, 27, 83, 15);
		contentPane.add(lblContactnum);
		
		contactText = new JTextField();
		contactText.setColumns(10);
		contactText.setBounds(1065, 24, 66, 21);
		contentPane.add(contactText);
		
		JLabel lblAddress = new JLabel("address");
		lblAddress.setFont(new Font("宋体", Font.PLAIN, 13));
		lblAddress.setBounds(1136, 27, 66, 15);
		contentPane.add(lblAddress);
		
		addressText = new JTextField();
		addressText.setColumns(10);
		addressText.setBounds(1185, 24, 66, 21);
		contentPane.add(addressText);
	}
	
	public static void startUI(Event event){
		DetailGUI frame = new DetailGUI();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//set title
		frame.setTitle("Event Management System : "+event.getName());
		
		//set Event Host
		frame.hostName.setText(event.getEventHostName());
		
		
		
		//set travellers
		ArrayList<Traveller> travellerList = event.getTourGroup().getAllTravellers();
		for(int i = 0; i < travellerList.size(); i++){
			frame.travellers.append(travellerList.get(i).getName());
			frame.travellers.append("\n");
		}
		
		//set add action
		frame.addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//get selected radioBtn
				String travellerTypeText= "";  
				Enumeration<AbstractButton> radioBtns=frame.buttonGroup.getElements();  
				while (radioBtns.hasMoreElements()) {  
				    AbstractButton btn = radioBtns.nextElement();  
				    if(btn.isSelected()){  
				    	travellerTypeText = btn.getText();  
				        break;  
				    }  
				}  
				String travellerType = null;
				if("Student".equals(travellerTypeText)){
					travellerType = "Student";
					StudentGUI.startUI(frame,event);
				}
				if("Corporate Executive".equals(travellerTypeText)){
					travellerType = "BusinessExec";
					BusinessExecGUI.startUI(frame, event);
				}
				if("Sporting Person".equals(travellerTypeText)){
					travellerType = "SportPerson";
					SportPersonGUI.startUI(frame, event);
				}
	
			}
		});
		
		//set travellers action
		frame.travellersBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TravellersGUI.startUI(event);
			}
		});
		
		//set report action
		frame.reportBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GUIManage("open", event);
			}
		});
		
		frame.setVisible(true);
	}
	
	public void addTravellers(DetailGUI frame , Event event , Map map) throws ParseException{
		String travellerName = frame.travellerNameText.getText().trim();
		String birth = frame.bitrhText.getText().trim();
		String passportNumber = frame.passportNumberText.getText().trim();
		String nationality = frame.nationalityText.getText().trim();
		String address = frame.addressText.getText().trim();
		String contactNum = frame.contactText.getText().trim();
		
		Traveller traveller = null;
		String type = (String) map.get("type");
		
		if ("Student".equals(type)){
			String insurer = (String) map.get("insurer");
			int insuranceNO = (int) map.get("insuranceNO");
			traveller = new Student(travellerName, birth, passportNumber, nationality, address , contactNum , insurer, insuranceNO);
		}
		if ("BusinessExec".equals(type)){
			String abnNumber = (String) map.get("abnNumber");
			int companyPaying = (int) map.get("companyPaying");
			String companyCreditCard = (String) map.get("companyCreditCard");
			traveller = new BusinessExec(travellerName, birth, passportNumber, nationality, address , contactNum , abnNumber, companyPaying , companyCreditCard);
		}
		if ("SportPerson".equals(type)){
			String clubInsurer = (String) map.get("clubInsurer");
			int insuranceNum = (int) map.get("insuranceNum");
			String sport = (String) map.get("sport");
			traveller = new SportPerson(travellerName, birth, passportNumber, nationality, address, contactNum, clubInsurer, insuranceNum, sport);
		}
		
		event.addTraveller(traveller);
		DriverClass.addTraveller(event);
		frame.travellers.append(travellerName+"\n");
	}
}
