package Bookings;
import MovieTheatres.*;
import ShowTime.showtime;
import dataDriver.CustomerCSVDriver;
import dataDriver.EnumDataFiles;
import java.util.*;
import UsrInput.UsrInput;


public class bookGold {

    private showtime newShowtime;
    private Gold goldCinema;
    private BookingMenu book;
    private CustomerCSVDriver driver;
    private String movieTitle;

    //constructor for bookGold

    /**
     *
     * @param newShowtime
     * @param goldCinema
     * @param book
     * @param driver
     * @param movieTitle
     */
    public bookGold(showtime newShowtime,Gold goldCinema,BookingMenu book,CustomerCSVDriver driver,String movieTitle){
        this.newShowtime = newShowtime;
        this.goldCinema = goldCinema;
        this.book = book;
        this.driver = driver;
        this.movieTitle = movieTitle;
    }


    /**
     *
     * @return
     */
    public double bookingGold(){
        UsrInput sc = new UsrInput();
        char classOfCinema = newShowtime.getCinema().getCinemaCode().charAt(0);
        String sClass = Character.toString(classOfCinema);

        int numOfTickets = sc.getUsrInt("Number of tickets to purchase: ");
        int row;
        int col;
        String seatType;
        boolean isitBook;
        //while less than numOfTickets, user can select the seat they want
        double total = 0;
        for(int i = 0; i<numOfTickets; i++){
            System.out.println("Ticket " + i+1);
            System.out.println("Selecting Seat.....");
            do{
                row = sc.getUsrInt("Input Row Number: ");
                col = sc.getUsrInt("Input Column Number: ");
                isitBook = goldCinema.BookSeat(row,col);
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
            if(row==3){
                seatType = "Elite";
            }
            else if(row == 4){
                seatType = "Platinum";
            }
            else if(row == 5){
                seatType = "Ultimate";
            }
            
            Booking goldBook = new Booking(timing,sClass,day,age,movieTitle);
            System.out.println("Movie Title: " + movieTitle);
            System.out.println("Price of each ticket: " + goldBook.calculatePayment(seatType));
            total = goldBook.calculatePayment(seatType) + total;

            }

            System.out.println("Total Payment: " + total);
            
            System.out.println("Booking is confirmed.");

            return total;
            


    }


    
}
