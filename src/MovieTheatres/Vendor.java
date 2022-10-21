package MovieTheatres;
import java.util.ArrayList;

public class Vendor {
    private int id;
    private String company;
    private ArrayList<Cineplex> cineplexes;

    //Constructor
    public Vendor(int id, String company){
        this.id = id;
        this.company = company;
    }

    //Accessor Methods
    public int getId(){
        return this.id;
    }
    public String getCompany(){
        return this.company;
    }

    //Mutator Methods
    public void setId(int id){
        this.id = id;
    }
    public void setCompany(String company){
        this.company = company;
    }


}
