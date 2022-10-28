import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import Menu.CustomerMenu;
import Menu.MainMenu;
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

        MainMenu menu = myApp.determineUsrMenu();
        menu.printMainMenu();





    }

    public MainMenu determineUsrMenu(){
        MainMenu thisMenu = new MainMenu();
        thisMenu.printMainMenu();

        int usrChoice = 0;
        do {
            usrChoice = usrInput.getUsrInt("User type: ");
            switch(usrChoice){
                case 1:
                    thisMenu = new CustomerMenu();
                    break;
                case 2:
                    thisMenu = new StaffMenu();
                    break;
                default:
                    System.out.println("Invalid input!");
                    usrChoice = 0;
            }

        } while (usrChoice == 0);

        return thisMenu;
    }


    public void testing(){
         MainMenu menu = new CustomerMenu();
         menu.printMainMenu();
         menu = new StaffMenu();
         menu.printMainMenu();
    }
}