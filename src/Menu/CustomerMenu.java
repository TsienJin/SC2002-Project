package Menu;

public class CustomerMenu implements MenuInterface{
    public void printMainMenu(){
        System.out.print("\nCustomer Menu:\n"
                        + "01) List Movies\n"
                        + "02) Search Movies\n"
                        + "03) View Movie Details\n"
                        + "04) Book ticket\n"
                        + "05) View Booking History\n"
                        + "06) List Top 5 Rankings\n"
                        + "07) Quit\n");
    }
}