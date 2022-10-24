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

    private UsrInput usrInput = new UsrInput();
    public static void main(String args[]){
        App myApp = new App();
        myApp.testing();




    }


    public void testing(){
         MainMenu menu = new CustomerMenu();
         menu.printMainMenu();
         menu = new StaffMenu();
         menu.printMainMenu();
    }
}