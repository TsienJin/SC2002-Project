package Menu;

import java.util.ArrayList;

public abstract class Menu {

    public abstract void printMainMenu();

    public void menuPrinter(String menuHeader, ArrayList<String> menuOptions){
        System.out.println(menuHeader);
        for(int i=0; i<menuOptions.size(); i++){
            System.out.println(String.format("%d) %s", i+1, menuOptions.get(i)));
        }
    }
}
