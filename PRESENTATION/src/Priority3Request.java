import javax.swing.*;
import java.awt.*;
public class Priority3Request {
	static JTextField pField;
	public Priority3Request() {}
		public static void main(String[] args){
		JFrame p3Frame = new JFrame();
		GridLayout p3g = new GridLayout(6, 1);
		p3Frame.setLayout(p3g);
		final int FRAME_WIDTH = 300;
		final int FRAME_HEIGHT = 450;
		p3Frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		p3Frame.setTitle("Submit A Priority 3 Request");
		
		JPanel p3Panel1 = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel pLabel = new JLabel("Priority: 3");
		pLabel.setForeground(Color.RED);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		
		p3Panel1.add(pLabel, c);
		
		JLabel p3NameLabel = new JLabel("Name:");
		JTextField p3NameField = new JTextField(15);
		c.gridy = 1;
		p3Panel1.add(p3NameLabel, c);
		c.gridy = 2;
		p3Panel1.add(p3NameField, c);
		p3Frame.add(p3Panel1);
		
		JPanel p3Panel2 = new JPanel(new GridBagLayout());
		JLabel p3SLabel = new JLabel("Semester:");
		ButtonGroup p3SGroup = new ButtonGroup();
		JRadioButton p3Fall = new JRadioButton("Fall");
		JRadioButton p3Winter = new JRadioButton("Winter");
		JRadioButton p3Summer = new JRadioButton("Summer");
		p3SGroup.add(p3Fall);
		p3SGroup.add(p3Winter);
		p3SGroup.add(p3Summer);
		
		c.gridy = 0;
		p3Panel2.add(p3SLabel, c);
		c.gridy = 1;
		p3Panel2.add(p3Fall, c);
		c.gridx = 1;
		p3Panel2.add(p3Winter, c);
		c.gridx = 2;
		p3Panel2.add(p3Summer, c);
		p3Frame.add(p3Panel2);
		
		JPanel p3Panel3 = new JPanel(new GridBagLayout());
		JLabel p3RoomLabel = new JLabel("Room:");
		JComboBox p3RoomBox = new JComboBox();
		p3RoomBox.addItem("Gym");
		p3RoomBox.addItem("Music");
		p3RoomBox.addItem("Auditorium");
		p3RoomBox.addItem("Lecture Hall");
		p3RoomBox.addItem("Computer Lab");
		c.gridy = 0;
		p3Panel3.add(p3RoomLabel, c);
		c.gridy = 1;
		p3Panel3.add(p3RoomBox, c);
		p3Frame.add(p3Panel3);
		
		JPanel p3Panel4 = new JPanel(new GridBagLayout());
		JLabel p3DayLabel = new JLabel("Day:");
		JComboBox p3DayBox = new JComboBox();
		p3DayBox.setEnabled(false);
		p3DayBox.addItem("Monday");
		p3DayBox.addItem("Tuesday");
		p3DayBox.addItem("Wednesday");
		p3DayBox.addItem("Thursday");
		p3DayBox.addItem("Friday");
		p3DayBox.addItem("Saturday");
		p3DayBox.addItem("Sunday");
		
		c.gridy = 0;
		p3Panel4.add(p3DayLabel, c);
		c.gridy = 1;
		p3Panel4.add(p3DayBox, c);
		p3Frame.add(p3Panel4);
		
		JPanel p3Panel5 = new JPanel(new GridBagLayout());
		p3Panel5.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
		JLabel p3TimeLabel = new JLabel("Time:");
		JComboBox p3TimeBox = new JComboBox();
		p3TimeBox.setEnabled(false);
	    /*p3TimeBox.addItem("9am - 10am");
		/*p3TimeBox.addItem("10am - 11am");
		p3TimeBox.addItem("11am - 12pm");
		p3TimeBox.addItem("12pm - 1pm");
		p3TimeBox.addItem("1pm - 2pm");
		p3TimeBox.addItem("2pm - 3pm");
		p3TimeBox.addItem("3pm - 4pm");
		p3TimeBox.addItem("4pm - 5pm");
		p3TimeBox.addItem("5pm - 6pm");
		p3TimeBox.addItem("6pm - 7pm");
		p3TimeBox.addItem("7pm - 8pm");
		p3TimeBox.addItem("8pm - 9pm");
		p3TimeBox.addItem("9pm - 10pm");
		*/
		c.gridy = 0;
		c.gridx = 0;
		p3Panel5.add(p3TimeLabel, c);
		
		c.gridy = 1;
		c.gridx = 0;
		p3Panel5.add(p3TimeBox, c);
		p3Frame.add(p3Panel5);
		
		JPanel p3Sub = new JPanel(new GridBagLayout());
		JButton p3Submit = new JButton("Submit");
		c.gridy = 0;
		p3Sub.add(p3Submit, c);
	    JButton p3p2 = new JButton("Make Another Request (Priority 4)");
	    c.gridy = 1;
	    p3Sub.add(p3p2, c);
	    p3Frame.add(p3Sub);
		
		
		
		p3Frame.setVisible(true);
		p3Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}


