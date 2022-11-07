import Menu.MainMenu;
import Menu.Menu;
import Users.Customer;
import Users.Staff;                     
import Users.User;
import UsrInput.UsrInput;


 
/** Main running app
 * @author SS3 GROUP NUMBER HERE
 */
public class App{
    UsrInput usrInput = new UsrInput();

    
    /** 
     * Runs main program
     * @param args[]
     */
    public static void main(String args[]) {
        App myApp = new App();

        User usr;
        do {
            usr = myApp.determineUsrType();
            if(usr!=null){
                usr.run();
            }
        } while (usr != null);
    }

    
    /** Method to determine user type
     * @return User
     */
    public User determineUsrType() {
        Menu thisMenu = new MainMenu();
        thisMenu.printMainMenu();

        User usrObj = null;

        int usrChoice = 1;
        do {
            usrChoice = usrInput.getUsrInt("User type: ");

            switch(usrChoice){
                case 1:
                    usrObj = new Staff();
                    break;
                case 2:
                    usrObj = new Customer();
                    break;
                case 3:
                    // quit
                    System.out.println("Exiting Application");
                    usrObj = null;
                    break;
                default:
                    System.out.println("Invalid input!");
                    usrChoice = 0;
                    break;
            }

        } while (usrChoice == 0);

        return usrObj;
    }
}