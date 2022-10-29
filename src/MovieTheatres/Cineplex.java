package MovieTheatres;
import java.util.ArrayList;

public class Cineplex {
    private String id;
    private String location;
    private ArrayList<Cinema> cinemas;

    //Constructor
    public Cineplex(String id, String location){
        this.id = id;
        this.location = location;
    }

    //Accessor Method
    public String getId(){
        return this.id;
    }
    public String getLocation(){
        return this.location;
    }

    //Mutator Method
    public void setId(String id){
        this.id = id;
    }
    public void setLocation(String location){
        this.location = location;
    }
}
