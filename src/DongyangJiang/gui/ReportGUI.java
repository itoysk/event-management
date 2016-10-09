package DongyangJiang.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import DongyangJiang.event.Event;
import DongyangJiang.traveller.Traveller;

import javax.swing.JLabel;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JTextArea;
import java.awt.FlowLayout;

public class ReportGUI extends JFrame {

	private JPanel contentPane;
	private JLabel typeNameLabel;
	private JLabel eventNameLabel;
	private JLabel hostLabel;
	private JLabel departureDateLabel;
	private JLabel arrivalDateLabel;
	private JLabel destinationLabel;
	private JLabel clientLabel;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTextArea textArea;
	private JTextArea descriptionArea;
	private JTextArea travellersArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportGUI frame = new ReportGUI();
					frame.descriptionArea.append("testText\n");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReportGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Type Name");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblNewLabel.setBounds(187, 41, 86, 21);
		contentPane.add(lblNewLabel);
		
		typeNameLabel = new JLabel("Type Name");
		typeNameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		typeNameLabel.setBounds(352, 41, 163, 21);
		contentPane.add(typeNameLabel);
		
		JLabel lblEventName = new JLabel("Event Name");
		lblEventName.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblEventName.setBounds(187, 72, 86, 21);
		contentPane.add(lblEventName);
		
		eventNameLabel = new JLabel("Type Name");
		eventNameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		eventNameLabel.setBounds(352, 72, 224, 21);
		contentPane.add(eventNameLabel);
		
		JLabel lblHost = new JLabel("Host");
		lblHost.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblHost.setBounds(187, 103, 86, 21);
		contentPane.add(lblHost);
		
		hostLabel = new JLabel("Type Name");
		hostLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		hostLabel.setBounds(352, 106, 163, 21);
		contentPane.add(hostLabel);
		
		JLabel lblDeparturedate = new JLabel("DepartureDate");
		lblDeparturedate.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblDeparturedate.setBounds(187, 136, 112, 21);
		contentPane.add(lblDeparturedate);
		
		departureDateLabel = new JLabel("Type Name");
		departureDateLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		departureDateLabel.setBounds(352, 136, 163, 21);
		contentPane.add(departureDateLabel);
		
		JLabel lblArrivaldate = new JLabel("ArrivalDate");
		lblArrivaldate.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblArrivaldate.setBounds(187, 167, 112, 21);
		contentPane.add(lblArrivaldate);
		
		arrivalDateLabel = new JLabel("Type Name");
		arrivalDateLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		arrivalDateLabel.setBounds(352, 167, 185, 21);
		contentPane.add(arrivalDateLabel);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblDestination.setBounds(187, 201, 112, 21);
		contentPane.add(lblDestination);
		
		destinationLabel = new JLabel("Type Name");
		destinationLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		destinationLabel.setBounds(352, 201, 202, 21);
		contentPane.add(destinationLabel);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblDescription.setBounds(187, 236, 112, 21);
		contentPane.add(lblDescription);
		
		JLabel lblClient = new JLabel("Client");
		lblClient.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblClient.setBounds(187, 304, 112, 21);
		contentPane.add(lblClient);
		
		clientLabel = new JLabel("Type Name");
		clientLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		clientLabel.setBounds(352, 304, 224, 21);
		contentPane.add(clientLabel);
		
		JLabel lblTravellers = new JLabel("Travellers");
		lblTravellers.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblTravellers.setBounds(187, 339, 112, 21);
		contentPane.add(lblTravellers);
		
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(352, 232, 226, 61);
		contentPane.add(scrollPane_1);
		
		descriptionArea = new JTextArea();
		descriptionArea.setLineWrap(true);
		descriptionArea.setEditable(false);
		scrollPane_1.setViewportView(descriptionArea);
		
		travellersArea = new JTextArea();
		travellersArea.setLineWrap(true);
		travellersArea.setEditable(false);
		travellersArea.setBounds(352, 338, 224, 115);
		contentPane.add(travellersArea);
		
		
	}

	public static void startUI(Event event){
		ReportGUI frame = new ReportGUI();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle(event.getName()+" report");
		
		//set typeName
		frame.typeNameLabel.setText(event.getType());
		
		//set eventName
		frame.eventNameLabel.setText(event.getName());
		
		//set hostName
		frame.hostLabel.setText(event.getEventHostName());
		
		//set departureDate
		frame.departureDateLabel.setText(new SimpleDateFormat("yyyy-MM-dd").format(event.getDepartureDate()));
		
		//set arrivalDate
		frame.arrivalDateLabel.setText(new SimpleDateFormat("yyyy-MM-dd").format(event.getArrivaleDate()));
		
		//set destination
		frame.destinationLabel.setText(event.getDestination());
		
		//set description
		frame.descriptionArea.append(event.getDescription()+"\n");
		
		//set client
		frame.clientLabel.setText(event.getBookingClient().getName());
		
		//set travellers
		List<Traveller> travellers = event.getTourGroup().getAllTravellers();
		for(int i = 0; i < travellers.size(); i++){
			frame.travellersArea.append(travellers.toString()+"\n");
		}
	
		frame.setVisible(true);
	}
}
