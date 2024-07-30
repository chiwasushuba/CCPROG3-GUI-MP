package guiPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu {

	JFrame MainMenuFrame;
	JButton createHotelButton;
	JButton viewHotelButton;
	JButton manageHotelButton;
	JButton simulateBookingButton;
	JButton exitButton;


	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MainMenuFrame = new JFrame();
		MainMenuFrame.setBounds(100, 100, 768, 510);
		MainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainMenuFrame.getContentPane().setLayout(null);
		
		createHotelButton = new JButton("Create Hotel");
		createHotelButton.setBounds(294, 71, 150, 30);
		MainMenuFrame.getContentPane().add(createHotelButton);
		
		viewHotelButton = new JButton("View Hotel");
		viewHotelButton.setBounds(294, 140, 150, 30);
		MainMenuFrame.getContentPane().add(viewHotelButton);
		
		manageHotelButton = new JButton("Manage Hotel");
		manageHotelButton.setBounds(294, 209, 150, 30);
		MainMenuFrame.getContentPane().add(manageHotelButton);
		
		simulateBookingButton = new JButton("Simulate Booking");
		simulateBookingButton.setBounds(294, 278, 150, 30);
		MainMenuFrame.getContentPane().add(simulateBookingButton);
		
		exitButton = new JButton("Exit");		
		exitButton.setBounds(294, 358, 150, 30);
		MainMenuFrame.getContentPane().add(exitButton);
	}

	public JButton getcreateHotelButton(){
		return createHotelButton;
	}

	public JButton getViewHotelButton(){
		return viewHotelButton;
	}

	public JButton getManageHotelButton(){
		return manageHotelButton;
	}

	public JButton getSimulateBookingButton(){
		return simulateBookingButton;
	}

	public JFrame getMainMenuFrame(){
		return MainMenuFrame;
	}

	public JButton getExitButton(){
		return exitButton;
	}

}
