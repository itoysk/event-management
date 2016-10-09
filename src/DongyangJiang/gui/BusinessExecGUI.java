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

public class BusinessExecGUI extends JFrame {

	private JPanel contentPane;
	private JTextField abnNumberText;
	private JTextField companyPayingText;
	private JButton okBtn;
	private JLabel lblCompanycreditcard;
	private JTextField companyCreditCardText;



	/**
	 * Create the frame.
	 */
	public BusinessExecGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsurer = new JLabel("AbnNumber");
		lblInsurer.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblInsurer.setBounds(90, 57, 95, 15);
		contentPane.add(lblInsurer);
		
		JLabel lblInsurerno = new JLabel("companyPaying");
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
		
		abnNumberText = new JTextField();
		abnNumberText.setBounds(252, 57, 124, 21);
		contentPane.add(abnNumberText);
		abnNumberText.setColumns(10);
		
		companyPayingText = new JTextField();
		companyPayingText.setColumns(10);
		companyPayingText.setBounds(252, 106, 124, 21);
		contentPane.add(companyPayingText);
		
		lblCompanycreditcard = new JLabel("companyCreditCard");
		lblCompanycreditcard.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		lblCompanycreditcard.setBounds(90, 144, 138, 15);
		contentPane.add(lblCompanycreditcard);
		
		companyCreditCardText = new JTextField();
		companyCreditCardText.setColumns(10);
		companyCreditCardText.setBounds(252, 144, 124, 21);
		contentPane.add(companyCreditCardText);
	}
	
	public static void startUI(DetailGUI firstFrame,Event event){
		BusinessExecGUI frame = new BusinessExecGUI();
		frame.okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String, Object> map = new HashMap<>();
				map.put("type", "BusinessExec");
				map.put("abnNumber", frame.abnNumberText.getText());
				map.put("companyPaying", Integer.valueOf(frame.companyPayingText.getText()));
				map.put("companyCreditCard", frame.companyCreditCardText.getText());
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
