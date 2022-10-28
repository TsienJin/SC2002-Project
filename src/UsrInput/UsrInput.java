package UsrInput;

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
        // Scanner scan = new Scanner(System.in);
        System.out.println(promt);
        return scan.next();
    }

    
    /** Gets user Integer input
     * @param promt
     * @return String
     */
    public int getUsrInt(String promt){
        // Scanner scan = new Scanner(System.in);
        System.out.println(promt);
        return scan.nextInt();
    }
}