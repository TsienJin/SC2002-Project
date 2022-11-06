package ShowTime;

import java.util.ArrayList;

import Menu.Menu;

public class updateShowtimeMenu extends Menu {

    @Override
    
    /** 
     * Adds array of Showtime Attributes name
     * parse array into `menuPrinter()`
     */
    public void printMainMenu() {
        ArrayList<String> options = new ArrayList<>();

        options.add("MovieID");
        options.add("CinemaCode");
        options.add("Time");

        super.menuPrinter("Column to Edit: ", options);
    }
    
}
