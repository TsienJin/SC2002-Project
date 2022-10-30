package OutputPrinter;

import java.util.ArrayList;

public class OutputPrinterFormatter implements InterfaceOutputPrinterFormatter {
    

    public String Header(String header){
        return(inTitle+header+clrFormat);
    }

    public String Subheader(String subheader){
        return(tab+inBold+subheader+clrFormat);
    }

    public String SubheaderUnderline(String subheader){
        return(tab+inBoldUnder+subheader+clrFormat);
    }

    public String Body(String bodyLine){
        return(tab+bodyLine);
    }

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
    
}