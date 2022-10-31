package Movie;

public enum EnumMovieType implements InterfaceNiceEnumString<EnumMovieType> {
    Undefined("Undefined"),
    Blockbuster("Blockbuster"),
    ThreeD("3D"),
    Indie("Indie"),
    IMax("IMax"),
    ;
    String prettyName;

    private EnumMovieType(String prettyName){
        this.prettyName = prettyName;
    }

    private EnumMovieType(){
        this.prettyName = name();
    }

    public String niceString(){
        return this.prettyName;
    }
}
