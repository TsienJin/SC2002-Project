import java.util.ArrayList;
import dataDriver.FileIO;


public class App{
    public static void main(String args[]){



        //// Testing methods for file reading
        FileIO FileIOObj = new FileIO();
        // reader.writeToFile("test.csv", "WritingTest");
        // ArrayList<String> res = reader.readFromFile("movie.csv");
        // System.out.println(reader.findMatchFromFile("movie.csv", "1375666"));
        String toUpdate = "0111161,The Shawshank Redemption,1,Drama,Too twoo Three long,Bob";
        FileIOObj.updateInFile("movie.csv", toUpdate);
    }
}