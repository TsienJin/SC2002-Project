package Menu;

public class StaffMenu implements MenuInterface{
    public void printMainMenu(){
        System.out.print("\nStaff Menu:\n"
                        + "01) Create Movie Listing\n"
                        + "02) Update Movie Listing\n"
                        + "03) Delete Movie Listing\n"
                        + "04) Create Cinema Showtime\n"
                        + "05) Update Cinema Showtime\n"
                        + "06) Delete Cinema Showtime\n"
                        + "07) Configure System Settings\n" //idk what is this :/
                        + "08) Quit\n");
    }
}