

//import java.util.ArrayList;
import java.util.Scanner;

import modelPackages.*;

public class DriverMCO1 {

    public static void main(String[] args){

        HotelSystem mco1 = new HotelSystem();
        Scanner scan = new Scanner(System.in);

        int choice = -1, index;
        String name;

        System.out.print("\033[H\033[2J");  
        System.out.flush();

        while(choice != 5){
            System.out.println(" -------------------------------");
            System.out.println("| What do you want to do:       |");
            System.out.println("| [1] Create Hotel              |");
            System.out.println("| [2] View Hotel                |");
            System.out.println("| [3] Manage Hotel              |");
            System.out.println("| [4] Simulate Booking          |");
            System.out.println("| [5] Exit                      |");
            System.out.println(" -------------------------------");
    
            choice = scan.nextInt();
            scan.nextLine();
    
            switch(choice){
                case 1:
                    System.out.print("\033[H\033[2J");  
                    System.out.flush(); 
                    System.out.print("Name of the hotel you want to add: ");
                    name = scan.nextLine();
                    System.out.print("How many Standard Rooms in " + name + ": ");
                    int Srooms = scan.nextInt();
                    int numRooms = Srooms;
                    
                    System.out.print("How many Deluxe Rooms in " + name + ": ");
                    int Drooms = scan.nextInt();
                    numRooms += Drooms;

                    System.out.print("How many Executive Rooms in " + name + ": ");
                    int Erooms = scan.nextInt();
                    numRooms += Erooms;

                    boolean check = mco1.addHotel(name, numRooms);
                
                    if (check == true){
                        int hotelIndex = mco1.getHotel().size() - 1;
                        if (mco1.getHotel().get(mco1.getHotel().size() - 1).addStandardRoom(name, Srooms) && 
                        mco1.getHotel().get(mco1.getHotel().size() - 1).addDeluxeRoom(name, Drooms) &&
                        mco1.getHotel().get(mco1.getHotel().size() - 1).addExecutiveRoom(name, Erooms))
                            System.out.println("A hotel " + mco1.getHotel().get(hotelIndex).getHotelName() + " has been made with " + mco1.getHotel().get(hotelIndex).getTotalRooms() + " rooms!");
                    }
                    break;

                case 2: 
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                    if (mco1.getHotel().size() == 0)
                        System.out.println("There are no hotels to view!");  
                    else{
                        mco1.displayHotelNames();
                        System.out.print("What hotel do you want to view: ");
                        index = scan.nextInt();
                        while(index > mco1.getHotel().size() || index < 1){
                            System.out.print("\033[H\033[2J");  
                            System.out.flush();

                            mco1.displayHotelNames();
                            System.out.println("Input is invalid!");
                            System.out.print("What hotel do you want to view: ");
                            index = scan.nextInt();
                        }
                        mco1.viewHotel(index - 1);    
                    }
                    
                    break;
                    
                case 3:
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();

                    if (mco1.getHotel().size() == 0)
                        System.out.println("There are no hotels to manage!");  

                    else{
                        mco1.displayHotelNames();
                        System.out.print("What hotel do you want to manage: " );
                        index = scan.nextInt();
                        while(index > mco1.getHotel().size() || index < 1){
                            System.out.print("\033[H\033[2J");  
                            System.out.flush();

                            mco1.displayHotelNames();
                            System.out.println("Input is invalid!");
                            System.out.print("What hotel do you want to manage: ");
                            index = scan.nextInt();
                        }
                        mco1.manageHotel(index - 1);
                    }
                    break;
                case 4:
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                    
                    if (mco1.getHotel().size() == 0)
                        System.out.println("There are no hotels to book from!");

                    else{
                        mco1.displayHotelNames();
                        System.out.print("What hotel do you want to book: " );
                        index = scan.nextInt();
                        while(index > mco1.getHotel().size() || index < 1){
                            System.out.print("\033[H\033[2J");  
                            System.out.flush();

                            mco1.displayHotelNames();
                            System.out.println("Input is invalid!");
                            System.out.print("What hotel do you want to book: ");
                            index = scan.nextInt();
                        }
                        mco1.simulateBooking(index - 1);
                    }
                    
                    break;
                case 5:
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                    System.out.println(" ------------------------------------------------------");
                    System.out.println("| Thank you for using Hotel Reservations System!       |");
                    System.out.println("| Programmed by:                                       |");
                    System.out.println("| [1] Joshua James Esleta                              |");
                    System.out.println("| [2] Russell Emmanuel Galan                           |");
                    System.out.println(" ------------------------------------------------------");
                    break;
                default:
                    System.out.println("Error input was not in the choices");
            }

        }
        scan.close();
    }
}