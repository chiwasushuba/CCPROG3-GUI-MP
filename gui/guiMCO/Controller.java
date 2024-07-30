import guiPackage.*;
import modelPackages.*;

import java.awt.event.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Controller {
    private HotelSystem model;
    private MainMenu mainMenu;
    private CreateHotel createHotel;
    private SimulateBooking simulateBooking;
    private ManageHotel manageHotel;
    private ViewHotel viewHotel;
    private HotelOverview hotelOverview;

    // MAIN MENU BUTTONS

    public Controller(MainMenu mainMenu, CreateHotel createHotel, SimulateBooking simulateBooking, ManageHotel manageHotel, ViewHotel viewHotel, HotelOverview hotelOverview, HotelSystem model){
        this.mainMenu = mainMenu;
        this.createHotel = createHotel;
        this.simulateBooking = simulateBooking;
        this.manageHotel = manageHotel;
        this.viewHotel = viewHotel;
        this.hotelOverview = hotelOverview;
        this.model = model;

        //MainMenu
        this.mainMenu.getcreateHotelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                mainMenu.getMainMenuFrame().setVisible(false);
                createHotel.getCreateHotelFrame().setVisible(true);
            }
            
        });

        this.mainMenu.getViewHotelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                mainMenu.getMainMenuFrame().setVisible(false);
                viewHotel.getViewHotelFrame().setVisible(true);
            }
        });

        this.mainMenu.getManageHotelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                mainMenu.getMainMenuFrame().setVisible(false);
                manageHotel.getManageHotelFrame().setVisible(true);
            }
        });

        this.mainMenu.getSimulateBookingButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                mainMenu.getMainMenuFrame().setVisible(false);
                simulateBooking.getSimulateBookingFrame().setVisible(true);
            }
        });

        this.mainMenu.getExitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });




        this.createHotel.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    String nameTextField = createHotel.getHotelNameTextField().getText();
                    String numberOfStandardRoomsString = createHotel.getNumberOfStandardRoomsTF().getText();
                    int numberOfStandardRooms = Integer.parseInt(numberOfStandardRoomsString);
                    String numberOfDeluxeRoomsString = createHotel.getNumberOfDeluxeRoomsTF().getText();
                    int numberOfDeluxeRooms = Integer.parseInt(numberOfDeluxeRoomsString);
                    String numberOfExecutiveRoomsString = createHotel.getNumberOfExclusiveRoomsTF().getText();
                    int numberOfExecutiveRooms = Integer.parseInt(numberOfExecutiveRoomsString);
                    int totalNumRooms = numberOfStandardRooms + numberOfDeluxeRooms  + numberOfExecutiveRooms;
        
                    boolean checker = model.addHotel(nameTextField, totalNumRooms);
                    
                    if(checker == true){
                        model.getHotel().get(model.getHotel().size() - 1).addStandardRoom(nameTextField, numberOfStandardRooms);
                        model.getHotel().get(model.getHotel().size() - 1).addDeluxeRoom(nameTextField, numberOfDeluxeRooms);
                        model.getHotel().get(model.getHotel().size() - 1).addExecutiveRoom(nameTextField, numberOfExecutiveRooms);
        
                        System.out.println("Succesfully Added");
                        fillSelectHotelComboBox();
        
                        createHotel.getHotelNameTextField().setText("");
                        createHotel.getNumberOfStandardRoomsTF().setText("");
                        createHotel.getNumberOfDeluxeRoomsTF().setText("");
                        createHotel.getNumberOfExclusiveRoomsTF().setText("");
                        mainMenu.getMainMenuFrame().setVisible(true);
                        createHotel.getCreateHotelFrame().setVisible(false);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Error", "Failure", JOptionPane.ERROR_MESSAGE);
                    }
                } catch(NumberFormatException ex){
                    System.err.println("Invalid Number: " + ex.getMessage());
                } catch(Exception ex){
                    System.err.println("Error: " + ex.getMessage());
                }
            }
        });
        
        
        

        this.createHotel.getCancelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                createHotel.getHotelNameTextField().setText("");
                createHotel.getNumberOfStandardRoomsTF().setText("");
                createHotel.getNumberOfDeluxeRoomsTF().setText("");
                createHotel.getNumberOfExclusiveRoomsTF().setText("");
                createHotel.getCreateHotelFrame().setVisible(false);
                mainMenu.getMainMenuFrame().setVisible(true);
            }
        });


        
        //View Hotel

        this.viewHotel.getHotelOverviewButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int selectedIndex = viewHotel.getSelectHotelComboBox().getSelectedIndex();
                System.out.println(model.getHotel().get(selectedIndex).getTotalRooms());


                hotelOverview.getHotelNameLabel().setText(model.getHotel().get(selectedIndex).getHotelName());
                hotelOverview.getNoRoomsLabel().setText("" + model.getHotel().get(selectedIndex).getTotalRooms());
                hotelOverview.getTotalRevenueLabel().setText("" + model.getHotel().get(selectedIndex).getEarnings());

                mainMenu.getMainMenuFrame().setVisible(false);
                hotelOverview.getHoteloverviewFrame().setVisible(true);
            }
        });

        this.viewHotel.getRoomReservationButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){


            }
        });

        this.viewHotel.getBackButton().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e){
            viewHotel.getViewHotelFrame().setVisible(false);
            mainMenu.getMainMenuFrame().setVisible(true);
           }

        });

        //HotelOverview

        this.hotelOverview.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                hotelOverview.getHoteloverviewFrame().setVisible(false);
                viewHotel.getViewHotelFrame().setVisible(true);
            }
        });


        //Manage Hotel

        this.manageHotel.getCancelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                manageHotel.getManageHotelFrame().setVisible(false);
                mainMenu.getMainMenuFrame().setVisible(true);
            }
        });

        this.manageHotel.getSelectHotelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int selectedIndex = manageHotel.getSelectHotelComboBox().getSelectedIndex();
                System.out.println("Selected Index: " + manageHotel.getSelectHotelComboBox().getSelectedIndex());
                System.out.println("Total Rooms: " + model.getHotel().get(selectedIndex).getTotalRooms());
                fillSelectRoomComboBox(selectedIndex);
            }
        });


        this.manageHotel.getChangeHotelNameButton().addActionListener(new ActionListener() {
            @SuppressWarnings("unchecked")
            @Override
            public void actionPerformed(ActionEvent e){

                int selectedIndex = manageHotel.getSelectHotelComboBox().getSelectedIndex();
                String newName = manageHotel.getChangeHotelNameTF().getText();
                boolean proceedChange = true;

                for(int i = 0 ; i  < model.getHotel().size(); i++){
                    if(model.getHotel().get(i).getHotelName().equalsIgnoreCase(newName)){   
                        proceedChange = false;
                    }
                }
                
                if(proceedChange){
                    model.getHotel().get(selectedIndex).setHotelName(newName);
                    manageHotel.getSelectHotelComboBox().removeItemAt(selectedIndex);
                    manageHotel.getSelectHotelComboBox().insertItemAt(newName, selectedIndex);
                    manageHotel.getSelectHotelComboBox().setSelectedIndex(selectedIndex);
                    

                    System.out.println(manageHotel.getSelectHotelComboBox().getSelectedItem());
                    System.out.println(newName);
                    System.out.println("success");
                } else {
                    JOptionPane.showMessageDialog(null, "Error", "Failure", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        this.manageHotel.getAddHotelRoomButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int selectedIndex = manageHotel.getSelectHotelComboBox().getSelectedIndex();
                String selectedHotel = (String) manageHotel.getSelectHotelComboBox().getSelectedItem();
                String numberOfRoomsString = manageHotel.getAddHotelRoomTF().getText();
                int numberOfRooms = Integer.parseInt(numberOfRoomsString);

                System.out.println("Number of rooms added" + numberOfRooms);
                model.getHotel().get(selectedIndex).addStandardRoom(selectedHotel, numberOfRooms);
                System.out.println("Total Number of Rooms: " + model.getHotel().get(selectedIndex).getTotalRooms());
                fillSelectRoomComboBox(selectedIndex);
            }
        });

        this.manageHotel.getDeleteHotelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int selectedIndex = manageHotel.getSelectHotelComboBox().getSelectedIndex();
                model.removeHotel(selectedIndex);
                manageHotel.getSelectHotelComboBox().removeItemAt(selectedIndex);
                viewHotel.getSelectHotelComboBox().removeItemAt(selectedIndex);
                simulateBooking.getSelectHotelComboBox().removeItemAt(selectedIndex);

                manageHotel.getRemoveHotelRoomComboBox().removeAllItems();
                manageHotel.getRemoveReservationRoomComboBox().removeAllItems();
                manageHotel.getRemoveReservationAvailableComboBox().removeAllItems();
                // manageHotel.getSelectHotelComboBox().setSelectedIndex(0);
            }
        });

        this.manageHotel.getRemoveHotelRoomButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int selectedIndex = manageHotel.getSelectHotelComboBox().getSelectedIndex();
                model.removeHotel(selectedIndex);
            }
        });

        this.manageHotel.getRemoveReservationAvailableComboBox().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int selectedHotelIndex=  manageHotel.getSelectHotelComboBox().getSelectedIndex();
                int selectedRoomIndex = manageHotel.getRemoveReservationAvailableComboBox().getSelectedIndex();
                fillSelectReservationComboBox(selectedHotelIndex, selectedRoomIndex);
            }
        });


        // Simulate Booking

        this.simulateBooking.getSelectHotelComboBox().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int selectedIndex = simulateBooking.getSelectHotelComboBox().getSelectedIndex();

                simulateBooking.getSelectRoomComboBox().removeAllItems();
                simulateBooking.getStandardRDButton().setSelected(true);
                fillSelectCheckDates();

            }
        });

        this.simulateBooking.getCheckOutComboBox().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int selectedIndex = simulateBooking.getSelectHotelComboBox().getSelectedIndex();
                fillSimulateSelectRoomComboBox(selectedIndex); // FIx this 
            }
        });

        this.simulateBooking.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                simulateBooking.getSimulateBookingFrame().setVisible(false);
                mainMenu.getMainMenuFrame().setVisible(true);
            }
        });

        this.simulateBooking.getStandardRDButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                simulateBooking.getDeluxeRDButton().setSelected(false);
                simulateBooking.getExclusiveRDButton().setSelected(false);


            }
        });

        this.simulateBooking.getDeluxeRDButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                simulateBooking.getStandardRDButton().setSelected(false);
                simulateBooking.getExclusiveRDButton().setSelected(false);

            }
        });

        this.simulateBooking.getExclusiveRDButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                simulateBooking.getStandardRDButton().setSelected(false);
                simulateBooking.getDeluxeRDButton().setSelected(false);

            }
        });

        // Add an action listener to the reserve button
        this.simulateBooking.getReserveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get selected hotel and room indices
                int selectedHotelIndex = simulateBooking.getSelectHotelComboBox().getSelectedIndex();
                int selectedRoomIndex = simulateBooking.getSelectRoomComboBox().getSelectedIndex();

                // Get guest's full name
                String fullName = simulateBooking.getGuestFirstTF().getText() + simulateBooking.getGuestLastTF().getText();

                int checkIn = (int) simulateBooking.getCheckInComboBox().getSelectedItem();
                int checkOut = (int) simulateBooking.getCheckOutComboBox().getSelectedItem();

                // Debugging output
                System.out.println("Check in: " + checkIn + " Checkout: " + checkOut);

                int roomIndex = simulateBooking.getSelectRoomComboBox().getSelectedIndex();

                // checks the availability of the rooms
                boolean checker = model.getHotel().get(selectedHotelIndex).getRoom(selectedRoomIndex).checkAvailability(checkIn, checkOut);
                if (checker == true) {

                    model.getHotel().get(selectedHotelIndex).addRoomReservation(roomIndex, fullName, checkIn, checkOut);
                    model.getHotel().get(selectedHotelIndex).setEarnings(model.getHotel().get(selectedHotelIndex).getRoom());
                    model.getHotel().get(selectedHotelIndex).getRoom(selectedRoomIndex).setStatus(true);
                }

                int latestReservationIndex = model.getHotel().get(selectedHotelIndex).getRoom(selectedRoomIndex).getReservationList().size() - 1;

                int result = JOptionPane.showConfirmDialog(null, "nigga", "Discount Code", 0);
                
                if(result == JOptionPane.YES_OPTION){
                    String discountCodeInputted = JOptionPane.showInputDialog("Discount Code: ");
                } else if(result == JOptionPane.NO_OPTION){
                    JOptionPane.showMessageDialog(null, "You reserved with no Discount!", "Reservation", 1);
                }

            }
        });



        mainMenu.getMainMenuFrame().setVisible(true);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void fillSelectHotelComboBox(){
        
        int i = model.getHotel().size()-1;

        viewHotel.getSelectHotelComboBox().insertItemAt(model.getHotel().get(i).getHotelName(), i);
        manageHotel.getSelectHotelComboBox().insertItemAt(model.getHotel().get(i).getHotelName(), i);
        simulateBooking.getSelectHotelComboBox().insertItemAt(model.getHotel().get(i).getHotelName(), i);

    }

    public void fillSelectRoomComboBox(int selectedIndex){
        // ArrayList<Hotel> hotelList = model.getHotel();

        manageHotel.getRemoveReservationRoomComboBox().removeAllItems();
        manageHotel.getRemoveHotelRoomComboBox().removeAllItems();

        for(int i = 0; i < model.getHotel().get(selectedIndex).getTotalRooms(); i++){
            manageHotel.getRemoveReservationRoomComboBox().addItem(model.getHotel().get(selectedIndex).getRoom(i).getRoomName());
            manageHotel.getRemoveHotelRoomComboBox().addItem(model.getHotel().get(selectedIndex).getRoom(i).getRoomName());
        }
    }

    public void fillSimulateSelectRoomComboBox(int selectedIndex){
        ArrayList<Room> roomsList = model.getHotel().get(selectedIndex).getRoom();

        simulateBooking.getSelectRoomComboBox().removeAllItems();

        for(int i = 0; i < model.getHotel().get(selectedIndex).getTotalRooms(); i++){
            if(roomsList.get(i).getStatus() == false){
                simulateBooking.getSelectRoomComboBox().addItem(roomsList.get(i).getRoomName());
            }
        }
    }

    public void fillSelectReservationComboBox(int selectedHotelIndex, int selectedRoomIndex){
        ArrayList<Reservation> reservationList = model.getHotel().get(selectedHotelIndex).getRoom(selectedRoomIndex).getReservationList();

        manageHotel.getRemoveReservationAvailableComboBox().removeAllItems();
        
        for(int i = 0; i < reservationList.size(); i++){
            manageHotel.getRemoveReservationAvailableComboBox().addItem(reservationList.get(i).getGuestName());
        }
    }

    public void fillSelectCheckDates(){
        
        simulateBooking.getCheckInComboBox().removeAllItems();
        simulateBooking.getCheckOutComboBox().removeAllItems();

        for(int i = 1; i <= 31; i++){
            if(i <= 30){
                simulateBooking.getCheckInComboBox().addItem(i);
            }
            if(i >= 2){
                simulateBooking.getCheckOutComboBox().addItem(i);
            }
        }

    }


}
