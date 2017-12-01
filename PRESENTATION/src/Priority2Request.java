import javax.swing.*;
import java.awt.*;
public class Priority2Request {
	static JTextField pField;
	public Priority2Request() {}
		public static void main(String[] args){
		JFrame p2Frame = new JFrame();
		GridLayout p2g = new GridLayout(6, 1);
		p2Frame.setLayout(p2g);
		final int FRAME_WIDTH = 300;
		final int FRAME_HEIGHT = 450;
		p2Frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		p2Frame.setTitle("Submit A Priority 2 Request");
		
		JPanel p2Panel1 = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel pLabel = new JLabel("Priority: 2");
		pLabel.setForeground(Color.RED);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		
		p2Panel1.add(pLabel, c);
		
		JLabel p2NameLabel = new JLabel("Name:");
		JTextField p2NameField = new JTextField(15);
		c.gridy = 1;
		p2Panel1.add(p2NameLabel, c);
		c.gridy = 2;
		p2Panel1.add(p2NameField, c);
		p2Frame.add(p2Panel1);
		
		JPanel p2Panel2 = new JPanel(new GridBagLayout());
		JLabel p2SLabel = new JLabel("Semester:");
		ButtonGroup p2SGroup = new ButtonGroup();
		JRadioButton p2Fall = new JRadioButton("Fall");
		JRadioButton p2Winter = new JRadioButton("Winter");
		JRadioButton p2Summer = new JRadioButton("Summer");
		p2SGroup.add(p2Fall);
		p2SGroup.add(p2Winter);
		p2SGroup.add(p2Summer);
		
		c.gridy = 0;
		p2Panel2.add(p2SLabel, c);
		c.gridy = 1;
		p2Panel2.add(p2Fall, c);
		c.gridx = 1;
		p2Panel2.add(p2Winter, c);
		c.gridx = 2;
		p2Panel2.add(p2Summer, c);
		p2Frame.add(p2Panel2);
		
		JPanel p2Panel3 = new JPanel(new GridBagLayout());
		JLabel p2RoomLabel = new JLabel("Room:");
		JComboBox p2RoomBox = new JComboBox();
		p2RoomBox.addItem("Gym");
		p2RoomBox.addItem("Music");
		p2RoomBox.addItem("Auditorium");
		p2RoomBox.addItem("Lecture Hall");
		p2RoomBox.addItem("Computer Lab");
		c.gridy = 0;
		p2Panel3.add(p2RoomLabel, c);
		c.gridy = 1;
		p2Panel3.add(p2RoomBox, c);
		p2Frame.add(p2Panel3);
		
		JPanel p2Panel4 = new JPanel(new GridBagLayout());
		JLabel p2DayLabel = new JLabel("Day:");
		JComboBox p2DayBox = new JComboBox();
		p2DayBox.setEnabled(false);
		p2DayBox.addItem("Monday");
		p2DayBox.addItem("Tuesday");
		p2DayBox.addItem("Wednesday");
		p2DayBox.addItem("Thursday");
		p2DayBox.addItem("Friday");
		p2DayBox.addItem("Saturday");
		p2DayBox.addItem("Sunday");
		
		c.gridy = 0;
		p2Panel4.add(p2DayLabel, c);
		c.gridy = 1;
		p2Panel4.add(p2DayBox, c);
		p2Frame.add(p2Panel4);
		
		JPanel p2Panel5 = new JPanel(new GridBagLayout());
		p2Panel5.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
		JLabel p2TimeLabel = new JLabel("Time:");
		JComboBox p2TimeBox = new JComboBox();
		p2TimeBox.setEnabled(false);
	    /*p2TimeBox.addItem("9am - 10am");
		/*p2TimeBox.addItem("10am - 11am");
		p2TimeBox.addItem("11am - 12pm");
		p2TimeBox.addItem("12pm - 1pm");
		p2TimeBox.addItem("1pm - 2pm");
		p2TimeBox.addItem("2pm - 3pm");
		p2TimeBox.addItem("3pm - 4pm");
		p2TimeBox.addItem("4pm - 5pm");
		p2TimeBox.addItem("5pm - 6pm");
		p2TimeBox.addItem("6pm - 7pm");
		p2TimeBox.addItem("7pm - 8pm");
		p2TimeBox.addItem("8pm - 9pm");
		p2TimeBox.addItem("9pm - 10pm");
		*/
		c.gridy = 0;
		c.gridx = 0;
		p2Panel5.add(p2TimeLabel, c);
		
		c.gridy = 1;
		c.gridx = 0;
		p2Panel5.add(p2TimeBox, c);
		p2Frame.add(p2Panel5);
		
		JPanel p2Sub = new JPanel(new GridBagLayout());
		JButton p2Submit = new JButton("Submit");
		c.gridy = 0;
		p2Sub.add(p2Submit, c);
	    JButton p2p2 = new JButton("Make Another Request (Priority 3)");
	    c.gridy = 1;
	    p2Sub.add(p2p2, c);
	    p2Frame.add(p2Sub);
		
		
		
		p2Frame.setVisible(true);
		p2Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}


