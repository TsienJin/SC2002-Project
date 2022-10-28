package Menu;

import java.util.ArrayList;

public class StaffMenu extends MainMenu {

    @Override
    public void printMainMenu(){
        // System.out.print("\nStaff Menu:\n"
        //                 + "01) Create Movie Listing\n"
        //                 + "02) Update Movie Listing\n"
        //                 + "03) Delete Movie Listing\n"
        //                 + "04) Create Cinema Showtime\n"
        //                 + "05) Update Cinema Showtime\n"
        //                 + "06) Delete Cinema Showtime\n"
        //                 + "07) Configure System Settings\n"
        //                 + "08) Quit\n");

        String header = "Staff Menu:";
        ArrayList<String> options = new ArrayList<>();
        options.add("Create Movie Listing");
        options.add("Update Movie Listing");
        options.add("Delete Movie Listing");
        options.add("Create Showtime");
        options.add("Update Showtime");
        options.add("Delete Showtime");
        options.add("Configure System Settings");
        options.add("Quit");

        menuPrinter(header, options);


    }

        
}
