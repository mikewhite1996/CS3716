//BLOCK DATA IN TIME SLOT USE BLOCKREQUEST (IT HOLDS THE HOUR BLOCKS) MAKE A NEW TS CLASS TO HANDLE FULL HOURS

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Priority1Request {
	static String p1name;
	static String p1semester;
	static String p1room;
	public Priority1Request() {}
		public static void main(String[] args){
		JFrame p1Frame = new JFrame();
		GridLayout p1g = new GridLayout(6, 1);
		p1Frame.setLayout(p1g);
		final int FRAME_WIDTH = 300;
		final int FRAME_HEIGHT = 600;
		p1Frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		p1Frame.setTitle("Submit A Priority 1 Request");
		
		JPanel p1Panel1 = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel pLabel = new JLabel("Priority: 1");
		pLabel.setForeground(Color.RED);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		
		p1Panel1.add(pLabel, c);
		
		JLabel p1NameLabel = new JLabel("Name:");
		JTextField p1NameField = new JTextField(15);
		c.gridy = 1;
		p1Panel1.add(p1NameLabel, c);
		c.gridy = 2;
		p1Panel1.add(p1NameField, c);
		p1Frame.add(p1Panel1);
		
		JPanel p1Panel2 = new JPanel(new GridBagLayout());
		JLabel p1SLabel = new JLabel("Semester:");
		ButtonGroup p1SGroup = new ButtonGroup();
		JRadioButton p1Fall = new JRadioButton("Fall");
		JRadioButton p1Winter = new JRadioButton("Winter");
		JRadioButton p1Summer = new JRadioButton("Summer");
		p1SGroup.add(p1Fall);
		p1SGroup.add(p1Winter);
		p1SGroup.add(p1Summer);
		
		c.gridy = 0;
		p1Panel2.add(p1SLabel, c);
		c.gridy = 1;
		p1Panel2.add(p1Fall, c);
		c.gridx = 1;
		p1Panel2.add(p1Winter, c);
		c.gridx = 2;
		p1Panel2.add(p1Summer, c);
		p1Frame.add(p1Panel2);
		
		JPanel p1Panel3 = new JPanel(new GridBagLayout());
		JLabel p1RoomLabel = new JLabel("Room:");
		JComboBox p1RoomBox = new JComboBox();
		p1RoomBox.addItem("Gym");
		p1RoomBox.addItem("Music");
		p1RoomBox.addItem("Auditorium");
		p1RoomBox.addItem("Lecture Hall");
		p1RoomBox.addItem("Computer Lab");
		c.gridy = 0;
		p1Panel3.add(p1RoomLabel, c);
		c.gridy = 1;
		p1Panel3.add(p1RoomBox, c);
		p1Frame.add(p1Panel3);
		
		JPanel p1Panel4 = new JPanel(new GridBagLayout());
		JLabel p1DayLabel = new JLabel("Day:");
		JComboBox<String> p1DayBox = new JComboBox();
		//p1DayBox.setEnabled(false);
		p1DayBox.addItem("Monday");
		p1DayBox.addItem("Tuesday");
		p1DayBox.addItem("Wednesday");
		p1DayBox.addItem("Thursday");
		p1DayBox.addItem("Friday");
		p1DayBox.addItem("Saturday");
		p1DayBox.addItem("Sunday");
		
		c.gridy = 0;
		p1Panel4.add(p1DayLabel, c);
		c.gridy = 1;
		p1Panel4.add(p1DayBox, c);
		p1Frame.add(p1Panel4);
		
		JPanel p1Panel5 = new JPanel(new GridBagLayout());
		p1Panel5.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
		JLabel p1TimeLabel = new JLabel("Time:");
		JComboBox p1TimeBox = new JComboBox();
		p1TimeBox.setEnabled(false);
	    p1TimeBox.addItem("9am - 10am");
		p1TimeBox.addItem("10am - 11am");
		p1TimeBox.addItem("11am - 12pm");
		p1TimeBox.addItem("12pm - 1pm");
		p1TimeBox.addItem("1pm - 2pm");
		p1TimeBox.addItem("2pm - 3pm");
		p1TimeBox.addItem("3pm - 4pm");
		p1TimeBox.addItem("4pm - 5pm");
		p1TimeBox.addItem("5pm - 6pm");
		p1TimeBox.addItem("6pm - 7pm");
		p1TimeBox.addItem("7pm - 8pm");
		p1TimeBox.addItem("8pm - 9pm");
		p1TimeBox.addItem("9pm - 10pm");
		
		c.gridy = 0;
		c.gridx = 0;
		p1Panel5.add(p1TimeLabel, c);
		
		c.gridy = 1;
		c.gridx = 0;
		p1Panel5.add(p1TimeBox, c);
		p1Frame.add(p1Panel5);
		
		JPanel p1Sub = new JPanel(new GridBagLayout());
		JButton p1getTime = new JButton("Get Times");
		c.gridy = 0;
		p1Sub.add(p1getTime, c);
		JButton p1Submit = new JButton("Submit");
		c.gridy = 1;
		p1Sub.add(p1Submit, c);
	    JButton p1p2 = new JButton("Make Another Request (Priority 2)");
	    c.gridy = 2;
	    p1Sub.add(p1p2, c);
	    p1Frame.add(p1Sub);
	    
	    ActionListener actionListener = new ActionListener(){

		public void actionPerformed(ActionEvent e) {
				if(e.getSource() instanceof JRadioButton){
					JButton Button = (JButton) (e.getSource());
					if(Button.isSelected()){
						String choice = Button.getText();
						proceed(choice);
					}
				}
				
			}
			
		};
		
		
		p1getTime.addActionListener(actionListener);
		p1Submit.addActionListener(actionListener);
		p1p2.addActionListener(actionListener);
		
		p1Frame.setVisible(true);
		p1Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p1name = p1NameField.getText();
		if (p1Fall.isSelected()) {
			p1semester = "fall";
		}
		else if (p1Winter.isSelected()){
			p1semester = "winter";
		}
		else if (p1Summer.isSelected()){
			p1semester = "summer";
		}
		
		p1room = (String) p1RoomBox.getSelectedItem();
		
		
	}
		
		public static String getName() {
			return p1name;
		}
		
		public static String getSemester() {
			return p1semester;
		}
		
		public static String getRoom() {
			return p1room;
		}
}


