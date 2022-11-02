package Booking;

import java.util.Scanner;
import Menu.CustomerMenu;
import dataDriver.CustomerCSVDriver;
import dataDriver.EnumDataFiles;
import MovieTheatres.*;
import UsrInput.UsrInput;

public class BookingApp {

    private String[] type = {"Senior Citizen","Students","Non-Peak : Weekday","Peak : Weekday","Weekend"};
    //private String movieTiming;
    //private String cinemaCode;
    //private String movieDay;

    /*public BookingApp(String movieTiming,String cinemaCode,String movieDay){
        this.movieTiming = movieTiming;
        this.cinemaCode = cinemaCode;
        this.movieDay = movieDay;
    }*/

    //Constructor for BookingApp
    public BookingApp(){
        
    }


    public int bookingApp(){
        BookingMenu book = new BookingMenu();
        UsrInput sc = new UsrInput();
        //Scanner item for input
        //Scanner sc = new Scanner(System.in);


        //1. List all the movies for customer to select
        CustomerCSVDriver driver = new CustomerCSVDriver();
        driver.listAllMovies();

        //2. To select a movie, ask the user to type in the movieID
        System.out.println("Select showtime of movie: Please type in the movieID");
        String movieId = sc.getUsrString("Movie id: ");

        //3. List all the showtime for that movie
        while(driver.listShowtimeFromRegex(movieId)==false){
            book.printShowtime();
            int choose = sc.getUsrInt("Choice");
            if(choose == 1){
                System.out.println("Select showtime of movie: Please type in the movieID");
                movieId = sc.getUsrString("Movie id: ");
            }
            else{
                return 0;
            }
        }

        //4. User will then need to select the showtime they want
        System.out.println("To select showtime of movie for booking: Please type in the showtime ID");
        String showTimeId = sc.getUsrString("Show time id: ");

        String csvline = driver.findCinema(showTimeId);
        CinemaBuilder buildcinema = new CinemaBuilder(csvline);
        Cinema newCinema = new Cinema(buildcinema);
        //System.out.println("Cinema code" + newCinema.getCinemaCode());

        char classOfCinema = newCinema.getCinemaCode().charAt(0);
        //System.out.println("Class of cinema: " + classOfCinema);
        System.out.println("Get booked seat: " + newCinema.getBookedSeat());


        if(Character.compare(classOfCinema,'R')==0){
            Regular regularCinema = new Regular(newCinema.getBookedSeat());
            regularCinema.initialLayout();
            regularCinema.showLayout();

            book.printBookingPrice();

            bookRegular regular = new bookRegular(newCinema,regularCinema,book,driver);
            regular.bookingRegular();

            TransactionID transact = new TransactionID(newCinema.getCinemaCode());
            String Tid = transact.TID();
            System.out.println("Transaction ID : " + Tid);

    }


        else if(Character.compare(classOfCinema,'F')==0){
            First firstCinema = new First(newCinema.getBookedSeat());
            firstCinema.initialLayout();
            firstCinema.showLayout();

            book.printBookingPrice();

            bookFirst first = new bookFirst(newCinema,firstCinema,book,driver);
            first.bookingFirst();

            TransactionID transact = new TransactionID(newCinema.getCinemaCode());
            String Tid = transact.TID();
            System.out.println("Transaction ID : " + Tid);

        }

        
        else if(Character.compare(classOfCinema,'G')==0){
            Gold goldCinema = new Gold(newCinema.getBookedSeat());
            goldCinema.initialLayout();
            goldCinema.showLayout();

            book.printBookingPrice();

            bookGold golden = new bookGold(newCinema,goldCinema,book,driver);
            golden.bookingGold();

            TransactionID transact = new TransactionID(newCinema.getCinemaCode());
            String Tid = transact.TID();
            System.out.println("Transaction ID : " + Tid);

        }

      
        return 0;
    }
}
