package MovieTheatres;
import java.util.ArrayList;

public class Vendor {
    private String id;
    private String company;
    private ArrayList<Cineplex> cineplexes;

    //Constructor
    public Vendor(String id, String company){
        this.id = id;
        this.company = company;
    }

    //Accessor Methods
    public String getId(){
        return this.id;
    }
    public String getCompany(){
        return this.company;
    }

    //Mutator Methods
    public void setId(String id){
        this.id = id;
    }
    public void setCompany(String company){
        this.company = company;
    }


}
