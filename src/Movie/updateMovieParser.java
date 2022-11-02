package Movie;

import java.util.ArrayList;

import Menu.Menu;
import UsrInput.UsrInput;

public class updateMovieParser {
    
    private UsrInput input = new UsrInput();
    private Menu updateMovieMenu = new updateMovieMenu();
    private EnumMovieParser movieEnum = new EnumMovieParser();

    public void inputUpdateType(MovieBuilder updateMovie){
        updateMovieMenu.printMainMenu();
        int usrInput = 0;

        do{
            usrInput = input.getUsrInt("Enter choice: ");
            switch(usrInput){
                case 1:
                    updateMovie.setMovieTitle(input.getUsrString("Enter Movie Title: "));
                    break;                    
                case 2:
                    updateMovie.setStatus(movieEnum.inputShowingStatus());
                    break;
                case 3:
                    updateMovie.setMovieType(movieEnum.inputMovieType());
                    break;
                case 4:
                    updateMovie.setSynopsis(input.getUsrString("Enter Movie Synopsis: "));
                    break;
                case 5:
                    updateMovie.setDirector(input.getUsrString("Enter Movie Director: "));
                    break;
                case 6:
                    String castCsvString = input.getUsrString("Enter Movie Casts (seperate with comma): ");
                    ArrayList<String> cast = new ArrayList<>();
                    for (String person : castCsvString.split(",")) {
                        cast.add(person.strip());
                    }
                    updateMovie.setCast(cast);
                    break;
                default:
                    System.out.println("Invalid input!");
                    usrInput = 0;
                
            }
        } while (usrInput == 0);

        // return updateMovie;
    }
}
