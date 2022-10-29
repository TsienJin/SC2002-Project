package MovieTheatres;

public abstract class Cinema {
    private String id;
    private int hallNumber;
    private String cinemaCode;


    //Constructors
    public Cinema(){
        id = "";
        hallNumber = 0;
        cinemaCode = " ";
    }

    public Cinema(String id, int hallNumber,String cinemaCode){
        this.id = id;
        this.hallNumber = hallNumber;
        this.cinemaCode = cinemaCode;
    }

    //Accessor Methods
    public String getId(){
        return this.id;
    }
    public int getHallNumber(){
        return this.hallNumber;
    }
    public String getCinemaCode(){
        return this.cinemaCode;
    }

    //Mutator Methods
    public void setId(String id){
        this.id = id;
    }
    public void setHallNumber(int hallNumber){
        this.hallNumber = hallNumber;
    }
    public void setCinemaCode(String cinemaCode){
        this.cinemaCode = cinemaCode;
    }



    //abstract methods - no method implementation
    //Implementation of all the abstract class
    public abstract void showLayout();
    public abstract boolean BookSeat(int row, int col);
    public abstract int getTotalSeats();
    public abstract int getNumEmptySeats();
    public abstract boolean isFullyBooked();





}
