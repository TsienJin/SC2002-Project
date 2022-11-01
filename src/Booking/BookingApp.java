package Booking;

import java.util.Scanner;

public class BookingApp {

    private String[] type = {"Senior Citizen","Students","Non-Peak : Weekday","Peak : Weekday","Weekend"};
    private String movieTiming;
    private String cinemaCode;
    private String movieDay;

    public BookingApp(String movieTiming,String cinemaCode,String movieDay){
        this.movieTiming = movieTiming;
        this.cinemaCode = cinemaCode;
        this.movieDay = movieDay;
    }

    public void bookingApp(){
        Scanner sc = new Scanner(System.in);

        BookingMenu book = new BookingMenu();


        book.printBookingPrice();
        System.out.print("\n");


        book.printMenu();
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                Booking newBooking = new Booking("1900","R","Wednesday","Adult");
                System.out.println("Payment: " + newBooking.calculatePayment());
                book.printConfirm();
                int confirm = sc.nextInt();
                if(confirm==1){
                    TransactionID Id = new TransactionID("R");
                    String id = Id.TID();
                    System.out.println("Transaction ID: " + id);
                }
                break;
            case 2:
                newBooking = new Booking("1900","R","Wednesday","Senior Citizen");
                System.out.println("Payment: " + newBooking.calculatePayment());
                book.printConfirm();
                confirm = sc.nextInt();
                if(confirm==1){
                    TransactionID Id = new TransactionID("R");
                    String id = Id.TID();
                    System.out.println("Transaction ID: " + id);
                }
                break;
            case 3:
                newBooking = new Booking("1900","R","Wednesday","Students");
                System.out.println("Payment: " + newBooking.calculatePayment());
                book.printConfirm();
                confirm = sc.nextInt();
                if(confirm==1){
                    TransactionID Id = new TransactionID("R");
                    String id = Id.TID();
                    System.out.println("Transaction ID: " + id);
                }
                break;
        }

    }
}
