package modelPackages;

public class ExecutiveRoom extends Room {
    
      /*
     * Constructs a ExecutiveRoom with the given name
     * 
     * @param name creates ExecutiveRoom using given name
     */
    public ExecutiveRoom (String name){
        super("Exec " + name);
        double Exec = 1299.0 * 0.35;
        double price = 1299.0 + Exec;
        setPrice(price);
    }
}