import javax.swing.*;
import java.awt.*;
public class Priority4Request {
	static JTextField pField;
	public Priority4Request() {}
		public static void main(String[] args){
		JFrame p4Frame = new JFrame();
		GridLayout p4g = new GridLayout(6, 1);
		p4Frame.setLayout(p4g);
		final int FRAME_WIDTH = 300;
		final int FRAME_HEIGHT = 450;
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
	    /*p4TimeBox.addItem("9am - 10am");
		/*p4TimeBox.addItem("10am - 11am");
		p4TimeBox.addItem("11am - 12pm");
		p4TimeBox.addItem("12pm - 1pm");
		p4TimeBox.addItem("1pm - 2pm");
		p4TimeBox.addItem("2pm - 3pm");
		p4TimeBox.addItem("3pm - 4pm");
		p4TimeBox.addItem("4pm - 5pm");
		p4TimeBox.addItem("5pm - 6pm");
		p4TimeBox.addItem("6pm - 7pm");
		p4TimeBox.addItem("7pm - 8pm");
		p4TimeBox.addItem("8pm - 9pm");
		p4TimeBox.addItem("9pm - 10pm");
		*/
		c.gridy = 0;
		c.gridx = 0;
		p4Panel5.add(p4TimeLabel, c);
		
		c.gridy = 1;
		c.gridx = 0;
		p4Panel5.add(p4TimeBox, c);
		p4Frame.add(p4Panel5);
		
		JPanel p4Sub = new JPanel(new GridBagLayout());
		JButton p4Submit = new JButton("Submit");
		c.gridy = 0;
		p4Sub.add(p4Submit, c);
	    JButton p4p2 = new JButton("Make Another Request (Priority 5)");
	    c.gridy = 1;
	    p4Sub.add(p4p2, c);
	    p4Frame.add(p4Sub);
		
		
		
		p4Frame.setVisible(true);
		p4Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}


