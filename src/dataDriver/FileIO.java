package dataDriver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


// This object handles pure CRUD operations to CSV files
public class FileIO {

    String relativeFileDir = new File("").getAbsolutePath()+"/src/dataDriver/data/";


    // CONSTRUCTOR METHODS
    public FileIO(){}
    public FileIO(String relativeFileDir){
        this.relativeFileDir = relativeFileDir;
    }


    // METHOD to read content line by line from specified file name
    public ArrayList<String> readFromFile(String fileName){

        ArrayList<String> content = new ArrayList<String>();

        try{
            BufferedReader reader = new BufferedReader(new FileReader(this.relativeFileDir+fileName));
            // iterates over lines until null
            reader.readLine(); // gets rid of header line
            String curLine = reader.readLine();
            while(curLine != null){
                System.out.println(curLine);
                content.add(curLine);
                curLine = reader.readLine();
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        return content;
    }

    // METHOD to read last line that matches first column, that should be ID
    public String getFirstMatchFromFile(String fileName, String key) throws IllegalArgumentException {

        String lineToReturn = "";

        try{
            BufferedReader reader = new BufferedReader(new FileReader(this.relativeFileDir+fileName));
            // iterates over lines until null
            reader.readLine(); // gets rid of header line
            String curLine = reader.readLine();
            while(curLine != null){
                String[] curLineSplit = curLine.split(",", 2);
                if(key.equalsIgnoreCase(curLineSplit[0])){
                    lineToReturn = curLine;
                }

                curLine = reader.readLine();
                
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        if (lineToReturn.length() == 0){
            throw new IllegalArgumentException(String.format("Moview with id [%s] not found!", key));
        } else {
            return lineToReturn;
        }
    }


    // METHOD to write single line content to specified file name
    public void writeToFile(String fileName, String lineToWrite){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.relativeFileDir+fileName, true));
            writer.write("\n"+lineToWrite);
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
