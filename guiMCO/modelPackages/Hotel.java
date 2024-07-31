package modelPackages;

import java.util.ArrayList;

//import javax.management.ConstructorParameters;

public class Hotel{

    private String HotelName;
    private ArrayList<Room> rooms = new ArrayList<Room>();
    private int totalRooms = 0;
    private double earnings;
    private DatePriceModifier dpm = new DatePriceModifier();

    /*
     * Constructs the hotel with the name 
     * 
     * @param is the name of the hotel
     */
    public Hotel (String name){
        this.HotelName = name;
    }

    /*
     * Add rooms and uses the name of the hotel for the room and creates a room with n numbers
     * 
     * @param name is the name of the hotel that will be used for naming the rooms
     * @param n is the number that the user wants to add 
     * @return returns true if creation was succesful
     */
    public boolean addStandardRoom (String name, int n){
        if (rooms.size() + n <= 50){
            for (int i = 0; i < n; i++){
            rooms.add(new StandardRoom(name + String.format("%02d", rooms.size() + 1))); 
            this.totalRooms++;
            }    
            return true;
        }

        return false;
    }

    public boolean addDeluxeRoom (String name, int n){
        if (rooms.size() + n <= 50){
            for (int i = 0; i < n; i++){
            rooms.add(new DeluxeRoom(name + String.format("%02d", rooms.size() + 1))); 
            totalRooms += 1;
            }    
            return true;
        }

        return false;
    }

    public boolean addExecutiveRoom (String name, int n){
        if (rooms.size() + n <= 50){
            for (int i = 0; i < n; i++){
            rooms.add(new ExecutiveRoom(name + String.format("%02d", rooms.size() + 1))); 
            totalRooms += 1;
            }    
            return true;
        }

        return false;
    }

    /*
     * Sets the hotel name of the selected hotel
     * 
     * @param name is new name of the hotel that will be set
     */
    public void setHotelName (String name){
        this.HotelName = name;
        int numStandard = 0;
        int numDeluxe = 0;
        int numExec = 0;

        for (Room room : rooms) {
            if (room.getClass() == StandardRoom.class)
                numStandard++;

            if (room.getClass() == DeluxeRoom.class)
                numDeluxe++;

            if (room.getClass() == ExecutiveRoom.class)
                numExec++;
        }
        rooms.clear();
        totalRooms = 0;

        addStandardRoom(name, numStandard);
        addDeluxeRoom(name, numDeluxe);
        addExecutiveRoom(name, numExec);
    }

    /*
     * Removes a room in the hotel at a specified index
     * 
     * @param RoomIndex is the specified index
     */
    public void removeRoom (int RoomIndex){

        rooms.remove(RoomIndex);
        totalRooms -= 1;
    }


    /*
     * Gets the hotel name
     * 
     * @return return the hotel name 
     */
    public String getHotelName() {
        return HotelName;
    }

    /*
     * Gets the Room at a specified index
     * 
     * @return the room of specified index
     */

    public Room getRoom(int RoomIndex) {
        return rooms.get(RoomIndex);
    }

    /*
     * Gets the array list of rooms
     * 
     * @return return the array list of rooms  
     */
    public ArrayList<Room> getRoom() {
        return rooms;
    }


    /*
     * Gets the total number of rooms
     * 
     * @return returns the total room in a hotel
     */
    public int getTotalRooms() {
        return totalRooms;
    }


    /*
     * Set the earnings using the all the reservation in the rooms of the hotel
     * 
     * @param rooms are all the rooms in the hotel that will get the reservations
     */
    public void setEarnings(ArrayList<Room> rooms){
        double totalEarnings = 0;

        for(Room room : rooms){
            for (Reservation reservation2 : room.getReservationList()) {
                totalEarnings += reservation2.getTotalPrice();
            }
        }
        
        
        this.earnings = totalEarnings;
    }
    
    /*
     * Gets the earnings of the hotel
     */
    public double getEarnings() {
        return earnings;
    }

    /*
     * Checks all the booked rooms in the hotel and count them
     * 
     * @return returns the count of all the number of booked rooms
     */
    public int checkBookedRooms(){
        int ctr = 0;
        
        for (Room room2 : rooms) {
            if (room2.getStatus() == true)
                ctr++;
        }

        return ctr;
    }

    /*
     * Checks all the available rooms in the hotel
     * 
     * @return returns the count of all available rooms in the hotel
     */

    public int checkAvailRooms(){
        int ctr = 0;
        
        for (Room room2 : rooms) {
            if (room2.getStatus() == false)
                ctr++;
        }

        return ctr;
    }
    
        /**
     * Books the reservation of a chosen room
     * 
     * @param roomIndex the selected room to where the reservation will be booked
     * @param GuestName Guest Name for the reservation
     * @param checkIn   Check-In date for the reservation
     * @param checkOut  Check-Out date for the reservation
     */
    public void addRoomReservation(int roomIndex, String GuestName, int checkIn, int checkOut){
        double sum = 0;
        for (int i = checkIn; i < checkOut; i++){
            sum += dpm.getPercentage(i) * getRoom(roomIndex).getPrice();
        }
        
        getRoom(roomIndex).addReservation(GuestName, checkIn, checkOut, sum);
    }

    /**
     * returns DatePriceModifier
     * 
     * @return dpm
     */
    public DatePriceModifier getDPM(){
        return dpm;
    }
}