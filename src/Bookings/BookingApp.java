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

        book.mainBookingPage();
        int choice;
        

        do{
        choice = sc.getUsrInt("Choice: ");
        switch(choice){
            case 1:
                book.printBookingPrice();
                break;
            case 2: //Start Booking
                //0. When start booking, customer will need to enter mobile phone and email

                //Get Mobile Number
                System.out.println("Please enter your mobile number: ");
                String mobileNum = sc.getUsrString("Mobile Number: ");

                //Get Email Address
                System.out.println("Please enter your email");
                String email = sc.getUsrString("Email: ");
                

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
                System.out.println("Cinema code" + newCinema.getCinemaCode());

                char classOfCinema = newCinema.getCinemaCode().charAt(0);
                //System.out.println("Class of cinema: " + classOfCinema);


                if(Character.compare(classOfCinema,'R')==0){
                    System.out.println("Type of Cinema: Regular");
                    Regular regularCinema = new Regular(newCinema.getBookedSeat());
                    regularCinema.initialLayout();
                    regularCinema.showLayout();

                    bookRegular regular = new bookRegular(newCinema,regularCinema,book,driver);
                    regular.bookingRegular();

                }

                else if(Character.compare(classOfCinema,'F')==0){
                    System.out.println("Type of Cinema: First");
                    First firstCinema = new First(newCinema.getBookedSeat());
                    firstCinema.initialLayout();
                    firstCinema.showLayout();


                    bookFirst first = new bookFirst(newCinema,firstCinema,book,driver);
                    first.bookingFirst();

                }
        
                else if(Character.compare(classOfCinema,'G')==0){
                    System.out.println("Type of Cinema: Gold");
                    Gold goldCinema = new Gold(newCinema.getBookedSeat());
                    goldCinema.initialLayout();
                    goldCinema.showLayout();


                    bookGold golden = new bookGold(newCinema,goldCinema,book,driver);
                    golden.bookingGold();


                }

                
                TransactionID transact = new TransactionID(newCinema.getCinemaCode());
                String Tid = transact.TID();
                System.out.println("Transaction ID : " + Tid);

                //After booking is made, need to write to booking history file
                bookingHistoryBuilder historyBuilder = new bookingHistoryBuilder();
                historyBuilder.setTID(Tid);
                historyBuilder.setmovieID(movieId);
                historyBuilder.setMobileNum(mobileNum);
                historyBuilder.setEmail(email);
                historyBuilder.setmovieName(driver.findmovie(movieId));

                driver.createBookingHistory(historyBuilder);

                
                break;

            case 3:
                System.out.println("Exiting......");
                break;
                

        }
    }while(choice!=3);

        return 0;
    }
}
