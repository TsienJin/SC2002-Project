package Booking;

import java.util.Scanner;
import Menu.CustomerMenu;
import dataDriver.CustomerCSVDriver;
import MovieTheatres.*;

public class BookingApp {

    private String[] type = {"Senior Citizen","Students","Non-Peak : Weekday","Peak : Weekday","Weekend"};
    private String movieTiming;
    private String cinemaCode;
    private String movieDay;

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
        //Scanner item for input
        Scanner sc = new Scanner(System.in);


        //1. List all the movies for customer to select
        CustomerCSVDriver driver = new CustomerCSVDriver();
        driver.listAllMovies();

        //2. To select a movie, ask the user to type in the movieID
        System.out.println("Select showtime of movie: Please type in the movieID");
        String movieId = sc.next();

        //3. List all the showtime for that movie
        while(driver.listShowtimeFromRegex(movieId)==false){
            book.printShowtime();
            int choose = sc.nextInt();
            if(choose == 1){
                System.out.println("Select showtime of movie: Please type in the movieID");
                movieId = sc.next();
            }
            else{
                return 0;
            }
        }

        //4. User will then need to select the showtime they want
        System.out.println("To select showtime of movie for booking: Please type in the showtime ID");
        String showTimeId = sc.next();

        String csvline = driver.findCinema(showTimeId);
        CinemaBuilder buildcinema = new CinemaBuilder(csvline);
        Cinema newCinema = new Cinema(buildcinema);

        char classOfCinema = newCinema.getCinemaCode().charAt(0);
        if(Character.compare(classOfCinema,'R')==0){
            Regular regularCinema = new Regular(newCinema.getBookedSeat());
            regularCinema.initialLayout();
            regularCinema.showLayout();


        }
        else if(Character.compare(classOfCinema,'F')==0){
            First firstCinema = new First(newCinema.getBookedSeat());
            firstCinema.initialLayout();
            firstCinema.showLayout();

        }
        else if(Character.compare(classOfCinema,'G')==0){
            Gold goldCinema = new Gold(newCinema.getBookedSeat());
            goldCinema.initialLayout();
            goldCinema.showLayout();

            book.printBookingPrice();

            System.out.println("How many tickets do you want to purchase?");
            int numOfTickets = sc.nextInt();
            
            boolean isitBook;
            //while less than numOfTickets, user can select the seat they want
            double total = 0;
            for(int i = 0; i<numOfTickets; i++){
                System.out.println("Ticket " + i+1);
                System.out.println("Selecting Seat.....");
                do{
                    System.out.println("Please input the row number: ");
                    int row = sc.nextInt();
                    System.out.println("Please input the column number: ");
                    int col = sc.nextInt();
                    isitBook = goldCinema.BookSeat(row,col);
                    /*if(isitBook == true){
                        int row_col = (row*10) + col;
                        String
                    }*/
                }while(isitBook == false);
                

                System.out.println("Select ticket type:");
                book.printMenu();
                String age = null;
                int ageChoice = sc.nextInt();
                if(ageChoice == 1){
                    age = "Adult";
                }
                else if(ageChoice == 2){
                    age = "Senior Citizen";
                }
                else if(ageChoice == 3){
                    age = "Students";
                }

                Booking goldBook = new Booking(newCinema.gettime(),newCinema.getCinemaCode(),newCinema.getmovieDay(),age);
                total = goldBook.calculatePayment() + total;
                System.out.println("Total Price: " + total);



            }


        }

        //User can select the quantity of tickets;
        



        


        //Instantiate an object to print all the things in bookingMenu
        /*


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
        }*/
        return 0;
    }
}
