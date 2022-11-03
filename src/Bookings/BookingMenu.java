package Bookings;

public class BookingMenu {
    private String[] type = {"Senior Citizen","Students","Non-Peak : Weekday","Peak : Weekday","Weekend"};
    private double[][] price = {
            {10,12,14},
            {10,12,14},
            {12,14,16},
            {14,16,18},
            {16,18,20}
    };

    public void printShowtime(){
        System.out.println("1. Enter showtime again");
        System.out.println("2. Exit");
    }

    public void printMenu(){
        System.out.println("Select ticket type:");
        System.out.println("1. Adult");
        System.out.println("2. Senior Citizen: For patrons 55 years & older");
        System.out.println("3. Students");
        System.out.println("\n");
    }

    public void printBookingPrice(){
        System.out.println("Ticket Price");
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

            for(int j = 0; j<3; j++){
                System.out.print(price[i][j] + "      ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");

    }

    public void printConfirm(){
        System.out.println("Select to confirm:");
        System.out.println("1. Confirm");
        System.out.println("2. Exit");
    }

    public void mainBookingPage(){
        System.out.println("--Welcome to the Booking App--");
        System.out.println("1. View Ticket Pricing");
        System.out.println("2. Start Booking");
        System.out.println("3. Exit");
    }



}
