package MovieTheatres;

public class Cinema {
    private int id;
    private int hallNumber;
    enum cinemaClass{Gold_Class,First_Class,Regular_class};
    private cinemaClass classOfCinema;
    private String cinemaCode;

    //Constructors
    public Cinema(){
        id = 0;
        hallNumber = 0;
        classOfCinema = cinemaClass.Regular_class;
        cinemaCode = " ";
    }

    public Cinema(int id, int hallNumber,cinemaClass classOfCinema, String cinemaCode){
        this.id = id;
        this.hallNumber = hallNumber;
        this.classOfCinema = classOfCinema;
        this.cinemaCode = cinemaCode;
    }

    //Accessor Methods
    public int getId(){
        return this.id;
    }
    public int getHallNumber(){
        return this.hallNumber;
    }
    public String getCinemaCode(){
        return this.cinemaCode;
    }

    //Mutator Methods
    public void setId(int id){
        this.id = id;
    }
    public void setHallNumber(int hallNumber){
        this.hallNumber = hallNumber;
    }
    public void setCinemaCode(String cinemaCode){
        this.cinemaCode = cinemaCode;
    }


    //Show layout of the Cinema for different cinema class
    public void showLayout(){


    }

    public boolean isFullyBooked(){

        //if there is no more empty seats, it means that the theatre is fully booked
        if(getNumEmptySeats()==0){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean BookSeat(int row, int col){

        return true;
    }

    public int getTotalSeats(){
        return 0;
    }

    public int getNumEmptySeats(){
        return 0;
    }



}
