package Movie;

import java.util.ArrayList;
import java.util.Arrays;

import Menu.Menu;

public class EnumShowingStatusMenu extends Menu {

    @Override
    public void printMainMenu() {
        ArrayList<String> options = new ArrayList<>();
        ArrayList<EnumShowingStatus> names = new ArrayList<>(Arrays.asList(EnumShowingStatus.values()));

        names.forEach(name -> {
            options.add(name.niceString());
        });

        super.menuPrinter("Showing Status: ", options);
    }
    
}
