package guiPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JTextArea;

public class RoomAndReservation {

	private JFrame frame;
    private JLabel roomNameLabel;
    private JLabel pricePerNightLabel;
    private JLabel availDaysLabel;
    private JComboBox checkInDateComboBox;
    private JComboBox checkOutDateComboBox;
    private JComboBox selectRoomComboBoxRoom;
    private JComboBox selectRoomComboBoxReservation;
    private JTextArea textArea;
    private JTextArea firstTextArea;
    private JComboBox selectReservationComboBoxReservation;

	/**
	 * Create the application.
	 */
	public RoomAndReservation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 601, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(10, 402, 85, 21);
		frame.getContentPane().add(backButton);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 567, 380);
		frame.getContentPane().add(tabbedPane);
		
		JPanel viewPanel = new JPanel();
		tabbedPane.addTab("View available rooms w/Date", null, viewPanel, null);
		viewPanel.setLayout(null);
		
		JLabel checkInLabel = new JLabel("Check-In date:");
		checkInLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkInLabel.setBounds(10, 26, 101, 23);
		viewPanel.add(checkInLabel);
		
		checkInDateComboBox = new JComboBox();
		checkInDateComboBox.setBounds(121, 29, 101, 21);
		viewPanel.add(checkInDateComboBox);
		
		JLabel checkOutLabel = new JLabel("Check-Out date: ");
		checkOutLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkOutLabel.setBounds(287, 26, 116, 23);
		viewPanel.add(checkOutLabel);
		
		firstTextArea = new JTextArea();
		firstTextArea.setBounds(24, 79, 494, 232);
		viewPanel.add(firstTextArea);
		
		checkOutDateComboBox = new JComboBox();
		checkOutDateComboBox.setBounds(408, 29, 110, 21);
		viewPanel.add(checkOutDateComboBox);
		
		JPanel roomOverviewPanel = new JPanel();
		tabbedPane.addTab("Room overview", null, roomOverviewPanel, null);
		roomOverviewPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select Room:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(44, 66, 94, 13);
		roomOverviewPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Room Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(44, 184, 94, 17);
		roomOverviewPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Pricer per Night:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(44, 236, 110, 13);
		roomOverviewPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Available Days:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(44, 289, 110, 13);
		roomOverviewPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Information about the Hotel:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(44, 135, 210, 13);
		roomOverviewPanel.add(lblNewLabel_5);
		
		roomNameLabel = new JLabel("New label");
		roomNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		roomNameLabel.setBounds(177, 184, 358, 17);
		roomOverviewPanel.add(roomNameLabel);
		
		pricePerNightLabel = new JLabel("New label");
		pricePerNightLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pricePerNightLabel.setBounds(177, 236, 360, 17);
		roomOverviewPanel.add(pricePerNightLabel);

		availDaysLabel = new JLabel("New label");
		availDaysLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		availDaysLabel.setBounds(177, 289, 360, 17);
		roomOverviewPanel.add(availDaysLabel);

		selectRoomComboBoxRoom = new JComboBox();
		selectRoomComboBoxRoom.setBounds(177, 64, 135, 21);
		roomOverviewPanel.add(selectRoomComboBoxRoom);
		
		JPanel reservationOverviewPanel = new JPanel();
		tabbedPane.addTab("Reservation overview", null, reservationOverviewPanel, null);
		reservationOverviewPanel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Select Room:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(26, 24, 95, 13);
		reservationOverviewPanel.add(lblNewLabel_4);

		selectRoomComboBoxReservation = new JComboBox();
		selectRoomComboBoxReservation.setBounds(131, 21, 110, 21);
		reservationOverviewPanel.add(selectRoomComboBoxReservation);
		
		JLabel lblNewLabel_6 = new JLabel("Select Reservation:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(268, 24, 127, 13);
		reservationOverviewPanel.add(lblNewLabel_6);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(26, 61, 507, 260);
		reservationOverviewPanel.add(textArea);

        selectReservationComboBoxReservation = new JComboBox();
		selectReservationComboBoxReservation.setBounds(405, 21, 128, 21);
		reservationOverviewPanel.add(selectReservationComboBoxReservation);
	}

    public JFrame getRoomAndReservationFrame(){
        return frame;
    }

    public JLabel getRoomNameLabel(){
        return roomNameLabel;
    }

    public JLabel getPricePerNightLabel(){
        return pricePerNightLabel;
    }

    public JLabel getAvailDaysLabel(){
        return availDaysLabel;
    }

    public JComboBox getCheckInDateComboBox(){
        return checkInDateComboBox;
    }

    public JComboBox getCheckOutDateComboBox(){
        return checkOutDateComboBox;
    }

    public JTextArea getFirstTextArea(){
        return firstTextArea;
    }

    public JComboBox getSelectRoomComboBoxRoom(){
        return selectRoomComboBoxRoom;
    }

    public JComboBox getSelectRoomComboBoxReservation(){
        return selectRoomComboBoxReservation;
    }

    public JComboBox getSelectReservationComboBoxReservation(){
        return selectRoomComboBoxReservation;
    }

    public JTextArea getTextArea(){
        return textArea;
    }


}
