package DongyangJiang.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DongyangJiang.event.Event;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class StudentGUI extends JFrame {

	private JPanel contentPane;
	private JTextField insurerText;
	private JTextField insurerNOText;
	private JButton okBtn;



	/**
	 * Create the frame.
	 */
	public StudentGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsurer = new JLabel("Insurer");
		lblInsurer.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblInsurer.setBounds(90, 57, 95, 15);
		contentPane.add(lblInsurer);
		
		JLabel lblInsurerno = new JLabel("InsurerNO");
		lblInsurerno.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblInsurerno.setBounds(90, 106, 82, 15);
		contentPane.add(lblInsurerno);
		
		okBtn = new JButton("Ok");
		okBtn.setBounds(92, 168, 93, 23);
		contentPane.add(okBtn);
		
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelBtn.setBounds(251, 168, 93, 23);
		contentPane.add(cancelBtn);
		
		insurerText = new JTextField();
		insurerText.setBounds(220, 54, 124, 21);
		contentPane.add(insurerText);
		insurerText.setColumns(10);
		
		insurerNOText = new JTextField();
		insurerNOText.setColumns(10);
		insurerNOText.setBounds(220, 103, 124, 21);
		contentPane.add(insurerNOText);
	}
	
	public static void startUI(DetailGUI firstFrame,Event event){
		StudentGUI frame = new StudentGUI();
		frame.okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String, Object> map = new HashMap<>();
				map.put("type", "Student");
				map.put("insurer", frame.insurerText.getText());
				map.put("insuranceNO", Integer.valueOf(frame.insurerNOText.getText()));
				try {
					firstFrame.addTravellers(firstFrame,event,map);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		frame.setVisible(true);
	}
}
