package guiPackage;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;

public class ViewHotel {

	private JFrame frame;
	private JButton hotelOverviewButton;
	private JButton roomReservationsButton;
	private JComboBox selectHotelComboBox;
	private JButton backButton;

	/**
	 * Create the application.
	 */
	public ViewHotel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 463);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		hotelOverviewButton = new JButton("Hotel Overview");
		hotelOverviewButton.setBounds(193, 176, 150, 30);
		frame.getContentPane().add(hotelOverviewButton);
		
		roomReservationsButton = new JButton("Room and Reservations");
		roomReservationsButton.setBounds(193, 304, 150, 30);
		frame.getContentPane().add(roomReservationsButton);
		
		JLabel lblNewLabel = new JLabel("High Level Information");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(157, 126, 225, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Low-Level Information");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(157, 244, 225, 40);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Hotels:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(45, 23, 100, 40);
		frame.getContentPane().add(lblNewLabel_2);
		
		selectHotelComboBox = new JComboBox();
		selectHotelComboBox.setBounds(157, 32, 200, 30);
		frame.getContentPane().add(selectHotelComboBox);

		backButton = new JButton("Back");
		backButton.setBounds(10, 386, 100, 20);
		frame.getContentPane().add(backButton);
	}

	/**
	 * Returns the JFrame used for viewing hotel details.
	 *
	 * @return the JFrame instance for viewing hotel details
	 */
	public JFrame getViewHotelFrame() {
		return frame;
	}

	/**
	 * Returns the JButton used for accessing the hotel overview.
	 *
	 * @return the JButton instance for hotel overview
	 */
	public JButton getHotelOverviewButton() {
		return hotelOverviewButton;
	}

	/**
	 * Returns the JButton used for accessing room reservations.
	 *
	 * @return the JButton instance for room reservations
	 */
	public JButton getRoomReservationButton() {
		return roomReservationsButton;
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


}
