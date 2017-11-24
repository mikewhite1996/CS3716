import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
	//create class and extend with JFrame
	public class DatePickerSR extends JFrame
	{	
			//add JPanel to the contentPane
			private JPanel contentPane;
			//declare variable
			private JTextField txtDate;
		
			/**
			 * Launch the application.
			 */
			public static void main(String[] args)// main method
			{	// it will call the run method on that object
				EventQueue.invokeLater(new Runnable()
				{	
					public void run()
					{
						try // try block 
						{
						     //create frame object
						     DatePickerSR frame = new DatePickerSR();
						     frame.setVisible(true);//set visible true
					        }
					        catch (Exception e) //catch the exception
					        {
					         	e.printStackTrace();
					        }
				        }          
			        });
		        }
	 
		/**
		 * Create the frame.
		 */
		//create constructor of class
		public DatePickerSR() 
		{
			//set title
			setTitle("Submit Date");
			//set close operation on frame
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			//set bounds of frame
			setBounds(100, 100, 450, 300);
			//create new JPanel in contentPane
			contentPane = new JPanel();
			//set border of frame
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			//set contentPane 
			setContentPane(contentPane);
			//set layout null
			contentPane.setLayout(null);
			
			//create text field
			txtDate = new JTextField();
			//set bounds of text field
			txtDate.setBounds(101, 107, 100, 30);
			//add text field to contentPane
			contentPane.add(txtDate);
			//set columns
			txtDate.setColumns(10);
			
			JButton pickAgain = new JButton("Pick Another Date");
			String str = "Submit Date";
			JButton submit = new JButton(str);
			//perform action listener
			pickAgain.addActionListener(new ActionListener() 
			{	
				//performed action
				public void actionPerformed(ActionEvent arg0) 
				{
					//create frame new object  f
					final JFrame f = new JFrame();
					//set text which is collected by date picker i.e. set date 
					txtDate.setText(new Datepicker(f).setPickedDate());
					System.out.println(txtDate.getText());
				}
			});
			
			submit.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e) {
					Date date = new Date();
					long mill = date.getTime();
					String dateText = txtDate.getText();
					System.out.println(dateText + "_" + mill);
					Key key = new Key(mill);
					Long K = key.getKey();
					String k = K.toString();
					System.out.println(key.getKey());
					createRequestPanel(k, dateText);
				}
			});
			
			
			//set button bound
			pickAgain.setBounds(200, 100, 150, 25);
			submit.setBounds(200, 130, 150, 25);
			//add button in contentPane
			contentPane.add(pickAgain);
			contentPane.add(submit);
			contentPane.setVisible(true);
		}
		public void createRequestPanel(String k, String d) {
			RequestForm p = new RequestForm();
			p.setKeyField(k);
			p.setDateField(d);
			
			
		}
		}
	
