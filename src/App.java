import java.io.File;
import java.util.ArrayList;
import dataDriver.FileIO;


public class App{
    public static void main(String args[]){



        //// Testing methods for file reading
        FileIO FileIOObj = new FileIO();
        String lineToWrite = "0068646,The Godfather,1,Crime|Drama,The aging patriarch of an organized crime dynasty in postwar New York City transfers control of his clandestine empire to his reluctant youngest son.,Francis Ford Coppola,Marlon Brando|Al Pacino";
        // FileIOObj.writeToFile("movie.csv", lineToWrite);
        System.out.println(FileIOObj.findMatchFromFile("movie.csv", "0068646"));
        // ArrayList<String> res = reader.readFromFile("movie.csv");
        // System.out.println(reader.findMatchFromFile("movie.csv", "1375666"));
        // String toUpdate = "0111161,The Shawshank Redemption,1,Drama,Too twoo Three long,Bob";
        // FileIOObj.updateInFile("movie.csv", toUpdate);
        // FileIOObj.deleteKeyInFile("movie.csv", "1375666");
        // FileIOObj.removeDuplicates("movie.csv");
    }
}