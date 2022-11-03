package Users;

import java.util.ArrayList;

import Menu.StaffMenu;
import dataDriver.InterfaceCsvDelimiter;
import dataDriver.InterfaceToCsvStringHelper;
import dataDriver.StaffCSVDriver;

public class Staff extends User implements InterfaceToCsvStringHelper, InterfaceCsvDelimiter{

    private boolean isAuthenticated = false;
    private String ID;
    private String usrName;
    private String usrPwd;
    
    public Staff(){
        super.menu = new StaffMenu();
        super.dataDriver = (StaffCSVDriver) new StaffCSVDriver();
    }

    protected Staff(String ID, String usrName, String usrPwd){
        super.menu = new StaffMenu();
        super.dataDriver = (StaffCSVDriver) new StaffCSVDriver();
        this.ID = ID;
        this.usrName = usrName;
        this.usrPwd = usrPwd;
    }


    // Helper methods

    private void authStaff(){
        do{
            System.out.println("\nLOGIN AS STAFF");
            String usrName = super.input.getUsrString("Enter Username:");
            String usrPwd = super.input.getUsrPwd("Enter Password:");

            if(((StaffCSVDriver) dataDriver).authenticate(usrName, usrPwd)){ // long cast statement for intellisense
                this.isAuthenticated = true;
                this.ID = ((StaffCSVDriver) super.dataDriver).getStaffIdFromUsrname(usrName);
                this.usrName = usrName;
                this.usrPwd = usrPwd;
            } else {
                System.out.println("Wrong login credentials! Please try again!\n");
            }
        } while (this.isAuthenticated == false);
    }

    private void updateCSV(Staff staffUsr){
        ((StaffCSVDriver) this.dataDriver).updateStaffAccount(staffUsr);
    }

    private void addCSV(Staff staffUsr){
        ((StaffCSVDriver) this.dataDriver).createStaffAccount(staffUsr);
    }


    @Override
    public String toCsvString(){
        ArrayList<String> details = new ArrayList<>();
        details.add(this.usrName);
        details.add(this.ID);
        details.add(this.usrPwd);

        return String.join(mainDelimiter, details);
    }

    

    @Override
    public void run(){

        while(!isAuthenticated){
            this.authStaff();
        }

        this._run();
    }

    // MAIN RUNNING LOOP
    private void _run(){
        int usrChoice = 0;
        this.menu.printMainMenu();
        do{
            usrChoice = super.getUsrChoice();

            switch(usrChoice){
                case 1:
                    // print this menu
                    this.menu.printMainMenu();
                    break;
                case 2:
                    // Create movie listing
                    ((StaffCSVDriver) this.dataDriver).createMovieListing();
                    break;
                case 3:
                    // Show all movie listing
                    this.dataDriver.listAllMovies();
                    break;
                case 4:
                    // update movie listing
                    ((StaffCSVDriver) this.dataDriver).updateMovieListing();
                    break;
                case 5:
                    // delete movie listing
                    ((StaffCSVDriver) this.dataDriver).deleteMovieListing();
                    break;
                case 6:
                    // create showtime
                    ((StaffCSVDriver) this.dataDriver).createCinemaShowtime();
                    break;
                case 7:
                    // show all showtimes;
                    this.dataDriver.listAllShowtimes();
                    break;
                case 8:
                    // show all upcoming showtimes;
                    this.dataDriver.listAllUpcomingShowtimes();
                    break;
                case 9:
                    // update showtime
                    ((StaffCSVDriver) this.dataDriver).updateCinemaShowtime();
                    break;
                case 10:
                    // delete showtime
                    ((StaffCSVDriver) this.dataDriver).deleteCinemaShowtime();
                    break;
                case 11:
                    // configure system settings
                    this.configSettings();
                    System.out.println("here!!!");
                    this.menu.printMainMenu();
                    break;
                case 12:
                    // quit
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Select option 1 to print menu again.");
                    break;
            }

        } while (usrChoice!=12);
    }


    private void configSettings(){
        ((StaffMenu) this.menu).printConfigMenu();
        int usrChoice = 0;
        do{
            usrChoice = super.input.getUsrInt("Enter choice: ");

            switch(usrChoice){
                case 1:
                    // print menu
                    ((StaffMenu) this.menu).printConfigMenu();
                    break;
                case 2:
                    // change password
                    this.usrPwd = super.input.getUsrPwd("Enter NEW password: ");
                    this.updateCSV(this);
                    break;
                case 3:
                    // change username
                    this.usrName = super.input.getUsrString("Enter NEW username: ");
                    this.updateCSV(this);
                    break;
                case 4:
                    // create new user
                    String newUsrID = super.input.getUsrString("Enter ID for new user: ");
                    String newUsrName = super.input.getUsrString("Enter username for new user: ");
                    String newUsrPwd = super.input.getUsrPwd("Enter password for new user: ");
                    this.addCSV(new Staff(newUsrID, newUsrName, newUsrPwd));
                    break;
                case 5:
                    // back, nothing here
                    break;
            }

        } while (usrChoice!=5);
    }

}
