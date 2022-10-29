import Menu.StaffMenu;

public class Staff extends User {

    private boolean isAuthenticated = false;
    
    public Staff(){
        super.menu = new StaffMenu();
    }


    // Helper methods

    private void authStaff(){
        System.out.println("\nLOGIN AS STAFF");
        String usrName = super.input.getUsrString("Enter Username:");
        String usrPwd = super.input.getUsrString("Enter Password:");
        
        // some logic here

        // testing purposes
        this.isAuthenticated = true;
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
        do{
            this.menu.printMainMenu();
            usrChoice = super.getUsrChoice();

            switch(usrChoice){
                case 1:
                    // print this menu
                    this.menu.printMainMenu();
                    break;
                case 2:
                    // Create movie listing
                    break;
                case 3:
                    // Show all movie listing
                    break;
                case 4:
                    // update movie listing
                    break;
                case 5:
                    // delete movie listing
                    break;
                case 6:
                    // delete movie listing
                    break;
                case 7:
                    // create showtime
                    break;
                case 8:
                    // show all showtimes;
                    break;
                case 9:
                    // show all upcoming showtimes;
                    break;
                case 10:
                    // update showtime
                    break;
                case 11:
                    // delete showtime
                    break;
                case 12:
                    // configure system settings
                    break;
                case 13:
                    // quit
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Select option 1 to print menu again.");
                    break;
            }

        } while (usrChoice!=13);
    }

}
