package Bookings;

/**
 * Booking Class that stores the different ticket price
 * Calculates the price of each ticket under certain conditions
 * @author keenlim
 */
public class Booking {
    private String movieTiming; //Will tell us if is non-peak or peak hour
    private String cinemaCode; //Will tell us the class of the cinema
    private String movieDay;  //Will tell us if is weekend or weekday
    private String age;  //tell us if is senior,students or adults.
    private String movieType; //Tell us the type of movie - different type, different price
    private String date;


    private String[] type = {"Senior Citizen","Students","Non-Peak : Weekday","Peak : Weekday","Weekend"};
    private double[][] Regprice = {
        {10,12,14},
        {10,12,14},
        {12,14,16},
        {14,16,18},
        {16,18,20},
        {30,35,40},
        {25,30,35},
        {40,45,50}
};

private double[][] Bprice = {
    {12,14,16},
    {12,14,16},
    {14,16,18},
    {16,18,20},
    {18,20,22},
    {30,35,40},
    {25,30,35},
    {40,45,50}
};

private double[][] Sprice = {
    {14,16,18},
    {14,16,18},
    {16,18,20},
    {18,20,22},
    {20,22,24},
    {30,35,40},
    {25,30,35},
    {40,45,50}
};

    //Booking constructor

    /**
     * 
     * @param movieTiming
     * @param cinemaCode
     * @param movieDay
     * @param age
     * @param movieType
     */
      public Booking(String movieTiming,String cinemaCode,String movieDay, String age,String movieType,String date){
        this.movieTiming = movieTiming;
        this.cinemaCode = cinemaCode;
        this.movieDay = movieDay;
        this.age = age;
        this.movieType = movieType;
        this.date = date;
    }


    /**
     * A function that returns the price of ticket
     * It takes into consideration the movieType, different cinema class, movie Timing, movie Day,
     * and age group as well as the different types of seats 
     * There are different ticket prices for different conditions. 
     * E.g. Prices for weekdays are different for prices for weekends. 
     * E.g. Prices for adults, senior citizens and students are different 
     * @return double price of that ticket
     */
    public double calculatePayment(String seatType){

        if(movieType.equals("Indie") || movieType.equals("Undefined")){

        switch(cinemaCode){
            case "R":

                if(seatType.equals("Normal")){

                
                if(age==type[0]){
                    return Regprice[0][0];
                }
                if(age==type[1]){
                    return Regprice[1][0];
                }
                else{
                    if(movieDay.equals("Monday") || movieDay.equals("Tuesday") || movieDay.equals("Wednesday") || movieDay.equals("Thursday")){
                        if(movieTiming.compareTo("1800")<0){ //non-peak
                            return Regprice[2][0];
                        }
                        if(movieTiming.compareTo("1800")>=0){
                            return Regprice[3][0];
                        }
                    }

                    if(movieDay.equals("Friday") || movieDay.equals("Saturday") || movieDay.equals("Sunday")) {
                        return Regprice[4][0];
                    }
                }
            }

            else if(seatType.equals("Ultimate")){
                return Regprice[5][0];
            }

            else if(seatType.equals("Elite")){
                return Regprice[6][0];
            }
            else if(seatType.equals("Platinum")){
                return Regprice[7][0];
            }

                break;
            case "F":
                if(seatType.equals("Normal")){

                
                if(age==type[0]){
                    return Regprice[0][1];
                }
                if(age==type[1]){
                    return Regprice[1][1];
                }
                else{
                    if(movieDay.equals("Monday") || movieDay.equals("Tuesday") || movieDay.equals("Wednesday") || movieDay.equals("Thursday")){
                        if(movieTiming.compareTo("1800")<0){ //non-peak
                            return Regprice[2][1];
                        }
                        if(movieTiming.compareTo("1800")>=0){
                            return Regprice[3][1];
                        }
                    }

                    if(movieDay.equals("Friday") || movieDay.equals("Saturday") || movieDay.equals("Sunday")) {
                        return Regprice[4][1];
                    }
                }
            }
            else if(seatType.equals("Ultimate")){
                return Regprice[5][1];
            }

            else if(seatType.equals("Elite")){
                return Regprice[6][1];
            }
            else if(seatType.equals("Platinum")){
                return Regprice[7][1];
            }
                break;
            case "G":
                if(seatType.equals("Normal")){

                
                if(age==type[0]){
                    return Regprice[0][2];
                }
                if(age==type[1]){
                    return Regprice[1][2];
                }
                else{
                    if(movieDay.equals("Monday") || movieDay.equals("Tuesday") || movieDay.equals("Wednesday") || movieDay.equals("Thursday")){
                        if(movieTiming.compareTo("1800")<0){ //non-peak
                            return Regprice[2][2];
                        }
                        if(movieTiming.compareTo("1800")>=0){
                            return Regprice[3][2];
                        }
                    }

                    if(movieDay.equals("Friday") || movieDay.equals("Saturday") || movieDay.equals("Sunday")) {
                        return Regprice[4][2];
                    }
                }
            }
            else if(seatType.equals("Ultimate")){
                return Regprice[5][2];
            }

            else if(seatType.equals("Elite")){
                return Regprice[6][2];
            }
            else if(seatType.equals("Platinum")){
                return Regprice[7][2];
            }

                break;
        }

    }


    else if(movieType.equals("Blockbuster")){
        switch(cinemaCode){
            case "R":
                if(seatType.equals("Normal")){

                if(age==type[0]){
                    return Bprice[0][0];
                }
                if(age==type[1]){
                    return Bprice[1][0];
                }
                else{
                    if(movieDay.equals("Monday") || movieDay.equals("Tuesday") || movieDay.equals("Wednesday") || movieDay.equals("Thursday")){
                        if(movieTiming.compareTo("1800")<0){ //non-peak
                            return Bprice[2][0];
                        }
                        if(movieTiming.compareTo("1800")>=0){
                            return Bprice[3][0];
                        }
                    }

                    if(movieDay.equals("Friday") || movieDay.equals("Saturday") || movieDay.equals("Sunday")) {
                        return Bprice[4][0];
                    }
                }
            }
            else if(seatType.equals("Ultimate")){
                return Bprice[5][0];
            }

            else if(seatType.equals("Elite")){
                return Bprice[6][0];
            }
            else if(seatType.equals("Platinum")){
                return Bprice[7][0];
            }

                break;
            case "F":
                if(seatType.equals("Normal")){

                if(age==type[0]){
                    return Bprice[0][1];
                }
                if(age==type[1]){
                    return Bprice[1][1];
                }
                else{
                    if(movieDay.equals("Monday") || movieDay.equals("Tuesday") || movieDay.equals("Wednesday") || movieDay.equals("Thursday")){
                        if(movieTiming.compareTo("1800")<0){ //non-peak
                            return Bprice[2][1];
                        }
                        if(movieTiming.compareTo("1800")>=0){
                            return Bprice[3][1];
                        }
                    }

                    if(movieDay.equals("Friday") || movieDay.equals("Saturday") || movieDay.equals("Sunday")) {
                        return Bprice[4][1];
                    }
                }
            }

            else if(seatType.equals("Ultimate")){
                return Bprice[5][1];
            }

            else if(seatType.equals("Elite")){
                return Bprice[6][1];
            }
            else if(seatType.equals("Platinum")){
                return Bprice[7][1];
            }

                break;
            case "G":
                if(seatType.equals("Normal")){

                if(age==type[0]){
                    return Bprice[0][2];
                }
                if(age==type[1]){
                    return Bprice[1][2];
                }
                else{
                    if(movieDay.equals("Monday") || movieDay.equals("Tuesday") || movieDay.equals("Wednesday") || movieDay.equals("Thursday")){
                        if(movieTiming.compareTo("1800")<0){ //non-peak
                            return Bprice[2][2];
                        }
                        if(movieTiming.compareTo("1800")>=0){
                            return Bprice[3][2];
                        }
                    }

                    if(movieDay.equals("Friday") || movieDay.equals("Saturday") || movieDay.equals("Sunday")) {
                        return Bprice[4][2];
                    }
                }

            }

            else if(seatType.equals("Ultimate")){
                return Bprice[5][2];
            }

            else if(seatType.equals("Elite")){
                return Bprice[6][2];
            }
            else if(seatType.equals("Platinum")){
                return Bprice[7][2];
            }

                break;
        }

    }

    else if(movieType.equals("3D") || movieType.equals("IMax")){
        switch(cinemaCode){
            case "R":
            if(seatType.equals("Normal")){

                if(age==type[0]){
                    return Sprice[0][0];
                }
                if(age==type[1]){
                    return Sprice[1][0];
                }
                else{
                    if(movieDay.equals("Monday") || movieDay.equals("Tuesday") || movieDay.equals("Wednesday") || movieDay.equals("Thursday")){
                        if(movieTiming.compareTo("1800")<0){ //non-peak
                            return Sprice[2][0];
                        }
                        if(movieTiming.compareTo("1800")>=0){
                            return Sprice[3][0];
                        }
                    }

                    if(movieDay.equals("Friday") || movieDay.equals("Saturday") || movieDay.equals("Sunday")) {
                        return Sprice[4][0];
                    }
                }

            }

            else if(seatType.equals("Ultimate")){
                return Sprice[5][0];
            }

            else if(seatType.equals("Elite")){
                return Sprice[6][0];
            }
            else if(seatType.equals("Platinum")){
                return Sprice[7][0];
            }

                break;
            case "F":

                if(seatType.equals("Normal")){

                if(age==type[0]){
                    return Sprice[0][1];
                }
                if(age==type[1]){
                    return Sprice[1][1];
                }
                else{
                    if(movieDay.equals("Monday") || movieDay.equals("Tuesday") || movieDay.equals("Wednesday") || movieDay.equals("Thursday")){
                        if(movieTiming.compareTo("1800")<0){ //non-peak
                            return Sprice[2][1];
                        }
                        if(movieTiming.compareTo("1800")>=0){
                            return Sprice[3][1];
                        }
                    }

                    if(movieDay.equals("Friday") || movieDay.equals("Saturday") || movieDay.equals("Sunday")) {
                        return Sprice[4][1];
                    }
                }
            }
            else if(seatType.equals("Ultimate")){
                return Sprice[5][1];
            }

            else if(seatType.equals("Elite")){
                return Sprice[6][1];
            }
            else if(seatType.equals("Platinum")){
                return Sprice[7][1];
            }
                break;
            case "G":

                if(seatType.equals("Normal")){

                if(age==type[0]){
                    return Sprice[0][2];
                }
                if(age==type[1]){
                    return Sprice[1][2];
                }
                else{
                    if(movieDay.equals("Monday") || movieDay.equals("Tuesday") || movieDay.equals("Wednesday") || movieDay.equals("Thursday")){
                        if(movieTiming.compareTo("1800")<0){ //non-peak
                            return Sprice[2][2];
                        }
                        if(movieTiming.compareTo("1800")>=0){
                            return Sprice[3][2];
                        }
                    }

                    if(movieDay.equals("Friday") || movieDay.equals("Saturday") || movieDay.equals("Sunday")) {
                        return Sprice[4][2];
                    }
                }

            }
            else if(seatType.equals("Ultimate")){
                return Sprice[5][2];
            }

            else if(seatType.equals("Elite")){
                return Sprice[6][2];
            }
            else if(seatType.equals("Platinum")){
                return Sprice[7][2];
            }

                break;
        }

    }



    return 0;

}

}







