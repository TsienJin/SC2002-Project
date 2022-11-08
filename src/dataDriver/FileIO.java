package dataDriver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Properties;


// This object handles pure CRUD operations to CSV files
/** Driver that handles all file I/O operations on CSV files.
 * This object can perform basic CRUD opertations,
 * and remove duplicates in CSV files.
 * @author Tsien Jin
 */
public class FileIO implements InterfaceCsvDelimiter {

    String relativeFileDir = new File("").getAbsolutePath()+"/src/dataDriver/data/";


    // CONSTRUCTOR METHODS
    public FileIO(){}
    public FileIO(String relativeFileDir){
        this.relativeFileDir = relativeFileDir;
    }

    
    /**  Checks for matching ID from specified index
     * This method compares a specified id with an untruncated string directly from the CSV.
     * @param csvLine
     * @param id
     * @return boolean
     */
    // METHOD to check if ID is same as that in CSV
    public boolean isSameID(String csvLine, String id, int idIndex){
        String csvLineId = csvLine.split(mainDelimiter)[idIndex];
        return csvLineId.equalsIgnoreCase(id);
    }

    
    /** Checks for matching ID
     * @param csvLine
     * @param Id
     * @return boolean
     */
    public boolean isSameID(String csvLine, String Id){
        return this.isSameID(csvLine, Id, 0);
    }

    
    /** Gets the ID from a CSV string.
     * ID is the first parameter according to our schema.
     * @param csvLine
     * @return String
     */
    // METHOD to get string ID from CSV string
    public String stripID(String csvLine){
        return csvLine.split(mainDelimiter,2)[0];
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
            // e.printStackTrace();
        }

        return content;
    }


    /** Uses regex to match string in CSV line
     * 
     * @param fileName
     * @param rgx
     * @return ArrayList<String> of CSV lines.
     */
    public ArrayList<String> regexMatch(String fileName, String rgx){
        ArrayList<String> rawRes = this.readFromFile(fileName);
        ArrayList<String> toReturn = new ArrayList<>();

        if(rawRes.size()==0){
            return toReturn;
        }


        rawRes.forEach(line -> {

            if(line.matches("(?i:.*"+rgx+".*)")){
                toReturn.add(line);
            }
        });

        return toReturn;
    }



    /** Gets the number of objects in the specified CSV file.
     * @param fileName
     * @return Int
     */
    // METHOD to ocunt number of lines from specified file name
    public int countLines(String fileName){

        int count = 0;

        try{
            BufferedReader reader = new BufferedReader(new FileReader(this.relativeFileDir+fileName));
            // iterates over lines until null
            reader.readLine(); // gets rid of header line
            String curLine = reader.readLine();
            while(curLine != null){
                count++;
                curLine = reader.readLine();
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        return count;
    }




    
    /** Count the number of matches with ID in a file
     * @param fileName
     * @param ID
     * @return int
     */
    public int countMatches(String fileName, String ID){
        return this.countMatches(fileName, ID, 0);
    }



    
    /** Count the number of matches with ID in a file with specified index
     * @param fileName
     * @param ID
     * @param index
     * @return int
     */
    public int countMatches(String fileName, String ID, int index){
        int count = 0;
        
        try{
            BufferedReader reader = new BufferedReader(new FileReader(this.relativeFileDir+fileName));
            // iterates over lines until null
            reader.readLine(); // gets rid of header line
            String curLine = reader.readLine();
            while(curLine != null){
                if(isSameID(curLine, ID, index)){
                    count++;
                }

                curLine = reader.readLine();
                
            }
            reader.close();
        } catch (IOException e){
            // e.printStackTrace();
        }

        return count;
    }

    
    /** Count sales value
     * @param fileName
     * @param ID
     * @return double
     */
    public double countSales(String fileName, String ID){
        return this.countSales(fileName, ID, 1);
    }
    
    /**  Count sales value from specified index
     * @param fileName
     * @param ID
     * @param index
     * @return double
     */
    public double countSales(String fileName, String ID, int index){
        double totalSales = 0;
        
        try{
            BufferedReader reader = new BufferedReader(new FileReader(this.relativeFileDir+fileName));
            // iterates over lines until null
            reader.readLine(); // gets rid of header line
            String curLine = reader.readLine();
            while(curLine != null){
                if(isSameID(curLine, ID, index)){
                    ArrayList<String> csvArr = new ArrayList<>(Arrays.asList(curLine.split(mainDelimiter)));
                    totalSales += Double.parseDouble(csvArr.get(5));
                }

                curLine = reader.readLine();
                
            }
            reader.close();
        } catch (IOException e){
            // e.printStackTrace();
        }

        return totalSales;
    }
    

    /** Finds the latest entry that matches given id
     * @param fileName
     * @param id
     * @return String
     * @throws IllegalArgumentException
     */
    // METHOD to update last line that matches ID with given string
    public String findMatchFromFile(String fileName, String id) throws IllegalArgumentException {
        return this.findMatchFromFile(fileName, id, 0);
    }

    /** Finds the latest entry that matches given id
     * @param fileName
     * @param id
     * @return String
     * @throws IllegalArgumentException
     */
    // METHOD to update last line that matches ID with given string
    public String findMatchFromFile(String fileName, String id, int index) throws IllegalArgumentException {
        String lineToReturn = "";

        try{
            BufferedReader reader = new BufferedReader(new FileReader(this.relativeFileDir+fileName));
            // iterates over lines until null
            reader.readLine(); // gets rid of header line
            String curLine = reader.readLine();
            while(curLine != null){
                if(isSameID(curLine, id, index)){
                    lineToReturn = curLine;
                }

                curLine = reader.readLine();
                
            }
            reader.close();
        } catch (IOException e){
            // e.printStackTrace();
        }

        if (lineToReturn.length() == 0){
            throw new IllegalArgumentException(String.format("[%s] not found!", id));
            // return new String("");
        } else {
            return lineToReturn;
        }
    }




    
    /** Finds all matches with same ID
     * @param fileName
     * @param id
     * @return ArrayList<String>
     */
    public ArrayList<String> findAllMatchesFromFile(String fileName, String id){
        return this.findAllMatchesFromFile(fileName, id, 0);
    }


    /** Finds all matches with same ID at specified index
     * @param fileName
     * @param id
     * @param index
     * @return ArrayList<String>
     * @throws IllegalArgumentException
     */
    public ArrayList<String> findAllMatchesFromFile(String fileName, String id, int index) throws IllegalArgumentException{

        ArrayList<String> arrToReturn = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(this.relativeFileDir+fileName));
            // iterates over lines until null
            reader.readLine(); // gets rid of header line
            String curLine = reader.readLine();
            while(curLine != null){
                if(isSameID(curLine, id, index)){
                    arrToReturn.add(curLine);
                }

                curLine = reader.readLine();
                
            }
            reader.close();
        } catch (IOException e){
            // e.printStackTrace();
        }

        if (arrToReturn.size() == 0){
            throw new IllegalArgumentException(String.format("[%s] not found!", id));
            // return new String("");
        } else {
            return arrToReturn;
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
                if(isSameID(curLine, key, 0)){
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
            // e.printStackTrace();
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
                if(isSameID(curLine, key, 0)){
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



    
    /** Gets properties from config file
     * @return Properties
     */
    public Properties getProps(){
        Properties props = new Properties();
        try {
            FileInputStream in = new FileInputStream(this.relativeFileDir+EnumDataFiles.Config.toString());
            props.load(in);
            in.close();
        } catch (Exception e) {
            // pass
        }
        return props;
    }


    
    /** Sets properties from config file
     * @param props
     */
    public void setProps(Properties props){
        try {
            FileOutputStream out = new FileOutputStream(this.relativeFileDir+EnumDataFiles.Config.toString());
            props.store(out, null);
            out.close();
        } catch (Exception e) {
            // pass
        }
    }

}
