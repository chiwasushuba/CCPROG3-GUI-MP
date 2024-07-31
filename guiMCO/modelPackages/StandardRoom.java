package modelPackages;

public class StandardRoom extends Room{

      /*
     * Constructs a StandardRoom with the given name
     * 
     * @param name creates StandardRoom using given name
     */
    public StandardRoom (String name){
        super(name);
        setPrice(1299.0);
    }
}