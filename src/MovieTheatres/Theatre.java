package MovieTheatres;

/**
 * Theatre class is a superclass to First, Gold and Regular
 */
public class Theatre {

    private int size;
    private int[][] layout = new int[size][size];
    private String bookedSeat;

    /**
     * Default constructor 
     */
    public Theatre(){
        

        
    }

    /*public void initialLayout(){
        if(this.bookedSeat.equals("null")){
            for(int i = 0; i<size ;i++){
                for(int j = 0; j<size ; j++){
                    layout[i][j] = 0;
                }
            }
        }
        else{
            int length = bookedSeat.length();
            for(int i = 0; i < length; i=i+3){
                int row = (bookedSeat.charAt(i))-'0';
                int col = (bookedSeat.charAt(i+1))-'0';
                layout[row][col] = 1;
            }

        }  
    }

    public void printInitialLayout(){
        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++){
                System.out.print(layout[i][j]);
            }
            System.out.println("\n");
        }
    }*/




    
}
