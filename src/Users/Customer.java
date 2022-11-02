package Users;

import Menu.CustomerMenu;
import Movie.Movie;
import dataDriver.CustomerCSVDriver;

public class Customer extends User {
    
    public Customer(){
        super.menu = new CustomerMenu();
        super.dataDriver = new CustomerCSVDriver();
    }

    @Override
    public void run(){
        super.menu.printMainMenu();
        int usrChoice = 0;
        do{
            usrChoice = super.getUsrChoice();
            switch(usrChoice){
                case 1:
                    super.menu.printMainMenu();
                    break;
                case 2:
                    // list all movies
                    super.dataDriver.listAllMovies();
                    break;
                case 3:
                    // list top 5 movies by sales
                    break;
                case 4:
                    // list top 5 movies by ratings
                    break;
                case 5:
                    // search movie
                    String rgx = input.getUsrString("Enter regex or string: ");
                    super.dataDriver.listMovieFromRegex(rgx);
                    break;
                case 6:
                    // view movie details
                    String movieID = input.getUsrString("Enter movie ID: ");
                    Movie movie = ((CustomerCSVDriver) super.dataDriver).getMovie(movieID);
                    if(movie != null){
                        System.out.println(movie.toString());
                        // need to print all showtimes for this movie too
                    } else {
                        System.out.println("Movie not found!");
                    }
                    break;
                case 7:
                    // book ticket
                    break;
                case 8:
                    // view booking history
                    break;
                case 9:
                    // quit
                    System.out.println("Goodbye!");
                    break;
                default:
                    usrChoice = 0;
                    System.out.println("Invalid input! Select option 1 to print menu again.");
                    break;
            }
        } while (usrChoice != 9);

    }

}