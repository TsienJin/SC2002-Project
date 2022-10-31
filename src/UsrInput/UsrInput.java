package UsrInput;

import java.util.InputMismatchException;
import java.util.Scanner;




/** Object that handles user inputs.
 * 
 * @author Tsien Jin
 */
public class UsrInput{

    Scanner scan = new Scanner(System.in);

    
    /** Gets user String input
     * @param promt
     * @return String
     */
    public String getUsrString(String promt){
        System.out.print(promt+"\t");
        return scan.next();
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
                usrInt = scan.nextInt();
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