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
     * @param args[]
     */
    public static void main(String args[]) {
        App myApp = new App();
        User usr = myApp.determineUsrType();
        usr.run();
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
                default:
                    System.out.println("Invalid input!");
                    usrChoice = 0;
                    break;
            }

        } while (usrChoice == 0);

        return usrObj;
    }
}