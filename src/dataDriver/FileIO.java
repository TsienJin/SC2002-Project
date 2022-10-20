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

    // METHOD to check if ID is same as that in CSV
    public boolean isSameID(String csvLine, String id){
        String csvLineId = csvLine.split(",", 2)[0];
        return csvLineId.equalsIgnoreCase(id);
    }

    // METHOD to get string ID from CSV string
    public String stripID(String csvLine){
        return csvLine.split(",",2)[0];
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
                // System.out.println(curLine);
                content.add(curLine);
                curLine = reader.readLine();
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        return content;
    }

    // METHOD to update last line that matches ID with given string
    public String findMatchFromFile(String fileName, String key) throws IllegalArgumentException {
        String lineToReturn = "";

        try{
            BufferedReader reader = new BufferedReader(new FileReader(this.relativeFileDir+fileName));
            // iterates over lines until null
            reader.readLine(); // gets rid of header line
            String curLine = reader.readLine();
            while(curLine != null){
                if(isSameID(curLine, key)){
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


    // METHOD to update last line that matches ID with given string
    public boolean updateInFile(String fileName, String newString){
        String lineToReturn = "";
        String key = stripID(newString);
        ArrayList<String> valArr = new ArrayList<String>();

        try{
            BufferedReader reader = new BufferedReader(new FileReader(this.relativeFileDir+fileName));
            // iterates over lines until null to read
            valArr.add(reader.readLine()); // gets rid of header line
            String curLine = reader.readLine();
            while(curLine != null){
                if(isSameID(curLine, key)){
                    valArr.add(newString);
                } else {
                    valArr.add(curLine);
                }
                curLine = reader.readLine();
            }
            reader.close();

            // send string for writing
            overwriteToFile(fileName, valArr);

        } catch (IOException e){
            e.printStackTrace();
        }

        if (lineToReturn.length() == 0){
            return false;
        } else {
            return true;
        }
    }



    // METHOD to write single line content to specified file name
    public void writeToFile(String fileName, String lineToWrite){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.relativeFileDir+fileName, true));
            writer.write(lineToWrite+"\n");
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    // METHOD to write an array of content to replace a specified file name
    public void overwriteToFile(String fileName, ArrayList<String> linesToWrite){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.relativeFileDir+fileName, false));
            linesToWrite.forEach(line -> {
                try {
                    writer.write(line+"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
