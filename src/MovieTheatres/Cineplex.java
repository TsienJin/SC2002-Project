package MovieTheatres;
import java.util.ArrayList;

public class Cineplex {
    private int id;
    private String location;
    private ArrayList<Cinema> cinemas;

    //Constructor
    public Cineplex(int id, String location){
        this.id = id;
        this.location = location;
    }

    //Accessor Method
    public int getId(){
        return this.id;
    }
    public String getLocation(){
        return this.location;
    }

    //Mutator Method
    public void setId(int id){
        this.id = id;
    }
    public void setLocation(String location){
        this.location = location;
    }
}
