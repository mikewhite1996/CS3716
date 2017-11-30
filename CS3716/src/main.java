

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
			createViewGUI();
		}else if(answer2.equals("View Time Slots")){
			createTimeSlotsGUI();
		}else if(answer2.equals("View Requests")){
			createRequestsGUI();
			// change to select a semesterGUI
			// used to be createSubmitGUI();
		}else if(answer2.equals("Submit a Request")){
			dayOrSemesterGUI();
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
		JButton view = new JButton(viewString);
		JButton time = new JButton(timeString);
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
		view.addActionListener(actionListener);
		time.addActionListener(actionListener);
		requests.addActionListener(actionListener);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(requests);
		buttonGroup.add(time);
		buttonGroup.add(schedule);
		buttonGroup.add(view);

		panel.add(schedule);
		panel.add(time);
		panel.add(view);
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
		String viewCScheduleString = "View Schedule";

		JButton submitReq = new JButton(subreqString);
		JButton viewSch = new JButton(viewCScheduleString);

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
		viewSch.addActionListener(actionListener);


		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(submitReq);
		buttonGroup.add(viewSch);


		panel.add(submitReq);
		panel.add(viewSch);


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
						Day tuesday = new Day(DayName.TUESDAY);
						TimeSlot tuesdayTime = new TimeSlot(Block_Sch.values()[start_indexT],Block_Sch.values()[end_indexT]);
						Info tuesFall = new Info(name, tuesday, auditorium, tuesdayTime);
						fallSemTues.makeRequest(tuesFall);
						System.out.println(fallSemTues.display());
						
						
						
						int start_indexW = wedStartBox.getSelectedIndex();
						int end_indexW = wedEndBox.getSelectedIndex() + 1;
						Day weds = new Day(DayName.WEDNESDAY);
						TimeSlot wedsTime = new TimeSlot(Block_Sch.values()[start_indexW],Block_Sch.values()[end_indexW]);
						Info wedsFall = new Info(name, weds, auditorium, wedsTime);
						fallSemWeds.makeRequest(wedsFall);
						System.out.println(fallSemWeds.display());
						
						
						int start_indexTR = thurStartBox.getSelectedIndex();
						int end_indexTR = thurEndBox.getSelectedIndex() + 1;
						Day thurs = new Day(DayName.THURSDAY);
						TimeSlot thursTime = new TimeSlot(Block_Sch.values()[start_indexTR],Block_Sch.values()[end_indexTR]);
						Info thursFall = new Info(name, thurs, auditorium, thursTime);
						fallSemThurs.makeRequest(thursFall);
						System.out.println(fallSemThurs.display());
						
						
						int start_indexF = friStartBox.getSelectedIndex();
						int end_indexF = friEndBox.getSelectedIndex() + 1;
						Day friday = new Day(DayName.FRIDAY);
						TimeSlot fridayTime = new TimeSlot(Block_Sch.values()[start_indexF],Block_Sch.values()[end_indexF]);
						Info friFall = new Info(name, friday, auditorium, fridayTime);
						fallSemFri.makeRequest(friFall);
						System.out.println(fallSemFri.display());
						
						
						int start_indexS = satStartBox.getSelectedIndex();
						int end_indexS = satEndBox.getSelectedIndex() + 1;
						Day saturday = new Day(DayName.SATURDAY);
						TimeSlot satTime = new TimeSlot(Block_Sch.values()[start_indexS],Block_Sch.values()[end_indexS]);
						Info satFall = new Info(name, saturday, auditorium, satTime);
						fallSemSat.makeRequest(satFall);
						System.out.println(fallSemSat.display());
						
						
						
						int start_indexSS = sunStartBox.getSelectedIndex();
						int end_indexSS = sunEndBox.getSelectedIndex() + 1;
						Day sunday = new Day(DayName.SUNDAY);
						TimeSlot sunTime = new TimeSlot(Block_Sch.values()[start_indexSS],Block_Sch.values()[end_indexSS]);
						Info sunFall = new Info(name, sunday, auditorium, sunTime);
						fallSemSun.makeRequest(sunFall);
						System.out.println(fallSemSun.display());
						
					}if(rooms.getSelectedItem() == "Computer Lab") {
						Room comp = new ComputerLab();
						Day monday = new Day(DayName.MONDAY);
						int start_index = monStartBox.getSelectedIndex();
						int end_index = monEndBox.getSelectedIndex() + 1;
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
						Day tuesday = new Day(DayName.TUESDAY);
						TimeSlot tuesdayTime = new TimeSlot(Block_Sch.values()[start_indexT],Block_Sch.values()[end_indexT]);
						Info tuesFall = new Info(name, tuesday, comp, tuesdayTime);
						fallSemTues.makeRequest(tuesFall);
						System.out.println(fallSemTues.display());
						
						
						
						int start_indexW = wedStartBox.getSelectedIndex();
						int end_indexW = wedEndBox.getSelectedIndex() + 1;
						Day weds = new Day(DayName.WEDNESDAY);
						TimeSlot wedsTime = new TimeSlot(Block_Sch.values()[start_indexW],Block_Sch.values()[end_indexW]);
						Info wedsFall = new Info(name, weds, comp, wedsTime);
						fallSemWeds.makeRequest(wedsFall);
						System.out.println(fallSemWeds.display());
						
						
						int start_indexTR = thurStartBox.getSelectedIndex();
						int end_indexTR = thurEndBox.getSelectedIndex() + 1;
						Day thurs = new Day(DayName.THURSDAY);
						TimeSlot thursTime = new TimeSlot(Block_Sch.values()[start_indexTR],Block_Sch.values()[end_indexTR]);
						Info thursFall = new Info(name, thurs, comp, thursTime);
						fallSemThurs.makeRequest(thursFall);
						System.out.println(fallSemThurs.display());
						
						
						int start_indexF = friStartBox.getSelectedIndex();
						int end_indexF = friEndBox.getSelectedIndex() + 1;
						Day friday = new Day(DayName.FRIDAY);
						TimeSlot fridayTime = new TimeSlot(Block_Sch.values()[start_indexF],Block_Sch.values()[end_indexF]);
						Info friFall = new Info(name, friday, comp, fridayTime);
						fallSemFri.makeRequest(friFall);
						System.out.println(fallSemFri.display());
						
						
						int start_indexS = satStartBox.getSelectedIndex();
						int end_indexS = satEndBox.getSelectedIndex() + 1;
						Day saturday = new Day(DayName.SATURDAY);
						TimeSlot satTime = new TimeSlot(Block_Sch.values()[start_indexS],Block_Sch.values()[end_indexS]);
						Info satFall = new Info(name, saturday, comp, satTime);
						fallSemSat.makeRequest(satFall);
						System.out.println(fallSemSat.display());
						
						
						
						int start_indexSS = sunStartBox.getSelectedIndex();
						int end_indexSS = sunEndBox.getSelectedIndex() + 1;
						Day sunday = new Day(DayName.SUNDAY);
						TimeSlot sunTime = new TimeSlot(Block_Sch.values()[start_indexSS],Block_Sch.values()[end_indexSS]);
						Info sunFall = new Info(name, sunday, comp, sunTime);
						fallSemSun.makeRequest(sunFall);
						System.out.println(fallSemSun.display());
						
					}if(rooms.getSelectedItem() == "Lecture Hall") {
						Room lect = new LectureHall();
						Day monday = new Day(DayName.MONDAY);
						int start_index = monStartBox.getSelectedIndex();
						int end_index = monEndBox.getSelectedIndex() + 1;
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
						Day tuesday = new Day(DayName.TUESDAY);
						TimeSlot tuesdayTime = new TimeSlot(Block_Sch.values()[start_indexT],Block_Sch.values()[end_indexT]);
						Info tuesFall = new Info(name, tuesday, lect, tuesdayTime);
						fallSemTues.makeRequest(tuesFall);
						System.out.println(fallSemTues.display());
						
						
						
						int start_indexW = wedStartBox.getSelectedIndex();
						int end_indexW = wedEndBox.getSelectedIndex() + 1;
						Day weds = new Day(DayName.WEDNESDAY);
						TimeSlot wedsTime = new TimeSlot(Block_Sch.values()[start_indexW],Block_Sch.values()[end_indexW]);
						Info wedsFall = new Info(name, weds, lect, wedsTime);
						fallSemWeds.makeRequest(wedsFall);
						System.out.println(fallSemWeds.display());
						
						
						int start_indexTR = thurStartBox.getSelectedIndex();
						int end_indexTR = thurEndBox.getSelectedIndex() + 1;
						Day thurs = new Day(DayName.THURSDAY);
						TimeSlot thursTime = new TimeSlot(Block_Sch.values()[start_indexTR],Block_Sch.values()[end_indexTR]);
						Info thursFall = new Info(name, thurs, lect, thursTime);
						fallSemThurs.makeRequest(thursFall);
						System.out.println(fallSemThurs.display());
						
						
						int start_indexF = friStartBox.getSelectedIndex();
						int end_indexF = friEndBox.getSelectedIndex() + 1;
						Day friday = new Day(DayName.FRIDAY);
						TimeSlot fridayTime = new TimeSlot(Block_Sch.values()[start_indexF],Block_Sch.values()[end_indexF]);
						Info friFall = new Info(name, friday, lect, fridayTime);
						fallSemFri.makeRequest(friFall);
						System.out.println(fallSemFri.display());
						
						
						int start_indexS = satStartBox.getSelectedIndex();
						int end_indexS = satEndBox.getSelectedIndex() + 1;
						Day saturday = new Day(DayName.SATURDAY);
						TimeSlot satTime = new TimeSlot(Block_Sch.values()[start_indexS],Block_Sch.values()[end_indexS]);
						Info satFall = new Info(name, saturday, lect, satTime);
						fallSemSat.makeRequest(satFall);
						System.out.println(fallSemSat.display());
						
						
						
						int start_indexSS = sunStartBox.getSelectedIndex();
						int end_indexSS = sunEndBox.getSelectedIndex() + 1;
						Day sunday = new Day(DayName.SUNDAY);
						TimeSlot sunTime = new TimeSlot(Block_Sch.values()[start_indexSS],Block_Sch.values()[end_indexSS]);
						Info sunFall = new Info(name, sunday, lect, sunTime);
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
						TimeSlot mondayTime = new TimeSlot(Block_Sch.values()[start_index],Block_Sch.values()[end_index]);
						Info mondayFall = new Info(name, monday,gym, mondayTime);
						winSemMon.makeRequest(mondayFall);
						System.out.println(winSemMon.display());
						
						
						int start_indexT = tuesStartBox.getSelectedIndex();
						int end_indexT = tuesEndBox.getSelectedIndex() + 1;
						Day tuesday = new Day(DayName.TUESDAY);
						TimeSlot tuesdayTime = new TimeSlot(Block_Sch.values()[start_indexT],Block_Sch.values()[end_indexT]);
						Info tuesFall = new Info(name, tuesday, gym, tuesdayTime);
						winSemTues.makeRequest(tuesFall);
						System.out.println(winSemTues.display());
						
						
						
						int start_indexW = wedStartBox.getSelectedIndex();
						int end_indexW = wedEndBox.getSelectedIndex() + 1;
						Day weds = new Day(DayName.WEDNESDAY);
						TimeSlot wedsTime = new TimeSlot(Block_Sch.values()[start_indexW],Block_Sch.values()[end_indexW]);
						Info wedsFall = new Info(name, weds, gym, wedsTime);
						winSemWeds.makeRequest(wedsFall);
						System.out.println(winSemWeds.display());
						
						
						int start_indexTR = thurStartBox.getSelectedIndex();
						int end_indexTR = thurEndBox.getSelectedIndex() + 1;
						Day thurs = new Day(DayName.THURSDAY);
						TimeSlot thursTime = new TimeSlot(Block_Sch.values()[start_indexTR],Block_Sch.values()[end_indexTR]);
						Info thursFall = new Info(name, thurs, gym, thursTime);
						winSemThurs.makeRequest(thursFall);
						System.out.println(winSemThurs.display());
						
						
						int start_indexF = friStartBox.getSelectedIndex();
						int end_indexF = friEndBox.getSelectedIndex() + 1;
						Day friday = new Day(DayName.FRIDAY);
						TimeSlot fridayTime = new TimeSlot(Block_Sch.values()[start_indexF],Block_Sch.values()[end_indexF]);
						Info friFall = new Info(name, friday, gym, fridayTime);
						winSemFri.makeRequest(friFall);
						System.out.println(winSemFri.display());
						
						
						int start_indexS = satStartBox.getSelectedIndex();
						int end_indexS = satEndBox.getSelectedIndex() + 1;
						Day saturday = new Day(DayName.SATURDAY);
						TimeSlot satTime = new TimeSlot(Block_Sch.values()[start_indexS],Block_Sch.values()[end_indexS]);
						Info satFall = new Info(name, saturday, gym, satTime);
						winSemSat.makeRequest(satFall);
						System.out.println(winSemSat.display());
						
						
						
						int start_indexSS = sunStartBox.getSelectedIndex();
						int end_indexSS = sunEndBox.getSelectedIndex() + 1;
						Day sunday = new Day(DayName.SUNDAY);
						TimeSlot sunTime = new TimeSlot(Block_Sch.values()[start_indexSS],Block_Sch.values()[end_indexSS]);
						Info sunFall = new Info(name, sunday, gym, sunTime);
						winSemSun.makeRequest(sunFall);
						System.out.println(winSemSun.display());
						
						
					}if(rooms.getSelectedItem() == "Music") {
						Room music = new Music();
						Day monday = new Day(DayName.MONDAY);
						int start_index = monStartBox.getSelectedIndex();
						int end_index = monEndBox.getSelectedIndex() + 1;
						TimeSlot mondayTime = new TimeSlot(Block_Sch.values()[start_index],Block_Sch.values()[end_index]);
						Info mondayFall = new Info(name, monday,music, mondayTime);
						winSemMon.makeRequest(mondayFall);
						System.out.println(winSemMon.display());
						
						
						int start_indexT = tuesStartBox.getSelectedIndex();
						int end_indexT = tuesEndBox.getSelectedIndex() + 1;
						Day tuesday = new Day(DayName.TUESDAY);
						TimeSlot tuesdayTime = new TimeSlot(Block_Sch.values()[start_indexT],Block_Sch.values()[end_indexT]);
						Info tuesFall = new Info(name, tuesday, music, tuesdayTime);
						winSemTues.makeRequest(tuesFall);
						System.out.println(winSemTues.display());
						
						
						
						int start_indexW = wedStartBox.getSelectedIndex();
						int end_indexW = wedEndBox.getSelectedIndex() + 1;
						Day weds = new Day(DayName.WEDNESDAY);
						TimeSlot wedsTime = new TimeSlot(Block_Sch.values()[start_indexW],Block_Sch.values()[end_indexW]);
						Info wedsFall = new Info(name, weds, music, wedsTime);
						winSemWeds.makeRequest(wedsFall);
						System.out.println(winSemWeds.display());
						
						
						int start_indexTR = thurStartBox.getSelectedIndex();
						int end_indexTR = thurEndBox.getSelectedIndex() + 1;
						Day thurs = new Day(DayName.THURSDAY);
						TimeSlot thursTime = new TimeSlot(Block_Sch.values()[start_indexTR],Block_Sch.values()[end_indexTR]);
						Info thursFall = new Info(name, thurs, music, thursTime);
						winSemThurs.makeRequest(thursFall);
						System.out.println(winSemThurs.display());
						
						
						int start_indexF = friStartBox.getSelectedIndex();
						int end_indexF = friEndBox.getSelectedIndex() + 1;
						Day friday = new Day(DayName.FRIDAY);
						TimeSlot fridayTime = new TimeSlot(Block_Sch.values()[start_indexF],Block_Sch.values()[end_indexF]);
						Info friFall = new Info(name, friday, music, fridayTime);
						winSemFri.makeRequest(friFall);
						System.out.println(winSemFri.display());
						
						
						int start_indexS = satStartBox.getSelectedIndex();
						int end_indexS = satEndBox.getSelectedIndex() + 1;
						Day saturday = new Day(DayName.SATURDAY);
						TimeSlot satTime = new TimeSlot(Block_Sch.values()[start_indexS],Block_Sch.values()[end_indexS]);
						Info satFall = new Info(name, saturday, music, satTime);
						winSemSat.makeRequest(satFall);
						System.out.println(winSemSat.display());
						
						
						
						int start_indexSS = sunStartBox.getSelectedIndex();
						int end_indexSS = sunEndBox.getSelectedIndex() + 1;
						Day sunday = new Day(DayName.SUNDAY);
						TimeSlot sunTime = new TimeSlot(Block_Sch.values()[start_indexSS],Block_Sch.values()[end_indexSS]);
						Info sunFall = new Info(name, sunday, music, sunTime);
						winSemSun.makeRequest(sunFall);
						System.out.println(winSemSun.display());
						
					}if(rooms.getSelectedItem() == "Auditorium"){
						Room auditorium = new Auditorium();
						Day monday = new Day(DayName.MONDAY);
						int start_index = monStartBox.getSelectedIndex();
						int end_index = monEndBox.getSelectedIndex() + 1;
						TimeSlot mondayTime = new TimeSlot(Block_Sch.values()[start_index],Block_Sch.values()[end_index]);
						Info mondayFall = new Info(name, monday,auditorium, mondayTime);
						winSemMon.makeRequest(mondayFall);
						System.out.println(winSemMon.display());
						
						
						int start_indexT = tuesStartBox.getSelectedIndex();
						int end_indexT = tuesEndBox.getSelectedIndex() + 1;
						Day tuesday = new Day(DayName.TUESDAY);
						TimeSlot tuesdayTime = new TimeSlot(Block_Sch.values()[start_indexT],Block_Sch.values()[end_indexT]);
						Info tuesFall = new Info(name, tuesday, auditorium, tuesdayTime);
						winSemTues.makeRequest(tuesFall);
						System.out.println(winSemTues.display());
						
						
						
						int start_indexW = wedStartBox.getSelectedIndex();
						int end_indexW = wedEndBox.getSelectedIndex() + 1;
						Day weds = new Day(DayName.WEDNESDAY);
						TimeSlot wedsTime = new TimeSlot(Block_Sch.values()[start_indexW],Block_Sch.values()[end_indexW]);
						Info wedsFall = new Info(name, weds, auditorium, wedsTime);
						winSemWeds.makeRequest(wedsFall);
						System.out.println(winSemWeds.display());
						
						
						int start_indexTR = thurStartBox.getSelectedIndex();
						int end_indexTR = thurEndBox.getSelectedIndex() + 1;
						Day thurs = new Day(DayName.THURSDAY);
						TimeSlot thursTime = new TimeSlot(Block_Sch.values()[start_indexTR],Block_Sch.values()[end_indexTR]);
						Info thursFall = new Info(name, thurs, auditorium, thursTime);
						winSemThurs.makeRequest(thursFall);
						System.out.println(winSemThurs.display());
						
						
						int start_indexF = friStartBox.getSelectedIndex();
						int end_indexF = friEndBox.getSelectedIndex() + 1;
						Day friday = new Day(DayName.FRIDAY);
						TimeSlot fridayTime = new TimeSlot(Block_Sch.values()[start_indexF],Block_Sch.values()[end_indexF]);
						Info friFall = new Info(name, friday, auditorium, fridayTime);
						winSemFri.makeRequest(friFall);
						System.out.println(winSemFri.display());
						
						
						int start_indexS = satStartBox.getSelectedIndex();
						int end_indexS = satEndBox.getSelectedIndex() + 1;
						Day saturday = new Day(DayName.SATURDAY);
						TimeSlot satTime = new TimeSlot(Block_Sch.values()[start_indexS],Block_Sch.values()[end_indexS]);
						Info satFall = new Info(name, saturday, auditorium, satTime);
						winSemSat.makeRequest(satFall);
						System.out.println(winSemSat.display());
						
						
						
						int start_indexSS = sunStartBox.getSelectedIndex();
						int end_indexSS = sunEndBox.getSelectedIndex() + 1;
						Day sunday = new Day(DayName.SUNDAY);
						TimeSlot sunTime = new TimeSlot(Block_Sch.values()[start_indexSS],Block_Sch.values()[end_indexSS]);
						Info sunFall = new Info(name, sunday, auditorium, sunTime);
						winSemSun.makeRequest(sunFall);
						System.out.println(winSemSun.display());
						
					}if(rooms.getSelectedItem() == "Computer Lab") {
						Room comp = new ComputerLab();
						Day monday = new Day(DayName.MONDAY);
						int start_index = monStartBox.getSelectedIndex();
						int end_index = monEndBox.getSelectedIndex() + 1;
						TimeSlot mondayTime = new TimeSlot(Block_Sch.values()[start_index],Block_Sch.values()[end_index]);
						Info mondayFall = new Info(name, monday,comp, mondayTime);
						winSemMon.makeRequest(mondayFall);
						System.out.println(winSemMon.display());
						
						
						int start_indexT = tuesStartBox.getSelectedIndex();
						int end_indexT = tuesEndBox.getSelectedIndex() + 1;
						Day tuesday = new Day(DayName.TUESDAY);
						TimeSlot tuesdayTime = new TimeSlot(Block_Sch.values()[start_indexT],Block_Sch.values()[end_indexT]);
						Info tuesFall = new Info(name, tuesday, comp, tuesdayTime);
						winSemTues.makeRequest(tuesFall);
						System.out.println(winSemTues.display());
						
						
						
						int start_indexW = wedStartBox.getSelectedIndex();
						int end_indexW = wedEndBox.getSelectedIndex() + 1;
						Day weds = new Day(DayName.WEDNESDAY);
						TimeSlot wedsTime = new TimeSlot(Block_Sch.values()[start_indexW],Block_Sch.values()[end_indexW]);
						Info wedsFall = new Info(name, weds, comp, wedsTime);
						winSemWeds.makeRequest(wedsFall);
						System.out.println(winSemWeds.display());
						
						
						int start_indexTR = thurStartBox.getSelectedIndex();
						int end_indexTR = thurEndBox.getSelectedIndex() + 1;
						Day thurs = new Day(DayName.THURSDAY);
						TimeSlot thursTime = new TimeSlot(Block_Sch.values()[start_indexTR],Block_Sch.values()[end_indexTR]);
						Info thursFall = new Info(name, thurs, comp, thursTime);
						winSemThurs.makeRequest(thursFall);
						System.out.println(winSemThurs.display());
						
						
						int start_indexF = friStartBox.getSelectedIndex();
						int end_indexF = friEndBox.getSelectedIndex() + 1;
						Day friday = new Day(DayName.FRIDAY);
						TimeSlot fridayTime = new TimeSlot(Block_Sch.values()[start_indexF],Block_Sch.values()[end_indexF]);
						Info friFall = new Info(name, friday, comp, fridayTime);
						winSemFri.makeRequest(friFall);
						System.out.println(winSemFri.display());
						
						
						int start_indexS = satStartBox.getSelectedIndex();
						int end_indexS = satEndBox.getSelectedIndex() + 1;
						Day saturday = new Day(DayName.SATURDAY);
						TimeSlot satTime = new TimeSlot(Block_Sch.values()[start_indexS],Block_Sch.values()[end_indexS]);
						Info satFall = new Info(name, saturday, comp, satTime);
						winSemSat.makeRequest(satFall);
						System.out.println(winSemSat.display());
						
						
						
						int start_indexSS = sunStartBox.getSelectedIndex();
						int end_indexSS = sunEndBox.getSelectedIndex() + 1;
						Day sunday = new Day(DayName.SUNDAY);
						TimeSlot sunTime = new TimeSlot(Block_Sch.values()[start_indexSS],Block_Sch.values()[end_indexSS]);
						Info sunFall = new Info(name, sunday, comp, sunTime);
						winSemSun.makeRequest(sunFall);
						System.out.println(winSemSun.display());
						
					}if(rooms.getSelectedItem() == "Lecture Hall") {
						Room lect = new LectureHall();
						Day monday = new Day(DayName.MONDAY);
						int start_index = monStartBox.getSelectedIndex();
						int end_index = monEndBox.getSelectedIndex() + 1;
						TimeSlot mondayTime = new TimeSlot(Block_Sch.values()[start_index],Block_Sch.values()[end_index]);
						Info mondayFall = new Info(name, monday,lect, mondayTime);
						winSemMon.makeRequest(mondayFall);
						System.out.println(winSemMon.display());
						
						
						int start_indexT = tuesStartBox.getSelectedIndex();
						int end_indexT = tuesEndBox.getSelectedIndex() + 1;
						Day tuesday = new Day(DayName.TUESDAY);
						TimeSlot tuesdayTime = new TimeSlot(Block_Sch.values()[start_indexT],Block_Sch.values()[end_indexT]);
						Info tuesFall = new Info(name, tuesday, lect, tuesdayTime);
						winSemTues.makeRequest(tuesFall);
						System.out.println(winSemTues.display());
						
						
						
						int start_indexW = wedStartBox.getSelectedIndex();
						int end_indexW = wedEndBox.getSelectedIndex() + 1;
						Day weds = new Day(DayName.WEDNESDAY);
						TimeSlot wedsTime = new TimeSlot(Block_Sch.values()[start_indexW],Block_Sch.values()[end_indexW]);
						Info wedsFall = new Info(name, weds, lect, wedsTime);
						winSemWeds.makeRequest(wedsFall);
						System.out.println(winSemWeds.display());
						
						
						int start_indexTR = thurStartBox.getSelectedIndex();
						int end_indexTR = thurEndBox.getSelectedIndex() + 1;
						Day thurs = new Day(DayName.THURSDAY);
						TimeSlot thursTime = new TimeSlot(Block_Sch.values()[start_indexTR],Block_Sch.values()[end_indexTR]);
						Info thursFall = new Info(name, thurs, lect, thursTime);
						winSemThurs.makeRequest(thursFall);
						System.out.println(winSemThurs.display());
						
						
						int start_indexF = friStartBox.getSelectedIndex();
						int end_indexF = friEndBox.getSelectedIndex() + 1;
						Day friday = new Day(DayName.FRIDAY);
						TimeSlot fridayTime = new TimeSlot(Block_Sch.values()[start_indexF],Block_Sch.values()[end_indexF]);
						Info friFall = new Info(name, friday, lect, fridayTime);
						winSemFri.makeRequest(friFall);
						System.out.println(winSemFri.display());
						
						
						int start_indexS = satStartBox.getSelectedIndex();
						int end_indexS = satEndBox.getSelectedIndex() + 1;
						Day saturday = new Day(DayName.SATURDAY);
						TimeSlot satTime = new TimeSlot(Block_Sch.values()[start_indexS],Block_Sch.values()[end_indexS]);
						Info satFall = new Info(name, saturday, lect, satTime);
						winSemSat.makeRequest(satFall);
						System.out.println(winSemSat.display());
						
						
						
						int start_indexSS = sunStartBox.getSelectedIndex();
						int end_indexSS = sunEndBox.getSelectedIndex() + 1;
						Day sunday = new Day(DayName.SUNDAY);
						TimeSlot sunTime = new TimeSlot(Block_Sch.values()[start_indexSS],Block_Sch.values()[end_indexSS]);
						Info sunFall = new Info(name, sunday, lect, sunTime);
						winSemSun.makeRequest(sunFall);
						System.out.println(winSemSun.display());
					}
				}else if(summer.isSelected()) {
					Schedule sumSemMon = new Schedule();
					Schedule sumSemTues = new Schedule();
					Schedule sumSemWeds = new Schedule();
					Schedule sumSemThurs = new Schedule();
					Schedule sumSemFri = new Schedule();
					Schedule sumSemSat = new Schedule();
					Schedule sumSemSun = new Schedule();
					
					
					Group name = new Group("Summer Schedule");
					if(rooms.getSelectedItem() == "Gym") {
						Room gym = new Gym();
						Day monday = new Day(DayName.MONDAY);
						
						int start_index = monStartBox.getSelectedIndex();
						int end_index = monEndBox.getSelectedIndex() + 1;
						TimeSlot mondayTime = new TimeSlot(Block_Sch.values()[start_index],Block_Sch.values()[end_index]);
						Info mondayFall = new Info(name, monday,gym, mondayTime);
						sumSemMon.makeRequest(mondayFall);
						System.out.println(sumSemMon.display());
						
						
						int start_indexT = tuesStartBox.getSelectedIndex();
						int end_indexT = tuesEndBox.getSelectedIndex() + 1;
						Day tuesday = new Day(DayName.TUESDAY);
						TimeSlot tuesdayTime = new TimeSlot(Block_Sch.values()[start_indexT],Block_Sch.values()[end_indexT]);
						Info tuesFall = new Info(name, tuesday, gym, tuesdayTime);
						sumSemTues.makeRequest(tuesFall);
						System.out.println(sumSemTues.display());
						
						
						
						int start_indexW = wedStartBox.getSelectedIndex();
						int end_indexW = wedEndBox.getSelectedIndex() + 1;
						Day weds = new Day(DayName.WEDNESDAY);
						TimeSlot wedsTime = new TimeSlot(Block_Sch.values()[start_indexW],Block_Sch.values()[end_indexW]);
						Info wedsFall = new Info(name, weds, gym, wedsTime);
						sumSemWeds.makeRequest(wedsFall);
						System.out.println(sumSemWeds.display());
						
						
						int start_indexTR = thurStartBox.getSelectedIndex();
						int end_indexTR = thurEndBox.getSelectedIndex() + 1;
						Day thurs = new Day(DayName.THURSDAY);
						TimeSlot thursTime = new TimeSlot(Block_Sch.values()[start_indexTR],Block_Sch.values()[end_indexTR]);
						Info thursFall = new Info(name, thurs, gym, thursTime);
						sumSemThurs.makeRequest(thursFall);
						System.out.println(sumSemThurs.display());
						
						
						int start_indexF = friStartBox.getSelectedIndex();
						int end_indexF = friEndBox.getSelectedIndex() + 1;
						Day friday = new Day(DayName.FRIDAY);
						TimeSlot fridayTime = new TimeSlot(Block_Sch.values()[start_indexF],Block_Sch.values()[end_indexF]);
						Info friFall = new Info(name, friday, gym, fridayTime);
						sumSemFri.makeRequest(friFall);
						System.out.println(sumSemFri.display());
						
						
						int start_indexS = satStartBox.getSelectedIndex();
						int end_indexS = satEndBox.getSelectedIndex() + 1;
						Day saturday = new Day(DayName.SATURDAY);
						TimeSlot satTime = new TimeSlot(Block_Sch.values()[start_indexS],Block_Sch.values()[end_indexS]);
						Info satFall = new Info(name, saturday, gym, satTime);
						sumSemSat.makeRequest(satFall);
						System.out.println(sumSemSat.display());
						
						
						
						int start_indexSS = sunStartBox.getSelectedIndex();
						int end_indexSS = sunEndBox.getSelectedIndex() + 1;
						Day sunday = new Day(DayName.SUNDAY);
						TimeSlot sunTime = new TimeSlot(Block_Sch.values()[start_indexSS],Block_Sch.values()[end_indexSS]);
						Info sunFall = new Info(name, sunday, gym, sunTime);
						sumSemSun.makeRequest(sunFall);
						System.out.println(sumSemSun.display());
						
						
					}if(rooms.getSelectedItem() == "Music") {
						Room music = new Music();
						Day monday = new Day(DayName.MONDAY);
						int start_index = monStartBox.getSelectedIndex();
						int end_index = monEndBox.getSelectedIndex() + 1;
						TimeSlot mondayTime = new TimeSlot(Block_Sch.values()[start_index],Block_Sch.values()[end_index]);
						Info mondayFall = new Info(name, monday,music, mondayTime);
						sumSemMon.makeRequest(mondayFall);
						System.out.println(sumSemMon.display());
						
						
						int start_indexT = tuesStartBox.getSelectedIndex();
						int end_indexT = tuesEndBox.getSelectedIndex() + 1;
						Day tuesday = new Day(DayName.TUESDAY);
						TimeSlot tuesdayTime = new TimeSlot(Block_Sch.values()[start_indexT],Block_Sch.values()[end_indexT]);
						Info tuesFall = new Info(name, tuesday, music, tuesdayTime);
						sumSemTues.makeRequest(tuesFall);
						System.out.println(sumSemTues.display());
						
						
						
						int start_indexW = wedStartBox.getSelectedIndex();
						int end_indexW = wedEndBox.getSelectedIndex() + 1;
						Day weds = new Day(DayName.WEDNESDAY);
						TimeSlot wedsTime = new TimeSlot(Block_Sch.values()[start_indexW],Block_Sch.values()[end_indexW]);
						Info wedsFall = new Info(name, weds, music, wedsTime);
						sumSemWeds.makeRequest(wedsFall);
						System.out.println(sumSemWeds.display());
						
						
						int start_indexTR = thurStartBox.getSelectedIndex();
						int end_indexTR = thurEndBox.getSelectedIndex() + 1;
						Day thurs = new Day(DayName.THURSDAY);
						TimeSlot thursTime = new TimeSlot(Block_Sch.values()[start_indexTR],Block_Sch.values()[end_indexTR]);
						Info thursFall = new Info(name, thurs, music, thursTime);
						sumSemThurs.makeRequest(thursFall);
						System.out.println(sumSemThurs.display());
						
						
						int start_indexF = friStartBox.getSelectedIndex();
						int end_indexF = friEndBox.getSelectedIndex() + 1;
						Day friday = new Day(DayName.FRIDAY);
						TimeSlot fridayTime = new TimeSlot(Block_Sch.values()[start_indexF],Block_Sch.values()[end_indexF]);
						Info friFall = new Info(name, friday, music, fridayTime);
						sumSemFri.makeRequest(friFall);
						System.out.println(sumSemFri.display());
						
						
						int start_indexS = satStartBox.getSelectedIndex();
						int end_indexS = satEndBox.getSelectedIndex() + 1;
						Day saturday = new Day(DayName.SATURDAY);
						TimeSlot satTime = new TimeSlot(Block_Sch.values()[start_indexS],Block_Sch.values()[end_indexS]);
						Info satFall = new Info(name, saturday, music, satTime);
						sumSemSat.makeRequest(satFall);
						System.out.println(sumSemSat.display());
						
						
						
						int start_indexSS = sunStartBox.getSelectedIndex();
						int end_indexSS = sunEndBox.getSelectedIndex() + 1;
						Day sunday = new Day(DayName.SUNDAY);
						TimeSlot sunTime = new TimeSlot(Block_Sch.values()[start_indexSS],Block_Sch.values()[end_indexSS]);
						Info sunFall = new Info(name, sunday, music, sunTime);
						sumSemSun.makeRequest(sunFall);
						System.out.println(sumSemSun.display());
						
					}if(rooms.getSelectedItem() == "Auditorium"){
						Room auditorium = new Auditorium();
						Day monday = new Day(DayName.MONDAY);
						int start_index = monStartBox.getSelectedIndex();
						int end_index = monEndBox.getSelectedIndex() + 1;
						TimeSlot mondayTime = new TimeSlot(Block_Sch.values()[start_index],Block_Sch.values()[end_index]);
						Info mondayFall = new Info(name, monday,auditorium, mondayTime);
						sumSemMon.makeRequest(mondayFall);
						System.out.println(sumSemMon.display());
						
						
						int start_indexT = tuesStartBox.getSelectedIndex();
						int end_indexT = tuesEndBox.getSelectedIndex() + 1;
						Day tuesday = new Day(DayName.TUESDAY);
						TimeSlot tuesdayTime = new TimeSlot(Block_Sch.values()[start_indexT],Block_Sch.values()[end_indexT]);
						Info tuesFall = new Info(name, tuesday, auditorium, tuesdayTime);
						sumSemTues.makeRequest(tuesFall);
						System.out.println(sumSemTues.display());
						
						
						
						int start_indexW = wedStartBox.getSelectedIndex();
						int end_indexW = wedEndBox.getSelectedIndex() + 1;
						Day weds = new Day(DayName.WEDNESDAY);
						TimeSlot wedsTime = new TimeSlot(Block_Sch.values()[start_indexW],Block_Sch.values()[end_indexW]);
						Info wedsFall = new Info(name, weds, auditorium, wedsTime);
						sumSemWeds.makeRequest(wedsFall);
						System.out.println(sumSemWeds.display());
						
						
						int start_indexTR = thurStartBox.getSelectedIndex();
						int end_indexTR = thurEndBox.getSelectedIndex() + 1;
						Day thurs = new Day(DayName.THURSDAY);
						TimeSlot thursTime = new TimeSlot(Block_Sch.values()[start_indexTR],Block_Sch.values()[end_indexTR]);
						Info thursFall = new Info(name, thurs, auditorium, thursTime);
						sumSemThurs.makeRequest(thursFall);
						System.out.println(sumSemThurs.display());
						
						
						int start_indexF = friStartBox.getSelectedIndex();
						int end_indexF = friEndBox.getSelectedIndex() + 1;
						Day friday = new Day(DayName.FRIDAY);
						TimeSlot fridayTime = new TimeSlot(Block_Sch.values()[start_indexF],Block_Sch.values()[end_indexF]);
						Info friFall = new Info(name, friday, auditorium, fridayTime);
						sumSemFri.makeRequest(friFall);
						System.out.println(sumSemFri.display());
						
						
						int start_indexS = satStartBox.getSelectedIndex();
						int end_indexS = satEndBox.getSelectedIndex() + 1;
						Day saturday = new Day(DayName.SATURDAY);
						TimeSlot satTime = new TimeSlot(Block_Sch.values()[start_indexS],Block_Sch.values()[end_indexS]);
						Info satFall = new Info(name, saturday, auditorium, satTime);
						sumSemSat.makeRequest(satFall);
						System.out.println(sumSemSat.display());
						
						
						
						int start_indexSS = sunStartBox.getSelectedIndex();
						int end_indexSS = sunEndBox.getSelectedIndex() + 1;
						Day sunday = new Day(DayName.SUNDAY);
						TimeSlot sunTime = new TimeSlot(Block_Sch.values()[start_indexSS],Block_Sch.values()[end_indexSS]);
						Info sunFall = new Info(name, sunday, auditorium, sunTime);
						sumSemSun.makeRequest(sunFall);
						System.out.println(sumSemSun.display());
						
					}if(rooms.getSelectedItem() == "Computer Lab") {
						Room comp = new ComputerLab();
						Day monday = new Day(DayName.MONDAY);
						int start_index = monStartBox.getSelectedIndex();
						int end_index = monEndBox.getSelectedIndex() + 1;
						TimeSlot mondayTime = new TimeSlot(Block_Sch.values()[start_index],Block_Sch.values()[end_index]);
						Info mondayFall = new Info(name, monday,comp, mondayTime);
						sumSemMon.makeRequest(mondayFall);
						System.out.println(sumSemMon.display());
						
						
						int start_indexT = tuesStartBox.getSelectedIndex();
						int end_indexT = tuesEndBox.getSelectedIndex() + 1;
						Day tuesday = new Day(DayName.TUESDAY);
						TimeSlot tuesdayTime = new TimeSlot(Block_Sch.values()[start_indexT],Block_Sch.values()[end_indexT]);
						Info tuesFall = new Info(name, tuesday, comp, tuesdayTime);
						sumSemTues.makeRequest(tuesFall);
						System.out.println(sumSemTues.display());
						
						
						
						int start_indexW = wedStartBox.getSelectedIndex();
						int end_indexW = wedEndBox.getSelectedIndex() + 1;
						Day weds = new Day(DayName.WEDNESDAY);
						TimeSlot wedsTime = new TimeSlot(Block_Sch.values()[start_indexW],Block_Sch.values()[end_indexW]);
						Info wedsFall = new Info(name, weds, comp, wedsTime);
						sumSemWeds.makeRequest(wedsFall);
						System.out.println(sumSemWeds.display());
						
						
						int start_indexTR = thurStartBox.getSelectedIndex();
						int end_indexTR = thurEndBox.getSelectedIndex() + 1;
						Day thurs = new Day(DayName.THURSDAY);
						TimeSlot thursTime = new TimeSlot(Block_Sch.values()[start_indexTR],Block_Sch.values()[end_indexTR]);
						Info thursFall = new Info(name, thurs, comp, thursTime);
						sumSemThurs.makeRequest(thursFall);
						System.out.println(sumSemThurs.display());
						
						
						int start_indexF = friStartBox.getSelectedIndex();
						int end_indexF = friEndBox.getSelectedIndex() + 1;
						Day friday = new Day(DayName.FRIDAY);
						TimeSlot fridayTime = new TimeSlot(Block_Sch.values()[start_indexF],Block_Sch.values()[end_indexF]);
						Info friFall = new Info(name, friday, comp, fridayTime);
						sumSemFri.makeRequest(friFall);
						System.out.println(sumSemFri.display());
						
						
						int start_indexS = satStartBox.getSelectedIndex();
						int end_indexS = satEndBox.getSelectedIndex() + 1;
						Day saturday = new Day(DayName.SATURDAY);
						TimeSlot satTime = new TimeSlot(Block_Sch.values()[start_indexS],Block_Sch.values()[end_indexS]);
						Info satFall = new Info(name, saturday, comp, satTime);
						sumSemSat.makeRequest(satFall);
						System.out.println(sumSemSat.display());
						
						
						
						int start_indexSS = sunStartBox.getSelectedIndex();
						int end_indexSS = sunEndBox.getSelectedIndex() + 1;
						Day sunday = new Day(DayName.SUNDAY);
						TimeSlot sunTime = new TimeSlot(Block_Sch.values()[start_indexSS],Block_Sch.values()[end_indexSS]);
						Info sunFall = new Info(name, sunday, comp, sunTime);
						sumSemSun.makeRequest(sunFall);
						System.out.println(sumSemSun.display());
						
					}if(rooms.getSelectedItem() == "Lecture Hall") {
						Room lect = new LectureHall();
						Day monday = new Day(DayName.MONDAY);
						int start_index = monStartBox.getSelectedIndex();
						int end_index = monEndBox.getSelectedIndex() + 1;
						TimeSlot mondayTime = new TimeSlot(Block_Sch.values()[start_index],Block_Sch.values()[end_index]);
						Info mondayFall = new Info(name, monday,lect, mondayTime);
						sumSemTues.makeRequest(mondayFall);
						System.out.println(sumSemTues.display());
						
						
						int start_indexT = tuesStartBox.getSelectedIndex();
						int end_indexT = tuesEndBox.getSelectedIndex() + 1;
						Day tuesday = new Day(DayName.TUESDAY);
						TimeSlot tuesdayTime = new TimeSlot(Block_Sch.values()[start_indexT],Block_Sch.values()[end_indexT]);
						Info tuesFall = new Info(name, tuesday, lect, tuesdayTime);
						sumSemTues.makeRequest(tuesFall);
						System.out.println(sumSemTues.display());
						
						
						
						int start_indexW = wedStartBox.getSelectedIndex();
						int end_indexW = wedEndBox.getSelectedIndex() + 1;
						Day weds = new Day(DayName.WEDNESDAY);
						TimeSlot wedsTime = new TimeSlot(Block_Sch.values()[start_indexW],Block_Sch.values()[end_indexW]);
						Info wedsFall = new Info(name, weds, lect, wedsTime);
						sumSemWeds.makeRequest(wedsFall);
						System.out.println(sumSemWeds.display());
						
						
						int start_indexTR = thurStartBox.getSelectedIndex();
						int end_indexTR = thurEndBox.getSelectedIndex() + 1;
						Day thurs = new Day(DayName.THURSDAY);
						TimeSlot thursTime = new TimeSlot(Block_Sch.values()[start_indexTR],Block_Sch.values()[end_indexTR]);
						Info thursFall = new Info(name, thurs, lect, thursTime);
						sumSemThurs.makeRequest(thursFall);
						System.out.println(sumSemThurs.display());
						
						
						int start_indexF = friStartBox.getSelectedIndex();
						int end_indexF = friEndBox.getSelectedIndex() + 1;
						Day friday = new Day(DayName.FRIDAY);
						TimeSlot fridayTime = new TimeSlot(Block_Sch.values()[start_indexF],Block_Sch.values()[end_indexF]);
						Info friFall = new Info(name, friday, lect, fridayTime);
						sumSemFri.makeRequest(friFall);
						System.out.println(sumSemFri.display());
						
						
						int start_indexS = satStartBox.getSelectedIndex();
						int end_indexS = satEndBox.getSelectedIndex() + 1;
						Day saturday = new Day(DayName.SATURDAY);
						TimeSlot satTime = new TimeSlot(Block_Sch.values()[start_indexS],Block_Sch.values()[end_indexS]);
						Info satFall = new Info(name, saturday, lect, satTime);
						sumSemSat.makeRequest(satFall);
						System.out.println(sumSemSat.display());
						
						
						
						int start_indexSS = sunStartBox.getSelectedIndex();
						int end_indexSS = sunEndBox.getSelectedIndex() + 1;
						Day sunday = new Day(DayName.SUNDAY);
						TimeSlot sunTime = new TimeSlot(Block_Sch.values()[start_indexSS],Block_Sch.values()[end_indexSS]);
						Info sunFall = new Info(name, sunday, lect, sunTime);
						sumSemSun.makeRequest(sunFall);
						System.out.println(sumSemSun.display());
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
		jframe.setTitle("Submit a Request");




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
			GridLayout p1g = new GridLayout(6, 1);
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
											p1TimeBox.setEnabled(true);
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
											p1TimeBox.addItem(name);
										}
									}
								}
							}
						}
					
					
				
				
			};
			
			
			p1getTime.addActionListener(actionListener);
			p1Submit.addActionListener(actionListener);
			p1p2.addActionListener(actionListener);
			
			
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
			
			public static String getP1Name() {
				return p1name;
			}
			
			public static String getP1Semester() {
				return p1semester;
			}
			
			public static String getP1Room() {
				return p1room;
			}
		
	
}

	

