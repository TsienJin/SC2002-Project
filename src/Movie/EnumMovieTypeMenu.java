package Movie;

import java.util.ArrayList;
import java.util.Arrays;

import Menu.Menu;

public class EnumMovieTypeMenu extends Menu {

    @Override
    public void printMainMenu() {
        ArrayList<String> options = new ArrayList<>();
        ArrayList<EnumMovieType> names = new ArrayList<>(Arrays.asList(EnumMovieType.values()));

        names.forEach(name -> {
            options.add(name.niceString());
        });

        super.menuPrinter("Movie Type: ", options);
    }
    
}
