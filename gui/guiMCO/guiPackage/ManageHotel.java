package guiPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageHotel {

	JFrame ManageHotelFrame;
	private JTextField changeHotelNameTF;
	private JTextField addHotelRoomTF;
	private JComboBox selectHotelComboBox;
	private JComboBox removeHotelRoomComboBox;
	private JComboBox updateRoomPriceComboBox ;
	private JComboBox removeReservationsAvailableComboBox;
	private JComboBox removeReservationRoomComboBox; 
	private JButton deleteHotelButton;
	private JButton cancelButton;
	private JButton selectHotelButton;
	private JButton changeHotelNameButton;
	private JButton addHotelRoomButton;
	private JButton removeHotelRoomButton;
	private JButton updateRoomPriceButton;
	private JButton removeReservationRoomButton;

	
	/**
	 * Create the application.
	 */
	public ManageHotel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ManageHotelFrame = new JFrame();
		ManageHotelFrame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		ManageHotelFrame.setBounds(100, 100, 751, 550);
		ManageHotelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ManageHotelFrame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select Hotel To Manage:\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(30, 21, 211, 42);
		ManageHotelFrame.getContentPane().add(lblNewLabel);
		
		selectHotelComboBox = new JComboBox();
		selectHotelComboBox.setBounds(251, 28, 303, 35);
		ManageHotelFrame.getContentPane().add(selectHotelComboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Change Hotel Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(30, 116, 141, 35);
		ManageHotelFrame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Add Hotel Room");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(30, 189, 141, 22);
		ManageHotelFrame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Remove Hotel Room");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(30, 260, 141, 22);
		ManageHotelFrame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Update Room Price");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(30, 333, 141, 22);
		ManageHotelFrame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Remove Reservation\r\n");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(30, 407, 141, 22);
		ManageHotelFrame.getContentPane().add(lblNewLabel_5);
		
		deleteHotelButton = new JButton("Delete Hotel");
		deleteHotelButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deleteHotelButton.setBounds(382, 462, 172, 30);
		ManageHotelFrame.getContentPane().add(deleteHotelButton);
		
		changeHotelNameTF = new JTextField();
		changeHotelNameTF.setBounds(227, 122, 327, 24);
		ManageHotelFrame.getContentPane().add(changeHotelNameTF);
		changeHotelNameTF.setColumns(10);
		
		removeHotelRoomComboBox = new JComboBox();
		removeHotelRoomComboBox.setBounds(227, 261, 327, 24);
		ManageHotelFrame.getContentPane().add(removeHotelRoomComboBox);
		
		updateRoomPriceComboBox = new JComboBox();
		updateRoomPriceComboBox.setBounds(227, 336, 327, 24);
		ManageHotelFrame.getContentPane().add(updateRoomPriceComboBox);
		
		removeReservationsAvailableComboBox = new JComboBox();
		removeReservationsAvailableComboBox.setBounds(424, 410, 130, 21);
		ManageHotelFrame.getContentPane().add(removeReservationsAvailableComboBox);
		
		addHotelRoomTF = new JTextField();
		addHotelRoomTF.setBounds(227, 193, 327, 24);
		ManageHotelFrame.getContentPane().add(addHotelRoomTF);
		addHotelRoomTF.setColumns(10);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(25, 482, 85, 21);
		ManageHotelFrame.getContentPane().add(cancelButton);
		
		removeReservationRoomComboBox = new JComboBox();
		removeReservationRoomComboBox.setBounds(227, 410, 130, 21);
		ManageHotelFrame.getContentPane().add(removeReservationRoomComboBox);
		
		JLabel lblNewLabel_6 = new JLabel("Room");
		lblNewLabel_6.setBounds(275, 395, 45, 13);
		ManageHotelFrame.getContentPane().add(lblNewLabel_6);
		
		selectHotelButton = new JButton("Select");
		selectHotelButton.setBounds(611, 30, 85, 30);
		ManageHotelFrame.getContentPane().add(selectHotelButton);
		
		changeHotelNameButton = new JButton("Change");
		changeHotelNameButton.setBounds(611, 123, 85, 24);
		ManageHotelFrame.getContentPane().add(changeHotelNameButton);
		
		addHotelRoomButton = new JButton("Add");
		addHotelRoomButton.setBounds(611, 192, 85, 24);
		ManageHotelFrame.getContentPane().add(addHotelRoomButton);
		
		removeHotelRoomButton = new JButton("Remove");
		removeHotelRoomButton.setBounds(611, 261, 85, 24);
		ManageHotelFrame.getContentPane().add(removeHotelRoomButton);
		
		updateRoomPriceButton = new JButton("Update");
		updateRoomPriceButton.setBounds(611, 336, 85, 24);
		ManageHotelFrame.getContentPane().add(updateRoomPriceButton);
		
		removeReservationRoomButton = new JButton("Remove");
		removeReservationRoomButton.setBounds(611, 410, 85, 24);
		ManageHotelFrame.getContentPane().add(removeReservationRoomButton);
	}

	public JFrame getManageHotelFrame(){
		return ManageHotelFrame;
	}

	public JComboBox getSelectHotelComboBox(){
		return selectHotelComboBox;
	}

	public JComboBox getRemoveHotelRoomComboBox(){
		return removeHotelRoomComboBox;
	}

	public JComboBox getUpdateRoomPriceComboBox(){
		return updateRoomPriceComboBox;
	}

	public JComboBox getRemoveReservationRoomComboBox(){
		return removeReservationRoomComboBox;
	}

	public JComboBox getRemoveReservationAvailableComboBox(){
		return removeReservationsAvailableComboBox;
	}

	public JButton getDeleteHotelButton(){
		return deleteHotelButton;
	}

	public JButton getCancelButton(){
		return cancelButton;
	}

	public JButton getSelectHotelButton(){
		return selectHotelButton;
	}

	public JButton getChangeHotelNameButton(){
		return changeHotelNameButton;
	}

	public JButton getAddHotelRoomButton(){
		return addHotelRoomButton;
	}

	public JButton getRemoveHotelRoomButton(){
		return removeHotelRoomButton;
	}

	public JButton getUpdateRoomPriceButton(){
		return updateRoomPriceButton;
	}

	public JButton getRemoveReservationRoomButton(){
		return removeReservationRoomButton;
	}

	public JTextField getChangeHotelNameTF(){
		return changeHotelNameTF;
	}

	public JTextField getAddHotelRoomTF(){
		return addHotelRoomTF;
	}

}
