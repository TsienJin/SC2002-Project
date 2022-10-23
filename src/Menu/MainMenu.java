package Menu;

import java.util.ArrayList;

public class MainMenu implements MenuInterface {


    public void menuPrinter(String menuHeader, ArrayList<String> menuOptions){
        System.out.println(menuHeader);
        for(int i=0; i<menuOptions.size(); i++){
            System.out.println(String.format("%d) %s", i+1, menuOptions.get(i)));
        }
    }

    @Override
    public void printMainMenu() {

        ArrayList<String> options = new ArrayList<>();
        options.add("Staff");
        options.add("Customer");

        menuPrinter("Select user type:", options);
    }
    
}
