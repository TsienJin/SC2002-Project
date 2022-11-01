import Menu.MainMenu;
import Menu.Menu;
import UsrInput.UsrInput;
import dataDriver.CSVDriver;
import dataDriver.StaffCSVDriver;


public class App{
    UsrInput usrInput = new UsrInput();

    public static void main(String args[]){
        App myApp = new App();

        User usr = myApp.determineUsrType();
        usr.run();

        // myApp.testing();



    }

    public User determineUsrType(){
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


    public void testing(){
        // FileIO fileobj = new FileIO();
        // System.out.println(fileobj.findMatchFromFile(EnumDataFiles.Movie.toString(), "2958305"));
        // MovieBuilder bldr = new MovieBuilder(fileobj.findMatchFromFile(EnumDataFiles.Movie.toString(), "2958305"));
        // Movie mv = bldr.build();
        // System.out.println(mv.getDirector());

        CSVDriver obj = new StaffCSVDriver();
        obj.listMovieFromRegex("pulp");

    }
}