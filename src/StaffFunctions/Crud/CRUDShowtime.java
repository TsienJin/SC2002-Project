//Needs to inclode FileIO which I didn't
//Needs to inclode StaffCSVDriverwhich I didn't

public class CRUDShowtime implements StaffCSVDriver{

    public void createShowtime(){
        //Create movie object here? OR Ask for user input?
        FileIO.writeToFile("ShowTime.showtime.csv", newMovie.toString());
    }
    public void updateShowtime(){
        //Ask for user input?
        //Idk need to search the original listing then call overwriteToFile?
        FileIO.overwriteToFile("ShowTime.showtime.csv", newMovie.toString());
    }
    public void deleteShowtime(){
        //Ask for user input?
        //Idk need to search the original listing then call deletekey?
        FileIO.deleteKeyInFile("ShowTime.showtime.csv", newMovie.toString());
    }

}
