package dataDriver;

public interface InterfaceToCsvStringHelper {
    final String mainDelimiter = ",";
    final String subDelimiter = "|";

    public String toCsvString();
}
