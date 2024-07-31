package modelPackages;

import java.util.ArrayList;

public abstract class Room{
    private String RoomName;
    private double price;
    private boolean status;
    private ArrayList<Reservation> reservation = new ArrayList<Reservation>();
    private boolean[] availableCheckInDays = new boolean[32];

    /*
     * Constructs a room with the given name
     * 
     * @param RoomName creates the room using given name
     */
    public Room (String RoomName){
        this.RoomName = RoomName;
        status = false;     //false means havent booked yet
        for (int i = 0; i < 32; i++) {
            availableCheckInDays[i] = true;
        }
    }

  

    /*
     * Sets the price of the Room
     * 
     * 
     * @param newPrice is the new price of the room
     * @return returns true of price is greater than 100
     */
    public boolean setPrice (double newPrice){
        if (newPrice >= 100.0f){
            this.price = newPrice;
            return true;
        }
        return false;
    }

    /*
     * Sets the status of the room
     * 
     * @param newStatus sets the status if true or false
     */
    public void setStatus (boolean newStatus){
        this.status = newStatus;
    }


    /*
     * Gets the RoomName
     * 
     * @return returns the String name of the room
     */
    public String getRoomName(){
        return RoomName;
    }

    /*
     * Gets the price of the room
     * 
     * @return returns the price of the room
     */
    public double getPrice(){
        return price;
    }

    /*
     * Gets the status of the room
     * 
     * @return returns the status of the room 
     */
    public boolean getStatus(){
        return status;
    }

    /*
     * Adds a reservation using name, checkIn checkOut, roomPRice
     * 
     * @param name GuestName of the reservation
     * @param checkIn day of the check in
     * @param checkOut day of the checkout
     * @param roomPrice the price per Night
     */
    public void addReservation (String name, int checkIn, int checkOut, double roomPrice){
        reservation.add(new Reservation(name, checkIn, checkOut, roomPrice));
    }

    /*
     * Removes the reservation using a specific index
     * 
     * @param ReserveIndex is the specified index to be removed
     */

    public void removeReservation (int ReserveIndex){
        int checkInTemp = reservation.get(ReserveIndex).getCheckInDate();
        int checkOutTemp = reservation.get(ReserveIndex).getCheckoutDate();
        for(int i = checkInTemp; i < checkOutTemp; i++){
            availableCheckInDays[i] = true;
        }
        reservation.remove(ReserveIndex);
    }

    /*
     * Gets the reservation at a specified index
     * 
     * @param ReserveIndex the specified index to be removed
     * @returns the reservation at a specified index
     */
    public Reservation getReservation(int ReserveIndex) {
        return this.reservation.get(ReserveIndex);
    }

    /*
     * Gets the whole ArrayList of the reservation
     * 
     * @return returns the whole reservation
     */
    public ArrayList<Reservation> getReservationList(){
        return this.reservation;
    }

    /*
     * Sets the available checkInDays in a specified day to true or false
     * 
     * @param index is the specified index that will change the status for the array
     * @param val sets true or false
     */
    public void setAvailableCheckInDays(int index, boolean val){
        availableCheckInDays[index] = val;
    }

    /*
     * Gets the array of availableCheckInDays
     * 
     * @return the array of the availableCheckInDays
     */
    public boolean[] getAvailableCheckInDays(){
        return availableCheckInDays;
    }

    /*
     * Checks the availability of the room to be reserved
     * 
     * @param CheckIn the day for the check in 
     * @paramCheckOut the day for the check out
     * @return returns true if the checkIn and checkOut are available otherwise false
     */
    public boolean checkAvailability(int checkIn, int checkOut){

        if (checkIn < 0 || checkOut > availableCheckInDays.length || checkIn >= checkOut) {
            return false;
        }

        int i;
        int ctr = 0;
        int approveCount = checkOut - checkIn;

        for(i = checkIn - 1; i < checkOut - 1; i++){
            if(availableCheckInDays[i]){
                ctr++;
            }
        }

        if(approveCount == ctr){
            for(i = checkIn - 1; i < checkOut - 1; i++){
                availableCheckInDays[i] = false;
            }

            return true;
        }

        return false;
    }

    /**
     * checks the availability of a room with a given date period
     * 
     * @param checkIn the day for the check in
     * @param checkOut the day for the check out
     * @return returns true if the date period is available otherwise false
     */
    public boolean checkDateAvailability(int checkIn, int checkOut){

        if (checkIn < 0 || checkOut > availableCheckInDays.length || checkIn >= checkOut) {
            return false;
        }

        int i;
        int ctr = 0;
        int approveCount = checkOut - checkIn;

        for(i = checkIn; i < checkOut; i++){
            if(availableCheckInDays[i]){
                ctr++;
            }
        }

        if(approveCount == ctr)
            return true;

        return false;
    }

}