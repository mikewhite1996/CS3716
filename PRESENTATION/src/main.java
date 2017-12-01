

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;


public class main{
	static GettingRequest req;
	static Info mondayFall;
	static JTextArea field = new JTextArea(8,20);
	static Schedule fallSemMon = new Schedule();
	static Schedule fallSemTues = new Schedule();
	static Schedule fallSemWeds = new Schedule();
	static Schedule fallSemThurs = new Schedule();
	static Schedule fallSemFri = new Schedule();
	static Schedule fallSemSat = new Schedule();
	static Schedule fallSemSun = new Schedule();
	
	static String p2name;
	static String p2semester;
	static String p2room;
	
	static String p1name;
	static String p1semester;
	static String p1room;
	
	void createGUI(){
		JFrame jframe = new JFrame();
		JPanel panel = new JPanel();
		final int FRAME_WIDTH = 600;
		final int FRAME_HEIGHT = 600;

		jframe.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		jframe.setTitle("GUI");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



		String userString = "User";
		String prinString = "Principal";
		JRadioButton userButton = new JRadioButton(userString);
		JRadioButton prinButton = new JRadioButton(prinString);
		ButtonGroup buttonGroup = new ButtonGroup();
		ActionListener actionListener = new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(e.getSource() instanceof JRadioButton){
					JRadioButton Button = (JRadioButton) (e.getSource());
					if(Button.isSelected()){
						String choice = Button.getText();
						proceed(choice);
					}
				}

			}

		};
		userButton.addActionListener(actionListener);
		prinButton.addActionListener(actionListener);
		buttonGroup.add(userButton);
		buttonGroup.add(prinButton);
		panel.add(userButton);
		panel.add(prinButton);


		jframe.add(panel);
		jframe.setVisible(true);
	}

	public static void main(String args[]){
		Schedule fall = new Schedule();
		Group g1 = new Group("group");
		Day day1 = new Day(DayName.MONDAY);
		Room gym = new Gym();
		TimeSlot block = new TimeSlot(Block_Sch.A, Block_Sch.B);
		Info info1 = new Info(g1, day1, gym, block);
		fall.makeRequest(info1);
	//	String sInfo = readSchedule(fall);
		System.out.println(fall.display());

			new main().createGUI();


	}

	protected static void proceed(String answer2) {
		if(answer2.equals("Principal")){
			createPrincipalGUI();
		}else if(answer2.equals("User")){
			createUserGUI();
		}else if(answer2.equals("Create Schedule")){
			createScheduleGUI();
		}else if(answer2.equals("View Schedule")){
			//createViewGUI();
		}else if(answer2.equals("View Time Slots")){
			createTimeSlotsGUI();
		}else if(answer2.equals("View Requests")){
			//
		}else if(answer2.equals("Submit a Request")){
			createPriority1Request();
		}else if(answer2.equals("Create the Schedule")){
			createCalenderGUI();
		}else if(answer2.equals("Request for fall semester")) {
			createPriority1Request();
		}

	}
	public static void createPrincipalGUI(){
		JFrame jframe = new JFrame();
		final int FRAME_WIDTH = 600;
		final int FRAME_HEIGHT = 600;
		JPanel panel = new JPanel();

		jframe.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		jframe.setTitle("Prinicpal Screen");



		String scheduleString = "Create Schedule";
		String viewString = "View Schedule";
		String timeString = "View Time Slots";
		String requestsString = "View Requests";
		JButton schedule = new JButton(scheduleString);
		JButton requests = new JButton(requestsString);

		ActionListener actionListener = new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(e.getSource() instanceof JButton){
					JButton Button = (JButton) (e.getSource());
						String choice = Button.getText();
						proceed(choice);
					}
				}

			};


		schedule.addActionListener(actionListener);
		requests.addActionListener(actionListener);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(requests);
		
		buttonGroup.add(schedule);
		

		panel.add(schedule);
		
		
		panel.add(requests);

		jframe.add(panel);
		jframe.setVisible(true);
	}

	public static void createUserGUI(){
		JFrame jframe = new JFrame();
		JPanel panel = new JPanel();
		final int FRAME_WIDTH = 600;
		final int FRAME_HEIGHT = 600;

		jframe.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		jframe.setTitle("User Screen");



		String subreqString = "Submit a Request";
		

		JButton submitReq = new JButton(subreqString);
		

		ActionListener actionListener = new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(e.getSource() instanceof JButton){
					JButton Button = (JButton) (e.getSource());
						String choice = Button.getText();
						proceed(choice);
					}
				}

			};


		submitReq.addActionListener(actionListener);
		


		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(submitReq);
		


		panel.add(submitReq);
		


		jframe.add(panel);
		jframe.setVisible(true);


	}

	public static void dayOrSemesterGUI() {
		JFrame jframe = new JFrame();
		JPanel panel = new JPanel();
		final int FRAME_WIDTH = 600;
		final int FRAME_HEIGHT = 600;
		JLabel label = new JLabel();

		jframe.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		jframe.setTitle("Request Period");

	  String greeting = "Please select when you will need the room for";
		String fall = "Request for fall semester";
		String winter = "Request for winter semester";
		String oneDay = "Request for single day";

    label.setText(greeting);
		JButton falSelec = new JButton(fall);
		JButton winSelec = new JButton(winter);
		JButton sglDay = new JButton(oneDay);

		panel.add(label);
		panel.add(falSelec);
		panel.add(winSelec);
		panel.add(sglDay);

		jframe.add(panel);

		ActionListener actionListener = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (e.getSource() instanceof JButton) {
					JButton button = (JButton) (e.getSource());
					String select = button.getText();
					if (select.equals("Request for fall semester")) {
						createPriority1Request();
					}
				}
			}
		};

		falSelec.addActionListener(actionListener);
		sglDay.addActionListener(actionListener);


		jframe.setVisible(true);

	}

	public static void createScheduleGUI(){
		
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
		
		

		JPanel test = new JPanel();
		test.add(semPanel);
		test.add(roomPanel);
		test.add(mondayPanel);
		test.add(tuesdayPanel);
		test.add(wednesdayPanel);
		test.add(thursdayPanel);
		test.add(fridayPanel);
		test.add(saturdayPanel);
		test.add(sundayPanel);
		
		
		/*cFrame.add(mondayPanel);
		cFrame.add(tuesdayPanel);
		cFrame.add(wednesdayPanel);
		cFrame.add(thursdayPanel);
		cFrame.add(fridayPanel);
		cFrame.add(saturdayPanel);
		cFrame.add(sundayPanel);*/
		
		JPanel sSubmit = new JPanel();
		JButton schedSubmit = new JButton("Submit");
		sSubmit.add(schedSubmit);
		test.add(sSubmit);
		
		
		ActionListener actionListenerSub = new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(fall.isSelected()) {
					
					
					String semester = "Fall";
					Group name = new Group("Fall Schedule");
					if(rooms.getSelectedItem() == "Gym") {
						Room gym = new Gym();
						Day monday = new Day(DayName.MONDAY);
						
						int start_index = monStartBox.getSelectedIndex();
						if(start_index == 13) {
							start_index = monStartBox.getSelectedIndex() + 1;
						}
						int end_index = monEndBox.getSelectedIndex() + 1;
						TimeSlot mondayTime = new TimeSlot(Block_Sch.values()[start_index],Block_Sch.values()[end_index]);
						mondayFall = new Info(name, monday,gym, mondayTime);
						String path = "C:\\Users\\cs";
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\csinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(mondayFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						
						req = new GettingRequest(mondayFall);
						
						fallSemMon.makeRequest(mondayFall);
						System.out.println(fallSemMon.display());
						
						
						int start_indexT = tuesStartBox.getSelectedIndex();
						if(start_indexT == 13) {
							start_indexT = tuesStartBox.getSelectedIndex() + 1;
						}
						int end_indexT = tuesEndBox.getSelectedIndex() + 1;
						Day tuesday = new Day(DayName.TUESDAY);
						TimeSlot tuesdayTime = new TimeSlot(Block_Sch.values()[start_indexT],Block_Sch.values()[end_indexT]);
						Info tuesFall = new Info(name, tuesday, gym, tuesdayTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\Tuesdaycsinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(tuesFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						fallSemTues.makeRequest(tuesFall);
						System.out.println(fallSemTues.display());
						
						
						
						int start_indexW = wedStartBox.getSelectedIndex();
						int end_indexW = wedEndBox.getSelectedIndex() + 1;
						if(start_indexW == 13) {
							start_indexW = wedStartBox.getSelectedIndex() + 1;
						}
						Day weds = new Day(DayName.WEDNESDAY);
						TimeSlot wedsTime = new TimeSlot(Block_Sch.values()[start_indexW],Block_Sch.values()[end_indexW]);
						Info wedsFall = new Info(name, weds, gym, wedsTime);
						
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\Wedscsinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(wedsFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						fallSemWeds.makeRequest(wedsFall);
						System.out.println(fallSemWeds.display());
						
						
						int start_indexTR = thurStartBox.getSelectedIndex();
						int end_indexTR = thurEndBox.getSelectedIndex() + 1;
						if(start_indexTR == 13) {
							start_indexTR = thurStartBox.getSelectedIndex() + 1;
						}
						Day thurs = new Day(DayName.THURSDAY);
						TimeSlot thursTime = new TimeSlot(Block_Sch.values()[start_indexTR],Block_Sch.values()[end_indexTR]);
						Info thursFall = new Info(name, thurs, gym, thursTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\Thurscsinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(thursFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						
						fallSemThurs.makeRequest(thursFall);
						System.out.println(fallSemThurs.display());
						
						
						int start_indexF = friStartBox.getSelectedIndex();
						int end_indexF = friEndBox.getSelectedIndex() + 1;
						if(start_indexF == 13) {
							start_indexF = friStartBox.getSelectedIndex() + 1;
						}
						Day friday = new Day(DayName.FRIDAY);
						TimeSlot fridayTime = new TimeSlot(Block_Sch.values()[start_indexF],Block_Sch.values()[end_indexF]);
						Info friFall = new Info(name, friday, gym, fridayTime);
						
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\Fridaycsinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(friFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						fallSemFri.makeRequest(friFall);
						System.out.println(fallSemFri.display());
						
						
						int start_indexS = satStartBox.getSelectedIndex();
						int end_indexS = satEndBox.getSelectedIndex() + 1;
						if(start_indexS == 13) {
							start_indexS = satStartBox.getSelectedIndex() + 1;
						}
						Day saturday = new Day(DayName.SATURDAY);
						TimeSlot satTime = new TimeSlot(Block_Sch.values()[start_indexS],Block_Sch.values()[end_indexS]);
						Info satFall = new Info(name, saturday, gym, satTime);
						
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\Satcsinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(satFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						fallSemSat.makeRequest(satFall);
						System.out.println(fallSemSat.display());
						
						
						
						int start_indexSS = sunStartBox.getSelectedIndex();
						int end_indexSS = sunEndBox.getSelectedIndex() + 1;
						if(start_indexSS == 13) {
							start_indexSS = sunStartBox.getSelectedIndex() + 1;
						}
						Day sunday = new Day(DayName.SUNDAY);
						TimeSlot sunTime = new TimeSlot(Block_Sch.values()[start_indexSS],Block_Sch.values()[end_indexSS]);
						Info sunFall = new Info(name, sunday, gym, sunTime);
						
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\Sundaycsinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(sunFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						fallSemSun.makeRequest(sunFall);
						System.out.println(fallSemSun.display());
						
						
					}if(rooms.getSelectedItem() == "Music") {
						Room music = new Music();
						Day monday = new Day(DayName.MONDAY);
						int start_index = monStartBox.getSelectedIndex();
						int end_index = monEndBox.getSelectedIndex() + 1;
						if(start_index == 13) {
							start_index = monStartBox.getSelectedIndex() + 1;
						}
						TimeSlot mondayTime = new TimeSlot(Block_Sch.values()[start_index],Block_Sch.values()[end_index]);
						Info mondayFall = new Info(name, monday,music, mondayTime);
						
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\MusicMondayFallinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(mondayFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						fallSemMon.makeRequest(mondayFall);
						System.out.println(fallSemMon.display());
						
						
						int start_indexT = tuesStartBox.getSelectedIndex();
						int end_indexT = tuesEndBox.getSelectedIndex() + 1;
						if(start_indexT == 13) {
							start_indexT = tuesStartBox.getSelectedIndex() + 1;
						}
						Day tuesday = new Day(DayName.TUESDAY);
						TimeSlot tuesdayTime = new TimeSlot(Block_Sch.values()[start_indexT],Block_Sch.values()[end_indexT]);
						Info tuesFall = new Info(name, tuesday, music, tuesdayTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\MusicTuesFallinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(tuesFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						
						fallSemTues.makeRequest(tuesFall);
						System.out.println(fallSemTues.display());
						
						
						
						int start_indexW = wedStartBox.getSelectedIndex();
						int end_indexW = wedEndBox.getSelectedIndex() + 1;
						if(start_indexW == 13) {
							start_indexW = wedStartBox.getSelectedIndex() + 1;
						}
						Day weds = new Day(DayName.WEDNESDAY);
						TimeSlot wedsTime = new TimeSlot(Block_Sch.values()[start_indexW],Block_Sch.values()[end_indexW]);
						Info wedsFall = new Info(name, weds, music, wedsTime);
						
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\MusicWedsFallinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(wedsFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						
						fallSemWeds.makeRequest(wedsFall);
						System.out.println(fallSemWeds.display());
						
						
						int start_indexTR = thurStartBox.getSelectedIndex();
						int end_indexTR = thurEndBox.getSelectedIndex() + 1;
						if(start_indexTR == 13) {
							start_indexTR = thurStartBox.getSelectedIndex() + 1;
						}
						Day thurs = new Day(DayName.THURSDAY);
						TimeSlot thursTime = new TimeSlot(Block_Sch.values()[start_indexTR],Block_Sch.values()[end_indexTR]);
						Info thursFall = new Info(name, thurs, music, thursTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\MusicThursFallinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(thursFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						
						fallSemThurs.makeRequest(thursFall);
						System.out.println(fallSemThurs.display());
						
						
						int start_indexF = friStartBox.getSelectedIndex();
						int end_indexF = friEndBox.getSelectedIndex() + 1;
						if(start_indexF == 13) {
							start_indexF = friStartBox.getSelectedIndex() + 1;
						}
						Day friday = new Day(DayName.FRIDAY);
						TimeSlot fridayTime = new TimeSlot(Block_Sch.values()[start_indexF],Block_Sch.values()[end_indexF]);
						Info friFall = new Info(name, friday, music, fridayTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\MusicFriFallinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(friFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						
						fallSemFri.makeRequest(friFall);
						System.out.println(fallSemFri.display());
						
						
						int start_indexS = satStartBox.getSelectedIndex();
						int end_indexS = satEndBox.getSelectedIndex() + 1;
						if(start_indexS == 13) {
							start_indexS = satStartBox.getSelectedIndex() + 1;
						}
						Day saturday = new Day(DayName.SATURDAY);
						TimeSlot satTime = new TimeSlot(Block_Sch.values()[start_indexS],Block_Sch.values()[end_indexS]);
						Info satFall = new Info(name, saturday, music, satTime);
						
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\MusicSatFallinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(satFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						fallSemSat.makeRequest(satFall);
						System.out.println(fallSemSat.display());
						
						
						
						int start_indexSS = sunStartBox.getSelectedIndex();
						int end_indexSS = sunEndBox.getSelectedIndex() + 1;
						if(start_indexSS == 13) {
							start_indexSS = sunStartBox.getSelectedIndex() + 1;
						}
						Day sunday = new Day(DayName.SUNDAY);
						TimeSlot sunTime = new TimeSlot(Block_Sch.values()[start_indexSS],Block_Sch.values()[end_indexSS]);
						Info sunFall = new Info(name, sunday, music, sunTime);
						
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\MusicSunFallinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(sunFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						fallSemSun.makeRequest(sunFall);
						System.out.println(fallSemSun.display());
						
					}if(rooms.getSelectedItem() == "Auditorium"){
						Room auditorium = new Auditorium();
						Day monday = new Day(DayName.MONDAY);
						int start_index = monStartBox.getSelectedIndex();
						int end_index = monEndBox.getSelectedIndex() + 1;
						if(start_index == 13) {
							start_index = monStartBox.getSelectedIndex() + 1;
						}
						TimeSlot mondayTime = new TimeSlot(Block_Sch.values()[start_index],Block_Sch.values()[end_index]);
						Info mondayFall = new Info(name, monday,auditorium, mondayTime);
						
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\AuditoriumMondayFallinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(mondayFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						
						fallSemMon.makeRequest(mondayFall);
						System.out.println(fallSemMon.display());
						
						
						int start_indexT = tuesStartBox.getSelectedIndex();
						int end_indexT = tuesEndBox.getSelectedIndex() + 1;
						if(start_indexT == 13) {
							start_indexT = tuesStartBox.getSelectedIndex() + 1;
						}
						Day tuesday = new Day(DayName.TUESDAY);
						TimeSlot tuesdayTime = new TimeSlot(Block_Sch.values()[start_indexT],Block_Sch.values()[end_indexT]);
						Info tuesFall = new Info(name, tuesday, auditorium, tuesdayTime);
						
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\AuditoriumTuesFallinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(tuesFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						fallSemTues.makeRequest(tuesFall);
						System.out.println(fallSemTues.display());
						
						
						
						int start_indexW = wedStartBox.getSelectedIndex();
						int end_indexW = wedEndBox.getSelectedIndex() + 1;
						if(start_indexW == 13) {
							start_indexW = wedStartBox.getSelectedIndex() + 1;
						}
						Day weds = new Day(DayName.WEDNESDAY);
						TimeSlot wedsTime = new TimeSlot(Block_Sch.values()[start_indexW],Block_Sch.values()[end_indexW]);
						Info wedsFall = new Info(name, weds, auditorium, wedsTime);
						
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\AuditoriumWedsFallinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(wedsFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						fallSemWeds.makeRequest(wedsFall);
						System.out.println(fallSemWeds.display());
						
						
						int start_indexTR = thurStartBox.getSelectedIndex();
						int end_indexTR = thurEndBox.getSelectedIndex() + 1;
						if(start_indexTR == 13) {
							start_indexTR = thurStartBox.getSelectedIndex() + 1;
						}
						Day thurs = new Day(DayName.THURSDAY);
						TimeSlot thursTime = new TimeSlot(Block_Sch.values()[start_indexTR],Block_Sch.values()[end_indexTR]);
						Info thursFall = new Info(name, thurs, auditorium, thursTime);
						
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\AuditoriumThursFallinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(thursFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						fallSemThurs.makeRequest(thursFall);
						System.out.println(fallSemThurs.display());
						
						
						int start_indexF = friStartBox.getSelectedIndex();
						int end_indexF = friEndBox.getSelectedIndex() + 1;
						if(start_indexF == 13) {
							start_indexF = friStartBox.getSelectedIndex() + 1;
						}
						Day friday = new Day(DayName.FRIDAY);
						TimeSlot fridayTime = new TimeSlot(Block_Sch.values()[start_indexF],Block_Sch.values()[end_indexF]);
						Info friFall = new Info(name, friday, auditorium, fridayTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\AuditoriumFriFallinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(friFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						
						fallSemFri.makeRequest(friFall);
						System.out.println(fallSemFri.display());
						
						
						int start_indexS = satStartBox.getSelectedIndex();
						int end_indexS = satEndBox.getSelectedIndex() + 1;
						if(start_indexS == 13) {
							start_indexS = satStartBox.getSelectedIndex() + 1;
						}
						Day saturday = new Day(DayName.SATURDAY);
						TimeSlot satTime = new TimeSlot(Block_Sch.values()[start_indexS],Block_Sch.values()[end_indexS]);
						Info satFall = new Info(name, saturday, auditorium, satTime);
						
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\AuditoriumSatFallinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(satFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						fallSemSat.makeRequest(satFall);
						System.out.println(fallSemSat.display());
						
						
						
						int start_indexSS = sunStartBox.getSelectedIndex();
						int end_indexSS = sunEndBox.getSelectedIndex() + 1;
						if(start_indexSS == 13) {
							start_indexSS = sunStartBox.getSelectedIndex() + 1;
						}
						Day sunday = new Day(DayName.SUNDAY);
						TimeSlot sunTime = new TimeSlot(Block_Sch.values()[start_indexSS],Block_Sch.values()[end_indexSS]);
						Info sunFall = new Info(name, sunday, auditorium, sunTime);
						
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\AuditoriumSunFallinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(sunFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						fallSemSun.makeRequest(sunFall);
						System.out.println(fallSemSun.display());
						
					}if(rooms.getSelectedItem() == "Computer Lab") {
						Room comp = new ComputerLab();
						Day monday = new Day(DayName.MONDAY);
						int start_index = monStartBox.getSelectedIndex();
						int end_index = monEndBox.getSelectedIndex() + 1;
						if(start_index == 13) {
							start_index = monStartBox.getSelectedIndex() + 1;
						}
						TimeSlot mondayTime = new TimeSlot(Block_Sch.values()[start_index],Block_Sch.values()[end_index]);
						Info mondayFall = new Info(name, monday,comp, mondayTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\ComputerLabMondayFallinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(mondayFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						
						fallSemMon.makeRequest(mondayFall);
						System.out.println(fallSemMon.display());
						
						
						int start_indexT = tuesStartBox.getSelectedIndex();
						int end_indexT = tuesEndBox.getSelectedIndex() + 1;
						if(start_indexT == 13) {
							start_indexT = tuesStartBox.getSelectedIndex() + 1;
						}
						Day tuesday = new Day(DayName.TUESDAY);
						TimeSlot tuesdayTime = new TimeSlot(Block_Sch.values()[start_indexT],Block_Sch.values()[end_indexT]);
						Info tuesFall = new Info(name, tuesday, comp, tuesdayTime);
						
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\ComputerLabTuesFallinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(tuesFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						fallSemTues.makeRequest(tuesFall);
						System.out.println(fallSemTues.display());
						
						
						
						int start_indexW = wedStartBox.getSelectedIndex();
						int end_indexW = wedEndBox.getSelectedIndex() + 1;
						if(start_indexW == 13) {
							start_indexW = wedStartBox.getSelectedIndex() + 1;
						}
						Day weds = new Day(DayName.WEDNESDAY);
						TimeSlot wedsTime = new TimeSlot(Block_Sch.values()[start_indexW],Block_Sch.values()[end_indexW]);
						Info wedsFall = new Info(name, weds, comp, wedsTime);
						
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\ComputerLabWedsFallinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(wedsFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						fallSemWeds.makeRequest(wedsFall);
						System.out.println(fallSemWeds.display());
						
						
						int start_indexTR = thurStartBox.getSelectedIndex();
						int end_indexTR = thurEndBox.getSelectedIndex() + 1;
						if(start_indexTR == 13) {
							start_indexTR = thurStartBox.getSelectedIndex() + 1;
						}
						Day thurs = new Day(DayName.THURSDAY);
						TimeSlot thursTime = new TimeSlot(Block_Sch.values()[start_indexTR],Block_Sch.values()[end_indexTR]);
						Info thursFall = new Info(name, thurs, comp, thursTime);
						
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\ComputerLabThursFallinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(thursFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						fallSemThurs.makeRequest(thursFall);
						System.out.println(fallSemThurs.display());
						
						
						int start_indexF = friStartBox.getSelectedIndex();
						int end_indexF = friEndBox.getSelectedIndex() + 1;
						if(start_indexF == 13) {
							start_indexF = friStartBox.getSelectedIndex() + 1;
						}
						Day friday = new Day(DayName.FRIDAY);
						TimeSlot fridayTime = new TimeSlot(Block_Sch.values()[start_indexF],Block_Sch.values()[end_indexF]);
						Info friFall = new Info(name, friday, comp, fridayTime);
						
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\ComputerLabFriFallinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(friFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						fallSemFri.makeRequest(friFall);
						System.out.println(fallSemFri.display());
						
						
						int start_indexS = satStartBox.getSelectedIndex();
						int end_indexS = satEndBox.getSelectedIndex() + 1;
						if(start_indexS == 13) {
							start_indexS = satStartBox.getSelectedIndex() + 1;
						}
						Day saturday = new Day(DayName.SATURDAY);
						TimeSlot satTime = new TimeSlot(Block_Sch.values()[start_indexS],Block_Sch.values()[end_indexS]);
						Info satFall = new Info(name, saturday, comp, satTime);
						
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\ComputerLabSatFallinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(satFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						fallSemSat.makeRequest(satFall);
						System.out.println(fallSemSat.display());
						
						
						
						int start_indexSS = sunStartBox.getSelectedIndex();
						int end_indexSS = sunEndBox.getSelectedIndex() + 1;
						if(start_indexSS == 13) {
							start_indexSS = sunStartBox.getSelectedIndex() + 1;
						}
						Day sunday = new Day(DayName.SUNDAY);
						TimeSlot sunTime = new TimeSlot(Block_Sch.values()[start_indexSS],Block_Sch.values()[end_indexSS]);
						Info sunFall = new Info(name, sunday, comp, sunTime);
						
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\ComputerLabSunFallinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(sunFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						fallSemSun.makeRequest(sunFall);
						System.out.println(fallSemSun.display());
						
					}if(rooms.getSelectedItem() == "Lecture Hall") {
						Room lect = new LectureHall();
						Day monday = new Day(DayName.MONDAY);
						int start_index = monStartBox.getSelectedIndex();
						int end_index = monEndBox.getSelectedIndex() + 1;
						if(start_index == 13) {
							start_index = monStartBox.getSelectedIndex() + 1;
						}
						TimeSlot mondayTime = new TimeSlot(Block_Sch.values()[start_index],Block_Sch.values()[end_index]);
						Info mondayFall = new Info(name, monday,lect, mondayTime);
						
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\LectureHallMondayFallinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(mondayFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						
						fallSemMon.makeRequest(mondayFall);
						System.out.println(fallSemMon.display());
						
						
						int start_indexT = tuesStartBox.getSelectedIndex();
						int end_indexT = tuesEndBox.getSelectedIndex() + 1;
						if(start_indexT == 13) {
							start_indexT = tuesStartBox.getSelectedIndex() + 1;
						}
						Day tuesday = new Day(DayName.TUESDAY);
						TimeSlot tuesdayTime = new TimeSlot(Block_Sch.values()[start_indexT],Block_Sch.values()[end_indexT]);
						Info tuesFall = new Info(name, tuesday, lect, tuesdayTime);
						
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\LectureHallTuesFallinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(tuesFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						fallSemTues.makeRequest(tuesFall);
						System.out.println(fallSemTues.display());
						
						
						
						int start_indexW = wedStartBox.getSelectedIndex();
						int end_indexW = wedEndBox.getSelectedIndex() + 1;
						if(start_indexW == 13) {
							start_indexW = wedStartBox.getSelectedIndex() + 1;
						}
						Day weds = new Day(DayName.WEDNESDAY);
						TimeSlot wedsTime = new TimeSlot(Block_Sch.values()[start_indexW],Block_Sch.values()[end_indexW]);
						Info wedsFall = new Info(name, weds, lect, wedsTime);
						
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\LectureHallWedsFallinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(wedsFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						fallSemWeds.makeRequest(wedsFall);
						System.out.println(fallSemWeds.display());
						
						
						int start_indexTR = thurStartBox.getSelectedIndex();
						int end_indexTR = thurEndBox.getSelectedIndex() + 1;
						if(start_indexTR == 13) {
							start_indexTR = thurStartBox.getSelectedIndex() + 1;
						}
						Day thurs = new Day(DayName.THURSDAY);
						TimeSlot thursTime = new TimeSlot(Block_Sch.values()[start_indexTR],Block_Sch.values()[end_indexTR]);
						Info thursFall = new Info(name, thurs, lect, thursTime);
						
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\LectureHallThursFallinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(thursFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						fallSemThurs.makeRequest(thursFall);
						System.out.println(fallSemThurs.display());
						
						
						int start_indexF = friStartBox.getSelectedIndex();
						int end_indexF = friEndBox.getSelectedIndex() + 1;
						if(start_indexF == 13) {
							start_indexF = friStartBox.getSelectedIndex() + 1;
						}
						Day friday = new Day(DayName.FRIDAY);
						TimeSlot fridayTime = new TimeSlot(Block_Sch.values()[start_indexF],Block_Sch.values()[end_indexF]);
						Info friFall = new Info(name, friday, lect, fridayTime);
						
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\LectureHallFriFallinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(friFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						fallSemFri.makeRequest(friFall);
						System.out.println(fallSemFri.display());
						
						
						int start_indexS = satStartBox.getSelectedIndex();
						int end_indexS = satEndBox.getSelectedIndex() + 1;
						if(start_indexS == 13) {
							start_indexS = satStartBox.getSelectedIndex() + 1;
						}
						Day saturday = new Day(DayName.SATURDAY);
						TimeSlot satTime = new TimeSlot(Block_Sch.values()[start_indexS],Block_Sch.values()[end_indexS]);
						Info satFall = new Info(name, saturday, lect, satTime);
						
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\LectureHallSatFallinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(satFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						fallSemSat.makeRequest(satFall);
						System.out.println(fallSemSat.display());
						
						
						
						int start_indexSS = sunStartBox.getSelectedIndex();
						int end_indexSS = sunEndBox.getSelectedIndex() + 1;
						if(start_indexSS == 13) {
							start_indexSS = sunStartBox.getSelectedIndex() + 1;
						}
						Day sunday = new Day(DayName.SUNDAY);
						TimeSlot sunTime = new TimeSlot(Block_Sch.values()[start_indexSS],Block_Sch.values()[end_indexSS]);
						Info sunFall = new Info(name, sunday, lect, sunTime);
						
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\LectureHallSunFallinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(sunFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						fallSemSun.makeRequest(sunFall);
						System.out.println(fallSemSun.display());
					}
					
					
				}else if(winter.isSelected()) {
					Schedule winSemMon = new Schedule();
					Schedule winSemTues = new Schedule();
					Schedule winSemWeds = new Schedule();
					Schedule winSemThurs = new Schedule();
					Schedule winSemFri = new Schedule();
					Schedule winSemSat = new Schedule();
					Schedule winSemSun = new Schedule();
					
					
					Group name = new Group("Winter Schedule");
					if(rooms.getSelectedItem() == "Gym") {
						Room gym = new Gym();
						Day monday = new Day(DayName.MONDAY);
						
						int start_index = monStartBox.getSelectedIndex();
						int end_index = monEndBox.getSelectedIndex() + 1;
						if(start_index == 13) {
							start_index = monStartBox.getSelectedIndex() + 1;
						}
						TimeSlot mondayTime = new TimeSlot(Block_Sch.values()[start_index],Block_Sch.values()[end_index]);
						Info mondayFall = new Info(name, monday,gym, mondayTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\WinterMondaycsinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(mondayFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemMon.makeRequest(mondayFall);
						System.out.println(winSemMon.display());
						
						
						int start_indexT = tuesStartBox.getSelectedIndex();
						int end_indexT = tuesEndBox.getSelectedIndex() + 1;
						if(start_indexT == 13) {
							start_indexT = tuesStartBox.getSelectedIndex() + 1;
						}
						Day tuesday = new Day(DayName.TUESDAY);
						TimeSlot tuesdayTime = new TimeSlot(Block_Sch.values()[start_indexT],Block_Sch.values()[end_indexT]);
						Info tuesFall = new Info(name, tuesday, gym, tuesdayTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\TuesdayWintercsinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(tuesFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemTues.makeRequest(tuesFall);
						System.out.println(winSemTues.display());
						
						
						
						int start_indexW = wedStartBox.getSelectedIndex();
						int end_indexW = wedEndBox.getSelectedIndex() + 1;
						if(start_indexW == 13) {
							start_indexW = wedStartBox.getSelectedIndex() + 1;
						}
						Day weds = new Day(DayName.WEDNESDAY);
						TimeSlot wedsTime = new TimeSlot(Block_Sch.values()[start_indexW],Block_Sch.values()[end_indexW]);
						Info wedsFall = new Info(name, weds, gym, wedsTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\WedsWintercsinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(wedsFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemWeds.makeRequest(wedsFall);
						System.out.println(winSemWeds.display());
						
						
						int start_indexTR = thurStartBox.getSelectedIndex();
						int end_indexTR = thurEndBox.getSelectedIndex() + 1;
						if(start_indexTR == 13) {
							start_indexTR = thurStartBox.getSelectedIndex() + 1;
						}
						Day thurs = new Day(DayName.THURSDAY);
						TimeSlot thursTime = new TimeSlot(Block_Sch.values()[start_indexTR],Block_Sch.values()[end_indexTR]);
						Info thursFall = new Info(name, thurs, gym, thursTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\ThursWintercsinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(thursFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemThurs.makeRequest(thursFall);
						System.out.println(winSemThurs.display());
						
						
						int start_indexF = friStartBox.getSelectedIndex();
						int end_indexF = friEndBox.getSelectedIndex() + 1;
						if(start_indexF == 13) {
							start_indexF = friStartBox.getSelectedIndex() + 1;
						}
						Day friday = new Day(DayName.FRIDAY);
						TimeSlot fridayTime = new TimeSlot(Block_Sch.values()[start_indexF],Block_Sch.values()[end_indexF]);
						Info friFall = new Info(name, friday, gym, fridayTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\FriWintercsinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(friFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemFri.makeRequest(friFall);
						System.out.println(winSemFri.display());
						
						
						int start_indexS = satStartBox.getSelectedIndex();
						int end_indexS = satEndBox.getSelectedIndex() + 1;
						if(start_indexS == 13) {
							start_indexS = satStartBox.getSelectedIndex() + 1;
						}
						Day saturday = new Day(DayName.SATURDAY);
						TimeSlot satTime = new TimeSlot(Block_Sch.values()[start_indexS],Block_Sch.values()[end_indexS]);
						Info satFall = new Info(name, saturday, gym, satTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\WinterSatcsinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(satFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemSat.makeRequest(satFall);
						System.out.println(winSemSat.display());
						
						
						
						int start_indexSS = sunStartBox.getSelectedIndex();
						int end_indexSS = sunEndBox.getSelectedIndex() + 1;
						if(start_indexSS == 13) {
							start_indexSS = sunStartBox.getSelectedIndex() + 1;
						}
						Day sunday = new Day(DayName.SUNDAY);
						TimeSlot sunTime = new TimeSlot(Block_Sch.values()[start_indexSS],Block_Sch.values()[end_indexSS]);
						Info sunFall = new Info(name, sunday, gym, sunTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\SundayWintercsinfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(sunFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemSun.makeRequest(sunFall);
						System.out.println(winSemSun.display());
						
						
					}if(rooms.getSelectedItem() == "Music") {
						Room music = new Music();
						Day monday = new Day(DayName.MONDAY);
						int start_index = monStartBox.getSelectedIndex();
						int end_index = monEndBox.getSelectedIndex() + 1;
						if(start_index == 13) {
							start_index = monStartBox.getSelectedIndex() + 1;
						}
						TimeSlot mondayTime = new TimeSlot(Block_Sch.values()[start_index],Block_Sch.values()[end_index]);
						Info mondayFall = new Info(name, monday,music, mondayTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\MusicMondayWinterInfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(mondayFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemMon.makeRequest(mondayFall);
						System.out.println(winSemMon.display());
						
						
						int start_indexT = tuesStartBox.getSelectedIndex();
						int end_indexT = tuesEndBox.getSelectedIndex() + 1;
						if(start_indexT == 13) {
							start_indexT = tuesStartBox.getSelectedIndex() + 1;
						}
						Day tuesday = new Day(DayName.TUESDAY);
						TimeSlot tuesdayTime = new TimeSlot(Block_Sch.values()[start_indexT],Block_Sch.values()[end_indexT]);
						Info tuesFall = new Info(name, tuesday, music, tuesdayTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\MusicTuesdayWinterInfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(tuesFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemTues.makeRequest(tuesFall);
						System.out.println(winSemTues.display());
						
						
						
						int start_indexW = wedStartBox.getSelectedIndex();
						int end_indexW = wedEndBox.getSelectedIndex() + 1;
						if(start_indexW == 13) {
							start_indexW = wedStartBox.getSelectedIndex() + 1;
						}
						Day weds = new Day(DayName.WEDNESDAY);
						TimeSlot wedsTime = new TimeSlot(Block_Sch.values()[start_indexW],Block_Sch.values()[end_indexW]);
						Info wedsFall = new Info(name, weds, music, wedsTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\MusicWedsWinterInfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(wedsFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemWeds.makeRequest(wedsFall);
						System.out.println(winSemWeds.display());
						
						
						int start_indexTR = thurStartBox.getSelectedIndex();
						int end_indexTR = thurEndBox.getSelectedIndex() + 1;
						if(start_indexTR == 13) {
							start_indexTR = thurStartBox.getSelectedIndex() + 1;
						}
						Day thurs = new Day(DayName.THURSDAY);
						TimeSlot thursTime = new TimeSlot(Block_Sch.values()[start_indexTR],Block_Sch.values()[end_indexTR]);
						Info thursFall = new Info(name, thurs, music, thursTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\MusicThursWinterInfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(thursFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemThurs.makeRequest(thursFall);
						System.out.println(winSemThurs.display());
						
						
						int start_indexF = friStartBox.getSelectedIndex();
						int end_indexF = friEndBox.getSelectedIndex() + 1;
						if(start_indexF == 13) {
							start_indexF = friStartBox.getSelectedIndex() + 1;
						}
						Day friday = new Day(DayName.FRIDAY);
						TimeSlot fridayTime = new TimeSlot(Block_Sch.values()[start_indexF],Block_Sch.values()[end_indexF]);
						Info friFall = new Info(name, friday, music, fridayTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\MusicFriWinterInfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(friFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemFri.makeRequest(friFall);
						System.out.println(winSemFri.display());
						
						
						int start_indexS = satStartBox.getSelectedIndex();
						int end_indexS = satEndBox.getSelectedIndex() + 1;
						if(start_indexS == 13) {
							start_indexS = satStartBox.getSelectedIndex() + 1;
						}
						Day saturday = new Day(DayName.SATURDAY);
						TimeSlot satTime = new TimeSlot(Block_Sch.values()[start_indexS],Block_Sch.values()[end_indexS]);
						Info satFall = new Info(name, saturday, music, satTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\MusicSatWinterInfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(satFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemSat.makeRequest(satFall);
						System.out.println(winSemSat.display());
						
						
						
						int start_indexSS = sunStartBox.getSelectedIndex();
						int end_indexSS = sunEndBox.getSelectedIndex() + 1;
						if(start_indexSS == 13) {
							start_indexSS = sunStartBox.getSelectedIndex() + 1;
						}
						Day sunday = new Day(DayName.SUNDAY);
						TimeSlot sunTime = new TimeSlot(Block_Sch.values()[start_indexSS],Block_Sch.values()[end_indexSS]);
						Info sunFall = new Info(name, sunday, music, sunTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\MusicSunWinterInfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(sunFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemSun.makeRequest(sunFall);
						System.out.println(winSemSun.display());
						
					}if(rooms.getSelectedItem() == "Auditorium"){
						Room auditorium = new Auditorium();
						Day monday = new Day(DayName.MONDAY);
						int start_index = monStartBox.getSelectedIndex();
						int end_index = monEndBox.getSelectedIndex() + 1;
						if(start_index == 13) {
							start_index = monStartBox.getSelectedIndex() + 1;
						}
						TimeSlot mondayTime = new TimeSlot(Block_Sch.values()[start_index],Block_Sch.values()[end_index]);
						Info mondayFall = new Info(name, monday,auditorium, mondayTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\AuditoriumMondayWinterInfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(mondayFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemMon.makeRequest(mondayFall);
						System.out.println(winSemMon.display());
						
						
						int start_indexT = tuesStartBox.getSelectedIndex();
						int end_indexT = tuesEndBox.getSelectedIndex() + 1;
						if(start_indexT == 13) {
							start_indexT = tuesStartBox.getSelectedIndex() + 1;
						}
						Day tuesday = new Day(DayName.TUESDAY);
						TimeSlot tuesdayTime = new TimeSlot(Block_Sch.values()[start_indexT],Block_Sch.values()[end_indexT]);
						Info tuesFall = new Info(name, tuesday, auditorium, tuesdayTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\AuditoriumTuesdayWinterInfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(tuesFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemTues.makeRequest(tuesFall);
						System.out.println(winSemTues.display());
						
						
						
						int start_indexW = wedStartBox.getSelectedIndex();
						int end_indexW = wedEndBox.getSelectedIndex() + 1;
						if(start_indexW == 13) {
							start_indexW = wedStartBox.getSelectedIndex() + 1;
						}
						Day weds = new Day(DayName.WEDNESDAY);
						TimeSlot wedsTime = new TimeSlot(Block_Sch.values()[start_indexW],Block_Sch.values()[end_indexW]);
						Info wedsFall = new Info(name, weds, auditorium, wedsTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\AuditoriumWedsWinterInfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(wedsFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemWeds.makeRequest(wedsFall);
						System.out.println(winSemWeds.display());
						
						
						int start_indexTR = thurStartBox.getSelectedIndex();
						int end_indexTR = thurEndBox.getSelectedIndex() + 1;
						if(start_indexTR == 13) {
							start_indexTR = thurStartBox.getSelectedIndex() + 1;
						}
						Day thurs = new Day(DayName.THURSDAY);
						TimeSlot thursTime = new TimeSlot(Block_Sch.values()[start_indexTR],Block_Sch.values()[end_indexTR]);
						Info thursFall = new Info(name, thurs, auditorium, thursTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\AuditoriumThursWinterInfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(thursFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemThurs.makeRequest(thursFall);
						System.out.println(winSemThurs.display());
						
						
						int start_indexF = friStartBox.getSelectedIndex();
						int end_indexF = friEndBox.getSelectedIndex() + 1;
						if(start_indexF == 13) {
							start_indexF = friStartBox.getSelectedIndex() + 1;
						}
						Day friday = new Day(DayName.FRIDAY);
						TimeSlot fridayTime = new TimeSlot(Block_Sch.values()[start_indexF],Block_Sch.values()[end_indexF]);
						Info friFall = new Info(name, friday, auditorium, fridayTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\AuditoriumFriWinterInfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(friFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemFri.makeRequest(friFall);
						System.out.println(winSemFri.display());
						
						
						int start_indexS = satStartBox.getSelectedIndex();
						int end_indexS = satEndBox.getSelectedIndex() + 1;
						if(start_indexS == 13) {
							start_indexS = satStartBox.getSelectedIndex() + 1;
						}
						Day saturday = new Day(DayName.SATURDAY);
						TimeSlot satTime = new TimeSlot(Block_Sch.values()[start_indexS],Block_Sch.values()[end_indexS]);
						Info satFall = new Info(name, saturday, auditorium, satTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\AuditoriumSatWinterInfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(satFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemSat.makeRequest(satFall);
						System.out.println(winSemSat.display());
						
						
						
						int start_indexSS = sunStartBox.getSelectedIndex();
						int end_indexSS = sunEndBox.getSelectedIndex() + 1;
						if(start_indexSS == 13) {
							start_indexSS = sunStartBox.getSelectedIndex() + 1;
						}
						Day sunday = new Day(DayName.SUNDAY);
						TimeSlot sunTime = new TimeSlot(Block_Sch.values()[start_indexSS],Block_Sch.values()[end_indexSS]);
						Info sunFall = new Info(name, sunday, auditorium, sunTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\AuditoriumSunWinterInfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(sunFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemSun.makeRequest(sunFall);
						System.out.println(winSemSun.display());
						
					}if(rooms.getSelectedItem() == "Computer Lab") {
						Room comp = new ComputerLab();
						Day monday = new Day(DayName.MONDAY);
						int start_index = monStartBox.getSelectedIndex();
						int end_index = monEndBox.getSelectedIndex() + 1;
						if(start_index == 13) {
							start_index = monStartBox.getSelectedIndex() + 1;
						}
						TimeSlot mondayTime = new TimeSlot(Block_Sch.values()[start_index],Block_Sch.values()[end_index]);
						Info mondayFall = new Info(name, monday,comp, mondayTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\ComputerLabMondayWinterInfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(mondayFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemMon.makeRequest(mondayFall);
						System.out.println(winSemMon.display());
						
						
						int start_indexT = tuesStartBox.getSelectedIndex();
						int end_indexT = tuesEndBox.getSelectedIndex() + 1;
						if(start_indexT == 13) {
							start_indexT = tuesStartBox.getSelectedIndex() + 1;
						}
						Day tuesday = new Day(DayName.TUESDAY);
						TimeSlot tuesdayTime = new TimeSlot(Block_Sch.values()[start_indexT],Block_Sch.values()[end_indexT]);
						Info tuesFall = new Info(name, tuesday, comp, tuesdayTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\ComputerLabTuesdayWinterInfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(tuesFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemTues.makeRequest(tuesFall);
						System.out.println(winSemTues.display());
						
						
						
						int start_indexW = wedStartBox.getSelectedIndex();
						int end_indexW = wedEndBox.getSelectedIndex() + 1;
						if(start_indexW == 13) {
							start_indexW = wedStartBox.getSelectedIndex() + 1;
						}
						Day weds = new Day(DayName.WEDNESDAY);
						TimeSlot wedsTime = new TimeSlot(Block_Sch.values()[start_indexW],Block_Sch.values()[end_indexW]);
						Info wedsFall = new Info(name, weds, comp, wedsTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\ComputerLabWedsWinterInfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(wedsFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemWeds.makeRequest(wedsFall);
						System.out.println(winSemWeds.display());
						
						
						int start_indexTR = thurStartBox.getSelectedIndex();
						int end_indexTR = thurEndBox.getSelectedIndex() + 1;
						if(start_indexTR == 13) {
							start_indexTR = thurStartBox.getSelectedIndex() + 1;
						}
						Day thurs = new Day(DayName.THURSDAY);
						TimeSlot thursTime = new TimeSlot(Block_Sch.values()[start_indexTR],Block_Sch.values()[end_indexTR]);
						Info thursFall = new Info(name, thurs, comp, thursTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\ComputerLabThursWinterInfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(thursFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemThurs.makeRequest(thursFall);
						System.out.println(winSemThurs.display());
						
						
						int start_indexF = friStartBox.getSelectedIndex();
						int end_indexF = friEndBox.getSelectedIndex() + 1;
						if(start_indexF == 13) {
							start_indexF = friStartBox.getSelectedIndex() + 1;
						}
						Day friday = new Day(DayName.FRIDAY);
						TimeSlot fridayTime = new TimeSlot(Block_Sch.values()[start_indexF],Block_Sch.values()[end_indexF]);
						Info friFall = new Info(name, friday, comp, fridayTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\ComputerLabFriWinterInfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(friFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemFri.makeRequest(friFall);
						System.out.println(winSemFri.display());
						
						
						int start_indexS = satStartBox.getSelectedIndex();
						int end_indexS = satEndBox.getSelectedIndex() + 1;
						if(start_indexS == 13) {
							start_indexS = satStartBox.getSelectedIndex() + 1;
						}
						Day saturday = new Day(DayName.SATURDAY);
						TimeSlot satTime = new TimeSlot(Block_Sch.values()[start_indexS],Block_Sch.values()[end_indexS]);
						Info satFall = new Info(name, saturday, comp, satTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\ComputerLabSatWinterInfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(satFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemSat.makeRequest(satFall);
						System.out.println(winSemSat.display());
						
						
						
						int start_indexSS = sunStartBox.getSelectedIndex();
						int end_indexSS = sunEndBox.getSelectedIndex() + 1;
						if(start_indexSS == 13) {
							start_indexSS = sunStartBox.getSelectedIndex() + 1;
						}
						Day sunday = new Day(DayName.SUNDAY);
						TimeSlot sunTime = new TimeSlot(Block_Sch.values()[start_indexSS],Block_Sch.values()[end_indexSS]);
						Info sunFall = new Info(name, sunday, comp, sunTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\ComputerLabSunWinterInfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(sunFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemSun.makeRequest(sunFall);
						System.out.println(winSemSun.display());
						
					}if(rooms.getSelectedItem() == "Lecture Hall") {
						Room lect = new LectureHall();
						Day monday = new Day(DayName.MONDAY);
						int start_index = monStartBox.getSelectedIndex();
						int end_index = monEndBox.getSelectedIndex() + 1;
						if(start_index == 13) {
							start_index = monStartBox.getSelectedIndex() + 1;
						}
						TimeSlot mondayTime = new TimeSlot(Block_Sch.values()[start_index],Block_Sch.values()[end_index]);
						Info mondayFall = new Info(name, monday,lect, mondayTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\LectureHallMondayWinterInfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(mondayFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemMon.makeRequest(mondayFall);
						System.out.println(winSemMon.display());
						
						
						int start_indexT = tuesStartBox.getSelectedIndex();
						int end_indexT = tuesEndBox.getSelectedIndex() + 1;
						if(start_indexT == 13) {
							start_indexT = tuesStartBox.getSelectedIndex() + 1;
						}
						Day tuesday = new Day(DayName.TUESDAY);
						TimeSlot tuesdayTime = new TimeSlot(Block_Sch.values()[start_indexT],Block_Sch.values()[end_indexT]);
						Info tuesFall = new Info(name, tuesday, lect, tuesdayTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\LectureHallTuesdayWinterInfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(tuesFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemTues.makeRequest(tuesFall);
						System.out.println(winSemTues.display());
						
						
						
						int start_indexW = wedStartBox.getSelectedIndex();
						int end_indexW = wedEndBox.getSelectedIndex() + 1;
						if(start_indexW == 13) {
							start_indexW = wedStartBox.getSelectedIndex() + 1;
						}
						Day weds = new Day(DayName.WEDNESDAY);
						TimeSlot wedsTime = new TimeSlot(Block_Sch.values()[start_indexW],Block_Sch.values()[end_indexW]);
						Info wedsFall = new Info(name, weds, lect, wedsTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\LectureHallWedsWinterInfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(wedsFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemWeds.makeRequest(wedsFall);
						System.out.println(winSemWeds.display());
						
						
						int start_indexTR = thurStartBox.getSelectedIndex();
						int end_indexTR = thurEndBox.getSelectedIndex() + 1;
						if(start_indexTR == 13) {
							start_indexTR = thurStartBox.getSelectedIndex() + 1;
						}
						Day thurs = new Day(DayName.THURSDAY);
						TimeSlot thursTime = new TimeSlot(Block_Sch.values()[start_indexTR],Block_Sch.values()[end_indexTR]);
						Info thursFall = new Info(name, thurs, lect, thursTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\LectureHallThursWinterInfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(thursFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemThurs.makeRequest(thursFall);
						System.out.println(winSemThurs.display());
						
						
						int start_indexF = friStartBox.getSelectedIndex();
						int end_indexF = friEndBox.getSelectedIndex() + 1;
						if(start_indexF == 13) {
							start_indexF = friStartBox.getSelectedIndex() + 1;
						}
						Day friday = new Day(DayName.FRIDAY);
						TimeSlot fridayTime = new TimeSlot(Block_Sch.values()[start_indexF],Block_Sch.values()[end_indexF]);
						Info friFall = new Info(name, friday, lect, fridayTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\LectureHallFriWinterInfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(friFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemFri.makeRequest(friFall);
						System.out.println(winSemFri.display());
						
						
						int start_indexS = satStartBox.getSelectedIndex();
						int end_indexS = satEndBox.getSelectedIndex() + 1;
						if(start_indexS == 13) {
							start_indexS = satStartBox.getSelectedIndex() + 1;
						}
						Day saturday = new Day(DayName.SATURDAY);
						TimeSlot satTime = new TimeSlot(Block_Sch.values()[start_indexS],Block_Sch.values()[end_indexS]);
						Info satFall = new Info(name, saturday, lect, satTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\LectureHallSatWinterInfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(satFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemSat.makeRequest(satFall);
						System.out.println(winSemSat.display());
						
						
						
						int start_indexSS = sunStartBox.getSelectedIndex();
						int end_indexSS = sunEndBox.getSelectedIndex() + 1;
						if(start_indexSS == 13) {
							start_indexSS = sunStartBox.getSelectedIndex() + 1;
						}
						Day sunday = new Day(DayName.SUNDAY);
						TimeSlot sunTime = new TimeSlot(Block_Sch.values()[start_indexSS],Block_Sch.values()[end_indexSS]);
						Info sunFall = new Info(name, sunday, lect, sunTime);
						try {
							FileOutputStream fileOut=
									new FileOutputStream("C:\\Users\\LectureHallSunWinterInfo.ser");
							ObjectOutputStream out = new ObjectOutputStream(fileOut);
							out.writeObject(sunFall);
							out.close();
							fileOut.close();
							System.out.println("works");
						} catch (IOException i) {
							i.printStackTrace();
						}
						winSemSun.makeRequest(sunFall);
						System.out.println(winSemSun.display());
					}
				
				}else {
					System.out.println("fail");
				}
					
			}
		};
		schedSubmit.addActionListener(actionListenerSub);
		
		
		cFrame.setContentPane(test);
		cFrame.setVisible(true);
		cFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		}

	

	public static void createTimeSlotsGUI(){
		JFrame jframe = new JFrame();
		JPanel panel = new JPanel();
		JPanel listPane = new JPanel();
		final int FRAME_WIDTH = 600;
		final int FRAME_HEIGHT = 600;
		JLabel name = new JLabel();
		JLabel room = new JLabel();
		JLabel time = new JLabel();


		jframe.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		jframe.setTitle("Time Slots");




		listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));

		String[] roomSch = { "Room1", "Room2", "Room3", "Room4", "Room5" };
		String[] dateSch = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct","Nov","Dec"};
		String[] daySch = {"Mon", "Tues", "Weds", "Thurs", "Fri","Sat","Sun"};
		String nameS = "Name: ";
		String roomS = "Room: ";
		String timeS = "Time: ";
		name.setText(nameS);
		time.setText(timeS);
		room.setText(roomS);

		listPane.add(name);
		listPane.add(room);
		listPane.add(time);

		listPane.add(Box.createRigidArea(new Dimension(0,5)));

		JComboBox roomMenu = new JComboBox(roomSch);
		roomMenu.setSelectedIndex(4);

		JComboBox dayMenu = new JComboBox(daySch);
		dayMenu.setSelectedIndex(6);

		JComboBox dateMenu = new JComboBox(dateSch);
		dateMenu.setSelectedIndex(11);

		panel.add(dateMenu);
		panel.add(dayMenu);
		panel.add(roomMenu);
		panel.add(listPane);


		jframe.add(panel);
		jframe.setVisible(true);


	}
	public static void createRequestsGUI(){
		JFrame jframe = new JFrame();
		JPanel panel = new JPanel();
		JPanel listPane = new JPanel();
		final int FRAME_WIDTH = 600;
		final int FRAME_HEIGHT = 600;
		JLabel name = new JLabel();
		JLabel room = new JLabel();
		JLabel time = new JLabel();


		jframe.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		jframe.setTitle("Submitted Requests");




		listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));

		String nameS = "Name: ";
		String roomS = "Room: ";
		String timeS = "Time: ";

		name.setText(nameS);
		time.setText(timeS);
		room.setText(roomS);

		listPane.add(name);
		listPane.add(room);
		listPane.add(time);

		listPane.add(Box.createRigidArea(new Dimension(0,5)));

		panel.add(listPane);

		jframe.add(panel);
		jframe.setVisible(true);

	}

	public static void createSubmitGUI(){
		JFrame jframe = new JFrame();
		final int FRAME_WIDTH = 600;
		final int FRAME_HEIGHT = 600;
		jframe.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		jframe.setTitle("Time Slots");


		JLabel label = new JLabel();
		JPanel panel = new JPanel();
		String amSt = "am";
		String pmSt = "pm";
		String submitSch = "Submit Request";
		String[] timeSch = {"1:00", "2:00", "3:00", "4:00", "5:00", "6:00","7:00"};
		String[] roomSch = { "Room1", "Room2", "Room3", "Room4", "Room5" };
		String[] dateSch = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct","Nov","Dec"};
		String[] daySch = {"Mon", "Tues", "Weds", "Thurs", "Fri","Sat","Sun"};
		String labelSt = " - ";


		JComboBox roomMenu = new JComboBox(roomSch);
		roomMenu.setSelectedIndex(4);
		JComboBox timeMenu = new JComboBox(timeSch);

		JComboBox roomMenu1 = new JComboBox(roomSch);
		roomMenu.setSelectedIndex(4);
		JComboBox timeMenu1 = new JComboBox(timeSch);

		JButton submit = new JButton(submitSch);

		JRadioButton am = new JRadioButton(amSt);
		JRadioButton pm = new JRadioButton(pmSt);

		JRadioButton am1 = new JRadioButton(amSt);
		JRadioButton pm2 = new JRadioButton(pmSt);


		JComboBox dayMenu = new JComboBox(daySch);
		dayMenu.setSelectedIndex(6);

		JComboBox dateMenu = new JComboBox(dateSch);
		dateMenu.setSelectedIndex(11);

		panel.add(dateMenu);
		panel.add(dayMenu);

		label.setText(labelSt);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(submit);
		buttonGroup.add(pm);
		buttonGroup.add(am);




		panel.add(roomMenu);
		panel.add(timeMenu);
		panel.add(am);
		panel.add(pm);
		panel.add(label);
		panel.add(timeMenu1);
		panel.add(am1);
		panel.add(pm2);
		panel.add(submit);



		jframe.add(panel);
		jframe.setVisible(true);


	}

	public static void createViewGUI(){

		JFrame jframe = new JFrame();
		JPanel panel = new JPanel();
		JLabel label = new JLabel();
		final int FRAME_WIDTH = 600;
		final int FRAME_HEIGHT = 600;
		jframe.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		jframe.setTitle("View Schedule");



		String labelS = "This is where the created schedule will be viewed";
		label.setText(labelS);

		panel.add(label);

		jframe.add(panel);
		jframe.setVisible(true);


	}

	public static void createCalenderGUI(){

		DatePickerEX frame = new DatePickerEX();
		Datepicker schedule = new Datepicker(frame);
		frame.setVisible(true);


	}
	
	public static void createPriority2Request() {
		
		JFrame p2Frame = new JFrame();
		GridLayout p2g = new GridLayout(6, 1);
		p2Frame.setLayout(p2g);
		final int FRAME_WIDTH = 300;
		final int FRAME_HEIGHT = 600;
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
		JButton p2getTime = new JButton("Get Times");
		c.gridy = 0;
		p2Sub.add(p2getTime, c);
		JButton p2Submit = new JButton("Submit");
		c.gridy = 1;
		p2Sub.add(p2Submit, c);
	    JButton p2p2 = new JButton("Make Another Request (Priority 3)");
	    c.gridy = 2;
	    p2Sub.add(p2p2, c);
	    p2Frame.add(p2Sub);
		

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
		
		p2getTime.addActionListener(actionListener);
		p2Submit.addActionListener(actionListener);
		p2p2.addActionListener(actionListener);
		
		
		
		p2Frame.setVisible(true);
		p2Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p2name = p2NameField.getText();
		
		if (p2Fall.isSelected()) {
			p2semester = "fall";
		}
		else if (p2Winter.isSelected()){
			p2semester = "winter";
		}
		else if (p2Summer.isSelected()){
			p2semester = "summer";
		}
		
		p2room = (String) p2RoomBox.getSelectedItem();
		
		
	}
		
		public static String getName() {
			return p2name;
		}
		
		public static String getSemester() {
			return p2semester;
		}
		
		public static String getRoom() {
			return p2room;
		}
		
		
		public static void createPriority1Request() {
			JFrame p1Frame = new JFrame();
			GridLayout p1g = new GridLayout(7, 1);
			p1Frame.setVisible(true);
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
			p1Fall.setActionCommand(p1Fall.getText());
			JRadioButton p1Winter = new JRadioButton("Winter");
			p1Winter.setActionCommand(p1Winter.getText());
			p1SGroup.add(p1Fall);
			p1SGroup.add(p1Winter);
			
			c.gridy = 0;
			p1Panel2.add(p1SLabel, c);
			c.gridy = 1;
			p1Panel2.add(p1Fall, c);
			c.gridx = 1;
			p1Panel2.add(p1Winter, c);
			c.gridx = 2;
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
			//p1Panel5.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
			JLabel p1TimeLabel = new JLabel("Time:");
			JComboBox p1TimeBox = new JComboBox();
			p1TimeBox.setEnabled(false);
		    
			c.gridy = 0;
			c.gridx = 0;
			p1Panel5.add(p1TimeLabel, c);
			
			c.gridy = 1;
			c.gridx = 0;
			p1Panel5.add(p1TimeBox, c);
			p1Frame.add(p1Panel5);
			
			JPanel pPanel6 = new JPanel(new GridBagLayout());
			JLabel pPriority = new JLabel("Priority:");
			pPriority.setForeground(Color.RED);
			ButtonGroup pPGroup = new ButtonGroup();
			JRadioButton p1 = new JRadioButton("1");
			p1.setActionCommand(p1.getText());
			JRadioButton p2 = new JRadioButton("2");
			p2.setActionCommand(p2.getText());
			JRadioButton p3 = new JRadioButton("3");
			p3.setActionCommand(p3.getText());
			JRadioButton p4 = new JRadioButton("4");
			p4.setActionCommand(p4.getText());
			JRadioButton p5 = new JRadioButton("5");
			p5.setActionCommand(p5.getText());
			pPGroup.add(p1);
			pPGroup.add(p2);
			pPGroup.add(p3);
			pPGroup.add(p4);
			pPGroup.add(p5);
			
			c.gridy = 0;
			pPanel6.add(pPriority, c);
			c.gridy = 1;
			c.gridx = 1;
			pPanel6.add(p1, c);
			c.gridx = 2;
			pPanel6.add(p2, c);
			c.gridx = 3;
			pPanel6.add(p3, c);
			c.gridx = 4;
			pPanel6.add(p4, c);
			c.gridx = 5;
			pPanel6.add(p5, c);
			
			p1Frame.add(pPanel6);
			
			JPanel p1Sub = new JPanel(new GridBagLayout());
			JButton p1getTime = new JButton("Get Times");
			c.gridy = 0;
			p1Sub.add(p1getTime, c);
			JButton p1Submit = new JButton("Submit");
			c.gridy = 1;
			p1Sub.add(p1Submit, c);
		    p1Frame.add(p1Sub);
		    
		    ButtonModel buttonmodel = p1SGroup.getSelection();
		    
		    
		    ActionListener actionListenerSub = new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		String name = p1NameField.getText();
		    		String priority = pPGroup.getSelection().getActionCommand();
		    		String room = (String)p1RoomBox.getSelectedItem();
		    		String day = (String)p1DayBox.getSelectedItem();
		    		String time = (String)p1TimeBox.getSelectedItem();
		    		String semester = p1SGroup.getSelection().getActionCommand();
		    		
		    		
		    		createRequestView(name, semester, room, day, time, priority);
		    		
		    	}
		    };
		    
		    p1Submit.addActionListener(actionListenerSub);
		    
		    
		    
		    ActionListener actionListener = new ActionListener(){

			public void actionPerformed(ActionEvent e) {
					
						JButton Button = (JButton) (e.getSource());
						
							String choice = Button.getText();
							if(choice.equals("Get Times")) {
								if(p1Fall.isSelected()) {
									if(p1DayBox.getSelectedItem().equals("Monday")) {
										System.out.println("works");
										if(p1RoomBox.getSelectedItem().equals("Gym")){
											String name = "";
											Info test = null;
											try {
										         FileInputStream fileIn = new FileInputStream("C:\\Users\\csinfo.ser");
										         ObjectInputStream in = new ObjectInputStream(fileIn);
										         test = (Info) in.readObject();
										         in.close();
										         fileIn.close();
										      } catch (IOException i) {
										         i.printStackTrace();
										         return;
										      } catch (ClassNotFoundException c) {
										         System.out.println("Employee class not found");
										         c.printStackTrace();
										         return;
										      }
											ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
											for(int i = 0; i < request.size(); i++) {
												name += request.get(i).toString() + " - ";
											}
											//createViewRequests(test);
											p1TimeBox.setEnabled(true);
											p1TimeBox.removeAllItems();
											p1TimeBox.addItem(name);
											
										}if(p1RoomBox.getSelectedItem().equals("Music")) {
											String name = "";
											Info test = null;
											try {
										         FileInputStream fileIn = new FileInputStream("C:\\Users\\MusicMondayFallInfo.ser");
										         ObjectInputStream in = new ObjectInputStream(fileIn);
										         test = (Info) in.readObject();
										         in.close();
										         fileIn.close();
										      } catch (IOException i) {
										         i.printStackTrace();
										         return;
										      } catch (ClassNotFoundException c) {
										         System.out.println("Employee class not found");
										         c.printStackTrace();
										         return;
										      }
											ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
											for(int i = 0; i < request.size(); i++) {
												name += request.get(i).toString() + " - ";
											}
											p1TimeBox.setEnabled(true);
											p1TimeBox.removeAllItems();
											p1TimeBox.addItem(name);
										}if(p1RoomBox.getSelectedItem().equals("Auditorium")){
											String name = "";
											Info test = null;
											try {
										         FileInputStream fileIn = new FileInputStream("C:\\Users\\AuditoriumMondayFallInfo.ser");
										         ObjectInputStream in = new ObjectInputStream(fileIn);
										         test = (Info) in.readObject();
										         in.close();
										         fileIn.close();
										      } catch (IOException i) {
										         i.printStackTrace();
										         return;
										      } catch (ClassNotFoundException c) {
										         System.out.println("Employee class not found");
										         c.printStackTrace();
										         return;
										      }
											ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
											for(int i = 0; i < request.size(); i++) {
												name += request.get(i).toString() + " - ";
											}
											p1TimeBox.setEnabled(true);
											p1TimeBox.removeAllItems();
											p1TimeBox.addItem(name);
										}if(p1RoomBox.getSelectedItem().equals("Computer Lab")) {
											String name = "";
											Info test = null;
											try {
										         FileInputStream fileIn = new FileInputStream("C:\\Users\\ComputerLabMondayFallInfo.ser");
										         ObjectInputStream in = new ObjectInputStream(fileIn);
										         test = (Info) in.readObject();
										         in.close();
										         fileIn.close();
										      } catch (IOException i) {
										         i.printStackTrace();
										         return;
										      } catch (ClassNotFoundException c) {
										         System.out.println("Employee class not found");
										         c.printStackTrace();
										         return;
										      }
											ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
											for(int i = 0; i < request.size(); i++) {
												name += request.get(i).toString() + " - ";
											}
											p1TimeBox.setEnabled(true);
											p1TimeBox.removeAllItems();
											p1TimeBox.addItem(name);
										}if(p1RoomBox.getSelectedItem().equals("Lecture Hall")) {
											String name = "";
											Info test = null;
											try {
										         FileInputStream fileIn = new FileInputStream("C:\\Users\\LectureHallMondayFallInfo.ser");
										         ObjectInputStream in = new ObjectInputStream(fileIn);
										         test = (Info) in.readObject();
										         in.close();
										         fileIn.close();
										      } catch (IOException i) {
										         i.printStackTrace();
										         return;
										      } catch (ClassNotFoundException c) {
										         System.out.println("Employee class not found");
										         c.printStackTrace();
										         return;
										      }
											ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
											for(int i = 0; i < request.size(); i++) {
												name += request.get(i).toString() + " - ";
											}
											p1TimeBox.setEnabled(true);
											p1TimeBox.removeAllItems();
											p1TimeBox.addItem(name);
										}
										
									}if(p1DayBox.getSelectedItem().equals("Tuesday")) {
										if(p1RoomBox.getSelectedItem().equals("Gym")){
											String name = "";
											Info test = null;
											try {
										         FileInputStream fileIn = new FileInputStream("C:\\Users\\Tuesdaycsinfo.ser");
										         ObjectInputStream in = new ObjectInputStream(fileIn);
										         test = (Info) in.readObject();
										         in.close();
										         fileIn.close();
										      } catch (IOException i) {
										         i.printStackTrace();
										         return;
										      } catch (ClassNotFoundException c) {
										         System.out.println("Employee class not found");
										         c.printStackTrace();
										         return;
										      }
											ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
											for(int i = 0; i < request.size(); i++) {
												name += request.get(i).toString() + " - ";
											}
											p1TimeBox.setEnabled(true);
											p1TimeBox.removeAllItems();
											p1TimeBox.addItem(name);
											
										}if(p1RoomBox.getSelectedItem().equals("Music")) {
											String name = "";
											Info test = null;
											try {
										         FileInputStream fileIn = new FileInputStream("C:\\Users\\MusicTuesFallInfo.ser");
										         ObjectInputStream in = new ObjectInputStream(fileIn);
										         test = (Info) in.readObject();
										         in.close();
										         fileIn.close();
										      } catch (IOException i) {
										         i.printStackTrace();
										         return;
										      } catch (ClassNotFoundException c) {
										         System.out.println("Employee class not found");
										         c.printStackTrace();
										         return;
										      }
											ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
											for(int i = 0; i < request.size(); i++) {
												name += request.get(i).toString() + " - ";
											}
											p1TimeBox.setEnabled(true);
											p1TimeBox.removeAllItems();
											p1TimeBox.addItem(name);
										}if(p1RoomBox.getSelectedItem().equals("Auditorium")){
											String name = "";
											Info test = null;
											try {
										         FileInputStream fileIn = new FileInputStream("C:\\Users\\AuditoriumTuesFallInfo.ser");
										         ObjectInputStream in = new ObjectInputStream(fileIn);
										         test = (Info) in.readObject();
										         in.close();
										         fileIn.close();
										      } catch (IOException i) {
										         i.printStackTrace();
										         return;
										      } catch (ClassNotFoundException c) {
										         System.out.println("Employee class not found");
										         c.printStackTrace();
										         return;
										      }
											ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
											for(int i = 0; i < request.size(); i++) {
												name += request.get(i).toString() + " - ";
											}
											p1TimeBox.setEnabled(true);
											p1TimeBox.removeAllItems();
											p1TimeBox.addItem(name);
										}if(p1RoomBox.getSelectedItem().equals("Computer Lab")) {
											String name = "";
											Info test = null;
											try {
										         FileInputStream fileIn = new FileInputStream("C:\\Users\\ComputerLabTuesFallInfo.ser");
										         ObjectInputStream in = new ObjectInputStream(fileIn);
										         test = (Info) in.readObject();
										         in.close();
										         fileIn.close();
										      } catch (IOException i) {
										         i.printStackTrace();
										         return;
										      } catch (ClassNotFoundException c) {
										         System.out.println("Employee class not found");
										         c.printStackTrace();
										         return;
										      }
											ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
											for(int i = 0; i < request.size(); i++) {
												name += request.get(i).toString() + " - ";
											}
											p1TimeBox.setEnabled(true);
											p1TimeBox.removeAllItems();
											p1TimeBox.addItem(name);
										}if(p1RoomBox.getSelectedItem().equals("Lecture Hall")) {
											String name = "";
											Info test = null;
											try {
										         FileInputStream fileIn = new FileInputStream("C:\\Users\\LectureHallTuesFallInfo.ser");
										         ObjectInputStream in = new ObjectInputStream(fileIn);
										         test = (Info) in.readObject();
										         in.close();
										         fileIn.close();
										      } catch (IOException i) {
										         i.printStackTrace();
										         return;
										      } catch (ClassNotFoundException c) {
										         System.out.println("Employee class not found");
										         c.printStackTrace();
										         return;
										      }
											ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
											for(int i = 0; i < request.size(); i++) {
												name += request.get(i).toString() + " - ";
											}
											p1TimeBox.setEnabled(true);
											p1TimeBox.removeAllItems();
											p1TimeBox.addItem(name);
										}
									}if(p1DayBox.getSelectedItem().equals("Wednesday")) {
											if(p1RoomBox.getSelectedItem().equals("Gym")){
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\Wedscsinfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
												
											}if(p1RoomBox.getSelectedItem().equals("Music")) {
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\MusicWedsFallInfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
											}if(p1RoomBox.getSelectedItem().equals("Auditorium")){
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\AuditoriumWedsFallInfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
											}if(p1RoomBox.getSelectedItem().equals("Computer Lab")) {
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\ComputerLabWedsFallInfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
											}if(p1RoomBox.getSelectedItem().equals("Lecture Hall")) {
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\LectureHallWedsFallinfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
											}
										}if(p1DayBox.getSelectedItem().equals("Thursday")) {
											if(p1RoomBox.getSelectedItem().equals("Gym")){
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\Thurscsinfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
												
											}if(p1RoomBox.getSelectedItem().equals("Music")) {
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\MusicThursFallInfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
											}if(p1RoomBox.getSelectedItem().equals("Auditorium")){
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\AuditoriumThursFallInfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
											}if(p1RoomBox.getSelectedItem().equals("Computer Lab")) {
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\ComputerLabThursFallInfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
											}if(p1RoomBox.getSelectedItem().equals("Lecture Hall")) {
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\LectureHallThursFallinfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
											}
										}if(p1DayBox.getSelectedItem().equals("Friday")) {
											if(p1RoomBox.getSelectedItem().equals("Gym")){
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\Fridaycsinfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
												
											}if(p1RoomBox.getSelectedItem().equals("Music")) {
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\MusicFriFallInfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
											}if(p1RoomBox.getSelectedItem().equals("Auditorium")){
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\AuditoriumFriFallInfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
											}if(p1RoomBox.getSelectedItem().equals("Computer Lab")) {
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\ComputerLabFriFallInfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
											}if(p1RoomBox.getSelectedItem().equals("Lecture Hall")) {
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\LectureHallFriFallinfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
											}
										
										}if(p1DayBox.getSelectedItem().equals("Saturday")) {
											if(p1RoomBox.getSelectedItem().equals("Gym")){
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\Satcsinfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
												
											}if(p1RoomBox.getSelectedItem().equals("Music")) {
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\MusicSatFallInfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
											}if(p1RoomBox.getSelectedItem().equals("Auditorium")){
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\AuditoriumSatFallInfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
											}if(p1RoomBox.getSelectedItem().equals("Computer Lab")) {
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\ComputerLabSatFallInfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
											}if(p1RoomBox.getSelectedItem().equals("Lecture Hall")) {
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\LectureHallSatFallinfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
											}
										}if(p1DayBox.getSelectedItem().equals("Sunday")) {
											if(p1RoomBox.getSelectedItem().equals("Gym")){
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\Sundaycsinfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
												
											}if(p1RoomBox.getSelectedItem().equals("Music")) {
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\MusicSunFallInfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
											}if(p1RoomBox.getSelectedItem().equals("Auditorium")){
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\AuditoriumSunFallInfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
											}if(p1RoomBox.getSelectedItem().equals("Computer Lab")) {
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\ComputerLabSunFallInfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
											}if(p1RoomBox.getSelectedItem().equals("Lecture Hall")) {
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\LectureHallSunFallinfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
											}
										}
									}if(p1Winter.isSelected()) {
										if(p1DayBox.getSelectedItem().equals("Monday")) {
											System.out.println("works");
											if(p1RoomBox.getSelectedItem().equals("Gym")){
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\WinterMondaycsinfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												//createViewRequests(test);
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
												
											}if(p1RoomBox.getSelectedItem().equals("Music")) {
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\MusicMondayWinterInfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
											}if(p1RoomBox.getSelectedItem().equals("Auditorium")){
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\AuditoriumMondayWinterInfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
											}if(p1RoomBox.getSelectedItem().equals("Computer Lab")) {
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\ComputerLabMondayWinterInfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
											}if(p1RoomBox.getSelectedItem().equals("Lecture Hall")) {
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\LectureHallMondayWinterInfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
											}
											
										}if(p1DayBox.getSelectedItem().equals("Tuesday")) {
											if(p1RoomBox.getSelectedItem().equals("Gym")){
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\TuesdayWintercsinfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
												
											}if(p1RoomBox.getSelectedItem().equals("Music")) {
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\MusicTuesWinterInfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
											}if(p1RoomBox.getSelectedItem().equals("Auditorium")){
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\AuditoriumTuesWinterInfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
											}if(p1RoomBox.getSelectedItem().equals("Computer Lab")) {
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\ComputerLabTuesWinterInfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
											}if(p1RoomBox.getSelectedItem().equals("Lecture Hall")) {
												String name = "";
												Info test = null;
												try {
											         FileInputStream fileIn = new FileInputStream("C:\\Users\\LectureHallTuesWinterInfo.ser");
											         ObjectInputStream in = new ObjectInputStream(fileIn);
											         test = (Info) in.readObject();
											         in.close();
											         fileIn.close();
											      } catch (IOException i) {
											         i.printStackTrace();
											         return;
											      } catch (ClassNotFoundException c) {
											         System.out.println("Employee class not found");
											         c.printStackTrace();
											         return;
											      }
												ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
												for(int i = 0; i < request.size(); i++) {
													name += request.get(i).toString() + " - ";
												}
												p1TimeBox.setEnabled(true);
												p1TimeBox.removeAllItems();
												p1TimeBox.addItem(name);
											}
										}if(p1DayBox.getSelectedItem().equals("Wednesday")) {
												if(p1RoomBox.getSelectedItem().equals("Gym")){
													String name = "";
													Info test = null;
													try {
												         FileInputStream fileIn = new FileInputStream("C:\\Users\\WedsWintercsinfo.ser");
												         ObjectInputStream in = new ObjectInputStream(fileIn);
												         test = (Info) in.readObject();
												         in.close();
												         fileIn.close();
												      } catch (IOException i) {
												         i.printStackTrace();
												         return;
												      } catch (ClassNotFoundException c) {
												         System.out.println("Employee class not found");
												         c.printStackTrace();
												         return;
												      }
													ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
													for(int i = 0; i < request.size(); i++) {
														name += request.get(i).toString() + " - ";
													}
													p1TimeBox.setEnabled(true);
													p1TimeBox.removeAllItems();
													p1TimeBox.addItem(name);
													
												}if(p1RoomBox.getSelectedItem().equals("Music")) {
													String name = "";
													Info test = null;
													try {
												         FileInputStream fileIn = new FileInputStream("C:\\Users\\MusicWedsWinterInfo.ser");
												         ObjectInputStream in = new ObjectInputStream(fileIn);
												         test = (Info) in.readObject();
												         in.close();
												         fileIn.close();
												      } catch (IOException i) {
												         i.printStackTrace();
												         return;
												      } catch (ClassNotFoundException c) {
												         System.out.println("Employee class not found");
												         c.printStackTrace();
												         return;
												      }
													ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
													for(int i = 0; i < request.size(); i++) {
														name += request.get(i).toString() + " - ";
													}
													p1TimeBox.setEnabled(true);
													p1TimeBox.removeAllItems();
													p1TimeBox.addItem(name);
												}if(p1RoomBox.getSelectedItem().equals("Auditorium")){
													String name = "";
													Info test = null;
													try {
												         FileInputStream fileIn = new FileInputStream("C:\\Users\\AuditoriumWedsWinterInfo.ser");
												         ObjectInputStream in = new ObjectInputStream(fileIn);
												         test = (Info) in.readObject();
												         in.close();
												         fileIn.close();
												      } catch (IOException i) {
												         i.printStackTrace();
												         return;
												      } catch (ClassNotFoundException c) {
												         System.out.println("Employee class not found");
												         c.printStackTrace();
												         return;
												      }
													ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
													for(int i = 0; i < request.size(); i++) {
														name += request.get(i).toString() + " - ";
													}
													p1TimeBox.setEnabled(true);
													p1TimeBox.removeAllItems();
													p1TimeBox.addItem(name);
												}if(p1RoomBox.getSelectedItem().equals("Computer Lab")) {
													String name = "";
													Info test = null;
													try {
												         FileInputStream fileIn = new FileInputStream("C:\\Users\\ComputerLabWedsWinterInfo.ser");
												         ObjectInputStream in = new ObjectInputStream(fileIn);
												         test = (Info) in.readObject();
												         in.close();
												         fileIn.close();
												      } catch (IOException i) {
												         i.printStackTrace();
												         return;
												      } catch (ClassNotFoundException c) {
												         System.out.println("Employee class not found");
												         c.printStackTrace();
												         return;
												      }
													ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
													for(int i = 0; i < request.size(); i++) {
														name += request.get(i).toString() + " - ";
													}
													p1TimeBox.setEnabled(true);
													p1TimeBox.removeAllItems();
													p1TimeBox.addItem(name);
												}if(p1RoomBox.getSelectedItem().equals("Lecture Hall")) {
													String name = "";
													Info test = null;
													try {
												         FileInputStream fileIn = new FileInputStream("C:\\Users\\LectureHallWedsWinterinfo.ser");
												         ObjectInputStream in = new ObjectInputStream(fileIn);
												         test = (Info) in.readObject();
												         in.close();
												         fileIn.close();
												      } catch (IOException i) {
												         i.printStackTrace();
												         return;
												      } catch (ClassNotFoundException c) {
												         System.out.println("Employee class not found");
												         c.printStackTrace();
												         return;
												      }
													ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
													for(int i = 0; i < request.size(); i++) {
														name += request.get(i).toString() + " - ";
													}
													p1TimeBox.setEnabled(true);
													p1TimeBox.removeAllItems();
													p1TimeBox.addItem(name);
												}
											}if(p1DayBox.getSelectedItem().equals("Thursday")) {
												if(p1RoomBox.getSelectedItem().equals("Gym")){
													String name = "";
													Info test = null;
													try {
												         FileInputStream fileIn = new FileInputStream("C:\\Users\\ThursWintercsinfo.ser");
												         ObjectInputStream in = new ObjectInputStream(fileIn);
												         test = (Info) in.readObject();
												         in.close();
												         fileIn.close();
												      } catch (IOException i) {
												         i.printStackTrace();
												         return;
												      } catch (ClassNotFoundException c) {
												         System.out.println("Employee class not found");
												         c.printStackTrace();
												         return;
												      }
													ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
													for(int i = 0; i < request.size(); i++) {
														name += request.get(i).toString() + " - ";
													}
													p1TimeBox.setEnabled(true);
													p1TimeBox.removeAllItems();
													p1TimeBox.addItem(name);
													
												}if(p1RoomBox.getSelectedItem().equals("Music")) {
													String name = "";
													Info test = null;
													try {
												         FileInputStream fileIn = new FileInputStream("C:\\Users\\MusicThursWinterInfo.ser");
												         ObjectInputStream in = new ObjectInputStream(fileIn);
												         test = (Info) in.readObject();
												         in.close();
												         fileIn.close();
												      } catch (IOException i) {
												         i.printStackTrace();
												         return;
												      } catch (ClassNotFoundException c) {
												         System.out.println("Employee class not found");
												         c.printStackTrace();
												         return;
												      }
													ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
													for(int i = 0; i < request.size(); i++) {
														name += request.get(i).toString() + " - ";
													}
													p1TimeBox.setEnabled(true);
													p1TimeBox.removeAllItems();
													p1TimeBox.addItem(name);
												}if(p1RoomBox.getSelectedItem().equals("Auditorium")){
													String name = "";
													Info test = null;
													try {
												         FileInputStream fileIn = new FileInputStream("C:\\Users\\AuditoriumThursWinterInfo.ser");
												         ObjectInputStream in = new ObjectInputStream(fileIn);
												         test = (Info) in.readObject();
												         in.close();
												         fileIn.close();
												      } catch (IOException i) {
												         i.printStackTrace();
												         return;
												      } catch (ClassNotFoundException c) {
												         System.out.println("Employee class not found");
												         c.printStackTrace();
												         return;
												      }
													ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
													for(int i = 0; i < request.size(); i++) {
														name += request.get(i).toString() + " - ";
													}
													p1TimeBox.setEnabled(true);
													p1TimeBox.removeAllItems();
													p1TimeBox.addItem(name);
												}if(p1RoomBox.getSelectedItem().equals("Computer Lab")) {
													String name = "";
													Info test = null;
													try {
												         FileInputStream fileIn = new FileInputStream("C:\\Users\\ComputerLabThursWinterInfo.ser");
												         ObjectInputStream in = new ObjectInputStream(fileIn);
												         test = (Info) in.readObject();
												         in.close();
												         fileIn.close();
												      } catch (IOException i) {
												         i.printStackTrace();
												         return;
												      } catch (ClassNotFoundException c) {
												         System.out.println("Employee class not found");
												         c.printStackTrace();
												         return;
												      }
													ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
													for(int i = 0; i < request.size(); i++) {
														name += request.get(i).toString() + " - ";
													}
													p1TimeBox.setEnabled(true);
													p1TimeBox.removeAllItems();
													p1TimeBox.addItem(name);
												}if(p1RoomBox.getSelectedItem().equals("Lecture Hall")) {
													String name = "";
													Info test = null;
													try {
												         FileInputStream fileIn = new FileInputStream("C:\\Users\\LectureHallThursWinterinfo.ser");
												         ObjectInputStream in = new ObjectInputStream(fileIn);
												         test = (Info) in.readObject();
												         in.close();
												         fileIn.close();
												      } catch (IOException i) {
												         i.printStackTrace();
												         return;
												      } catch (ClassNotFoundException c) {
												         System.out.println("Employee class not found");
												         c.printStackTrace();
												         return;
												      }
													ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
													for(int i = 0; i < request.size(); i++) {
														name += request.get(i).toString() + " - ";
													}
													p1TimeBox.setEnabled(true);
													p1TimeBox.removeAllItems();
													p1TimeBox.addItem(name);
												}
											}if(p1DayBox.getSelectedItem().equals("Friday")) {
												if(p1RoomBox.getSelectedItem().equals("Gym")){
													String name = "";
													Info test = null;
													try {
												         FileInputStream fileIn = new FileInputStream("C:\\Users\\FriWintercsinfo.ser");
												         ObjectInputStream in = new ObjectInputStream(fileIn);
												         test = (Info) in.readObject();
												         in.close();
												         fileIn.close();
												      } catch (IOException i) {
												         i.printStackTrace();
												         return;
												      } catch (ClassNotFoundException c) {
												         System.out.println("Employee class not found");
												         c.printStackTrace();
												         return;
												      }
													ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
													for(int i = 0; i < request.size(); i++) {
														name += request.get(i).toString() + " - ";
													}
													p1TimeBox.setEnabled(true);
													p1TimeBox.removeAllItems();
													p1TimeBox.addItem(name);
													
												}if(p1RoomBox.getSelectedItem().equals("Music")) {
													String name = "";
													Info test = null;
													try {
												         FileInputStream fileIn = new FileInputStream("C:\\Users\\MusicFriWinterInfo.ser");
												         ObjectInputStream in = new ObjectInputStream(fileIn);
												         test = (Info) in.readObject();
												         in.close();
												         fileIn.close();
												      } catch (IOException i) {
												         i.printStackTrace();
												         return;
												      } catch (ClassNotFoundException c) {
												         System.out.println("Employee class not found");
												         c.printStackTrace();
												         return;
												      }
													ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
													for(int i = 0; i < request.size(); i++) {
														name += request.get(i).toString() + " - ";
													}
													p1TimeBox.setEnabled(true);
													p1TimeBox.removeAllItems();
													p1TimeBox.addItem(name);
												}if(p1RoomBox.getSelectedItem().equals("Auditorium")){
													String name = "";
													Info test = null;
													try {
												         FileInputStream fileIn = new FileInputStream("C:\\Users\\AuditoriumFriWinterInfo.ser");
												         ObjectInputStream in = new ObjectInputStream(fileIn);
												         test = (Info) in.readObject();
												         in.close();
												         fileIn.close();
												      } catch (IOException i) {
												         i.printStackTrace();
												         return;
												      } catch (ClassNotFoundException c) {
												         System.out.println("Employee class not found");
												         c.printStackTrace();
												         return;
												      }
													ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
													for(int i = 0; i < request.size(); i++) {
														name += request.get(i).toString() + " - ";
													}
													p1TimeBox.setEnabled(true);
													p1TimeBox.removeAllItems();
													p1TimeBox.addItem(name);
												}if(p1RoomBox.getSelectedItem().equals("Computer Lab")) {
													String name = "";
													Info test = null;
													try {
												         FileInputStream fileIn = new FileInputStream("C:\\Users\\ComputerLabFriWinterInfo.ser");
												         ObjectInputStream in = new ObjectInputStream(fileIn);
												         test = (Info) in.readObject();
												         in.close();
												         fileIn.close();
												      } catch (IOException i) {
												         i.printStackTrace();
												         return;
												      } catch (ClassNotFoundException c) {
												         System.out.println("Employee class not found");
												         c.printStackTrace();
												         return;
												      }
													ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
													for(int i = 0; i < request.size(); i++) {
														name += request.get(i).toString() + " - ";
													}
													p1TimeBox.setEnabled(true);
													p1TimeBox.removeAllItems();
													p1TimeBox.addItem(name);
												}if(p1RoomBox.getSelectedItem().equals("Lecture Hall")) {
													String name = "";
													Info test = null;
													try {
												         FileInputStream fileIn = new FileInputStream("C:\\Users\\LectureHallFriWinterinfo.ser");
												         ObjectInputStream in = new ObjectInputStream(fileIn);
												         test = (Info) in.readObject();
												         in.close();
												         fileIn.close();
												      } catch (IOException i) {
												         i.printStackTrace();
												         return;
												      } catch (ClassNotFoundException c) {
												         System.out.println("Employee class not found");
												         c.printStackTrace();
												         return;
												      }
													ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
													for(int i = 0; i < request.size(); i++) {
														name += request.get(i).toString() + " - ";
													}
													p1TimeBox.setEnabled(true);
													p1TimeBox.removeAllItems();
													p1TimeBox.addItem(name);
												}
											}if(p1DayBox.getSelectedItem().equals("Saturday")) {
												if(p1RoomBox.getSelectedItem().equals("Gym")){
													String name = "";
													Info test = null;
													try {
												         FileInputStream fileIn = new FileInputStream("C:\\Users\\WinterSatcsinfo.ser");
												         ObjectInputStream in = new ObjectInputStream(fileIn);
												         test = (Info) in.readObject();
												         in.close();
												         fileIn.close();
												      } catch (IOException i) {
												         i.printStackTrace();
												         return;
												      } catch (ClassNotFoundException c) {
												         System.out.println("Employee class not found");
												         c.printStackTrace();
												         return;
												      }
													ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
													for(int i = 0; i < request.size(); i++) {
														name += request.get(i).toString() + " - ";
													}
													p1TimeBox.setEnabled(true);
													p1TimeBox.removeAllItems();
													p1TimeBox.addItem(name);
													
												}if(p1RoomBox.getSelectedItem().equals("Music")) {
													String name = "";
													Info test = null;
													try {
												         FileInputStream fileIn = new FileInputStream("C:\\Users\\MusicSatWinterInfo.ser");
												         ObjectInputStream in = new ObjectInputStream(fileIn);
												         test = (Info) in.readObject();
												         in.close();
												         fileIn.close();
												      } catch (IOException i) {
												         i.printStackTrace();
												         return;
												      } catch (ClassNotFoundException c) {
												         System.out.println("Employee class not found");
												         c.printStackTrace();
												         return;
												      }
													ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
													for(int i = 0; i < request.size(); i++) {
														name += request.get(i).toString() + " - ";
													}
													p1TimeBox.setEnabled(true);
													p1TimeBox.removeAllItems();
													p1TimeBox.addItem(name);
												}if(p1RoomBox.getSelectedItem().equals("Auditorium")){
													String name = "";
													Info test = null;
													try {
												         FileInputStream fileIn = new FileInputStream("C:\\Users\\AuditoriumSatWinterInfo.ser");
												         ObjectInputStream in = new ObjectInputStream(fileIn);
												         test = (Info) in.readObject();
												         in.close();
												         fileIn.close();
												      } catch (IOException i) {
												         i.printStackTrace();
												         return;
												      } catch (ClassNotFoundException c) {
												         System.out.println("Employee class not found");
												         c.printStackTrace();
												         return;
												      }
													ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
													for(int i = 0; i < request.size(); i++) {
														name += request.get(i).toString() + " - ";
													}
													p1TimeBox.setEnabled(true);
													p1TimeBox.removeAllItems();
													p1TimeBox.addItem(name);
												}if(p1RoomBox.getSelectedItem().equals("Computer Lab")) {
													String name = "";
													Info test = null;
													try {
												         FileInputStream fileIn = new FileInputStream("C:\\Users\\ComputerLabSatWinterInfo.ser");
												         ObjectInputStream in = new ObjectInputStream(fileIn);
												         test = (Info) in.readObject();
												         in.close();
												         fileIn.close();
												      } catch (IOException i) {
												         i.printStackTrace();
												         return;
												      } catch (ClassNotFoundException c) {
												         System.out.println("Employee class not found");
												         c.printStackTrace();
												         return;
												      }
													ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
													for(int i = 0; i < request.size(); i++) {
														name += request.get(i).toString() + " - ";
													}
													p1TimeBox.setEnabled(true);
													p1TimeBox.removeAllItems();
													p1TimeBox.addItem(name);
												}if(p1RoomBox.getSelectedItem().equals("Lecture Hall")) {
													String name = "";
													Info test = null;
													try {
												         FileInputStream fileIn = new FileInputStream("C:\\Users\\LectureHallSatWinterInfo.ser");
												         ObjectInputStream in = new ObjectInputStream(fileIn);
												         test = (Info) in.readObject();
												         in.close();
												         fileIn.close();
												      } catch (IOException i) {
												         i.printStackTrace();
												         return;
												      } catch (ClassNotFoundException c) {
												         System.out.println("Employee class not found");
												         c.printStackTrace();
												         return;
												      }
													ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
													for(int i = 0; i < request.size(); i++) {
														name += request.get(i).toString() + " - ";
													}
													p1TimeBox.setEnabled(true);
													p1TimeBox.removeAllItems();
													p1TimeBox.addItem(name);
												}
											}if(p1DayBox.getSelectedItem().equals("Sunday")) {
												if(p1RoomBox.getSelectedItem().equals("Gym")){
													String name = "";
													Info test = null;
													try {
												         FileInputStream fileIn = new FileInputStream("C:\\Users\\SundayWintercsinfo.ser");
												         ObjectInputStream in = new ObjectInputStream(fileIn);
												         test = (Info) in.readObject();
												         in.close();
												         fileIn.close();
												      } catch (IOException i) {
												         i.printStackTrace();
												         return;
												      } catch (ClassNotFoundException c) {
												         System.out.println("Employee class not found");
												         c.printStackTrace();
												         return;
												      }
													ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
													for(int i = 0; i < request.size(); i++) {
														name += request.get(i).toString() + " - ";
													}
													p1TimeBox.setEnabled(true);
													p1TimeBox.removeAllItems();
													p1TimeBox.addItem(name);
													
												}if(p1RoomBox.getSelectedItem().equals("Music")) {
													String name = "";
													Info test = null;
													try {
												         FileInputStream fileIn = new FileInputStream("C:\\Users\\MusicSunWinterInfo.ser");
												         ObjectInputStream in = new ObjectInputStream(fileIn);
												         test = (Info) in.readObject();
												         in.close();
												         fileIn.close();
												      } catch (IOException i) {
												         i.printStackTrace();
												         return;
												      } catch (ClassNotFoundException c) {
												         System.out.println("Employee class not found");
												         c.printStackTrace();
												         return;
												      }
													ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
													for(int i = 0; i < request.size(); i++) {
														name += request.get(i).toString() + " - ";
													}
													p1TimeBox.setEnabled(true);
													p1TimeBox.removeAllItems();
													p1TimeBox.addItem(name);
												}if(p1RoomBox.getSelectedItem().equals("Auditorium")){
													String name = "";
													Info test = null;
													try {
												         FileInputStream fileIn = new FileInputStream("C:\\Users\\AuditoriumSunWinterInfo.ser");
												         ObjectInputStream in = new ObjectInputStream(fileIn);
												         test = (Info) in.readObject();
												         in.close();
												         fileIn.close();
												      } catch (IOException i) {
												         i.printStackTrace();
												         return;
												      } catch (ClassNotFoundException c) {
												         System.out.println("Employee class not found");
												         c.printStackTrace();
												         return;
												      }
													ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
													for(int i = 0; i < request.size(); i++) {
														name += request.get(i).toString() + " - ";
													}
													p1TimeBox.setEnabled(true);
													p1TimeBox.removeAllItems();
													p1TimeBox.addItem(name);
												}if(p1RoomBox.getSelectedItem().equals("Computer Lab")) {
													String name = "";
													Info test = null;
													try {
												         FileInputStream fileIn = new FileInputStream("C:\\Users\\ComputerLabSunWinterInfo.ser");
												         ObjectInputStream in = new ObjectInputStream(fileIn);
												         test = (Info) in.readObject();
												         in.close();
												         fileIn.close();
												      } catch (IOException i) {
												         i.printStackTrace();
												         return;
												      } catch (ClassNotFoundException c) {
												         System.out.println("Employee class not found");
												         c.printStackTrace();
												         return;
												      }
													ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
													for(int i = 0; i < request.size(); i++) {
														name += request.get(i).toString() + " - ";
													}
													String s = name;
													p1TimeBox.setEnabled(true);
													p1TimeBox.removeAllItems();
													p1TimeBox.addItem(name);
												}if(p1RoomBox.getSelectedItem().equals("Lecture Hall")) {
													String name = "";
													Info test = null;
													try {
												         FileInputStream fileIn = new FileInputStream("C:\\Users\\LectureHallSunWinterInfo.ser");
												         ObjectInputStream in = new ObjectInputStream(fileIn);
												         test = (Info) in.readObject();
												         in.close();
												         fileIn.close();
												      } catch (IOException i) {
												         i.printStackTrace();
												         return;
												      } catch (ClassNotFoundException c) {
												         System.out.println("Employee class not found");
												         c.printStackTrace();
												         return;
												      }
													ArrayList<Block_Sch> request = test.getTheTimeSlot().getRange();
													for(int i = 0; i < request.size(); i++) {
														name += request.get(i).toString() + " - ";
													}
													String s = name;
													fixTime(s);
													p1TimeBox.setEnabled(true);
													p1TimeBox.removeAllItems();
													p1TimeBox.addItem(name);
												}
											}
										}
								}
							}
						
					
					
				
				
			};
			
			
			p1getTime.addActionListener(actionListener);
			p1Submit.addActionListener(actionListener);
			
			
			
			p1Frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			
			p1name = p1NameField.getText();
			if (p1Fall.isSelected()) {
				p1semester = "fall";
			}
			else if (p1Winter.isSelected()){
				p1semester = "winter";
			}
			
			
			p1room = (String) p1RoomBox.getSelectedItem();
			
			
		}
			
			public static String getP1Name() {
				return p1name;
			}
			
			public static String getP1Semester() {
				return p1semester;
			}
			
			public static String getP1Room() {
				return p1room;
			}
		public static void createRequestView(String name, String semester, String room, String day, String time, String priority) {
			JFrame jframe = new JFrame();
			JPanel panel = new JPanel();
			JLabel label = new JLabel();
			field.setEditable(false);
			
			String oldText = field.getText();
			String newText = oldText + "\nName: " + name + "\n" + "Semester: " + semester + "\n" +"Room: " + room + "\n" +"Day: " + day + "\n" +"Time: " + time + "\n" +"Priority: " +  priority + "\n";
			field.setText(newText);
			String labelText = "Submitted Requests: ";
			label.setText(labelText);
			
			
			final int FRAME_WIDTH = 600;
			final int FRAME_HEIGHT = 600;
			jframe.setSize(FRAME_WIDTH, FRAME_HEIGHT);
			jframe.setTitle("Submitted Requests");


			
			
			

			panel.add(label);
			panel.add(field);

			jframe.add(panel);
			jframe.setVisible(true);

		}
	
		public static void fixTime(String s) {
			  String s1 = "";
			  String s2 = "";
			  String s3 = "";
			  String s4 = "";
			  String s5 = "";
			  String s6 = "";
			  String s7 = "";
			  String s8 = "";
			  String s9 = "";
			  String s10 = "";
			  String s11 = "";
			  String s12 = "";
			  String s13 = "";



			if (s.length() == 14) {
			  s1 = s.substring(0,11);
			  	
			  }
			if (s.length() == 21) {
			  s1 = s.substring(0,11);
			  s2 = s.substring(7,18);
			  }

			if (s.length() == 28) {
			  s1 = s.substring(0,11);
			  s2 = s.substring(7,18);
			  s3 = s.substring(14, 25);

			}
			if (s.length() == 35) {
			  s1 = s.substring(0,11);
			  s2 = s.substring(7,18);
			  s3 = s.substring(14, 25);
			  s4 = s.substring(21, 32);


			}
			if (s.length() == 42) {
			  s1 = s.substring(0,11);
			  s2 = s.substring(7,18);
			  s3 = s.substring(14, 25);
			  s4 = s.substring(21, 32);
			  s5 = s.substring(28, 39);


			}
			if (s.length() == 49) {
			  s1 = s.substring(0,11);
			  s2 = s.substring(7,18);
			  s3 = s.substring(14, 25);
			  s4 = s.substring(21, 32);
			  s5 = s.substring(28, 39);
			  s6 = s.substring(35, 46);


			}
			if (s.length() == 56) {
			  s1 = s.substring(0,11);
			  s2 = s.substring(7,18);
			  s3 = s.substring(14, 25);
			  s4 = s.substring(21, 32);
			  s5 = s.substring(28, 39);
			  s6 = s.substring(35, 46);
			  s7 = s.substring(42, 53);


			}
			if (s.length() == 63) {
			  s1 = s.substring(0,11);
			  s2 = s.substring(7,18);
			  s3 = s.substring(14, 25);
			  s4 = s.substring(21, 32);
			  s5 = s.substring(28, 39);
			  s6 = s.substring(35, 46);
			  s7 = s.substring(42, 53);
			  s8 = s.substring(49, 60);


			}
			if (s.length() == 70) {
			  s1 = s.substring(0,11);
			  s2 = s.substring(7,18);
			  s3 = s.substring(14, 25);
			  s4 = s.substring(21, 32);
			  s5 = s.substring(28, 39);
			  s6 = s.substring(35, 46);
			  s7 = s.substring(42, 53);
			  s8 = s.substring(49, 60);
			  s9 = s.substring(56, 67);



			}
			if (s.length() == 77) {
			  s1 = s.substring(0,11);
			  s2 = s.substring(7,18);
			  s3 = s.substring(14, 25);
			  s4 = s.substring(21, 32);
			  s5 = s.substring(28, 39);
			  s6 = s.substring(35, 46);
			  s7 = s.substring(42, 53);
			  s8 = s.substring(49, 60);
			  s9 = s.substring(56, 67);
			  s10 = s.substring(63, 74);




			}
			if (s.length() == 84) {
			  s1 = s.substring(0,11);
			  s2 = s.substring(7,18);
			  s3 = s.substring(14, 25);
			  s4 = s.substring(21, 32);
			  s5 = s.substring(28, 39);
			  s6 = s.substring(35, 46);
			  s7 = s.substring(42, 53);
			  s8 = s.substring(49, 60);
			  s9 = s.substring(56, 67);
			  s10 = s.substring(63, 74);
			  s11 = s.substring(70, 81);



			}
			if (s.length() == 91) {
			  s1 = s.substring(0,11);
			  s2 = s.substring(7,18);
			  s3 = s.substring(14, 25);
			  s4 = s.substring(21, 32);
			  s5 = s.substring(28, 39);
			  s6 = s.substring(35, 46);
			  s7 = s.substring(42, 53);
			  s8 = s.substring(49, 60);
			  s9 = s.substring(56, 67);
			  s10 = s.substring(63, 74);
			  s11 = s.substring(70, 81);
			  s12 = s.substring(77, 88);



			}
			if (s.length() == 98) {
			  s1 = s.substring(0,11);
			  s2 = s.substring(7,18);
			  s3 = s.substring(14, 25);
			  s4 = s.substring(21, 32);
			  s5 = s.substring(28, 39);
			  s6 = s.substring(35, 46);
			  s7 = s.substring(42, 53);
			  s8 = s.substring(49, 60);
			  s9 = s.substring(56, 67);
			  s10 = s.substring(63, 74);
			  s11 = s.substring(70, 81);
			  s12 = s.substring(77, 88);
			  s13 = s.substring(84, 95);

			  
			}
		}
}

	

