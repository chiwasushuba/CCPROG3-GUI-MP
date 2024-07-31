package modelPackages;

public class Reservation {

    private String GuestName;
    private int checkInDate;
    private int checkOutDate;
    private double totalPrice;
    private String discount;

    /**
     * Constructs a Reservation with the given name, check-in date, check-out date and price
     * 
     * @param GuestName is the Guestname of the new reservation thwat will be made
     * @param checkInDate is the check-in date of the new reservation that will be made
     * @param checkOutDate is the check-out date of the new reservation that will be made
     * @param totalPrice is the Total Cost of the new reservation that will be made
     */
    public Reservation(String GuestName, int checkInDate, int checkOutDate, double totalPrice){
        this.GuestName = GuestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;
        this.discount = "none";
    }

    /**
     * Sets new total price (when discounts are applied)
     * @param newPrice
     */
    public void setPrice(double newPrice){
        totalPrice = newPrice;
    }

    /**
     * Sets discount code
     * @param code
     */
    public void setDiscount(String code){
        discount = code;
    }

    /**
     * Gets the discount code
     * @return discount code
     */
    public String getDiscountCode(){
        return discount;
    }
    /*
     * Gets the GuestName
     * 
     * @return returns the String GuestName
     */
    public String getGuestName(){
        return this.GuestName;
    }

    /*
     * Gets the checkInDate
     * 
     * @return returns the int checkInDate
     */
    public int getCheckInDate(){
        return this.checkInDate;
    }

     /*
     * Gets the checkOutDate
     * 
     * @return returns the int checkOutDate
     */
    public int getCheckoutDate(){
        return this.checkOutDate;
    }

    /*
     * Gets the totalPrice
     * 
     * @return returns the double totalPrice
     */

    public double getTotalPrice(){
        return totalPrice;
    }
}
