package dataDriver;

import Movie.InterfaceNiceEnumString;

public enum EnumDataFiles implements InterfaceNiceEnumString<EnumDataFiles> {
    Movie("movie.csv"),
    Review("review.csv"),
    Test("test.csv"),
    StaffUser("staffUser.csv"),
    Showtime("showtime.csv"),
    Cinema("cinema.csv"),
    bookingHistory("bookingHistory.csv"),
    Config("config.properties"),
    ;
    String prettyName;

    /** Private constructor for setting file name
     * 
     * @param prettyName
     */
    private EnumDataFiles(String prettyName){
        this.prettyName = prettyName;
    }

    /** Get actual file name
     * 
     */
    @Override
    public String niceString() {
        return this.prettyName;
    }

    /** Get actual file name
     * 
     */
    @Override
    public String toString(){
        return this.prettyName;
    }


}
