package Booking;

public class Booking {
    private String movieTiming; //Will tell us if is non-peak or peak hour
    private String cinemaCode; //Will tell us the class of the cinema
    private String movieDay;  //Will tell us if is weekend or weekday
    private String age;  //tell us if is senior,students or adults.

    private String[] type = {"Senior Citizen","Students","Non-Peak : Weekday","Peak : Weekday","Weekend"};
    private double[][] price = { //Table of price for the different type of ticket prices
            {10,12,14},
            {10,12,14},
            {12,14,16},
            {14,16,18},
            {16,18,20}
    };


    //Booking constructor
    public Booking(String movieTiming,String cinemaCode,String movieDay, String age){
        this.movieTiming = movieTiming;
        this.cinemaCode = cinemaCode;
        this.movieDay = movieDay;
        this.age = age;
    }

    public double calculatePayment(){
        switch(cinemaCode){
            case "R":
                if(age==type[0]){
                    return price[0][0];
                }
                if(age==type[1]){
                    return price[1][0];
                }
                else{
                    if(movieDay=="Monday" || movieDay == "Tuesday" || movieDay == "Wednesday" || movieDay == "Thursday"){
                        if(movieTiming.compareTo("1800")<0){ //non-peak
                            return price[2][0];
                        }
                        if(movieTiming.compareTo("1800")>=0){
                            return price[3][0];
                        }
                    }

                    if(movieDay=="Friday" || movieDay == "Saturday" || movieDay=="Sunday"){
                        return price[4][0];
                    }

                }

                break;
            case "F":
                if(age==type[0]){
                    return price[0][1];
                }
                if(age==type[1]){
                    return price[1][1];
                }
                else{
                    if(movieDay=="Monday" || movieDay == "Tuesday" || movieDay == "Wednesday" || movieDay == "Thursday"){
                        if(movieTiming.compareTo("1800")<0){ //non-peak
                            return price[2][1];
                        }
                        if(movieTiming.compareTo("1800")>=0){
                            return price[3][1];
                        }
                    }

                    if(movieDay=="Friday" || movieDay == "Saturday" || movieDay=="Sunday"){
                        return price[4][1];
                    }
                }

                break;
            case "G":
                if(age==type[0]){
                    return price[0][2];
                }
                if(age==type[1]){
                    return price[1][2];
                }
                else{
                    if(movieDay=="Monday" || movieDay == "Tuesday" || movieDay == "Wednesday" || movieDay == "Thursday"){
                        if(movieTiming.compareTo("1800")<0){ //non-peak
                            return price[2][2];
                        }
                        if(movieTiming.compareTo("1800")>=0){
                            return price[3][2];
                        }
                    }

                    if(movieDay=="Friday" || movieDay == "Saturday" || movieDay=="Sunday") {
                        return price[4][2];
                    }
                }

                break;
        }

        return 0;
    }

}
