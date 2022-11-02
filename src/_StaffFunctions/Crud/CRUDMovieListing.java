package _StaffFunctions.Crud;
//Needs to inclode FileIO which I didn't
//Needs to inclode StaffCSVDriver which I didn't

public class CRUDMovieListing implements StaffCSVDriver{

    public void createMovieListing(){
        //Create movie object here? OR Ask for user input?
        FileIO.writeToFile("movie.csv", newMovie.toString());
    }
    public void updateMovieListing(){
        //Ask for user input?
        //Idk need to search the original listing then call overwriteToFile?
        FileIO.overwriteToFile("movie.csv", newMovie.toString());
    }
    public void deleteMovieListing(){
        //Ask for user input?
        //Idk need to search the original listing then call deletekey?
        FileIO.deleteKeyInFile("movie.csv", newMovie.toString());
    }

}
