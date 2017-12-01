import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PriorityRequest {
	static String pname;
	static String psemester;
	static String proom;
	public PriorityRequest() {}
		public static void main(String[] args){
		JFrame pFrame = new JFrame();
		GridLayout pg = new GridLayout(7, 1);
		pFrame.setLayout(pg);
		final int FRAME_WIDTH = 300;
		final int FRAME_HEIGHT = 600;
		pFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		pFrame.setTitle("Submit A Priority Request");
		
		JPanel pPanel1 = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		JLabel pNameLabel = new JLabel("Name:");
		JTextField pNameField = new JTextField(15);
		c.gridy = 0;
		pPanel1.add(pNameLabel, c);
		c.gridy = 1;
		pPanel1.add(pNameField, c);
		pFrame.add(pPanel1);
		
		JPanel pPanel2 = new JPanel(new GridBagLayout());
		JLabel pSLabel = new JLabel("Semester:");
		ButtonGroup pSGroup = new ButtonGroup();
		JRadioButton pFall = new JRadioButton("Fall");
		JRadioButton pWinter = new JRadioButton("Winter");
		pSGroup.add(pFall);
		pSGroup.add(pWinter);
		
		c.gridy = 0;
		pPanel2.add(pSLabel, c);
		c.gridy = 1;
		pPanel2.add(pFall, c);
		c.gridx = 1;
		pPanel2.add(pWinter, c);
		c.gridx = 2;
		pFrame.add(pPanel2);
		
		JPanel pPanel3 = new JPanel(new GridBagLayout());
		JLabel pRoomLabel = new JLabel("Room:");
		JComboBox pRoomBox = new JComboBox();
		pRoomBox.addItem("Gym");
		pRoomBox.addItem("Music");
		pRoomBox.addItem("Auditorium");
		pRoomBox.addItem("Lecture Hall");
		pRoomBox.addItem("Computer Lab");
		c.gridy = 0;
		pPanel3.add(pRoomLabel, c);
		c.gridy = 1;
		pPanel3.add(pRoomBox, c);
		pFrame.add(pPanel3);
		
		JPanel pPanel4 = new JPanel(new GridBagLayout());
		JLabel pDayLabel = new JLabel("Day:");
		JComboBox<String> pDayBox = new JComboBox();
		//pDayBox.setEnabled(false);
		pDayBox.addItem("Monday");
		pDayBox.addItem("Tuesday");
		pDayBox.addItem("Wednesday");
		pDayBox.addItem("Thursday");
		pDayBox.addItem("Friday");
		pDayBox.addItem("Saturday");
		pDayBox.addItem("Sunday");
		
		c.gridy = 0;
		pPanel4.add(pDayLabel, c);
		c.gridy = 1;
		pPanel4.add(pDayBox, c);
		pFrame.add(pPanel4);
		
		JPanel pPanel5 = new JPanel(new GridBagLayout());
		//pPanel5.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
		JLabel pTimeLabel = new JLabel("Time:");
		JComboBox pTimeBox = new JComboBox();
		pTimeBox.setEnabled(false);
		c.gridy = 0;
		pPanel5.add(pTimeLabel, c);
		c.gridy = 1;
		pPanel5.add(pTimeBox, c);
		
		pFrame.add(pPanel5);
		
		JPanel pPanel6 = new JPanel(new GridBagLayout());
		JLabel pPriority = new JLabel("Priority:");
		pPriority.setForeground(Color.RED);
		ButtonGroup pPGroup = new ButtonGroup();
		JRadioButton p1 = new JRadioButton("1");
		JRadioButton p2 = new JRadioButton("2");
		JRadioButton p3 = new JRadioButton("3");
		JRadioButton p4 = new JRadioButton("4");
		JRadioButton p5 = new JRadioButton("5");
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
		
		pFrame.add(pPanel6);
		
		JPanel pPanel7 = new JPanel(new GridBagLayout());
		JButton pGetTime = new JButton("Get Times");
		c.gridy = 0;
		pPanel7.add(pGetTime, c);
		JButton pSubmit = new JButton("Submit");
		c.gridy = 1;
		pPanel7.add(pSubmit, c);
	
	    pFrame.add(pPanel7);
		
		pFrame.setVisible(true);
		pFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		}
}