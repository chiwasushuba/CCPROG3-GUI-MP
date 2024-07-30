package modelPackages;

public class DeluxeRoom extends Room{
    
    /*
     * Constructs a DeluxeRoom with the given name
     * 
     * @param name creates DeluxeRoom using given name
     */
    public DeluxeRoom (String name){
        super("Deluxe " + name);
        double deluxe = 1299.0 * 0.20;
        double price = 1299.0 + deluxe;
        setPrice(price);
    }
}
