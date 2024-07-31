package guiPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class HotelOverview {

	private JFrame HotelOverviewFrame;
    private JButton backButton;
    private JLabel hotelNameLabel;
    private JLabel noRoomsLabel;
    private JLabel totalRevenueLabel;


	/**
	 * Create the application.
	 */
	public HotelOverview() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		HotelOverviewFrame = new JFrame();
		HotelOverviewFrame.setBounds(100, 100, 450, 300);
		HotelOverviewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		HotelOverviewFrame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hotel Name: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(25, 37, 106, 26);
		HotelOverviewFrame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("No. of Rooms:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(25, 94, 106, 31);
		HotelOverviewFrame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Total Revenue:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(25, 165, 106, 31);
		HotelOverviewFrame.getContentPane().add(lblNewLabel_3);
		
		backButton = new JButton("Back");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		backButton.setBounds(170, 216, 85, 21);
		HotelOverviewFrame.getContentPane().add(backButton);
		
		hotelNameLabel = new JLabel("Nigga didn't change");
		hotelNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		hotelNameLabel.setBounds(170, 41, 165, 20);
		HotelOverviewFrame.getContentPane().add(hotelNameLabel);
		
		noRoomsLabel = new JLabel("Nigga didn't change2");
		noRoomsLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		noRoomsLabel.setBounds(170, 105, 165, 20);
		HotelOverviewFrame.getContentPane().add(noRoomsLabel);
		
		totalRevenueLabel = new JLabel("Nigga didn't change3");
		totalRevenueLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		totalRevenueLabel.setBounds(170, 169, 165, 24);
		HotelOverviewFrame.getContentPane().add(totalRevenueLabel);
	}

	/**
	 * Returns the JFrame used for displaying the hotel overview.
	 *
	 * @return the JFrame instance for the hotel overview
	 */
	public JFrame getHotelOverviewFrame() {
		return HotelOverviewFrame;
	}

	/**
	 * Returns the JButton used for navigating back.
	 *
	 * @return the JButton instance for the back navigation
	 */
	public JButton getBackButton() {
		return backButton;
	}

	/**
	 * Returns the JLabel displaying the hotel name.
	 *
	 * @return the JLabel instance for the hotel name
	 */
	public JLabel getHotelNameLabel() {
		return hotelNameLabel;
	}

	/**
	 * Returns the JLabel displaying the number of rooms.
	 *
	 * @return the JLabel instance for the number of rooms
	 */
	public JLabel getNoRoomsLabel() {
		return noRoomsLabel;
	}

	/**
	 * Returns the JLabel displaying the total revenue.
	 *
	 * @return the JLabel instance for the total revenue
	 */
	public JLabel getTotalRevenueLabel() {
		return totalRevenueLabel;
	}


}
