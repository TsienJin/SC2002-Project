package Bookings;

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
     *
     */
    public void printShowtime(){
        System.out.println("1. Enter showtime again");
        System.out.println("2. Exit");
    }

    /**
     *
     */
    public void printMenu(){
        System.out.println("Select ticket type:");
        System.out.println("1. Adult");
        System.out.println("2. Senior Citizen: For patrons 55 years & older");
        System.out.println("3. Students");
        System.out.println("\n");
    }

    /**
     *
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
                System.out.print("Ultimate Seats     |");
            }
            if(i==6){
                System.out.print("Elite Seats        |");
            }
            if(i==7){
                System.out.print("Platinum Seats     |");
            }

            for(int j = 0; j<3; j++){
                System.out.print(price[i][j] + "      ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");

    }

    /**
     *
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
                System.out.print("Ultimate Seats     |");
            }
            if(i==6){
                System.out.print("Elite Seats        |");
            }
            if(i==7){
                System.out.print("Platinum Seats     |");
            }

            for(int j = 0; j<3; j++){
                System.out.print(Bprice[i][j] + "      ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");

    }

    /**
     *
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
                System.out.print("Ultimate Seats     |");
            }
            if(i==6){
                System.out.print("Elite Seats        |");
            }
            if(i==7){
                System.out.print("Platinum Seats     |");
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
     *
     */
    public void printConfirm(){
        System.out.println("Select to confirm:");
        System.out.println("1. Confirm");
        System.out.println("2. Exit");
    }

    /**
     *
     */
    public void mainBookingPage(){
        System.out.println("--Welcome to the Booking App--");
        System.out.println("1. Print this menu");
        System.out.println("2. View Ticket Pricing");
        System.out.println("3. Start Booking");
        System.out.println("4. Exit");
    }



}
