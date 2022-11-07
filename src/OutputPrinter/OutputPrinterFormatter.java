package OutputPrinter;

import java.util.ArrayList;

public class OutputPrinterFormatter implements InterfaceOutputPrinterFormatter {
    
    /** Formats text as header
     * @param header
     * @return String
     */
    public String Header(String header){
        return(inTitle+header+clrFormat);
    }

    
    /** Formats text as subheader
     * @param subheader
     * @return String
     */
    public String Subheader(String subheader){
        return(tab+inBold+subheader+clrFormat);
    }

    
    /** Formats text as subheader with underline
     * @param subheader
     * @return String
     */
    public String SubheaderUnderline(String subheader){
        return(tab+inBoldUnder+subheader+clrFormat);
    }

    
    /** Formats text as body
     * @param bodyLine
     * @return String
     */
    public String Body(String bodyLine){
        return(tab+wrapString(bodyLine, nLine+tab, textWrap));
    }

    
    /** Formats ArrayList as CSV
     * @param items
     * @return String
     */
    public String ArrayToCSV(ArrayList<String> items){
        StringBuilder strBuilder = new StringBuilder();
        String prefix = "";
        for(String item : items){
            strBuilder.append(prefix);
            strBuilder.append(item);
            prefix = ", ";
        }

        return strBuilder.toString();

    }

    
    /** Formats longs string to wrapped text 
     * @param s
     * @param deliminator
     * @param length
     * @return String
     */
    public String wrapString(String s, String deliminator, int length) {
        String result = "";
        int lastdelimPos = 0;
        for (String token : s.split(" ", -1)) {
            if (result.length() - lastdelimPos + token.length() > length) {
                result = result + deliminator + token;
                lastdelimPos = result.length() + 1;
            }
            else {
                result += (result.isEmpty() ? "" : " ") + token;
            }
        }
        return result;
    }
    
}
