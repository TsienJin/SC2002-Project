package Movie;

public enum EnumMovieType implements InterfaceNiceEnumString<EnumMovieType> {
    Undefined("Undefined"),
    Blockbuster("Blockbuster"),
    ThreeD("3D"),
    Indie("Indie"),
    IMax("IMax"),
    ;
    String prettyName;

    /** Own constructor to set prettyname
     * 
     * @param prettyName
     */
    private EnumMovieType(String prettyName){
        this.prettyName = prettyName;
    }

    /* Constructor
     * 
     */
    private EnumMovieType(){
        this.prettyName = name();
    }

    /** Method to get pretty name from enum
     * 
     */
    @Override
    public String niceString(){
        return this.prettyName;
    }
}
