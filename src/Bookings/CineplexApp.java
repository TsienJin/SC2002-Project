package Bookings;
import UsrInput.UsrInput;

public class CineplexApp {

    public void Cineplex_Menu(){
        System.out.println("--Welcome to the Booking App--");
        System.out.println("Location of Cineplexes: ");
        System.out.println("1. Jurong Point");
        System.out.println("2. Paya Lebar");
        System.out.println("3. Bugis");
        System.out.println("4. Punggol");

    }

    public void Cineplex_app(){
        UsrInput usrInput = new UsrInput();
        this.Cineplex_Menu();
        int usrChoice = usrInput.getUsrInt("Please choose the cineplex");

        switch(usrChoice){
            case 1:
                new BookingApp().bookingApp();
                break;
            case 2:
                new BookingApp().bookingApp();
                break;
            case 3:
                new BookingApp().bookingApp();
                break;
            case 4:
                new BookingApp().bookingApp();
                break;
        }

        
    }
    
}
