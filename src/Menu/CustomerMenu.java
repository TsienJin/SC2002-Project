package Menu;

import java.util.ArrayList;

public class CustomerMenu extends Menu {

    /** Main running menu
     * 
     */
    @Override
    public void printMainMenu(){
        String header = "Customer Menu:";
        ArrayList<String> options = new ArrayList<>();
        options.add("Print this menu");
        options.add("Movie Menu");
        options.add("Show Upcoming Showtimes");
        options.add("Book Ticket");
        options.add("View Booking History");
        options.add("Write review");
        options.add("Quit");

        menuPrinter(header, options);
    }

    /** Submenu for Unrestricted customer sorting
     * 
     */
    public void printUnrestrictedMovieMenu(){
        String header = "Movie Menu";
        ArrayList<String> options = new ArrayList<>();
        options.add("Print this menu");
        options.add("Top 5 Movies by Ticket Sales");
        options.add("Top 5 Movies by Rating");
        options.add("View All Movies");
        options.add("Search for Movie");
        options.add("View Movie Details");
        options.add("Back");

        menuPrinter(header, options);
    }

    /** Submenu for Restricted customer sorting
     * 
     */
    public void printRestrictedMovieMenu(){
        String header = "Movie Menu";
        ArrayList<String> options = new ArrayList<>();
        options.add("Print this menu");
        options.add("Top 5 Movies");
        options.add("View All Movies");
        options.add("Search for Movie");
        options.add("View Movie Details");
        options.add("Back");

        menuPrinter(header, options);
    }
}

