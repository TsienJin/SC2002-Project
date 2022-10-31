package Movie;

import Menu.Menu;
import UsrInput.UsrInput;

public class EnumMovieParser {
    
    private UsrInput input = new UsrInput();
    private Menu movieTypeMenu = new EnumMovieTypeMenu();
    private Menu movieShowingMenu = new EnumShowingStatusMenu();

    public EnumMovieType inputMovieType(){
        movieTypeMenu.printMainMenu();
        int usrInput = 0;

        do{
            usrInput = input.getUsrInt("Enter choice: ");
            switch(usrInput){
                case 1:
                    return EnumMovieType.Undefined;
                case 2:
                    return EnumMovieType.Blockbuster;
                case 3:
                    return EnumMovieType.ThreeD;
                case 4:
                    return EnumMovieType.Indie;
                case 5:
                    return EnumMovieType.IMax;
                default:
                    System.out.println("Invalid input!");
                    usrInput = 0;
                
            }
        } while (usrInput == 0);
        
        return null;
    }


    public EnumShowingStatus inputShowingStatus(){
        movieShowingMenu.printMainMenu();
        int usrInput = 0;

        do{
            usrInput = input.getUsrInt("Enter choice: ");
            switch(usrInput){
                case 1:
                    return EnumShowingStatus.Undefined;
                case 2:
                    return EnumShowingStatus.Coming_Soon;
                case 3:
                    return EnumShowingStatus.Preview;
                case 4:
                    return EnumShowingStatus.Now_Showing;
                case 5:
                    return EnumShowingStatus.Not_Showing;
                default:
                    System.out.println("Invalid input!");
                    usrInput = 0;
                
            }
        } while (usrInput == 0);

        return null;
    }



}
