package Bookings;
import MovieTheatres.*;
import ShowTime.showtime;
import dataDriver.CustomerCSVDriver;
import dataDriver.EnumDataFiles;
import java.util.*;
import UsrInput.UsrInput;

public class bookRegular {
    //private Cinema newCinema;
    private showtime newShowtime;
    private Regular regularCinema;
    private BookingMenu book;
    private CustomerCSVDriver driver;
    private String movieTitle;

    public bookRegular(showtime newShowtime, Regular regularCinema, BookingMenu book, CustomerCSVDriver driver,String movieTitle){
        this.newShowtime = newShowtime;
        this.regularCinema = regularCinema;
        this.book = book;
        this.driver = driver;
        this.movieTitle = movieTitle;
    }

    public double bookingRegular(){
        UsrInput sc = new UsrInput();
        char classOfCinema = newShowtime.getCinema().getCinemaCode().charAt(0);
        String sClass = Character.toString(classOfCinema);

        int numOfTickets = sc.getUsrInt("Number of tickets to purchase: ");
        
        boolean isitBook;
        //while less than numOfTickets, user can select the seat they want
        double total = 0;
        for(int i = 0; i<numOfTickets; i++){
            System.out.println("Ticket " + i+1);
            System.out.println("Selecting Seat.....");
            do{
                int row = sc.getUsrInt("Input Row Number: ");
                int col = sc.getUsrInt("Input Column Number: ");
                isitBook = regularCinema.BookSeat(row,col);
                if(isitBook == true){
                    System.out.println("Updating bookseat...");
                    String Id = newShowtime.getCinema().getId();
                    int row_col = (row*10) + col;
                    String new_seat;
                    if(newShowtime.getBookedSeat()==""){
                        if(row==0){
                            new_seat = newShowtime.getBookedSeat() + "0" + row_col;
                        }
                        else{
                            new_seat = newShowtime.getBookedSeat() + row_col;
                        }
                    }
                    else{
                        if(row==0){
                            new_seat = newShowtime.getBookedSeat() + " " + "0" + row_col;
                        }
                        else{
                            new_seat = newShowtime.getBookedSeat() + " " + row_col;
                        }
                    }
                    
                    newShowtime.setBookedSeat(new_seat);
                    driver.updateBookedSeats(EnumDataFiles.Showtime.toString(),newShowtime.toCsvString() );
                }
            }while(isitBook == false);
            
            book.printMenu();
            String age = null;
            int ageChoice = sc.getUsrInt("Choose: ");
            if(ageChoice == 1){
                age = "Adult";
            }
            else if(ageChoice == 2){
                age = "Senior Citizen";
            }
            else if(ageChoice == 3){
                age = "Students";
            }
            //System.out.println("Day: " + newCinema.getmovieDay());
            String day = newShowtime.getmovieDay();
            //System.out.println("Time: " + newCinema.gettime().substring(4,8));
            String timing = newShowtime.getTime_date().substring(4,8);
            
            
            Booking regularBook = new Booking(timing,sClass,day,age,movieTitle);
            System.out.println("Movie Title: " + movieTitle);
            System.out.println("Price of each ticket: " + regularBook.calculatePayment());
            total = regularBook.calculatePayment() + total;
    }

    System.out.println("Total ticket price: " + total);
    System.out.println("Booking is confirmed");

    return total;
    }
    
}
