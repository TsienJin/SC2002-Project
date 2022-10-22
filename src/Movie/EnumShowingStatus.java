package Movie;

public enum EnumShowingStatus implements InterfaceNiceEnumString{
    Undefined("Undefined"),
    Coming_Soon("Coming Soon"),
    Preview("Preview"),
    Now_Showing("Now Showing"),
    Not_Showing("Not Showing"),
    ;
    String prettyName;

    private EnumShowingStatus(String prettyName){
        this.prettyName = prettyName;
    }

    private EnumShowingStatus(){
        this.prettyName = name();
    }

    public String niceString(){
        return this.prettyName;
    }
}
