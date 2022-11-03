package Menu;

import java.util.ArrayList;

public class MainMenu extends Menu {

    @Override
    public void printMainMenu() {
        Banner banner = new Banner();
        banner.printBanner();
        ArrayList<String> options = new ArrayList<>();
        options.add("Staff");
        options.add("Customer");

        menuPrinter("Select user type:", options);
    }
    
}
