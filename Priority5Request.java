import javax.swing.*;
import java.awt.*;
public class Priority5Request {
	static JTextField pField;
	public Priority5Request() {}
		public static void main(String[] args){
		JFrame p5Frame = new JFrame();
		GridLayout p5g = new GridLayout(6, 1);
		p5Frame.setLayout(p5g);
		final int FRAME_WIDTH = 300;
		final int FRAME_HEIGHT = 450;
		p5Frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		p5Frame.setTitle("Submit A Priority 5 Request");
		
		JPanel p5Panel1 = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel pLabel = new JLabel("Priority: 5");
		pLabel.setForeground(Color.RED);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		
		p5Panel1.add(pLabel, c);
		
		JLabel p5NameLabel = new JLabel("Name:");
		JTextField p5NameField = new JTextField(15);
		c.gridy = 1;
		p5Panel1.add(p5NameLabel, c);
		c.gridy = 2;
		p5Panel1.add(p5NameField, c);
		p5Frame.add(p5Panel1);
		
		JPanel p5Panel2 = new JPanel(new GridBagLayout());
		JLabel p5SLabel = new JLabel("Semester:");
		ButtonGroup p5SGroup = new ButtonGroup();
		JRadioButton p5Fall = new JRadioButton("Fall");
		JRadioButton p5Winter = new JRadioButton("Winter");
		JRadioButton p5Summer = new JRadioButton("Summer");
		p5SGroup.add(p5Fall);
		p5SGroup.add(p5Winter);
		p5SGroup.add(p5Summer);
		
		c.gridy = 0;
		p5Panel2.add(p5SLabel, c);
		c.gridy = 1;
		p5Panel2.add(p5Fall, c);
		c.gridx = 1;
		p5Panel2.add(p5Winter, c);
		c.gridx = 2;
		p5Panel2.add(p5Summer, c);
		p5Frame.add(p5Panel2);
		
		JPanel p5Panel3 = new JPanel(new GridBagLayout());
		JLabel p5RoomLabel = new JLabel("Room:");
		JComboBox p5RoomBox = new JComboBox();
		p5RoomBox.addItem("Gym");
		p5RoomBox.addItem("Music");
		p5RoomBox.addItem("Auditorium");
		p5RoomBox.addItem("Lecture Hall");
		p5RoomBox.addItem("Computer Lab");
		c.gridy = 0;
		p5Panel3.add(p5RoomLabel, c);
		c.gridy = 1;
		p5Panel3.add(p5RoomBox, c);
		p5Frame.add(p5Panel3);
		
		JPanel p5Panel4 = new JPanel(new GridBagLayout());
		JLabel p5DayLabel = new JLabel("Day:");
		JComboBox p5DayBox = new JComboBox();
		p5DayBox.setEnabled(false);
		p5DayBox.addItem("Monday");
		p5DayBox.addItem("Tuesday");
		p5DayBox.addItem("Wednesday");
		p5DayBox.addItem("Thursday");
		p5DayBox.addItem("Friday");
		p5DayBox.addItem("Saturday");
		p5DayBox.addItem("Sunday");
		
		c.gridy = 0;
		p5Panel4.add(p5DayLabel, c);
		c.gridy = 1;
		p5Panel4.add(p5DayBox, c);
		p5Frame.add(p5Panel4);
		
		JPanel p5Panel5 = new JPanel(new GridBagLayout());
		p5Panel5.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
		JLabel p5TimeLabel = new JLabel("Time:");
		JComboBox p5TimeBox = new JComboBox();
		p5TimeBox.setEnabled(false);
	    /*p5TimeBox.addItem("9am - 10am");
		/*p5TimeBox.addItem("10am - 11am");
		p5TimeBox.addItem("11am - 12pm");
		p5TimeBox.addItem("12pm - 1pm");
		p5TimeBox.addItem("1pm - 2pm");
		p5TimeBox.addItem("2pm - 3pm");
		p5TimeBox.addItem("3pm - 4pm");
		p5TimeBox.addItem("4pm - 5pm");
		p5TimeBox.addItem("5pm - 6pm");
		p5TimeBox.addItem("6pm - 7pm");
		p5TimeBox.addItem("7pm - 8pm");
		p5TimeBox.addItem("8pm - 9pm");
		p5TimeBox.addItem("9pm - 10pm");
		*/
		c.gridy = 0;
		c.gridx = 0;
		p5Panel5.add(p5TimeLabel, c);
		
		c.gridy = 1;
		c.gridx = 0;
		p5Panel5.add(p5TimeBox, c);
		p5Frame.add(p5Panel5);
		
		JPanel p5Sub = new JPanel(new GridBagLayout());
		JButton p5Submit = new JButton("Submit");
		c.gridy = 0;
		p5Sub.add(p5Submit, c);
	    p5Frame.add(p5Sub);
		
		
		
		p5Frame.setVisible(true);
		p5Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}


