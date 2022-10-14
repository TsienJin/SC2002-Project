import java.util.ArrayList;
import dataDriver.FileIO;


public class App{
    public static void main(String args[]){



        //// Testing methods for file reading
        FileIO reader = new FileIO();
        reader.writeToFile("test.csv", "WritingTest");
        ArrayList<String> res = reader.readFromFile("movie.csv");
    }
}