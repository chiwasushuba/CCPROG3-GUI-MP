package modelPackages;

public class Discount{
    private String discCode1 = "I_WORK_HERE";
    private String discCode2 = "STAY4_GET1";
    private String discCode3 = "PAYDAY";

    public boolean applyDiscount(String code, Reservation Reserve){
        if (discCode1.equals(code)){
            double discounted = Reserve.getTotalPrice() - Reserve.getTotalPrice()*0.1; 
            Reserve.setPrice(discounted);
            System.out.println(discCode1 + " is applied!");
            Reserve.setDiscount(discCode1);
            return true;
        }

        else if (discCode2.equals(code)){
            int numNights = Reserve.getCheckoutDate() - Reserve.getCheckInDate();
            if (numNights >= 5){
                double nightPrice = Reserve.getTotalPrice()/numNights;
                Reserve.setPrice(Reserve.getTotalPrice() - nightPrice);
                System.out.println(discCode2 + " is applied!");
                Reserve.setDiscount(discCode2);
                return true;
            }
            else {
                System.out.println("Current booking does not meet the discount's requirements!");
                System.out.println("Proceeding without Discount Code\n");
                return false;    
            }
            
        }

        else if (discCode3.equals(code)){
            if (Reserve.getCheckInDate() <= 15 && Reserve.getCheckoutDate() > 15){
                Reserve.setPrice(Reserve.getTotalPrice() - Reserve.getTotalPrice() * 0.07);
                System.out.println(discCode3 + " is applied!");
                Reserve.setDiscount(discCode3);
                return true;
            }

            else if (Reserve.getCheckoutDate() <= 30 && Reserve.getCheckInDate() > 30){
                Reserve.setPrice(Reserve.getTotalPrice() - Reserve.getTotalPrice() * 0.07);
                Reserve.setDiscount(discCode3);
                System.out.println(discCode3 + " is applied!");
                return true;
            }
            else {
                System.out.println("Current booking does not meet the discount's requirements!");
                System.out.println("Proceeding without Discount Code\n");
                return false;
            }
        }

        else 
            System.out.println("Invalid Discount Code! Proceeding without Discount Code\n");
            return false;
    }
}