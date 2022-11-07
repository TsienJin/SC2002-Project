package MovieTheatres;
import java.util.ArrayList;

public class Cineplex {
    private String id;
    private String location;
    private ArrayList<Cinema> cinemas;

    //Constructor
    /**
     * Takes in id and location as String
     * Construct the Cineplex object
     * @param id
     * @param location
     */
    public Cineplex(String id, String location){
        this.id = id;
        this.location = location;
    }

    /**
     * Accessor methods that returns the attribute id of Cineplex object
     * @return id attribute
     */
    public String getId(){
        return this.id;
    }
    /**
     * Accessor methods that returns the attribute location of Cineplex object
     * @return location attribute
     */
    public String getLocation(){
        return this.location;
    }

    /**
     * Setter for Cineplex id
     * @param id
     */
    public void setId(String id){
        this.id = id;
    }
    /**
     * Setter for location
     * @param location
     */
    public void setLocation(String location){
        this.location = location;
    }
}
