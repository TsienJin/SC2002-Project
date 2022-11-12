package Bookings;

import Menu.CustomerMenu;
import dataDriver.CustomerCSVDriver;
import dataDriver.EnumDataFiles;
import MovieTheatres.*;
import ShowTime.ShowtimeBuilder;
import ShowTime.showtime;
import UsrInput.UsrInput;

public class BookingApp {

    private String[] type = {"Senior Citizen","Students","Non-Peak : Weekday","Peak : Weekday","Weekend"};
    private UsrInput input = new UsrInput();
   

    /**
     * Default Constructor
     */
    //Constructor for BookingApp
    public BookingApp(){
        
    }


    /**
     * Main booking function for the main application
     * @return int User Choice
     */

    public int bookingApp(){

        BookingMenu book = new BookingMenu();

        book.mainBookingPage();
        int choice;
        

        do{
        choice = this.input.getUsrInt("Choice: ");
        switch(choice){
            case 1:
                book.mainBookingPage();
                break;
            case 2:
                book.printBookingPrice();
                book.printBookingBPrice();
                book.printBookingSPrice();
                break;
            case 3: //Start Booking
                //0. When start booking, customer will need to enter mobile phone and email

                //Get Mobile Number
                String mobileNum = this.input.getUsrString("Please enter your Mobile Number: ");

                //Get Email Address
                String email = this.input.getUsrString("Please Enter your Email: ");
                

                 //1. List all the movies for customer to select
                CustomerCSVDriver driver = new CustomerCSVDriver();
                driver.listAllMovieforBooking();

                //2. To select a movie, ask the user to type in the movieID
                String movieId = this.input.getUsrString("Please Enter Movie ID: ");
                while(!driver.checkMovieStatus(movieId)){
                    System.out.println("Movie not available for booking");
                    movieId = this.input.getUsrString("Please Enter Movie ID: ");
                }

                //3. List all the showtime for that movie
                while(driver.listUpcomingShowtimefromregex(movieId)==false){
                    book.printShowtime();
                    int choose = this.input.getUsrInt("Choice");
                    if(choose == 1){
                        movieId = this.input.getUsrString("Please Enter Movie ID: ");
                    }
                    else{
                        return 0;
                    }
                }

                String movieTitle = driver.findmovieType(movieId);

                //4. User will then need to select the showtime they want
                String showTimeId = this.input.getUsrString("Please Enter Showtime ID: ");

                showtime newShowtime = new ShowtimeBuilder(driver.findShowtime(showTimeId)).build();
                //System.out.println("Showtime ID: " + newShowtime.getCinema().getHallNumber());
                System.out.println("Cinema code: " + newShowtime.getCinema().getCinemaCode());

                char classOfCinema = newShowtime.getCinema().getCinemaCode().charAt(0);
                //System.out.println("Class of cinema: " + classOfCinema);


                double totalPrice = 0;
                if(Character.compare(classOfCinema,'R')==0){
                    System.out.println("Type of Cinema: Regular");
                    Regular regularCinema = new Regular(newShowtime.getBookedSeat());
                    regularCinema.initialLayout();
                    regularCinema.showLayout();

                    bookRegular regular = new bookRegular(newShowtime,regularCinema,book,driver,movieTitle);
                    totalPrice = regular.booking();

                }

                else if(Character.compare(classOfCinema,'F')==0){
                    System.out.println("Type of Cinema: First");
                    First firstCinema = new First(newShowtime.getBookedSeat());
                    firstCinema.initialLayout();
                    firstCinema.showLayout();


                    bookFirst first = new bookFirst(newShowtime,firstCinema,book,driver,movieTitle);
                    totalPrice = first.booking();

                }
        
                else if(Character.compare(classOfCinema,'G')==0){
                    System.out.println("Type of Cinema: Gold");
                    Gold goldCinema = new Gold(newShowtime.getBookedSeat());
                    goldCinema.initialLayout();
                    goldCinema.showLayout();


                    bookGold golden = new bookGold(newShowtime,goldCinema,book,driver,movieTitle);
                    totalPrice = golden.booking();


                }

                
                TransactionID transact = new TransactionID(newShowtime.getCinema().getCinemaCode());
                String Tid = transact.TID();
                System.out.println("Transaction ID : " + Tid);

                //After booking is made, need to write to booking history file
                bookingHistoryBuilder historyBuilder = new bookingHistoryBuilder();
                historyBuilder.setTID(Tid);
                historyBuilder.setmovieID(movieId);
                historyBuilder.setMobileNum(mobileNum);
                historyBuilder.setEmail(email);
                historyBuilder.setmovieName(driver.findmovie(movieId));
                historyBuilder.settotalPrice(Double.toString(totalPrice));

                driver.createBookingHistory(historyBuilder);

                
                break;

            case 4:
                System.out.println("Exiting......");
                break;
                

        }
    }while(choice!=4);

        return 0;
    }
}
