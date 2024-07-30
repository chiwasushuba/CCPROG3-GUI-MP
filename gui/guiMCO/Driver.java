import guiPackage.*;
import modelPackages.*;

public class Driver {
    public static void main(String[] args) {
        HotelSystem model = new HotelSystem();
        CreateHotel createHotel = new CreateHotel();
        MainMenu mainMenu = new MainMenu();
        SimulateBooking simulateBooking = new SimulateBooking();
        ViewHotel viewHotel = new ViewHotel();
        HotelOverview hotelOverview = new HotelOverview();
        ManageHotel manageHotel = new ManageHotel();
        Controller controller = new Controller(mainMenu, createHotel, simulateBooking, manageHotel, viewHotel, hotelOverview, model);
    }
}
