import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;

<<<<<<< HEAD
//import org.jdatepicker.JDatePicker;
//import org.jdatepicker.impl.JDatePanelImpl;
//import org.jdatepicker.impl.JDatePickerImpl;
//import org.jdatepicker.impl.UtilDateModel;

=======
>>>>>>> 89d5a1971a668013c15c12ffbf7af93730e7ce43

public class main{
	void createGUI(){
		JFrame jframe = new JFrame();
		JPanel panel = new JPanel();
		final int FRAME_WIDTH = 600;
		final int FRAME_HEIGHT = 600;

		jframe.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		jframe.setTitle("GUI");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
<<<<<<< HEAD



=======
		
		//jframe.setVisible(true);
		
>>>>>>> 89d5a1971a668013c15c12ffbf7af93730e7ce43
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
<<<<<<< HEAD


		jframe.add(panel);
=======
		
		
		jframe.add(panel);	
>>>>>>> 89d5a1971a668013c15c12ffbf7af93730e7ce43
		jframe.setVisible(true);
	}

	public static void main(String args[]){
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
		}else if(answer2.equals("Submit a Request")){
			createSubmitGUI();
		}else if(answer2.equals("Create the Schedule")){
			createCalenderGUI();
		}

	}
	public static void createPrincipalGUI(){
		JFrame jframe = new JFrame();
		final int FRAME_WIDTH = 600;
		final int FRAME_HEIGHT = 600;
		JPanel panel = new JPanel();

		jframe.setSize(FRAME_WIDTH, FRAME_HEIGHT);
<<<<<<< HEAD
		jframe.setTitle("Prinicpal Screen");



=======
		jframe.setTitle("Principal Screen");
		
		jframe.setVisible(true);
		
>>>>>>> 89d5a1971a668013c15c12ffbf7af93730e7ce43
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

	public static void createScheduleGUI(){
		JFrame jframe = new JFrame();
		JFrame jf2 = new JFrame();
		JPanel panel = new JPanel();
		final int FRAME_WIDTH = 600;
		final int FRAME_HEIGHT = 600;
		JLabel label = new JLabel();

		jframe.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		jf2.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		jframe.setTitle("Schedule");




		String amSt = "am";
		String pmSt = "pm";
		String createSch = "Create the Schedule";
		String addSch = "Add to Schedule";
		String[] timeSch = {"1:00", "2:00", "3:00", "4:00", "5:00", "6:00","7:00"};
		String[] roomSch = { "Room1", "Room2", "Room3", "Room4", "Room5" };
		String[] dateSch = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct","Nov","Dec"};
		String[] daySch = {"Mon", "Tues", "Weds", "Thurs", "Fri","Sat","Sun"};
		String labelSt = " - ";

		JComboBox dayMenu = new JComboBox(daySch);
		dayMenu.setSelectedIndex(6);

		JComboBox dateMenu = new JComboBox(dateSch);
		dateMenu.setSelectedIndex(11);

		JComboBox roomMenu = new JComboBox(roomSch);
		roomMenu.setSelectedIndex(4);
		JComboBox timeMenu = new JComboBox(timeSch);

		JComboBox roomMenu1 = new JComboBox(roomSch);
		roomMenu.setSelectedIndex(4);
		JComboBox timeMenu1 = new JComboBox(timeSch);

		JButton createSchedule = new JButton(createSch);
		JButton addSchedule = new JButton(addSch);

		JRadioButton am = new JRadioButton(amSt);
		JRadioButton pm = new JRadioButton(pmSt);

		JRadioButton am1 = new JRadioButton(amSt);
		JRadioButton pm2 = new JRadioButton(pmSt);

		label.setText(labelSt);

		ActionListener actionListener = new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(e.getSource() instanceof JButton){
					JButton Button = (JButton) (e.getSource());
						String choice = Button.getText();
						if(choice.equals("Create the Schedule")){
							//JDatePickerImpl datepicker = createCalenderGUI();
							//jf2.add(datepicker);
							//jf2.setVisible(true);
							//jf2.repaint();
							//Calendar selectedValue = (Calendar) datepicker.getModel().getValue();
							createCalenderGUI();
							//System.out.println(datePicker.getJFormattedTextField().getText());
						}
					}
				}

			};



		createSchedule.addActionListener(actionListener);
		addSchedule.addActionListener(actionListener);


		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(createSchedule);
		buttonGroup.add(addSchedule);
		buttonGroup.add(pm);
		buttonGroup.add(am);



		panel.add(dateMenu);
		panel.add(dayMenu);
		panel.add(roomMenu);
		panel.add(timeMenu);
		panel.add(am);
		panel.add(pm);
		panel.add(label);
		panel.add(timeMenu1);
		panel.add(am1);
		panel.add(pm2);
		panel.add(createSchedule);
		panel.add(addSchedule);


		jframe.add(panel);
		jframe.setVisible(true);


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
<<<<<<< HEAD
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


=======
	DatePickerSR frame = new DatePickerSR();
		Datepicker schedule = new Datepicker(frame);
		frame.setVisible(true);
		
>>>>>>> 89d5a1971a668013c15c12ffbf7af93730e7ce43
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
<<<<<<< HEAD
}
=======
}
>>>>>>> 89d5a1971a668013c15c12ffbf7af93730e7ce43
