package DongyangJiang.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DongyangJiang.event.Event;
import DongyangJiang.traveller.Traveller;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.CardLayout;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ScrollPaneConstants;

public class TravellersGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;


	/**
	 * Create the frame.
	 */
	public TravellersGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(214, 55, 424, 387);
		contentPane.add(scrollPane);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		 
	}
	
	public static void startUI(Event event){
		TravellersGUI frame = new TravellersGUI();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle(event.getName()+" Travellers");
		
		List<Traveller> list = event.getTourGroup().getAllTravellers();
		for(int i = 0; i < list.size(); i++){
			Traveller traveller = list.get(i);
			
			//name
			JPanel namePanel = new JPanel();
			JLabel labelName = new JLabel("name:");
			JLabel name = new JLabel(traveller.getName());
			namePanel.add(labelName);
			namePanel.add(name);
			
			//birth
			JPanel birthPanel = new JPanel();
			JLabel labelBirth = new JLabel("birth:");
			JLabel birth = new JLabel(traveller.getDateOfBirth().toString());
			birthPanel.add(labelBirth);
			birthPanel.add(birth);
			
			//passport
			JPanel passportPanel = new JPanel();
			JLabel labelPassport = new JLabel("PassportNum:");
			JLabel passport = new JLabel(traveller.getPassportNumber());
			passportPanel.add(labelPassport);
			passportPanel.add(passport);
			
			//nationality
			JPanel nationalityPanel = new JPanel();
			JLabel labelNationality = new JLabel("Nationality:");
			JLabel nationality = new JLabel(traveller.getNationality());
			nationalityPanel.add(labelNationality);
			nationalityPanel.add(nationality);
			
			
			frame.panel.add(namePanel);
			frame.panel.add(birthPanel);
			frame.panel.add(passportPanel);
			frame.panel.add(nationalityPanel);
		}
		
		frame.setVisible(true);
	}
	
	
}
