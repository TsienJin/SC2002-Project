package Menu;

import java.util.ArrayList;

public class CustomerMenu extends MainMenu {

    @Override
    public void printMainMenu(){
        String header = "Customer Menu:";
        ArrayList<String> options = new ArrayList<>();
        options.add("List Movies");
        options.add("List Top 5 Movies");
        options.add("Search Movies");
        options.add("View Movie Details");
        options.add("Book Ticket");
        options.add("View Booking History");
        options.add("Quit");

        menuPrinter(header, options);
    }
}

