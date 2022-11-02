package Movie;

import java.util.ArrayList;

import Menu.Menu;

public class updateMovieMenu extends Menu {

    @Override
    public void printMainMenu() {
        ArrayList<String> options = new ArrayList<>();

        options.add("Movie Title");
        options.add("Showing Status");
        options.add("Movie Type");
        options.add("Synopsis");
        options.add("Director");
        options.add("Cast");

        super.menuPrinter("Column to Edit: ", options);
    }
    
}
