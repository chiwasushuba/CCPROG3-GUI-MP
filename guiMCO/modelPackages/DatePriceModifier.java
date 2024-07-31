package modelPackages;

public class DatePriceModifier{
    private double[] percentage = new double[31]; //the percentage values to be applied to the rooms depending on its date

    /**
     * Contructs DatePriceModifier and sets all the price rate of the day values to default (100%)
     */
    public DatePriceModifier (){
        for (int i = 0; i < 31; i++)
            percentage[i] = 1.0;
    }

    /**
     * Modifies Price Date of a chosen day
     * 
     * @param day   the index of day to be changed
     * @param percent   the rate to be applied
     */
    public void ModifyPriceDate(int day, double percent){
        percentage[day-1] = percent/100.0;
    }

    /**
     * Displays Breakdown Cost per night of Reservation
     * @param room  the room that was reserved
     * @param reservation   the selected reservation containing details
     */
    public void getBreakdownCost(Room room, Reservation reservation){
        int numDay = 1;
        for(int i = reservation.getCheckInDate(); i < reservation.getCheckoutDate(); i++){
            System.out.println("Day " + numDay + ": " + percentage[i-1]*room.getPrice());
            numDay++;
        }  
    }

    /**
     * returns the price rate of a specific day
     * @param index  the price rate to be returned
     * @return price rate of a specific day
     */
    public double getPercentage(int index){
        return percentage[index-1];
    }

    /**
     * returns the price rate array
     * @return percentage
     */
    public double[] getPercentage(){
        return percentage;
    }
}