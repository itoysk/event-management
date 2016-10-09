package kevin.gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kevin.event.Event;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	private JPanel eventPane;
	private JPanel btnPane;
	private JButton loadBtn;
	private JButton openBtn;
	

	
	/**
	 * Create the frame.
	 */
	public MainGUI() {
		setTitle("event Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Load or Select events to inspect :");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel.setBounds(105, 39, 259, 31);
		contentPane.add(lblNewLabel);
		
		eventPane = new JPanel();
		eventPane.setBounds(369, 10, 480, 67);
			
		contentPane.add(eventPane);
		eventPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		btnPane = new JPanel();
		btnPane.setBounds(168, 206, 634, 75);
		contentPane.add(btnPane);
		btnPane.setLayout(null);
		
		openBtn = new JButton("Open selected events");
		openBtn.setBounds(28, 25, 186, 23);
		btnPane.add(openBtn);
		
		JButton quitBtn = new JButton("Quit");
		quitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		quitBtn.setBounds(278, 25, 93, 23);
		btnPane.add(quitBtn);
		
		loadBtn = new JButton("Load event data");
		loadBtn.setBounds(424, 25, 150, 23);
		btnPane.add(loadBtn);
		
	}
	
	
	

	
	public static void startUI(List<Event> list){
		MainGUI frame = new MainGUI();  
		
		//add eventType
		frame.eventPane.setLayout(new GridLayout(0, 1, 0, 0));
		Map selectedMap = new HashMap<String,Boolean>();
		
		for(int i = 0; i<list.size(); i++){
			//String type = list.get(i).getType();
			String name = list.get(i).getName();
			JCheckBox jCheckBox = new JCheckBox(name);
			jCheckBox.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(jCheckBox.isSelected()){
						selectedMap.put(name,true);
					}
					else{
						selectedMap.remove(name);
					}
					
				}
			});
			frame.eventPane.add(jCheckBox);
		}
		
		//openBton actionListener
		frame.openBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//get Selected
				Iterator it=selectedMap.keySet().iterator();
				while(it.hasNext()){    
				    String name = it.next().toString(); 
				    Event event = null;
				    for(int i = 0; i < list.size(); i++){
				    	if(name.equals(list.get(i).getName())){
				    		event = list.get(i);
				    	}
				    }
				    
				   
					new GUIManage("open",event);
		
				}   
			}
		});
		
		//loadBtn actionListener
		frame.loadBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//get Selected
				Iterator it=selectedMap.keySet().iterator();
				while(it.hasNext()){    
				    String name = it.next().toString(); 
				    Event event = null;
				    for(int i = 0; i < list.size(); i++){
				    	if(name.equals(list.get(i).getName())){
				    		event = list.get(i);
				    	}
				    }
				    
				   
					new GUIManage(event);
		
				}   
				
				
			}
		});
		
		frame.setVisible(true);
	}
}
