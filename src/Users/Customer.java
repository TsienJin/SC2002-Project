package Users;

import Bookings.CineplexApp;
import Bookings.historyApp;
import Menu.CustomerMenu;
import Movie.Movie;
import dataDriver.CustomerCSVDriver;

public class Customer extends User {
    
    /** Constructor
     * 
     */
    public Customer(){
        super.menu = new CustomerMenu();
        super.dataDriver = new CustomerCSVDriver();
    }

    /** Private method to print movies from regex
     * 
     */
    private void searchMovieRegex(){
        String rgx = input.getUsrString("Enter regex or string: ");
        super.dataDriver.listMovieFromRegex(rgx);
    }


    /** private method to print movies matched by ID
     * 
     */
    private void searchMovieID(){
        String movieID = input.getUsrString("Enter movie ID: ");
        Movie movie = ((CustomerCSVDriver) super.dataDriver).getMovie(movieID);
        if(movie != null){
            System.out.println(movie.toString());
            System.out.println(super.formatter.Header("Reviews")+"\n");
            movie.printReviews();
            System.out.println(formatter.Header("Upcoming Show Times")+"\n");
            this.dataDriver.listShowtimeFromMovieId(movie.getID());
            // need to print all showtimes for this movie too
        } else {
            System.out.println("Movie not found!");
        }
    }




    /** Main runtime for Customer Object
     * 
     */
    @Override
    public void run(){
        
        super.menu.printMainMenu();
        int usrChoice = 0;
        do{
            usrChoice = super.getUsrChoice();
            switch(usrChoice){
                case 1:
                    super.menu.printMainMenu();
                    break;
                case 2:
                    // movie menu
                    this.movieViewer();
                    super.menu.printMainMenu();
                    break;
                case 3:
                    // show upcoming showtimes
                    this.dataDriver.listAllUpcomingShowtimes();
                    break;
                case 4:
                    // book ticket
                    new CineplexApp().Cineplex_app();
                    break;
                case 5:
                    // view booking history
                    new historyApp().viewHistory();
                    break;
                case 6:
                    // write review
                    ((CustomerCSVDriver) super.dataDriver).writeReview();
                    break;
                case 7:
                    // quit
                    System.out.println("Goodbye!");
                    break;
                default:
                    usrChoice = 0;
                    System.out.println("Invalid input! Select option 1 to print menu again.");
                    break;
            }
        } while (usrChoice != 7);

    }


    /** Method to determine suitable submenu for movieViewer
     * 
     */
    private void movieViewer(){
        if(super.dataDriver.isCustomerRestricted()){
            this.restrictedMovieViewer();
        } else {
            this.unrestrictedMovieViewer();
        }
    }


    /** Handles user choice for Unrestricted Movie Viewer
     * 
     */
    private void unrestrictedMovieViewer(){
        ((CustomerMenu) super.menu).printUnrestrictedMovieMenu();
        int usrChoice = 0;
        do {
            usrChoice = super.input.getUsrInt("Enter choice: ");
            switch (usrChoice) {
                case 1:
                    // print menu
                    ((CustomerMenu) super.menu).printUnrestrictedMovieMenu();
                    break;
                case 2:
                    // top 5 by sales
                    super.dataDriver.listTopMoviesBySales();
                    break;
                case 3:
                    // top 5 by rating
                    super.dataDriver.listTopMoviesByRating();
                    break;
                case 4:
                    // all movies
                    super.dataDriver.listAllMovies();
                    break;
                case 5:
                    // search for movie
                    this.searchMovieRegex();
                    break;
                case 6:
                    // view movie details
                    this.searchMovieID();
                    break;
                case 7:
                    // back
                    break;
                default:
                    System.out.println("Invalid input!");
                    usrChoice = 0;
                    break;
            }
        } while (usrChoice !=7);
    }


    /** Handles user input for Restricted Movie Viewer
     * 
     */
    private void restrictedMovieViewer(){
        ((CustomerMenu) super.menu).printRestrictedMovieMenu();
        int usrChoice = 0;
        do {
            usrChoice = super.input.getUsrInt("Enter choice: ");
            switch (usrChoice) {
                case 1:
                    // print menu
                    ((CustomerMenu) super.menu).printRestrictedMovieMenu();
                    break;
                case 2:
                    // top 5 movies by sys config
                    super.dataDriver.listTop5Movies();
                    break;
                case 3:
                    // all movies
                    super.dataDriver.listAllMovies();
                    break;
                case 4:
                    // search for movie
                    this.searchMovieRegex();
                    break;
                case 5:
                    // view movie details
                    this.searchMovieID();
                    break;
                case 6:
                    // back
                    usrChoice = 6;
                    break;
                default:
                    System.out.println("Invalid input!");
                    usrChoice = 0;
                    break;
            }
        } while (usrChoice !=6);
    }

}