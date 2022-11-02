package Booking;
import MovieTheatres.*;
import dataDriver.CustomerCSVDriver;
import dataDriver.EnumDataFiles;
import java.util.*;
import UsrInput.UsrInput;

public class bookFirst {

    private Cinema newCinema;
    private First firstCinema;
    private BookingMenu book;
    private CustomerCSVDriver driver;

    public bookFirst(Cinema newCinema, First firstCinema, BookingMenu book, CustomerCSVDriver driver){
        this.newCinema = newCinema;
        this.firstCinema = firstCinema;
        this.book = book;
        this.driver = driver;

    }

    public void bookingFirst(){
        UsrInput sc = new UsrInput();
        char classOfCinema = newCinema.getCinemaCode().charAt(0);
        String sClass = Character.toString(classOfCinema);
        
        System.out.println("How many tickets do you want to purchase?");
        int numOfTickets = sc.getUsrInt("Number of tickets: ");
        
        boolean isitBook;
        //while less than numOfTickets, user can select the seat they want
        double total = 0;
        for(int i = 0; i<numOfTickets; i++){
            System.out.println("Ticket " + i+1);
            System.out.println("Selecting Seat.....");
            do{
                System.out.println("Please input the row number: ");
                int row = sc.getUsrInt("Row number: ");
                System.out.println("Please input the column number: ");
                int col = sc.getUsrInt("Column number: ");
                isitBook = firstCinema.BookSeat(row,col);
                if(isitBook == true){
                    System.out.println("Updating bookseat...");
                    String Id = newCinema.getId();
                    int row_col = (row*10) + col;
                    String new_seat = newCinema.getBookedSeat() + " " + row_col;
                    newCinema.setBookedSeat(new_seat);
                    driver.updateBookedSeats(EnumDataFiles.Cinema.toString(),newCinema.toCsvString() );
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
            System.out.println("Day: " + newCinema.getmovieDay());
            String day = newCinema.getmovieDay();
            System.out.println("Time: " + newCinema.gettime().substring(4,8));
            String timing = newCinema.gettime().substring(4,8);
            
            
            Booking firstBook = new Booking(timing,sClass,day,age);
            System.out.println("Price of each ticket: " + firstBook.calculatePayment());
            total = firstBook.calculatePayment() + total;
        }

        System.out.println("Total Payment: " + total);
        System.out.println("Booking is confirmed.");
    }
    
}
