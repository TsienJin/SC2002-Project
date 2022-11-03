package Booking;
import UsrInput.UsrInput;
import dataDriver.CustomerCSVDriver;

public class historyApp {

    public void viewHistory(){
        System.out.println("View Booking History: ");
        System.out.println("1. Search by Mobile Number");
        System.out.println("2. Search by Email Address");
        System.out.println("3. Exit");

        UsrInput sc = new UsrInput();
        int choice = sc.getUsrInt("Choice: ");

        CustomerCSVDriver driver = new CustomerCSVDriver();

        switch(choice){
            case 1:
                System.out.println("Enter your mobile number: ");
                String mobileNum = sc.getUsrString("Mobile Number: ");
                driver.listHistory(mobileNum);
                break;

            case 2:
                System.out.println("Enter your email address: ");
                String email = sc.getUsrString("Email Address: ");
                driver.listHistory(email);
                break;
            case 3:
                System.out.println("Exiting...");
                break;
        }

    }


    
}
