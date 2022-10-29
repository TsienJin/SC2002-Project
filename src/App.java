import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import Menu.CustomerMenu;
import Menu.MainMenu;
import Menu.Menu;
import Menu.StaffMenu;
import Movie.EnumMovieType;
import Movie.EnumShowingStatus;
import Movie.Movie;
import Movie.MovieBuilder;
import Movie.Review;
import Movie.ReviewBuilder;
import UsrInput.UsrInput;
import dataDriver.EnumDataFiles;
import dataDriver.FileIO;


public class App{
    UsrInput usrInput = new UsrInput();

    public static void main(String args[]){
        App myApp = new App();

        User usr = myApp.determineUsrType();
        usr.run();

        // myApp.testing();



    }

    public User determineUsrType(){
        Menu thisMenu = new MainMenu();
        thisMenu.printMainMenu();

        User usrObj = null;

        int usrChoice = 0;
        do {
            usrChoice = usrInput.getUsrInt("User type: ");
            switch(usrChoice){
                case 1:
                    usrObj = new Staff();
                    break;
                case 2:
                    usrObj = new Customer();
                    break;
                default:
                    System.out.println("Invalid input!");
                    usrChoice = 0;
            }

        } while (usrChoice == 0);

        return usrObj;
    }


    public void testing(){
        FileIO fileobj = new FileIO();
        System.out.println(fileobj.findMatchFromFile(EnumDataFiles.Movie.toString(), "2958305"));
        MovieBuilder bldr = new MovieBuilder(fileobj.findMatchFromFile(EnumDataFiles.Movie.toString(), "2958305"));
        Movie mv = bldr.build();
        System.out.println(mv.getDirector());

    }
}