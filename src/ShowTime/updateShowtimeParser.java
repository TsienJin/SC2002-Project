package ShowTime;

import Menu.Menu;
import UsrInput.UsrInput;

public class updateShowtimeParser {
    
    private UsrInput input = new UsrInput();
    private Menu updateShowtimeMenu = new updateShowtimeMenu();

    public void inputUpdateType(ShowtimeBuilder updateShowtime){
        updateShowtimeMenu.printMainMenu();
        int usrInput = 0;

        do{
            usrInput = input.getUsrInt("Enter choice: ");
            switch(usrInput){
                case 1:
                    updateShowtime.setMovie(input.getUsrString("Enter Movie ID: "));
                    break;                    
                case 2:
                    updateShowtime.setCinema(input.getUsrString("Enter Cinema Code: "));
                    break;
                case 3:
                    updateShowtime.setTimeDate(input.getUsrString("Enter Time Date: "));
                    break;
                default:
                    System.out.println("Invalid input!");
                    usrInput = 0;
                
            }
        } while (usrInput == 0);

        // return updateShowtime;
    }
}
