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
    private RoomAndReservation roomAndReservation;

    // MAIN MENU BUTTONS

    public Controller(MainMenu mainMenu, CreateHotel createHotel, SimulateBooking simulateBooking, ManageHotel manageHotel, ViewHotel viewHotel, HotelOverview hotelOverview, RoomAndReservation roomAndReservation, HotelSystem model){
        this.mainMenu = mainMenu;
        this.createHotel = createHotel;
        this.simulateBooking = simulateBooking;
        this.manageHotel = manageHotel;
        this.viewHotel = viewHotel;
        this.hotelOverview = hotelOverview;
        this.roomAndReservation = roomAndReservation;
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

                viewHotel.getViewHotelFrame().setVisible(false);
                hotelOverview.getHoteloverviewFrame().setVisible(true);
            }
        });

        this.viewHotel.getRoomReservationButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    int selectedHotelIndex = viewHotel.getSelectHotelComboBox().getSelectedIndex();
                    fillSelectCheckDatesForView();
                    fillSelectRoomForView(selectedHotelIndex);
                    roomAndReservation.getRoomAndReservationFrame().setVisible(true);
                    viewHotel.getViewHotelFrame().setVisible(false);
                } catch (Exception NullPointerException) {
                    viewHotel.getViewHotelFrame().dispose();
                    mainMenu.getMainMenuFrame().setVisible(true);
                }
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

        // RoomReservation

        this.roomAndReservation.getCheckOutDateComboBox().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e){
                int selectedIndex = viewHotel.getSelectHotelComboBox().getSelectedIndex();

                fillFirstTextArea(selectedIndex);

           } 
        });

        this.roomAndReservation.getSelectRoomComboBoxRoom().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                int selectedIndex = viewHotel.getSelectHotelComboBox().getSelectedIndex();
                int selectedRoomIndex = roomAndReservation.getSelectRoomComboBoxRoom().getSelectedIndex();
                String roomDays = setStringAvailDays();
                String pricePerNight = String.valueOf(model.getHotel().get(selectedIndex).getRoom(selectedRoomIndex).getPrice());
                String roomName = model.getHotel().get(selectedIndex).getRoom(selectedIndex).getRoomName();
                roomAndReservation.getAvailDaysLabel().setText(roomDays);
                roomAndReservation.getPricePerNightLabel().setText(pricePerNight);
                roomAndReservation.getRoomNameLabel().setText(roomName);

            }
        });

        this.roomAndReservation.getSelectRoomComboBoxReservation().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                fillSelectRoomReservationForView();
            }
        });

        this.roomAndReservation.getSelectReservationComboBoxReservation().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                fillTextArea();
            }
        });

        this.roomAndReservation.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                viewHotel.getViewHotelFrame().setVisible(true);
                roomAndReservation.getRoomAndReservationFrame().setVisible(false);
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

        this.manageHotel.getUpdateRoomPriceButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int selectedHotelIndex=  manageHotel.getSelectHotelComboBox().getSelectedIndex();
                int selectedRoomIndex = manageHotel.getUpdateRoomPriceComboBox().getSelectedIndex();
                double newPrice = Double.parseDouble(manageHotel.getUpdatePriceTF().getText());

                model.getHotel().get(selectedHotelIndex).getRoom(selectedRoomIndex).setPrice(newPrice);
            }
            
        });


        // Simulate Booking

        this.simulateBooking.getSelectHotelComboBox().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int selectedIndex = simulateBooking.getSelectHotelComboBox().getSelectedIndex();

                simulateBooking.getSelectRoomComboBox().removeAllItems();
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

                int result = JOptionPane.showConfirmDialog(null, "Do you want a Discount?", "Discount Code", 0);
                
                if(result == JOptionPane.YES_OPTION){
                    String discountCodeInputted = JOptionPane.showInputDialog("Discount Code: ");
                    Discount discount = new Discount();
                    discount.applyDiscount(discountCodeInputted, model.getHotel().get(selectedHotelIndex).getRoom(roomIndex).getReservation(latestReservationIndex));
                } 
                else if(result == JOptionPane.NO_OPTION){
                    JOptionPane.showMessageDialog(null, "You reserved with no Discount!", "Reservation", 1);
                }

                simulateBooking.getSimulateBookingFrame().setVisible(false);
                mainMenu.getMainMenuFrame().setVisible(true);
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
            manageHotel.getUpdateRoomPriceComboBox().addItem(model.getHotel().get(selectedIndex).getRoom(i).getRoomName());
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

    public void fillSelectCheckDatesForView(){
        roomAndReservation.getCheckInDateComboBox().removeAllItems();
        roomAndReservation.getCheckOutDateComboBox().removeAllItems();

        for (int i = 1; i < 31; i++){
            if(i <= 30){
                roomAndReservation.getCheckInDateComboBox().addItem(i);
            }
            if(i >= 2){
                roomAndReservation.getCheckOutDateComboBox().addItem(i);
            }
        }

    }

    public void fillFirstTextArea(int selectedIndex){

        roomAndReservation.getFirstTextArea().setText("");

        int checkIn = (int) roomAndReservation.getCheckInDateComboBox().getSelectedItem();
        int checkOut = (int) roomAndReservation.getCheckOutDateComboBox().getSelectedItem();

        for(int i = 0; i < model.getHotel().get(selectedIndex).getRoom().size(); i++){
            if(model.getHotel().get(selectedIndex).getRoom(i).checkAvailability(checkIn, checkOut) == true){
                roomAndReservation.getFirstTextArea().append(model.getHotel().get(selectedIndex).getRoom(i).getRoomName() + "\n");
            }
        }
    }

    public String setStringAvailDays(){

        int selectedIndex = viewHotel.getSelectHotelComboBox().getSelectedIndex();
        int selectedRoomIndex = roomAndReservation.getSelectRoomComboBoxRoom().getSelectedIndex();

        StringBuilder sb = new StringBuilder();

        for (int x = 0; x < 31; x++){
            if (model.getHotel().get(selectedIndex).getRoom(selectedRoomIndex).getAvailableCheckInDays()[x] == true)
                sb.append(" "+ (x+1) + " ");
        }
        return sb.toString();
    }

    public void fillSelectRoomForView(int selectedIndex) {
        //Selected Index is for the hotel
        int n = model.getHotel().get(selectedIndex).getTotalRooms();
    
        // Clear the combo boxes
        // roomAndReservation.getSelectRoomComboBoxReservation().removeAllItems();
        // roomAndReservation.getSelectRoomComboBoxRoom().removeAllItems();
    
        for(int i = 0; i < n; i++){
            roomAndReservation.getSelectRoomComboBoxRoom().addItem(model.getHotel().get(selectedIndex).getRoom(i).getRoomName());
            roomAndReservation.getSelectReservationComboBoxReservation().addItem(model.getHotel().get(selectedIndex).getRoom(i).getRoomName());
        }

        System.out.println("Success");
    }

    public void fillSelectRoomReservationForView(){
        int selectedIndex = viewHotel.getSelectHotelComboBox().getSelectedIndex();
        int selectedRoomIndex = roomAndReservation.getSelectRoomComboBoxRoom().getSelectedIndex();
        int n = model.getHotel().get(selectedIndex).getRoom(selectedRoomIndex).getReservationList().size();

        roomAndReservation.getSelectReservationComboBoxReservation().removeAllItems();

        for(int i = 0; i < n; i++){
            String reservations = model.getHotel().get(selectedIndex).getRoom(selectedRoomIndex).getReservation(i).getGuestName();
            roomAndReservation.getSelectReservationComboBoxReservation().addItem(reservations);
        }
    }

    public void fillTextArea(){
        int selectedIndex = viewHotel.getSelectHotelComboBox().getSelectedIndex();
        int selectedRoomIndex = roomAndReservation.getSelectRoomComboBoxRoom().getSelectedIndex();
        int selectedReservation = roomAndReservation.getSelectReservationComboBoxReservation().getSelectedIndex();
        String  guestName = model.getHotel().get(selectedIndex).getRoom(selectedRoomIndex).getReservation(selectedReservation).getGuestName();
        int checkIn = model.getHotel().get(selectedIndex).getRoom(selectedRoomIndex).getReservation(selectedReservation).getCheckInDate();
        int checkOut = model.getHotel().get(selectedIndex).getRoom(selectedRoomIndex).getReservation(selectedReservation).getCheckoutDate();
        double totalCost = model.getHotel().get(selectedIndex).getRoom(selectedRoomIndex).getReservation(selectedReservation).getTotalPrice();
        String forDiscount = model.getHotel().get(selectedIndex).getRoom(selectedRoomIndex).getReservation(selectedReservation).getDiscountCode();


        roomAndReservation.getFirstTextArea().setText("");

        roomAndReservation.getTextArea().append("Here is the reservation info:\n");
        roomAndReservation.getTextArea().append("Guest Name: " + guestName + "\n");
        roomAndReservation.getTextArea().append("Check In: " + checkIn + "\n");
        roomAndReservation.getTextArea().append("Check Out: " + checkOut + "\n");
        roomAndReservation.getTextArea().append("Total Cost: " + totalCost + "\n");
        roomAndReservation.getTextArea().append("Discount code Applied:" + forDiscount + "\n");
        roomAndReservation.getTextArea().append("Breakdown Cost:\n\n");

        int numDay = 1;
        for(int i = 0; i < checkIn; i++){
            roomAndReservation.getTextArea().append("Day " + numDay + ": " + model.getHotel().get(selectedIndex).getRoom(selectedRoomIndex).getPrice() * model.getHotel().get(selectedIndex).getDPM().getPercentage(i) + "\n");
            numDay++;
        }

    }
}
