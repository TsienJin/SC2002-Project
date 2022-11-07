package Movie;

import java.util.ArrayList;
import java.util.Arrays;

import Menu.Menu;

/** Menu object to print the different MovieTypes
 * 
 */
public class EnumMovieTypeMenu extends Menu {

    /** Method to print menu of movie types
     * 
     */
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
