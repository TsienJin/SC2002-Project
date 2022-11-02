package Menu;

import java.util.ArrayList;

public class CustomerMenu extends Menu {

    @Override
    public void printMainMenu(){
        String header = "Customer Menu:";
        ArrayList<String> options = new ArrayList<>();
        options.add("Print this menu");
        options.add("List all Movies");
        options.add("List Top 5 Movies by sales");
        options.add("List Top 5 Movies by ratings");
        options.add("Search Movies");
        options.add("View Movie Details");
        options.add("Book Ticket");
        options.add("View Booking History");
        options.add("Write review");
        options.add("Quit");

        menuPrinter(header, options);
    }
}

