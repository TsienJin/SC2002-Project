package Bookings;
/**
 * BookingMenu class contains all the Menu that is needed to print for the user
 */
public class BookingMenu {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED_BACKGROUND= "\u001B[41m";
    private static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    private static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";


    private String[] type = {"Senior Citizen","Students","Non-Peak : Weekday","Peak : Weekday","Weekend"};
    private double[][] price = {
            {10,12,14},
            {10,12,14},
            {12,14,16},
            {14,16,18},
            {16,18,20},
            {30,35,40},
            {25,30,35},
            {40,45,50}
    };

    private double[][] Bprice = {
        {12,14,16},
        {12,14,16},
        {14,16,18},
        {16,18,20},
        {18,20,22},
        {30,35,40},
        {25,30,35},
        {40,45,50}
    };

    private double[][] Sprice = {
        {14,16,18},
        {14,16,18},
        {16,18,20},
        {18,20,22},
        {20,22,24},
        {30,35,40},
        {25,30,35},
        {40,45,50}
    };

    /**
     * Menu to ask user to print showtime 
     */
    public void printShowtime(){
        System.out.println("1. Enter showtime again");
        System.out.println("2. Exit");
    }

    /**
     * Menu for the different ticket type in terms of age group
     */
    public void printMenu(){
        System.out.println("Select ticket type:");
        System.out.println("1. Adult");
        System.out.println("2. Senior Citizen: For patrons 55 years & older");
        System.out.println("3. Students");
        System.out.println("\n");
    }

    /**
     * Menu to print out the different movie ticket pricing in Table format for regular movie
     */
    public void printBookingPrice(){
        System.out.println("Regular Movie Ticket Price");
        System.out.println("----------------------------------------------");
        System.out.println("                    Regular   First     Gold");
        for(int i = 0;i<8;i++){
            if(i==0){
                System.out.print(type[i]+"     |");
            }
            if(i==1){
                System.out.print(type[i]+"           |");
            }
            if(i==2){
                System.out.print(type[i] + " |");
            }
            if(i==3){
                System.out.print(type[i]+"     |");
            }
            if(i==4){
                System.out.print(type[i]+"            |");
            }
            if(i==5){
                System.out.print(ANSI_RED_BACKGROUND + "Ultimate Seats     |" + ANSI_RESET);
            }
            if(i==6){
                System.out.print(ANSI_PURPLE_BACKGROUND + "Elite Seats        |" + ANSI_RESET);
            }
            if(i==7){
                System.out.print(ANSI_BLUE_BACKGROUND + "Platinum Seats     |" + ANSI_RESET);
            }

            for(int j = 0; j<3; j++){
                System.out.print(price[i][j] + "      ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");

    }

    /**
     * Menu to print out the different movie ticket pricing in Table format for BlockBuster movie
     */
    public void printBookingBPrice(){
        System.out.println("BlockBuster Movie Ticket Price");
        System.out.println("----------------------------------------------");
        System.out.println("                    Regular   First     Gold");
        for(int i = 0;i<5;i++){
            if(i==0){
                System.out.print(type[i]+"     |");
            }
            if(i==1){
                System.out.print(type[i]+"           |");
            }
            if(i==2){
                System.out.print(type[i] + " |");
            }
            if(i==3){
                System.out.print(type[i]+"     |");
            }
            if(i==4){
                System.out.print(type[i]+"            |");
            }
            if(i==5){
                System.out.print(ANSI_RED_BACKGROUND + "Ultimate Seats     |" + ANSI_RESET);
            }
            if(i==6){
                System.out.print(ANSI_PURPLE_BACKGROUND + "Elite Seats        |" + ANSI_RESET);
            }
            if(i==7){
                System.out.print(ANSI_BLUE_BACKGROUND + "Platinum Seats     |" + ANSI_RESET);
            }

            for(int j = 0; j<3; j++){
                System.out.print(Bprice[i][j] + "      ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");

    }

    /**
     * Menu to print out the different movie ticket pricing in Table format for 3D & IMax movie
     */
    public void printBookingSPrice(){
        System.out.println("3D & IMax Movie Ticket Price");
        System.out.println("----------------------------------------------");
        System.out.println("                    Regular   First     Gold");
        for(int i = 0;i<5;i++){
            if(i==0){
                System.out.print(type[i]+"     |");
            }
            if(i==1){
                System.out.print(type[i]+"           |");
            }
            if(i==2){
                System.out.print(type[i] + " |");
            }
            if(i==3){
                System.out.print(type[i]+"     |");
            }
            if(i==4){
                System.out.print(type[i]+"            |");
            }
            if(i==5){
                System.out.print(ANSI_RED_BACKGROUND + "Ultimate Seats     |" + ANSI_RESET);
            }
            if(i==6){
                System.out.print(ANSI_PURPLE_BACKGROUND + "Elite Seats        |" + ANSI_RESET);
            }
            if(i==7){
                System.out.print(ANSI_BLUE_BACKGROUND + "Platinum Seats     |" + ANSI_RESET);
            }

            for(int j = 0; j<3; j++){
                System.out.print(Sprice[i][j] + "      ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");


        System.out.println(ANSI_RED_BACKGROUND + "Terms and Condition" + ANSI_RESET);
        System.out.println("* Senior citizens are aged above 55 and only applies to regular seats");
        System.out.println("** Students need to show verfication card when entering and only applies to regular seats");
        System.out.println("*** Ultimate, Elite and Platinum seats have fixed rates");
        

    }

    /**
     * Menu for confirmation of booking
     */
    public void printConfirm(){
        System.out.println("Select to confirm:");
        System.out.println("1. Confirm");
        System.out.println("2. Exit");
    }

    /**
     * Menu for the main booking page 
     */
    public void mainBookingPage(){
        
        System.out.println("1. Print this menu");
        System.out.println("2. View Ticket Pricing");
        System.out.println("3. Start Booking");
        System.out.println("4. Exit");
    }



}
