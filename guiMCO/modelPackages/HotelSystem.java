package modelPackages;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelSystem {
    
    private ArrayList<Hotel> hotel = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);
    /*
     * Gets the arrayList of the hotel
     * 
     * @return returns the arrayList of hotel
     */

    public ArrayList<Hotel> getHotel(){
        return hotel;
    }

    /*
     * Displays all the existing hotel names
     */       

    public void displayHotelNames(){

        int i = 1;
        System.out.println("Hotels: ");
        for(Hotel hotels : hotel){
            System.out.printf("[%d] ", i++);
            System.out.println(hotels.getHotelName());
        }
        System.out.println("\n");
    }

    /*
     * Displays all the room in the specified hotel
     * 
     * @param index is the Hotel index that will show all the rooms 
     */
    public void displayRooms(int index){
        ArrayList<Room> temp = hotel.get(index).getRoom();
        int i = 1; String bookVal;

        for(Room rooms : temp){
            System.out.printf("[%d] ", i++);
            if (rooms.getStatus() == true)
                bookVal = "booked";
            else 
                bookVal = "available";
            if (rooms.getReservationList().size() == 0)
                System.out.println(rooms.getRoomName() + ", Status: " + bookVal);

            else{
                System.out.println(rooms.getRoomName() + ", Status: " + bookVal + " for: ");
                for (Reservation reservation : rooms.getReservationList()) {
                    System.out.println("\t\t\t\t" + reservation.getCheckInDate() + " - " + reservation.getCheckoutDate() + "  "); 
            }
            }
            
            
        }
    }

    /*
     * Displays all the reservation in a room 
     * 
     * @param indexHotel is the specified hotel
     * @param indexRoom is the specified room
     */

    public void displayReservation(int indexHotel, int indexRoom){
        ArrayList<Reservation> temp = hotel.get(indexHotel).getRoom(indexRoom).getReservationList();
        int i = 1;

        for(Reservation reservation : temp){
            System.out.printf("[%d] ", i++);
            System.out.println("Guest name: " + reservation.getGuestName() + " date: " + reservation.getCheckInDate() + " - " + reservation.getCheckoutDate());
        }

    }

    /*
     * Adds a Hotel with a specified Name
     * 
     * @param HotelName used to name the hotel to be added
     * @param n number of rooms to be added in the hotel
     * @return returns true if the added hotel is less than 50 or no same names for the previous hotels
     */
    public boolean addHotel(String HotelName, int n){

        for(Hotel hotels: hotel){
            if(hotels.getHotelName().equalsIgnoreCase(HotelName)){
                System.out.println("Name is already taken");
                return false;
            }
        }

        if (n > 50){
            System.out.println("The number of rooms should not exceed 50!");
            return false;
        }

        if (n < 1){
            System.out.println("The minimum number of rooms should be at least 1!");
            return false;
        }
        
        hotel.add(new Hotel(HotelName));
        return true;
    }

    public void removeHotel(int index){
        hotel.remove(index);
    }

    // Name, total number of rooms, sum of total price across all reservations
    /*
     * View the hotel to get the information that they needed in the hotel
     * 
     * @param index is the index of the hotel you want to view
     */
    public void viewHotel(int index){

        int choice = 0, choice2 = 0;

        System.out.println(" -----------------------------------------------------");
        System.out.println("| What information do you want to know:               |");
        System.out.println("| [1] Hotel Overview                                  |");
        System.out.println("| [2] Room and Reservation Overview                   |");
        System.out.println(" -----------------------------------------------------");

        
        while (choice != 1 && choice != 2){
            choice = scan.nextInt();

            switch (choice){
                case 1: 
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                System.out.println("Information about the hotel: ");
                System.out.println("Hotel Name: " + hotel.get(index).getHotelName());
                System.out.println("Total number of rooms: " + hotel.get(index).getTotalRooms());
                System.out.println("Total Revenue of the Hotel: " + hotel.get(index).getEarnings());
                break;

                case 2: 
                System.out.print("\033[H\033[2J");  
                System.out.flush();

                System.out.println(" -----------------------------------------------------");
                System.out.println("| Room and Reservation Overview:                      |");
                System.out.println("| [1] View available rooms with date                  |");
                System.out.println("| [2] Room Overview                                   |");
                System.out.println("| [3] Reservation Overview                            |");
                System.out.println(" -----------------------------------------------------");

                choice2 = scan.nextInt();
                while (choice != 1 && choice != 2 && choice != 3){
                System.out.println("Selected input is not valid enter again!");
                choice2 = scan.nextInt();
                }
                switch(choice2){
                    case 1: 
                    System.out.print("Enter check-in date [1-30]: ");;
                    int checkIn = scan.nextInt();
                    while (checkIn < 1 || checkIn > 30){
                        System.out.println("Invalid check-in date!");
                        System.out.print("Enter check-in date [1-30]: ");
                        checkIn = scan.nextInt();
                    }
        
                    System.out.print("Enter check-out date [2-31]: ");
                    int checkOut = scan.nextInt();
                    scan.nextLine();
                    while (checkOut < 2 || checkOut > 31) {
                        System.out.println("Invalid check-out date!");
                        System.out.print("Enter check-out date [2-31]: ");
                        checkOut = scan.nextInt();
                        scan.nextLine();
                    }
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                    int i = 1;
                    System.out.println("Here are the available rooms in date: " + checkIn + " - " + checkOut);
                    for (Room room : hotel.get(index).getRoom()) {
                        if (room.checkDateAvailability(checkIn, checkOut) == true){
                            System.out.printf("[%d] ", i++);
                            System.out.println(room.getRoomName());
                        }     
                    }
                    break;

                    case 2: 
                    displayRooms(index);

                    System.out.print("\nSelect Room : ");
                    int index1 = scan.nextInt();
                    while (index1 <= 0 || index1 > hotel.get(index).getRoom().size()){
                        System.out.println("Invalid selected room!");
                        System.out.print("Select Room : ");
                        index1 = scan.nextInt();
                        scan.nextLine();
                    } 
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                    System.out.println("Information about the room: ");
                    System.out.println("Room Name: " + hotel.get(index).getRoom(index1 - 1).getRoomName());
                    System.out.println("Price per night: " + hotel.get(index).getRoom(index1 - 1).getPrice());
                    System.out.print("Available Days: ");
                    for (int x = 0; x < 31; x++){
                        if (hotel.get(index).getRoom(index1 - 1).getAvailableCheckInDays()[x] == true)
                            System.out.print(x + 1 + " ");
                    }
                    System.out.print("\n");
                    break;

                    case 3:
                    displayRooms(index);

                    System.out.print("\nSelect Room to check its reservations: ");
                     index1 = scan.nextInt();
                    while (index1 <= 0 || index1 > hotel.get(index).getRoom().size()){
                        System.out.println("Invalid selected room!");
                        System.out.print("Select Room : ");
                        index1 = scan.nextInt();
                        scan.nextLine();
                    } 
                    if (hotel.get(index).getRoom(index1-1).getReservationList().size() == 0){
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();
                        System.out.println(hotel.get(index).getRoom(index1-1).getRoomName() + " has no reservations!");
                        return;
                    }
                    else{
                        displayReservation(index, index1-1);
                        System.out.print("Select Reservation: ");
                        int index2 = scan.nextInt();
                        while (index2 < 1 || index2 > hotel.get(index).getRoom(index1-1).getReservationList().size()){
                            System.out.println("Invalid input!");
                            System.out.print("Select Reservation: ");
                            index2 = scan.nextInt();   
                        }
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();
                        System.out.println("Here is the reservation info:");
                        System.out.println("Room Number: " + hotel.get(index).getRoom(index1-1).getRoomName());
                        System.out.println("Guest name: " + hotel.get(index).getRoom(index1-1).getReservation(index2-1).getGuestName());
                        System.out.println("Check-in: " + hotel.get(index).getRoom(index1-1).getReservation(index2-1).getCheckInDate());
                        System.out.println("Check-out: " +  hotel.get(index).getRoom(index1-1).getReservation(index2-1).getCheckoutDate());
                        System.out.println("Total Cost: " +  hotel.get(index).getRoom(index1-1).getReservation(index2-1).getTotalPrice());
                        System.out.println("Discount Code Applied: " +  hotel.get(index).getRoom(index1-1).getReservation(index2-1).getDiscountCode());
                        System.out.println("Breakdown Cost per Night: ");
                        hotel.get(index).getDPM().getBreakdownCost(hotel.get(index).getRoom(index1-1), hotel.get(index).getRoom(index1-1).getReservation(index2-1));
                    }
                       

                    break;
                }
                break;

                default: System.out.println("Selected input is not valid enter again!");
            }
        }
    }

    /*
     * Manages the specified hotel using the index that can change name, add hotel room, update the room prices, remove reservations and removes hotel
     * 
     * @param index is the index of the hotel to be managed
     */
    
    public void manageHotel(int index){
        
        String name;
        int index1, index2;
        double newPrice;

        System.out.println("----------------------------------------");
        System.out.println("| What do you want to do:              |");
        System.out.println("| [1] Change Hotel Name                |");
        System.out.println("| [2] Add Hotel Room                   |");
        System.out.println("| [3] Remove Hotel Room                |");
        System.out.println("| [4] Update Room Price                |");
        System.out.println("| [5] Modify Date Price                |");
        System.out.println("| [6] Remove Reservation               |");
        System.out.println("| [7] Remove Hotel                     |");
        System.out.println("----------------------------------------");
        System.out.print("Your choice: ");
        int choice = scan.nextInt();

        switch(choice){
            case 1:
                System.out.print("Name of hotel to be changed: ");
                scan.nextLine();
                name = scan.nextLine();

                for(Hotel hotels: hotel){
                    if(hotels.getHotelName().equalsIgnoreCase(name)){
                        System.out.println("Name is already taken");
                        return;
                    }
                }
                hotel.get(index).setHotelName(name);
                System.out.println(hotel.get(index).getHotelName() + " is the new hotel name!");
                break;
            case 2:
                name = hotel.get(index).getHotelName();
                System.out.println("--------------------------------");
                System.out.println("|What type of room to be added?|");
                System.out.println("|1 - Standard                  |");
                System.out.println("|2 - Deluxe                    |");
                System.out.println("|3 - Executive                 |");
                System.out.println("--------------------------------");
                int roomtype = scan.nextInt();

                switch (roomtype){
                    case 1 : System.out.print("Enter number of Standard Rooms to add (currently "+ hotel.get(index).getRoom().size() + ")" + ": ");
                        int n = scan.nextInt();
                        boolean checkTrue = hotel.get(index).addStandardRoom(name, n);

                        if(checkTrue == true)
                            System.out.println(n + " Standard Rooms has been added to " + hotel.get(index).getHotelName() + "!");
                        else
                            System.out.println("The maximum number of rooms in " + hotel.get(index).getHotelName() + " can only be 50!");
                        break;

                    case 2 :

                        System.out.print("Enter number of Deluxe Rooms to add (currently "+ hotel.get(index).getRoom().size() + ")" + ": ");
                        n = scan.nextInt();
                        checkTrue = hotel.get(index).addDeluxeRoom(name, n);

                        if(checkTrue == true)
                            System.out.println(n + " Deluxe Rooms has been added to " + hotel.get(index).getHotelName() + "!");
                        else
                            System.out.println("The maximum number of rooms in " + hotel.get(index).getHotelName() + " can only be 50!");
                        break;

                    case 3 :

                        System.out.print("Enter number of Executive Rooms to add (currently "+ hotel.get(index).getRoom().size() + ")" + ": ");
                        n = scan.nextInt();
                        checkTrue = hotel.get(index).addExecutiveRoom(name, n);

                        if(checkTrue == true)
                            System.out.println(n + " Executive Rooms has been added to " + hotel.get(index).getHotelName() + "!");
                        else
                            System.out.println("The maximum number of rooms in " + hotel.get(index).getHotelName() + " can only be 50!");
                        break;
                }

                break;

            case 3:
                displayRooms(index);
                System.out.print("Select Room to be removed: ");
                index1 = scan.nextInt();
                while (index1 <= 0 || index1 > hotel.get(index).getRoom().size()){
                    System.out.println("Invalid selected room!");
                    System.out.print("Select Room to change price: ");
                    index1 = scan.nextInt();
                    scan.nextLine();
                }
                if(hotel.get(index).getRoom(index1-1).getStatus()){
                    System.out.println("Can't be removed");
                }
                else {
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();

                    System.out.println(hotel.get(index).getRoom(index1 - 1).getRoomName() + " has been removed!");
                    hotel.get(index).removeRoom(index1 - 1);
                }
                break;

            case 4:
                displayRooms(index);
                System.out.print("Select Room to change price: ");
                index1 = scan.nextInt();
                while (index1 <= 0 || index1 > hotel.get(index).getRoom().size()) {
                    System.out.println("Invalid selected room!");
                    System.out.print("Select Room to change price: ");
                    index1 = scan.nextInt();
                    scan.nextLine();
                }
                System.out.print("New Price: ");
                newPrice = scan.nextDouble();
                boolean check2 = hotel.get(index).getRoom(index1 - 1).getStatus();

                if (check2 == false && newPrice >= 100){
                    boolean check = hotel.get(index).getRoom(index1 - 1).setPrice(newPrice);
                
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                    if (check == true && check2 == false){
                    System.out.println("New Price of " + hotel.get(index).getRoom(index1 - 1).getRoomName() + " is: " + hotel.get(index).getRoom(index1 - 1).getPrice());
                    }
                }
                
                else System.out.println("New Price was not set!");
                break;

            case 5:
                System.out.print("Enter day only [1 - 30]: ");
                int day = scan.nextInt();
                while (day <= 0 || day > 30) {
                    System.out.println("Invalid selected day!");
                    System.out.print("Enter day only [1 - 30]: ");
                    day = scan.nextInt();
                    scan.nextLine();
                }

                System.out.print("Enter new price rate: ");
                double percent = scan.nextInt();

                hotel.get(index).getDPM().ModifyPriceDate(day, percent);

                System.out.println("\nNew Price Rate of " + hotel.get(index).getHotelName() + " in day " + day + " is: " + hotel.get(index).getDPM().getPercentage(day) * 100 + "%!");
                
                break;

            case 6:
                displayRooms(index);
                System.out.print("Select Room to remove its reservation: ");
                index1 = scan.nextInt();
                while (index1 <= 0 || index1 > hotel.get(index).getRoom().size()) {
                    System.out.println("Invalid selected room!");
                    System.out.print("Select Room to change price: ");
                    index1 = scan.nextInt();
                    scan.nextLine();
                }

                if (hotel.get(index).getRoom(index1-1).getReservationList().size() == 0){
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                    System.out.println(hotel.get(index).getRoom(index1-1).getRoomName() + " has no reservations!");
                    return;
                }
                else{
                    displayReservation(index, index1-1);
                    System.out.print("Select Reservation to remove: ");
                    index2 = scan.nextInt();
                    while (index2 < 1 || index2 > hotel.get(index).getRoom(index1-1).getReservationList().size()){
                        System.out.println("Invalid input!");
                        System.out.print("Select Reservation to remove: ");
                        index2 = scan.nextInt();   
                    }
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                    System.out.println("Reservation under " + hotel.get(index).getRoom(index1-1).getReservation(index2 - 1).getGuestName() + " is removed!");
                    int checkIn = hotel.get(index).getRoom(index1-1).getReservation(index2 - 1).getCheckInDate();
                    int checkOut = hotel.get(index).getRoom(index1-1).getReservation(index2 - 1).getCheckoutDate();

                    for (int i = checkIn - 1; i <= checkOut - 1; i++)
                        hotel.get(index).getRoom(index1-1).setAvailableCheckInDays(i, true);

                    hotel.get(index).getRoom(index1-1).removeReservation(index2 - 1);
                    hotel.get(index).setEarnings(hotel.get(index).getRoom());

                    if (hotel.get(index).getRoom(index1-1).getReservationList().size() == 0)
                        hotel.get(index).getRoom(index1-1).setStatus(false);
                            
                }   

                break;
                
            case 7:
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                System.out.println(hotel.get(index).getHotelName() + " has been removed!");
                hotel.remove(index);
                break;
            default:
                System.out.println("Error only 1 to 7");
        }  
    }

    /*
     * Simulates the booking of a hotel using the pov of a customer
     * 
     * @param index is the specified hotel that the customer will reserve at
     */
    public void simulateBooking (int index){
        int checkIn, checkOut, roomReserve, latestIndex;
        String GuestName;
        boolean checker = false;
        Hotel currentHotel = hotel.get(index);

        do{

            System.out.print("Enter check-in date [1-30]: ");;
            checkIn = scan.nextInt();
            while (checkIn < 1 || checkIn > 30){
                System.out.println("Invalid check-in date!");
                System.out.print("Enter check-in date [1-30]: ");
                checkIn = scan.nextInt();
            }

            System.out.print("Enter check-out date [2-31]: ");
            checkOut = scan.nextInt();
            scan.nextLine();
            while (checkOut < 2 || checkOut > 31) {
                System.out.println("Invalid check-out date!");
                System.out.print("Enter check-out date [2-31]: ");
                checkOut = scan.nextInt();
                scan.nextLine();
            }

            if (checkOut - checkIn <= 0){
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                System.out.println("Invalid Booking Schedule!");
            }

        } while (checkOut - checkIn <= 0);

        displayRooms(index);
        
        do{
            System.out.print("Enter room number to be reserved: ");
        roomReserve = scan.nextInt();
        scan.nextLine();
        }while (roomReserve < 1 || roomReserve > hotel.get(index).getRoom().size());
        roomReserve--;


        System.out.print("Enter Guest Name: ");
        GuestName = scan.nextLine();
        
        if (hotel.get(index).getRoom(roomReserve).checkAvailability(checkIn, checkOut)){
            hotel.get(index).addRoomReservation(roomReserve, GuestName, checkIn, checkOut); // initialization of reserve
            hotel.get(index).setEarnings(hotel.get(index).getRoom());
            hotel.get(index).getRoom(roomReserve).setStatus(true);
            checker = true;
        }
            
        
        latestIndex = hotel.get(index).getRoom(roomReserve).getReservationList().size() - 1;

        
        // Dapat yung latest na reservation yung didisplay (yung kaka reserve)
        if (checker == true){
            System.out.println("Would you like to enter a discount code?");
            System.out.println("(1) Yes");
            System.out.println("(2) No");
            System.out.print("Enter: ");
            int DiscountChoice = scan.nextInt();
            scan.nextLine();
            while (DiscountChoice != 1 && DiscountChoice != 2){
                DiscountChoice = scan.nextInt();
                scan.nextLine();
            }
            
    
            if (DiscountChoice == 1){
                System.out.print("Enter Discount Code: ");
                String code = scan.nextLine();
                Discount discount = new Discount();
                discount.applyDiscount(code, currentHotel.getRoom(roomReserve).getReservation(latestIndex));
            }
            

        System.out.println("A reservation under " + GuestName + " has been made!");
        System.out.println("Here is the reservation info:");
        System.out.println("Room Number: " + currentHotel.getRoom(roomReserve).getRoomName());
        System.out.println("Guest name: " + currentHotel.getRoom(roomReserve).getReservation(latestIndex).getGuestName());
        System.out.println("Check-in: " + currentHotel.getRoom(roomReserve).getReservation(latestIndex).getCheckInDate());
        System.out.println("Check-out: " +  currentHotel.getRoom(roomReserve).getReservation(latestIndex).getCheckoutDate());
        System.out.println("Total Cost: " +  currentHotel.getRoom(roomReserve).getReservation(latestIndex).getTotalPrice());
        System.out.println("Discount Code Applied: " +  currentHotel.getRoom(roomReserve).getReservation(latestIndex).getDiscountCode());
        } 
        
        else {

            System.out.println(currentHotel.getRoom(roomReserve).getRoomName() + " is currently booked!");
            System.out.println("Please try other rooms!");
        } 
    }

}
