package Menu;

import java.util.ArrayList;

public class CustomerMenu extends MainMenu {

    @Override
    public void printMainMenu(){
        // System.out.print("\nCustomer Menu:\n"
        //                 + "01) List Movies\n"
        //                 + "02) Search Movies\n"
        //                 + "03) View Movie Details\n"
        //                 + "04) Book ticket\n"
        //                 + "05) View Booking History\n"
        //                 + "06) List Top 5 Rankings\n"
        //                 + "07) Quit\n");

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

