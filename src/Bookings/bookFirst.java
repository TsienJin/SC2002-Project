package Bookings;
import MovieTheatres.*;
import ShowTime.showtime;
import dataDriver.CustomerCSVDriver;
import dataDriver.EnumDataFiles;
//import java.util.*;
import UsrInput.UsrInput;

/**
 * Class that settles booking for First Class movie theatres
 * @author keenlim
 */
public class bookFirst implements DifferentBooking {

    //Attributes of bookFirst
    private showtime newShowtime;
    private First firstCinema;
    private BookingMenu book;
    private CustomerCSVDriver driver;
    private String movieTitle;

    /**
     * Creates a new bookFirst using object from showtime,First,BookingMenu,CustomerCSVDriver
     * @param newShowtime
     * @param firstCinema
     * @param book
     * @param driver
     * @param movieTitle
     */
    public bookFirst(showtime newShowtime, First firstCinema, BookingMenu book, CustomerCSVDriver driver,String movieTitle){
        this.newShowtime = newShowtime;
        this.firstCinema = firstCinema;
        this.book = book;
        this.driver = driver;
        this.movieTitle = movieTitle;

    }

    /**
     * This is a simple booking method for First class movie theatre
     * Ask the user the number of tickets they want and from there, allowing user to select the seats
     * Then updates the seats that are being booked
     * Calculate the price of total tickets according to the conditions of tickets
     * @return double total price of ticket
     */

    public double booking(){
        UsrInput sc = new UsrInput();
        char classOfCinema = newShowtime.getCinema().getCinemaCode().charAt(0);
        String sClass = Character.toString(classOfCinema);
        
        int numOfTickets = sc.getUsrInt("Number of tickets to purchase: ");
        
        boolean isitBook;
        int row;
        int col;
        String seatType;
        //while less than numOfTickets, user can select the seat they want
        double total = 0;
        for(int i = 0; i<numOfTickets; i++){
            System.out.println("Ticket " + i+1);
            System.out.println("Selecting Seat.....");
            do{
                row = sc.getUsrInt("Input Row Number: ");
                while(row>=8){
                    System.out.println("Row does not exist.");
                    row = sc.getUsrInt("Input Row Number: ");
                }
                col = sc.getUsrInt("Input Column Number: ");
                while(col >= 8){
                    System.out.println("Column does not exist.");
                    col = sc.getUsrInt("Input Column Number: ");
                }
                isitBook = firstCinema.BookSeat(row,col);
                if(isitBook == true){
                    System.out.println("Updating bookseat...");
                    String Id = newShowtime.getCinema().getId();
                    int row_col = (row*10) + col;
                    String new_seat;
                    if(newShowtime.getBookedSeat().equals("null")){
                        if(row==0){
                            new_seat = "0" + row_col;
                        }
                        else{
                            new_seat = Integer.toString(row_col);
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
            System.out.println("Day: " + newShowtime.getmovieDay());
            String day = newShowtime.getmovieDay();
            System.out.println("Time: " + newShowtime.getTime_date().substring(4,8));
            String timing = newShowtime.getTime_date().substring(4,8);
            
            seatType = "Normal";
            if(row==5){
                seatType = "Elite";
            }
            else if(row == 6){
                seatType = "Platinum";
            }
            else if(row == 7){
                seatType = "Ultimate";
            }

            String date = newShowtime.getTime_date().substring(0,8);

            
            Booking firstBook = new Booking(timing,sClass,day,age,movieTitle,date);
            System.out.println("Movie Title: " + movieTitle);
            double holidayPrice = driver.findHoliday(date);
            if(holidayPrice > 0){
                System.out.println("Price of each ticket: " + holidayPrice);
                total = total + holidayPrice;
            }
            else{
                System.out.println("Price of each ticket: " + firstBook.calculatePayment(seatType));
                total = firstBook.calculatePayment(seatType) + total;
            }
            
        }

        System.out.println("Total Payment: " + total);
        System.out.println("Booking is confirmed.");

        return total;
    }
    
}

