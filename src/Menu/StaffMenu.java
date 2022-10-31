package Menu;

import java.util.ArrayList;

public class StaffMenu extends Menu {

    @Override
    public void printMainMenu(){
        String header = "Staff Menu:";
        ArrayList<String> options = new ArrayList<>();
        options.add("Print this menu");
        options.add("Create Movie Listing");
        options.add("Show all Movie Listing");
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

        
}
