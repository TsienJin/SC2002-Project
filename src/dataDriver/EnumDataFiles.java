package dataDriver;

import Movie.InterfaceNiceEnumString;

public enum EnumDataFiles implements InterfaceNiceEnumString{
    Movie("movie.csv"),
    Review("review.csv"),
    Test("test.csv"),
    StaffUser("staffUser.csv"),
    Showtime("showtime.csv"),
    Cinema("cinema.csv");
    ;
    String prettyName;

    private EnumDataFiles(String prettyName){
        this.prettyName = prettyName;
    }

    @Override
    public String niceString() {
        return this.prettyName;
    }

    @Override
    public String toString(){
        return this.prettyName;
    }
}
