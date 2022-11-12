package Holiday;
import UsrInput.UsrInput;
import dataDriver.StaffCSVDriver;

public class holidayApp {


    public void holidayapp(){
        StaffCSVDriver driver = new StaffCSVDriver();

        UsrInput input = new UsrInput();
   

    //Staff will first have to enter the name of holiday
    String nameOfhol = input.getUsrString("Enter the name of holiday: ");
    String dateOfhol = input.getUsrString("Enter the date of holiday in yyyymmdd: ");
    String ticketPrice = input.getUsrString("Enter the ticket price: ");

    holidayBuilder holidayBuild = new holidayBuilder();
    holidayBuild.setholidayName(nameOfhol);
    holidayBuild.setholidayDate(dateOfhol);
    holidayBuild.setticketPrice(ticketPrice);
    driver.createHoliday(holidayBuild);



    }
    



    
}
