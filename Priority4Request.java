import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Priority4Request {
	static String p4name;
	static String p4semester;
	static String p4room;
	public Priority4Request() {}
		public static void main(String[] args){
		JFrame p4Frame = new JFrame();
		GridLayout p4g = new GridLayout(6, 1);
		p4Frame.setLayout(p4g);
		final int FRAME_WIDTH = 300;
		final int FRAME_HEIGHT = 600;
		p4Frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		p4Frame.setTitle("Submit A Priority 4 Request");
		
		JPanel p4Panel1 = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel pLabel = new JLabel("Priority: 4");
		pLabel.setForeground(Color.RED);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		
		p4Panel1.add(pLabel, c);
		
		JLabel p4NameLabel = new JLabel("Name:");
		JTextField p4NameField = new JTextField(15);
		c.gridy = 1;
		p4Panel1.add(p4NameLabel, c);
		c.gridy = 2;
		p4Panel1.add(p4NameField, c);
		p4Frame.add(p4Panel1);
		
		JPanel p4Panel2 = new JPanel(new GridBagLayout());
		JLabel p4SLabel = new JLabel("Semester:");
		ButtonGroup p4SGroup = new ButtonGroup();
		JRadioButton p4Fall = new JRadioButton("Fall");
		JRadioButton p4Winter = new JRadioButton("Winter");
		JRadioButton p4Summer = new JRadioButton("Summer");
		p4SGroup.add(p4Fall);
		p4SGroup.add(p4Winter);
		p4SGroup.add(p4Summer);
		
		c.gridy = 0;
		p4Panel2.add(p4SLabel, c);
		c.gridy = 1;
		p4Panel2.add(p4Fall, c);
		c.gridx = 1;
		p4Panel2.add(p4Winter, c);
		c.gridx = 2;
		p4Panel2.add(p4Summer, c);
		p4Frame.add(p4Panel2);
		
		JPanel p4Panel3 = new JPanel(new GridBagLayout());
		JLabel p4RoomLabel = new JLabel("Room:");
		JComboBox p4RoomBox = new JComboBox();
		p4RoomBox.addItem("Gym");
		p4RoomBox.addItem("Music");
		p4RoomBox.addItem("Auditorium");
		p4RoomBox.addItem("Lecture Hall");
		p4RoomBox.addItem("Computer Lab");
		c.gridy = 0;
		p4Panel3.add(p4RoomLabel, c);
		c.gridy = 1;
		p4Panel3.add(p4RoomBox, c);
		p4Frame.add(p4Panel3);
		
		JPanel p4Panel4 = new JPanel(new GridBagLayout());
		JLabel p4DayLabel = new JLabel("Day:");
		JComboBox p4DayBox = new JComboBox();
		p4DayBox.setEnabled(false);
		p4DayBox.addItem("Monday");
		p4DayBox.addItem("Tuesday");
		p4DayBox.addItem("Wednesday");
		p4DayBox.addItem("Thursday");
		p4DayBox.addItem("Friday");
		p4DayBox.addItem("Saturday");
		p4DayBox.addItem("Sunday");
		
		c.gridy = 0;
		p4Panel4.add(p4DayLabel, c);
		c.gridy = 1;
		p4Panel4.add(p4DayBox, c);
		p4Frame.add(p4Panel4);
		
		JPanel p4Panel5 = new JPanel(new GridBagLayout());
		p4Panel5.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
		JLabel p4TimeLabel = new JLabel("Time:");
		JComboBox p4TimeBox = new JComboBox();
		p4TimeBox.setEnabled(false);
		c.gridy = 0;
		c.gridx = 0;
		p4Panel5.add(p4TimeLabel, c);
		
		c.gridy = 1;
		c.gridx = 0;
		p4Panel5.add(p4TimeBox, c);
		p4Frame.add(p4Panel5);
		
		JPanel p4Sub = new JPanel(new GridBagLayout());
		JButton p4getTime = new JButton("Get Times");
		c.gridy = 0;
		p4Sub.add(p4getTime, c);
		JButton p4Submit = new JButton("Submit");
		c.gridy = 1;
		p4Sub.add(p4Submit, c);
	    JButton p4p2 = new JButton("Make Another Request (Priority 4)");
	    c.gridy = 2;
	    p4Sub.add(p4p2, c);
	    p4Frame.add(p4Sub);
		

	    ActionListener actionListener = new ActionListener(){

		public void actionPerformed(ActionEvent e) {
				if(e.getSource() instanceof JRadioButton){
					JButton Button = (JButton) (e.getSource());
					if(Button.isSelected()){
						String choice = Button.getText();
						
					}
				}
				
			}
			
		};
		
		p4getTime.addActionListener(actionListener);
		p4Submit.addActionListener(actionListener);
		p4p2.addActionListener(actionListener);
		
		
		
		p4Frame.setVisible(true);
		p4Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p4name = p4NameField.getText();
		
		if (p4Fall.isSelected()) {
			p4semester = "fall";
		}
		else if (p4Winter.isSelected()){
			p4semester = "winter";
		}
		else if (p4Summer.isSelected()){
			p4semester = "summer";
		}
		
		p4room = (String) p4RoomBox.getSelectedItem();
		
		
	}
		
		public static String getName() {
			return p4name;
		}
		
		public static String getSemester() {
			return p4semester;
		}
		
		public static String getRoom() {
			return p4room;
		}
		
}
