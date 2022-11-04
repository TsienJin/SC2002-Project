package Menu;

import java.util.ArrayList;

public class StaffMenu extends Menu {

    @Override
    public void printMainMenu(){
        String header = "Staff Menu: ";
        ArrayList<String> options = new ArrayList<>();
        options.add("Print this menu");
        options.add("Create Movie Listing");
        options.add("Show all Movie Listing");
        options.add("Show top 5 Movie Listing by Rating");
        options.add("Show top 5 Movie Listing by Sales");
        options.add("Update Movie Listing");
        options.add("Delete Movie Listing");
        options.add("Create Showtime");
        options.add("Show all Showtimes");
        options.add("Show all upcoming Showtimes");
        options.add("Update Showtime");
        options.add("Delete Showtime");
        options.add("Configure System Settings");
        options.add("Quit");

        menuPrinter(header, options);
    }



    public void printConfigMenu(){
        String header = "System Configuration: ";
        ArrayList<String> options = new ArrayList<>();
        options.add("Print this menu");
        options.add("Change password");
        options.add("Change username");
        options.add("Create new user");
        options.add("Change ranking of movies");
        options.add("Back");

        menuPrinter(header, options);
    }

    public void printMovieRankingMenu(){
        String header = "Movie Ranking Sorting: ";
        ArrayList<String> options = new ArrayList<>();
        options.add("Tickets Sold");
        options.add("Rating");
        options.add("Enable Customer Sorting Choice");
        options.add("Disable Customer Sorting Choice");
        options.add("Back");

        menuPrinter(header, options);
    }

        
}
