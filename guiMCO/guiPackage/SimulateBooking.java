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

	/**
	 * Returns the JFrame used for simulating a booking.
	 *
	 * @return the JFrame instance for simulating a booking
	 */
	public JFrame getSimulateBookingFrame() {
		return frame;
	}

	/**
	 * Returns the JComboBox used for selecting a hotel.
	 *
	 * @return the JComboBox instance for hotel selection
	 */
	public JComboBox getSelectHotelComboBox() {
		return selectHotelComboBox;
	}

	/**
	 * Returns the JButton used for navigating back.
	 *
	 * @return the JButton instance for back navigation
	 */
	public JButton getBackButton() {
		return backButton;
	}

	/**
	 * Returns the JTextField used for entering the guest's first name.
	 *
	 * @return the JTextField instance for the guest's first name
	 */
	public JTextField getGuestFirstTF() {
		return guestFirstTF;
	}

	/**
	 * Returns the JTextField used for entering the guest's last name.
	 *
	 * @return the JTextField instance for the guest's last name
	 */
	public JTextField getGuestLastTF() {
		return guestLastTF;
	}

	/**
	 * Returns the JComboBox used for selecting the check-in date.
	 *
	 * @return the JComboBox instance for check-in date selection
	 */
	public JComboBox getCheckInComboBox() {
		return checkInComboBox;
	}

	/**
	 * Returns the JComboBox used for selecting the check-out date.
	 *
	 * @return the JComboBox instance for check-out date selection
	 */
	public JComboBox getCheckOutComboBox() {
		return checkOutComboBox;
	}

	/**
	 * Returns the JComboBox used for selecting a room.
	 *
	 * @return the JComboBox instance for room selection
	 */
	public JComboBox getSelectRoomComboBox() {
		return selectRoomComboBox;
	}

	/**
	 * Returns the JButton used for reserving a room.
	 *
	 * @return the JButton instance for reserving a room
	 */
	public JButton getReserveButton() {
		return reserveButton;
	}


}
