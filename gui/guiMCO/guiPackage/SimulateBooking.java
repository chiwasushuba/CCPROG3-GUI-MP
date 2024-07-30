package guiPackage;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SimulateBooking {

	private JFrame frame;
	private JComboBox selectHotelComboBox;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JButton backButton;
	private JLabel lblNewLabel_3;
	private JTextField guestFirstTF;
	private JTextField guestLastTF;
	private JComboBox checkInComboBox;
	private JComboBox checkOutComboBox;
	private JComboBox selectRoomComboBox;
	private JButton reserveButton;


	/**
	 * Create the application.
	 */
	public SimulateBooking() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 735, 545);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pick a hotel:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(40, 41, 150, 30);
		frame.getContentPane().add(lblNewLabel);
		
		selectHotelComboBox = new JComboBox();
		selectHotelComboBox.setBounds(221, 41, 360, 30);
		frame.getContentPane().add(selectHotelComboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Pick kind of room");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(40, 116, 126, 35);
		frame.getContentPane().add(lblNewLabel_1);
		
		rdbtnNewRadioButton = new JRadioButton("Standard");
		rdbtnNewRadioButton.setBounds(221, 125, 103, 21);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Deluxe");
		rdbtnNewRadioButton_1.setBounds(350, 125, 103, 21);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton("Exclusive");
		rdbtnNewRadioButton_2.setBounds(478, 125, 103, 21);
		frame.getContentPane().add(rdbtnNewRadioButton_2);

		backButton = new JButton("Back");
		backButton.setBounds(20,455, 100, 30);
		frame.getContentPane().add(backButton);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Check-In Date: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(40, 174, 150, 30);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Enter Check-Out Date:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(40, 229, 166, 30);
		frame.getContentPane().add(lblNewLabel_3);
		
		checkInComboBox = new JComboBox();
		checkInComboBox.setBounds(210, 181, 119, 21);
		frame.getContentPane().add(checkInComboBox);

		checkOutComboBox = new JComboBox();
		checkOutComboBox.setBounds(210, 236, 119, 21);
		frame.getContentPane().add(checkOutComboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Select a room:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(40, 295, 150, 30);
		frame.getContentPane().add(lblNewLabel_4);
		
		selectRoomComboBox = new JComboBox();
		selectRoomComboBox.setBounds(210, 302, 119, 21);
		frame.getContentPane().add(selectRoomComboBox);
		
		JLabel lblNewLabel_5 = new JLabel("Guest First Name:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(40, 372, 180, 30);
		frame.getContentPane().add(lblNewLabel_5);
		
		guestFirstTF = new JTextField();
		guestFirstTF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		guestFirstTF.setBounds(210, 375, 119, 27);
		frame.getContentPane().add(guestFirstTF);
		guestFirstTF.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Guest Last Name:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(350, 372, 150, 30);
		frame.getContentPane().add(lblNewLabel_6);
		
		guestLastTF = new JTextField();
		guestLastTF.setBounds(478, 376, 119, 27);
		frame.getContentPane().add(guestLastTF);
		guestLastTF.setColumns(10);
		
		reserveButton = new JButton("Reserve");
		reserveButton.setBounds(586, 460, 100, 30);
		frame.getContentPane().add(reserveButton);
	}

	public JFrame getSimulateBookingFrame(){
		return frame;
	}

	public JComboBox getSelectHotelComboBox(){
		return selectHotelComboBox;
	}

	public JRadioButton getStandardRDButton(){
		return rdbtnNewRadioButton;
	}

	public JRadioButton getDeluxeRDButton(){
		return rdbtnNewRadioButton_1;
	}
	
	public JRadioButton getExclusiveRDButton(){
		return rdbtnNewRadioButton_2;
	}

	public JButton getBackButton(){
		return backButton;
	}

	public JTextField getGuestFirstTF(){
		return guestFirstTF;
	}

	public JTextField getGuestLastTF(){
		return guestLastTF;
	}

	public JComboBox getCheckInComboBox(){
		return checkInComboBox;
	}

	public JComboBox getCheckOutComboBox(){
		return checkOutComboBox;
	}

	public JComboBox getSelectRoomComboBox(){
		return selectRoomComboBox;
	}

	public JButton getReserveButton(){
		return reserveButton;
	}

}
