package Movie;


public enum EnumShowingStatus implements InterfaceNiceEnumString<EnumShowingStatus>{
    Undefined("Undefined"),
    Coming_Soon("Coming Soon"),
    Preview("Preview"),
    Now_Showing("Now Showing"),
    Not_Showing("Not Showing"),
    ;
    String prettyName;

    /** Constructor to set prettyName
     * 
     * @param prettyName
     */
    private EnumShowingStatus(String prettyName){
        this.prettyName = prettyName;
    }

    /** Default Constructor
     * 
     */
    private EnumShowingStatus(){
        this.prettyName = name();
    }

    /** Method to return prettyName 
     * 
     */
    @Override
    public String niceString(){
        return this.prettyName;
    }
}
