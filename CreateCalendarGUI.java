import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class CreateCalendarGUI {
	public static void main(String args[]){
	JFrame cFrame = new JFrame();
	GridLayout g = new GridLayout(10, 1);
	cFrame.setLayout(g);
	final int FRAME_WIDTH = 600;
	final int FRAME_HEIGHT = 600;
	cFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	cFrame.setTitle("Create Schedule");
	
	JPanel semPanel = new JPanel(new GridBagLayout());
	semPanel.setAlignmentX( JPanel.LEFT_ALIGNMENT );
	GridBagConstraints c = new GridBagConstraints();
	
	JLabel sLabel = new JLabel("Semester:");
	ButtonGroup sGroup = new ButtonGroup();
	JRadioButton fall = new JRadioButton("Fall");
	JRadioButton winter = new JRadioButton("Winter");
	JRadioButton summer = new JRadioButton("Summer");
	sGroup.add(fall);
	sGroup.add(winter);
	sGroup.add(summer);
			
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 0;
	c.gridy = 0;
	semPanel.add(sLabel, c);
	
	c.gridy = 1;
	semPanel.add(fall, c);
	c.gridx = 1;
	semPanel.add(winter, c);
	c.gridx = 2;
	semPanel.add(summer, c);
	semPanel.setVisible(true);
	cFrame.add(semPanel);
	
	JPanel roomPanel = new JPanel(new GridBagLayout());
	roomPanel.setAlignmentX( JPanel.LEFT_ALIGNMENT );

	JLabel rLabel = new JLabel("Room: ");
	JComboBox<String> rooms = new JComboBox();
	rooms.addItem("Gym");
	rooms.addItem("Auditorium");
	rooms.addItem("Music");
	rooms.addItem("Lecture Hall");
	rooms.addItem("Computer Lab");
	
	c.gridx = 0;
	c.gridy = 2;
	roomPanel.add(rLabel, c);
	c.gridy = 3;
	roomPanel.add(rooms, c);
	roomPanel.setVisible(true);
	cFrame.add(roomPanel);
	
	JPanel mondayPanel = new JPanel(new GridBagLayout());
	JLabel mon = new JLabel("Monday:");
	String[] startTimes = {"9am", "10am", "11am", "12pm", "1pm", "2pm", "3pm", "4pm", "5pm", "6pm", "7pm", "8pm", "9pm", "Not Available"};
	String[] mondayStart = startTimes;
	String[] tuesdayStart = startTimes;
	String[] wednesdayStart = startTimes;
	String[] thursdayStart = startTimes;
	String[] fridayStart = startTimes;
	String[] saturdayStart = startTimes;
	String[] sundayStart = startTimes;
	
	String[] endTimes = {"10am", "11am", "12pm", "1pm", "2pm", "3pm", "4pm", "5pm", "6pm", "7pm", "8pm", "9pm", "10pm", "Not Available"};
	String[] mondayEnd = endTimes;
	String[] tuesdayEnd = endTimes;
	String[] wednesdayEnd = endTimes;
	String[] thursdayEnd = endTimes;
	String[] fridayEnd = endTimes;
	String[] saturdayEnd = endTimes;
	String[] sundayEnd = endTimes;
	
	

	c.gridy = 0;
	c.gridx = 0;
	mondayPanel.add(mon, c);
	c.gridy = 1;
	JLabel mStart = new JLabel("Available from: ");
	mondayPanel.add(mStart, c);	
	JComboBox<String> monStartBox = new JComboBox();
	
	for(int x = 0; x < startTimes.length; x++) {
		monStartBox.addItem(startTimes[x]);
	}
	c.gridx = 1;
	mondayPanel.add(monStartBox, c);
	c.gridx = 2;
	JLabel mEnd = new JLabel(" until: ");
	mondayPanel.add(mEnd, c);
	
	JComboBox<String> monEndBox = new JComboBox();
	for (int x = 0; x < endTimes.length; x++){
		monEndBox.addItem(endTimes[x]);
	}
	
	c.gridx = 3;
	mondayPanel.add(monEndBox, c);
	
	
	JPanel tuesdayPanel = new JPanel(new GridBagLayout());
	JLabel tue = new JLabel("Tuesday:");
	c.gridy = 0;
	c.gridx = 0;
	tuesdayPanel.add(tue, c);
	c.gridy = 1;
	JLabel tStart = new JLabel("Available from: ");
	tuesdayPanel.add(tStart, c);	
	JComboBox<String> tuesStartBox = new JComboBox();
	
	for(int x = 0; x < startTimes.length; x++) {
		tuesStartBox.addItem(startTimes[x]);
	}
	c.gridx = 1;
	tuesdayPanel.add(tuesStartBox, c);
	c.gridx = 2;
	JLabel tEnd = new JLabel(" until: ");
	tuesdayPanel.add(tEnd, c);
	
	JComboBox<String> tuesEndBox = new JComboBox();
	for (int x = 0; x < endTimes.length; x++){
		tuesEndBox.addItem(endTimes[x]);
	}
	
	c.gridx = 3;
	tuesdayPanel.add(tuesEndBox, c);
	JButton repeatMon = new JButton("Repeat Monday");
	c.gridx = 4;
	tuesdayPanel.add(repeatMon, c);
	
	ActionListener actionListenerMon = new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			Object start = monStartBox.getSelectedItem();
			Object end = monEndBox.getSelectedItem();
			tuesStartBox.setSelectedItem(start);
			tuesEndBox.setSelectedItem(end);
		}
	};
	repeatMon.addActionListener(actionListenerMon);	
	
	
			
	
	JPanel wednesdayPanel = new JPanel(new GridBagLayout());
	JLabel wed = new JLabel("Wednesday:");
	c.gridy = 0;
	c.gridx = 0;
	wednesdayPanel.add(wed, c);
	c.gridy = 1;
	JLabel wStart = new JLabel("Available from: ");
	wednesdayPanel.add(wStart, c);	
	JComboBox<String> wedStartBox = new JComboBox();
	
	for(int x = 0; x < startTimes.length; x++) {
		wedStartBox.addItem(startTimes[x]);
	}
	c.gridx = 1;
	wednesdayPanel.add(wedStartBox, c);
	c.gridx = 2;
	JLabel wEnd = new JLabel(" until: ");
	wednesdayPanel.add(wEnd, c);
	
	JComboBox<String> wedEndBox = new JComboBox();
	for (int x = 0; x < endTimes.length; x++){
		wedEndBox.addItem(endTimes[x]);
	}
	
	c.gridx = 3;
	wednesdayPanel.add(wedEndBox, c);
	JButton repeatTue = new JButton("Repeat Tuesday");
	c.gridx = 4;
	wednesdayPanel.add(repeatTue, c);
	
	ActionListener actionListenerTue = new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			Object start = tuesStartBox.getSelectedItem();
			Object end = tuesEndBox.getSelectedItem();
			wedStartBox.setSelectedItem(start);
			wedEndBox.setSelectedItem(end);
		}
	};
	repeatTue.addActionListener(actionListenerTue);	
	
	
	JPanel thursdayPanel = new JPanel(new GridBagLayout());
	JLabel thu = new JLabel("Thursday:");
	c.gridy = 0;
	c.gridx = 0;
	thursdayPanel.add(thu, c);
	c.gridy = 1;
	JLabel thStart = new JLabel("Available from: ");
	thursdayPanel.add(thStart, c);	
	JComboBox<String> thurStartBox = new JComboBox();
	
	for(int x = 0; x < startTimes.length; x++) {
		thurStartBox.addItem(startTimes[x]);
	}
	c.gridx = 1;
	thursdayPanel.add(thurStartBox, c);
	c.gridx = 2;
	JLabel thEnd = new JLabel(" until: ");
	thursdayPanel.add(thEnd, c);
	
	JComboBox<String> thurEndBox = new JComboBox();
	for (int x = 0; x < endTimes.length; x++){
		thurEndBox.addItem(endTimes[x]);
	}
	
	c.gridx = 3;
	thursdayPanel.add(thurEndBox, c);
	JButton repeatWed = new JButton("Repeat Wednesday");
	c.gridx = 4;
	thursdayPanel.add(repeatWed, c);
	
	ActionListener actionListenerWed = new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			Object start = wedStartBox.getSelectedItem();
			Object end = wedEndBox.getSelectedItem();
			thurStartBox.setSelectedItem(start);
			thurEndBox.setSelectedItem(end);
		}
	};
	repeatWed.addActionListener(actionListenerWed);	
	
	
	JPanel fridayPanel = new JPanel(new GridBagLayout());
	JLabel fri = new JLabel("Friday:");
	c.gridy = 0;
	c.gridx = 0;
	fridayPanel.add(fri, c);
	c.gridy = 1;
	JLabel fStart = new JLabel("Available from: ");
	fridayPanel.add(fStart, c);	
	JComboBox<String> friStartBox = new JComboBox();
	
	for(int x = 0; x < startTimes.length; x++) {
		friStartBox.addItem(startTimes[x]);
	}
	c.gridx = 1;
	fridayPanel.add(friStartBox, c);
	c.gridx = 2;
	JLabel fEnd = new JLabel(" until: ");
	fridayPanel.add(fEnd, c);
	
	JComboBox<String> friEndBox = new JComboBox();
	for (int x = 0; x < endTimes.length; x++){
		friEndBox.addItem(endTimes[x]);
	}
	
	c.gridx = 3;
	fridayPanel.add(friEndBox, c);
	JButton repeatThu = new JButton("Repeat Thursday");
	c.gridx = 4;
	fridayPanel.add(repeatThu, c);
	
	ActionListener actionListenerThu = new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			Object start = thurStartBox.getSelectedItem();
			Object end = thurEndBox.getSelectedItem();
			friStartBox.setSelectedItem(start);
			friEndBox.setSelectedItem(end);
		}
	};
	repeatThu.addActionListener(actionListenerThu);	
	
			
	JPanel saturdayPanel = new JPanel(new GridBagLayout());
	JLabel sat = new JLabel("Saturday:");
	c.gridy = 0;
	c.gridx = 0;
	saturdayPanel.add(sat, c);
	c.gridy = 1;
	JLabel sStart = new JLabel("Available from: ");
	saturdayPanel.add(sStart, c);	
	JComboBox<String> satStartBox = new JComboBox();
	
	for(int x = 0; x < startTimes.length; x++) {
		satStartBox.addItem(startTimes[x]);
	}
	c.gridx = 1;
	saturdayPanel.add(satStartBox, c);
	c.gridx = 2;
	JLabel sEnd = new JLabel(" until: ");
	saturdayPanel.add(sEnd, c);
	
	JComboBox<String> satEndBox = new JComboBox();
	for (int x = 0; x < endTimes.length; x++){
		satEndBox.addItem(endTimes[x]);
	}
	
	c.gridx = 3;
	saturdayPanel.add(satEndBox, c);
	JButton repeatFri = new JButton("Repeat Friday");
	c.gridx = 4;
	saturdayPanel.add(repeatFri, c);
	
	ActionListener actionListenerFri = new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			Object start = friStartBox.getSelectedItem();
			Object end = friEndBox.getSelectedItem();
			satStartBox.setSelectedItem(start);
			satEndBox.setSelectedItem(end);
		}
	};
	repeatFri.addActionListener(actionListenerFri);	
	
	
	JPanel sundayPanel = new JPanel(new GridBagLayout());
	JLabel sun = new JLabel("Sunday:");
	c.gridy = 0;
	c.gridx = 0;
	sundayPanel.add(sun, c);
	c.gridy = 1;
	JLabel suStart = new JLabel("Available from: ");
	sundayPanel.add(suStart, c);	
	JComboBox<String> sunStartBox = new JComboBox();
	
	for(int x = 0; x < startTimes.length; x++) {
		sunStartBox.addItem(startTimes[x]);
	}
	c.gridx = 1;
	sundayPanel.add(sunStartBox, c);
	c.gridx = 2;
	JLabel suEnd = new JLabel(" until: ");
	sundayPanel.add(suEnd, c);
	
	JComboBox<String> sunEndBox = new JComboBox();
	for (int x = 0; x < endTimes.length; x++){
		sunEndBox.addItem(endTimes[x]);
	}
	
	c.gridx = 3;
	sundayPanel.add(sunEndBox, c);
	JButton repeatSat = new JButton("Repeat Saturday");
	c.gridx = 4;
	sundayPanel.add(repeatSat, c);
	
	ActionListener actionListenerSat = new ActionListener(){

		public void actionPerformed(ActionEvent e) {
			Object start = satStartBox.getSelectedItem();
			Object end = satEndBox.getSelectedItem();
			sunStartBox.setSelectedItem(start);
			sunEndBox.setSelectedItem(end);
		}
	};
	repeatSat.addActionListener(actionListenerSat);	
	

	
	cFrame.add(mondayPanel);
	cFrame.add(tuesdayPanel);
	cFrame.add(wednesdayPanel);
	cFrame.add(thursdayPanel);
	cFrame.add(fridayPanel);
	cFrame.add(saturdayPanel);
	cFrame.add(sundayPanel);
	
	JPanel sSubmit = new JPanel();
	JButton schedSubmit = new JButton("Submit");
	sSubmit.add(schedSubmit);
	cFrame.add(sSubmit);
	
	
	
	cFrame.setVisible(true);
	cFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}

}
