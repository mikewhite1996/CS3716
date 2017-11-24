import javax.swing.*;
import java.awt.*;

public class RequestForm {
	static JTextField keyField;
	static JTextField dateField;
	public RequestForm() {
		JFrame rFrame = new JFrame();
		final int FRAME_WIDTH = 250;
		final int FRAME_HEIGHT = 450;
		rFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		rFrame.setTitle("Submit A Request");
		
		JPanel rPanel = new JPanel(new GridBagLayout());
		rPanel.setAlignmentX( JPanel.LEFT_ALIGNMENT );
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel keyLabel = new JLabel("Request ID:");
		keyField = new JTextField(15);
		keyField.setEditable(false);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		
		rPanel.add(keyLabel, c);
		
		c.gridy = 1;
		rPanel.add(keyField, c);
		
		JLabel nameLabel = new JLabel("Name:");
		JTextField nameField = new JTextField(15);
		c.gridy = 2;
		rPanel.add(nameLabel, c);
		c.gridy = 3;
		rPanel.add(nameField, c);
		
		JLabel timeLabel = new JLabel("Time:");
		JComboBox timeBox = new JComboBox();
		timeBox.addItem("9am - 10am");
		timeBox.addItem("10am - 11am");
		timeBox.addItem("11am - 12pm");
		timeBox.addItem("12pm - 1pm");
		timeBox.addItem("1pm - 2pm");
		timeBox.addItem("2pm - 3pm");
		timeBox.addItem("3pm - 4pm");
		timeBox.addItem("4pm - 5pm");
		timeBox.addItem("5pm - 6pm");
		timeBox.addItem("6pm - 7pm");
		timeBox.addItem("7pm - 8pm");
		timeBox.addItem("8pm - 9pm");
		timeBox.addItem("9pm - 10pm");
		
		c.gridy = 4;
		rPanel.add(timeLabel, c);
		
		c.gridy = 5;
		rPanel.add(timeBox, c);
		
		JLabel roomLabel = new JLabel("Room:");
		JComboBox roomBox = new JComboBox();
		roomBox.addItem("Gym");
		roomBox.addItem("Music");
		roomBox.addItem("Auditorium");
		c.gridy = 6;
		rPanel.add(roomLabel, c);
		c.gridy = 7;
		rPanel.add(roomBox, c);
		
		
		JLabel dateLabel = new JLabel("Date:");
		dateField = new JTextField(15);
		dateField.setEditable(false);
		c.gridy = 8;
		rPanel.add(dateLabel, c);
		c.gridy = 9;
		rPanel.add(dateField, c);
		
		JButton submit = new JButton("Submit");
		c.gridy = 10;
		rPanel.add(submit, c);
		
		
		rPanel.setVisible(true);
		
		rFrame.add(rPanel);
		rFrame.setVisible(true);
		rFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setKeyField(String k) {
		keyField.setText(k);
	}
	
	public void setDateField(String d){
		dateField.setText(d);
	}
	}
