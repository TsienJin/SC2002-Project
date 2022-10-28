package Menu;

import java.util.ArrayList;


/** Abstract class for all menu objects
 * contains helper methods and defines the entry point
 * 
 * @author Tsien Jin
 */
public abstract class Menu {

    public abstract void printMainMenu();

    /** Prints out menu from an array of options with a given menu header.
     * @param menuHeader
     * @param menuOptions
     */
    protected void menuPrinter(String menuHeader, ArrayList<String> menuOptions){
        System.out.println(menuHeader);
        for(int i=0; i<menuOptions.size(); i++){
            System.out.println(String.format("%d) %s", i+1, menuOptions.get(i)));
        }
    }

    
    /** Prints out menu from an array of options.
     * @param menuOptions
     */
    protected void menuPrinter(ArrayList<String> menuOptions){
        this.menuPrinter("Options:", menuOptions);
    }
}
