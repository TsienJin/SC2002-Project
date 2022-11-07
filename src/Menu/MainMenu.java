package Menu;

import java.util.ArrayList;

public class MainMenu extends Menu {

    /** Prints menu for user selection
     * 
     */
    @Override
    public void printMainMenu() {
        Banner banner = new Banner();
        banner.printBanner();
        ArrayList<String> options = new ArrayList<>();
        options.add("Staff");
        options.add("Customer");
        options.add("Exit");

        menuPrinter("Select user type:", options);
    }
    
}
