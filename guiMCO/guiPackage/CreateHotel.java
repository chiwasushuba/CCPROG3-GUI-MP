package guiPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CreateHotel {

	JFrame CreateHotelFrame;
	private JTextField hotelNameTextField;
	private JTextField numberOfStandardRoomsTF;
	private JButton cancelButton;
	private JButton addButton;
	private JLabel lblNewLabel_3;
	private JTextField numberOfDeluxeRoomsTF;
	private JTextField numberOfExlusiveRoomsTF;


	/**
	 * Create the application.
	 */
	public CreateHotel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		CreateHotelFrame = new JFrame();
		CreateHotelFrame.setBounds(100, 100, 431, 463);
		CreateHotelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CreateHotelFrame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create Hotel:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(23, 10, 149, 33);
		CreateHotelFrame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Hotel Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(23, 99, 85, 25);
		CreateHotelFrame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Number of Standard Rooms:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(23, 155, 189, 25);
		CreateHotelFrame.getContentPane().add(lblNewLabel_2);
		
		hotelNameTextField = new JTextField();
		hotelNameTextField.setBounds(154, 101, 199, 25);
		CreateHotelFrame.getContentPane().add(hotelNameTextField);
		hotelNameTextField.setColumns(10);
		
		numberOfStandardRoomsTF = new JTextField();
		numberOfStandardRoomsTF.setBounds(222, 157, 131, 25);
		CreateHotelFrame.getContentPane().add(numberOfStandardRoomsTF);
		numberOfStandardRoomsTF.setColumns(10);
		
		cancelButton = new JButton("Back");
		cancelButton.setBounds(23, 382, 85, 21);
		CreateHotelFrame.getContentPane().add(cancelButton);
		
		addButton = new JButton("Add");
		addButton.setBounds(272, 382, 85, 21);
		CreateHotelFrame.getContentPane().add(addButton);
		
		lblNewLabel_3 = new JLabel("Number of Deluxe Rooms:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(23, 220, 189, 25);
		CreateHotelFrame.getContentPane().add(lblNewLabel_3);
		
		numberOfDeluxeRoomsTF = new JTextField();
		numberOfDeluxeRoomsTF.setBounds(222, 220, 131, 25);
		CreateHotelFrame.getContentPane().add(numberOfDeluxeRoomsTF);
		numberOfDeluxeRoomsTF.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Number of Exclusive Rooms:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(23, 290, 189, 25);
		CreateHotelFrame.getContentPane().add(lblNewLabel_4);
		
		numberOfExlusiveRoomsTF = new JTextField();
		numberOfExlusiveRoomsTF.setBounds(222, 292, 131, 25);
		CreateHotelFrame.getContentPane().add(numberOfExlusiveRoomsTF);
		numberOfExlusiveRoomsTF.setColumns(10);
	}

	/**
	 * Returns the JFrame used for creating a hotel.
	 *
	 * @return the JFrame instance for creating a hotel
	 */
	public JFrame getCreateHotelFrame() {
		return CreateHotelFrame;
	}

	/**
	 * Returns the JButton used for cancelling an operation.
	 *
	 * @return the JButton instance for cancelling
	 */
	public JButton getCancelButton() {
		return cancelButton;
	}

	/**
	 * Returns the JButton used for adding a new item or entry.
	 *
	 * @return the JButton instance for adding
	 */
	public JButton getAddButton() {
		return addButton;
	}

	/**
	 * Returns the JTextField used for entering the hotel name.
	 *
	 * @return the JTextField instance for the hotel name
	 */
	public JTextField getHotelNameTextField() {
		return hotelNameTextField;
	}

	/**
	 * Returns the JTextField used for entering the number of standard rooms.
	 *
	 * @return the JTextField instance for the number of standard rooms
	 */
	public JTextField getNumberOfStandardRoomsTF() {
		return numberOfStandardRoomsTF;
	}

	/**
	 * Returns the JTextField used for entering the number of deluxe rooms.
	 *
	 * @return the JTextField instance for the number of deluxe rooms
	 */
	public JTextField getNumberOfDeluxeRoomsTF() {
		return numberOfDeluxeRoomsTF;
	}

	/**
	 * Returns the JTextField used for entering the number of exclusive rooms.
	 *
	 * @return the JTextField instance for the number of exclusive rooms
	 */
	public JTextField getNumberOfExclusiveRoomsTF() {
		return numberOfExlusiveRoomsTF;
	}



}
