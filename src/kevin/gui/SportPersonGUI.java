package kevin.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kevin.event.Event;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class SportPersonGUI extends JFrame {

	private JPanel contentPane;
	private JTextField clubInsurerText;
	private JTextField insuranceNumText;
	private JButton okBtn;
	private JLabel lblCompanycreditcard;
	private JTextField sportText;



	/**
	 * Create the frame.
	 */
	public SportPersonGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsurer = new JLabel("clubInsurer");
		lblInsurer.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblInsurer.setBounds(90, 57, 95, 15);
		contentPane.add(lblInsurer);
		
		JLabel lblInsurerno = new JLabel("insuranceNum");
		lblInsurerno.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblInsurerno.setBounds(90, 106, 120, 15);
		contentPane.add(lblInsurerno);
		
		okBtn = new JButton("Ok");
		okBtn.setBounds(92, 209, 93, 23);
		contentPane.add(okBtn);
		
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelBtn.setBounds(251, 209, 93, 23);
		contentPane.add(cancelBtn);
		
		clubInsurerText = new JTextField();
		clubInsurerText.setBounds(252, 57, 124, 21);
		contentPane.add(clubInsurerText);
		clubInsurerText.setColumns(10);
		
		insuranceNumText = new JTextField();
		insuranceNumText.setColumns(10);
		insuranceNumText.setBounds(252, 106, 124, 21);
		contentPane.add(insuranceNumText);
		
		lblCompanycreditcard = new JLabel("sport");
		lblCompanycreditcard.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblCompanycreditcard.setBounds(90, 144, 138, 15);
		contentPane.add(lblCompanycreditcard);
		
		sportText = new JTextField();
		sportText.setColumns(10);
		sportText.setBounds(252, 144, 124, 21);
		contentPane.add(sportText);
	}
	
	public static void startUI(DetailGUI firstFrame,Event event){
		System.out.println("进来了");
		SportPersonGUI frame = new SportPersonGUI();
		frame.okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String, Object> map = new HashMap<>();
				map.put("type", "SportPerson");
				map.put("clubInsurer", frame.clubInsurerText.getText());
				map.put("insuranceNum", Integer.valueOf(frame.insuranceNumText.getText()));
				map.put("sport", frame.sportText.getText());
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
