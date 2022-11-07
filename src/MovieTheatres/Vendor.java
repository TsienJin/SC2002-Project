package MovieTheatres;
import java.util.ArrayList;

/**
 * Vendor class that is able to contain all the different cineplexes
 */

public class Vendor {
    private String id;
    private String company;
    private ArrayList<Cineplex> cineplexes;

    //Constructor
    /**
     * Constructo class to create the Vendor class
     * @param id
     * @param company
     */
    public Vendor(String id, String company){
        this.id = id;
        this.company = company;
    }

    //Accessor Methods
    /**
     * Accessor methods to get the attribute id
     * @return id attribute
     */
    public String getId(){
        return this.id;
    }

    /**
     * Accessor method to get the company attribute
     * @return company attribute
     */
    public String getCompany(){
        return this.company;
    }

    //Mutator Methods
    /**
     * Mutator that sets the attribute id
     * @param id
     */
    public void setId(String id){
        this.id = id;
    }
    /**
     * Mutator that sets the attribute company
     * @param company
     */
    public void setCompany(String company){
        this.company = company;
    }


}
