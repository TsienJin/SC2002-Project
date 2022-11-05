package Bookings;

public class Booking {
    private String movieTiming; //Will tell us if is non-peak or peak hour
    private String cinemaCode; //Will tell us the class of the cinema
    private String movieDay;  //Will tell us if is weekend or weekday
    private String age;  //tell us if is senior,students or adults.
    private String movieType; //Tell us the type of movie - different type, different price

    private String[] type = {"Senior Citizen","Students","Non-Peak : Weekday","Peak : Weekday","Weekend"};
    private double[][] Regprice = { //Table of price for the different type of ticket prices
            {10,12,14},
            {10,12,14},
            {12,14,16},
            {14,16,18},
            {16,18,20}
    };
    private double[][] Bprice = {
            {12,14,16},
            {12,14,16},
            {14,16,18},
            {16,18,20},
            {18,20,22}
    };
    private double[][] Sprice = {
        {14,16,18},
        {14,16,18},
        {16,18,20},
        {18,20,22},
        {20,22,24}
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
      public Booking(String movieTiming,String cinemaCode,String movieDay, String age,String movieType){
        this.movieTiming = movieTiming;
        this.cinemaCode = cinemaCode;
        this.movieDay = movieDay;
        this.age = age;
        this.movieType = movieType;
    }


    /**
     *
     * @return
     */
    public double calculatePayment(){
        if(movieType.equals("Indie") || movieType.equals("Undefined")){

        switch(cinemaCode){
            case "R":
                
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

                break;
            case "F":
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
                break;
            case "G":
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

                break;
        }

    }


    else if(movieType.equals("Blockbuster")){
        switch(cinemaCode){
            case "R":
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

                break;
            case "F":
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
                break;
            case "G":
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

                break;
        }

    }

    else if(movieType.equals("3D") || movieType.equals("IMax")){
        switch(cinemaCode){
            case "R":
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

                break;
            case "F":
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
                break;
            case "G":
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

                break;
        }

    }

    return 0;

}

}







