package UsrInput;

import java.util.InputMismatchException;
import java.util.Scanner;

import java.io.Console;



/** Object that handles user inputs.
 * 
 * @author Tsien Jin
 */
public class UsrInput{

    Scanner scan = new Scanner(System.in);
    Console console = System.console();

    
    /** Gets user String input
     * @param promt
     * @return String
     */
    public String getUsrString(String promt){
        System.out.print(promt+"\t");
        return scan.nextLine();
    }
    
    /** Gets user password input, mask output
     * @param promt
     * @return String
     */
    public String getUsrPwd(String promt){
        console.printf(promt+"\t");
        char[] passwordChars = console.readPassword();
        return new String(passwordChars);
    }

    
    /** Gets user Integer input
     * @param promt
     * @return Int
     */
    public int getUsrInt(String promt){

        boolean restart = false;
        int usrInt = -1;
        do {
            try{
                System.out.print(promt+"\t");
                usrInt = Integer.parseInt(scan.nextLine());
                restart = false;
            } catch (InputMismatchException e) {
                System.out.println("Error! Please input a value Integer.");
                restart = true;
                scan.nextLine();
                break;
            }
        } while (restart == true);

        return usrInt;
    }
}