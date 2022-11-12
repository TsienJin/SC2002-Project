package Users;

import java.util.ArrayList;

import Menu.StaffMenu;
import dataDriver.InterfaceCsvDelimiter;
import dataDriver.InterfaceToCsvStringHelper;
import dataDriver.StaffCSVDriver;
import Holiday.*;

/**
 * Staff running 'shell'
 * 
 * @Author Tsien Jin
 */
public class Staff extends User implements InterfaceToCsvStringHelper, InterfaceCsvDelimiter {

    private boolean isAuthenticated = false;
    private String ID;
    private String usrName;
    private String usrPwd;

    /**
     * Constructor
     * 
     */
    public Staff() {
        super.menu = new StaffMenu();
        super.dataDriver = (StaffCSVDriver) new StaffCSVDriver();
    }

    /**
     * Protected constructor with user information
     * 
     * @param ID
     * @param usrName
     * @param usrPwd
     * 
     */
    protected Staff(String ID, String usrName, String usrPwd) {
        super.menu = new StaffMenu();
        super.dataDriver = (StaffCSVDriver) new StaffCSVDriver();
        this.ID = ID;
        this.usrName = usrName;
        this.usrPwd = usrPwd;
    }

    /**
     * Method to authenticate staff user and handle user logic
     * Updates attribute this.isAuthenticated once password and login is correct
     */
    // Helper methods
    private void authStaff() {
        do {
            System.out.println("\nLOGIN AS STAFF");
            String usrName = super.input.getUsrString("Enter Username:");
            String usrPwd = super.input.getUsrPwd("Enter Password:");

            if (((StaffCSVDriver) dataDriver).authenticate(usrName, usrPwd)) { // long cast statement for intellisense
                this.isAuthenticated = true;
                this.ID = ((StaffCSVDriver) super.dataDriver).getStaffIdFromUsrname(usrName);
                this.usrName = usrName;
                this.usrPwd = usrPwd;
            } else {
                System.out.println("Wrong login credentials! Please try again!\n");
            }
        } while (this.isAuthenticated == false);
    }

    /**
     * Method to update CSV with changed information
     * 
     * @param staffUsr
     */
    private void updateCSV(Staff staffUsr) {
        ((StaffCSVDriver) this.dataDriver).updateStaffAccount(staffUsr);
    }

    /**
     * Method to add new user information to CSV
     * 
     * @param staffUsr
     */
    private void addCSV(Staff staffUsr) {
        ((StaffCSVDriver) this.dataDriver).createStaffAccount(staffUsr);
    }

    /**
     * Formats object information into CSV string
     * 
     * @return String
     */
    @Override
    public String toCsvString() {
        ArrayList<String> details = new ArrayList<>();
        details.add(this.usrName);
        details.add(this.ID);
        details.add(this.usrPwd);

        return String.join(mainDelimiter, details);
    }

    /**
     * Callable running loop
     * 
     */
    @Override
    public void run() {

        while (!isAuthenticated) {
            this.authStaff();
        }

        this._run();
    }

    /**
     * Main running loop
     * Called from Staff.run()
     */
    // MAIN RUNNING LOOP
    private void _run() {
        int usrChoice = 0;
        this.menu.printMainMenu();
        do {
            usrChoice = super.getUsrChoice();

            switch (usrChoice) {
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
                    this.dataDriver.listAllMoviesforStaff();
                    break;
                case 4:
                    // show top 5 movies rating
                    this.dataDriver.listTopMoviesByRating();
                    break;
                case 5:
                    // show top 5 movies sales
                    this.dataDriver.listTopMoviesBySales();
                    break;
                case 6:
                    // update movie listing
                    ((StaffCSVDriver) this.dataDriver).updateMovieListing();
                    break;
                case 7:
                    // delete movie listing
                    ((StaffCSVDriver) this.dataDriver).deleteMovieListing();
                    break;
                case 8:
                    // create showtime
                    ((StaffCSVDriver) this.dataDriver).createCinemaShowtime();
                    break;
                case 9:
                    // show all showtimes;
                    this.dataDriver.listAllShowtimes();
                    break;
                case 10:
                    // show all upcoming showtimes;
                    this.dataDriver.listAllUpcomingShowtimes();
                    break;
                case 11:
                    // update showtime
                    ((StaffCSVDriver) this.dataDriver).updateCinemaShowtime();
                    break;
                case 12:
                    // delete showtime
                    ((StaffCSVDriver) this.dataDriver).deleteCinemaShowtime();
                    break;
                case 13:
                    // configure system settings
                    this.configSettings();
                    this.menu.printMainMenu();
                    break;
                case 14:
                    // quit
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Select option 1 to print menu again.");
                    break;
            }

        } while (usrChoice != 14);
    }

    /**
     * Menu for staff to configure settings
     * 
     */
    private void configSettings() {
        ((StaffMenu) this.menu).printConfigMenu();
        int usrChoice = 0;
        do {
            usrChoice = super.input.getUsrInt("Enter choice: ");

            switch (usrChoice) {
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
                    // change ranking of menu for customer
                    this.configMovieSorting();
                    ((StaffMenu) this.menu).printConfigMenu();
                    break;
                case 6:
                    // Configuring holiday dates
                    new holidayApp().holidayapp();
                    break;
                case 7:
                    // back, nothing here
                    break;
            }

        } while (usrChoice != 7);
    }

    /**
     * Submenu to configure movie sorting
     * 
     */
    public void configMovieSorting() {
        ((StaffMenu) this.menu).printMovieRankingMenu();
        int usrChoice = 0;
        do {
            usrChoice = this.input.getUsrInt("Enter choice: ");
            switch (usrChoice) {
                case 1:
                    // sort by sales
                    ((StaffCSVDriver) this.dataDriver).sortMoviesBySales();
                    break;
                case 2:
                    // sort by rating
                    ((StaffCSVDriver) this.dataDriver).sortMoviesByRating();
                    break;
                case 3:
                    // unrestrict customer
                    ((StaffCSVDriver) this.dataDriver).unrestrictCustomerMovieSort();
                    break;
                case 4:
                    // restrict customer
                    ((StaffCSVDriver) this.dataDriver).restrictCustomerMovieSort();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid input!");
                    usrChoice = 0;
            }
            ;
        } while (usrChoice == 0);
    }

}
