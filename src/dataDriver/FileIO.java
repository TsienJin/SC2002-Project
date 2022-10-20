package dataDriver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


// This object handles pure CRUD operations to CSV files
/** Driver that handles all file I/O operations on CSV files.
 * This object can perform basic CRUD opertations,
 * and remove duplicates in CSV files.
 * @author Tsien Jin
 */
public class FileIO {

    String relativeFileDir = new File("").getAbsolutePath()+"/src/dataDriver/data/";


    // CONSTRUCTOR METHODS
    public FileIO(){}
    public FileIO(String relativeFileDir){
        this.relativeFileDir = relativeFileDir;
    }

    
    /**  Checks for matching IDs
     * This method compares a specified id with an untruncated string directly from the CSV.
     * @param csvLine
     * @param id
     * @return boolean
     */
    // METHOD to check if ID is same as that in CSV
    public boolean isSameID(String csvLine, String id){
        String csvLineId = csvLine.split(",", 2)[0];
        return csvLineId.equalsIgnoreCase(id);
    }

    
    /** Gets the ID from a CSV string.
     * ID is the first parameter according to our schema.
     * @param csvLine
     * @return String
     */
    // METHOD to get string ID from CSV string
    public String stripID(String csvLine){
        return csvLine.split(",",2)[0];
    }


    
    /** Gets all values from the specified CSV file as an array.
     * @param fileName
     * @return ArrayList<String>
     */
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

    
    /** Finds the latest entry that matches given id
     * @param fileName
     * @param id
     * @return String
     * @throws IllegalArgumentException
     */
    // METHOD to update last line that matches ID with given string
    public String findMatchFromFile(String fileName, String id) throws IllegalArgumentException {
        String lineToReturn = "";

        try{
            BufferedReader reader = new BufferedReader(new FileReader(this.relativeFileDir+fileName));
            // iterates over lines until null
            reader.readLine(); // gets rid of header line
            String curLine = reader.readLine();
            while(curLine != null){
                if(isSameID(curLine, id)){
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


    
    /** Updates a key with specified string.
     * @param fileName
     * @param newString
     * @return boolean
     */
    // METHOD to update last line that matches ID with given string
    public boolean updateKeyInFile(String fileName, String newString){
        boolean isKeyFound = false;
        String key = stripID(newString);
        ArrayList<String> valArr = new ArrayList<String>();

        try{
            BufferedReader reader = new BufferedReader(new FileReader(this.relativeFileDir+fileName));
            // iterates over lines until null to read
            valArr.add(reader.readLine()); // gets rid of header line
            String curLine = reader.readLine();
            while(curLine != null){
                if(isSameID(curLine, key)){
                    isKeyFound = true;
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

        return isKeyFound;
    }


    
    /** Deletes line with specified key in file.
     * Returns true if key is found.
     * @param fileName
     * @param key
     * @return boolean
     */
    public boolean deleteKeyInFile(String fileName, String key){
        boolean isKeyFound = false;
        // String key = stripID(newString);
        ArrayList<String> valArr = new ArrayList<String>();

        try{
            BufferedReader reader = new BufferedReader(new FileReader(this.relativeFileDir+fileName));
            // iterates over lines until null to read
            valArr.add(reader.readLine()); // gets rid of header line
            String curLine = reader.readLine();
            while(curLine != null){
                if(isSameID(curLine, key)){
                    isKeyFound = true;
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

        return isKeyFound;

    }


    
    /** Writes single line to specified CSV file
     * @param fileName
     * @param lineToWrite
     */
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

    
    /** Overwrites the file with a ListArray.
     * Note: This method does not preserve headers.
     * @param fileName
     * @param linesToWrite
     */
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


    
    /**  Remove dupplicates in CSV file.
     * Preserves only the latest entry
     * @param fileName
     */
    // METHOD to remove duplicate entries in database by IDs
    public void removeDuplicates(String fileName){
        HashMap<String, String> hMap = new HashMap<>();
        ArrayList<String> toWrite = new ArrayList<>();

        try{
            BufferedReader reader = new BufferedReader(new FileReader(this.relativeFileDir+fileName));
            // iterates over lines until null to read
            toWrite.add(reader.readLine()); // gets rid of header line
            String curLine = reader.readLine();
            while(curLine != null){
                hMap.put(stripID(curLine), curLine);
                System.out.println(curLine);
                curLine = reader.readLine();
            }
            reader.close();

            // iterates over all the strings to append to toWrite
            hMap.values().forEach(str -> toWrite.add(str));

            // send string for writing
            overwriteToFile(fileName, toWrite);

        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
