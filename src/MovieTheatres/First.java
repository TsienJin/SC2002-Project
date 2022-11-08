package MovieTheatres;

/**
 * Inherits from theatre class to show the booking layout and to book seats for First Class cinema
 * @author keenlim
 */
public class First implements Theatre  {
    private static final int size = 8;

    private int Empty = size*size;
    private int[][] layout = new int[size][size];
    private String bookedSeat;

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED_BACKGROUND= "\u001B[41m";
    private static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    private static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";

    //Constructor for regular class
    /**
     * Creates a new First object using the bookedSeat String from ShowTime csv file
     * Also, initialise all seats of cinema array to be empty initially
     * @param bookedSeat
     */
    public First(String bookedSeat){

    
        //Initialisation of first cinema array
        //So if the integer is 0 means the spot is not being booked yet (available)
        //Else if integer increments to 1, means the spot is being booked (not available)
        this.bookedSeat = bookedSeat;

        for(int i = 0; i<size ;i++){
            for(int j = 0; j<size ; j++){
                layout[i][j] = 0;
            }
        }
    }

    /**
     * Function that will traverse the bookedSeat string to check which seat is already booked
     * So in bookedSeat string: "00", means that seat at row 0, col 0 is already taken
     * If seat is booked then set the array to 1 while seat is not booked, set to 0 
     */
    public void initialLayout(){
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

    /**
     * Print initial layout of the cinema in 1 and 0. 
     */
    public void printInitialLayout(){
        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++){
                System.out.print(layout[i][j]);
            }
            System.out.println("\n");
        }
    }

    //showLayout() function: It will show the seat availability for the customers
    //'O' means available
    //'X' means not available

    /**
     * showLayout() will show the seat avaiability to the customer in the following format: 
     * 'O' means available
     * 'X' means seat not available 
     * Seats without background are regualr seats
     * Purple background: Elite seats
     * Blue background: Platinum seats
     * Red background: Ultimate seats
     * Traverse the 2D array of the layout of movie theatre and prints out accordingly 
     */
    public void showLayout(){
        System.out.println("Layout of Movie Theatre");
        for(int i = 0; i<size; i++){
            if(i==0){
                System.out.println("     0 1 2 3   ||    4 5 6 7");
            }
            for(int j = 0; j<size; j++){

                if(i==5){
                    if(j==3){
                        if(layout[i][j]==0){
                            System.out.print(ANSI_PURPLE_BACKGROUND + "O   ||    " + ANSI_RESET); //Seat is available
                        }
                        else if(layout[i][j]==1) {
                            System.out.print(ANSI_PURPLE_BACKGROUND + "X   ||    " + ANSI_RESET); //Seat is not available
                        }
                    }
                    else{
                        if(j==0){
                            System.out.print(ANSI_PURPLE_BACKGROUND + i + "    " + ANSI_RESET);
                        }
                        
                        if(layout[i][j]==0){
                            System.out.print(ANSI_PURPLE_BACKGROUND + "O " + ANSI_RESET); //Seat is available
                        }
                        else if(layout[i][j]==1) {
                            System.out.print(ANSI_PURPLE_BACKGROUND + "X " + ANSI_RESET); //Seat is not available
                        }
                    }

                } 

                else if(i==6){
                    if(j==3){
                        if(layout[i][j]==0){
                            System.out.print(ANSI_BLUE_BACKGROUND + "O   ||    " + ANSI_RESET); //Seat is available
                        }
                        else if(layout[i][j]==1) {
                            System.out.print(ANSI_BLUE_BACKGROUND + "X   ||    " + ANSI_RESET); //Seat is not available
                        }
                    }
                    else{
                        if(j==0){
                            System.out.print(ANSI_BLUE_BACKGROUND + i + "    " + ANSI_RESET);
                        }
                        
                        if(layout[i][j]==0){
                            System.out.print(ANSI_BLUE_BACKGROUND + "O " + ANSI_RESET); //Seat is available
                        }
                        else if(layout[i][j]==1) {
                            System.out.print(ANSI_BLUE_BACKGROUND + "X " + ANSI_RESET); //Seat is not available
                        }
                    }
                }

                else if(i==7){
                    if(j==3){
                        if(layout[i][j]==0){
                            System.out.print(ANSI_RED_BACKGROUND + "O   ||    " + ANSI_RESET); //Seat is available
                        }
                        else if(layout[i][j]==1) {
                            System.out.print(ANSI_RED_BACKGROUND + "X   ||    " + ANSI_RESET); //Seat is not available
                        }
                    }
                    else{
                        if(j==0){
                            System.out.print(ANSI_RED_BACKGROUND + i + "    " + ANSI_RESET);
                        }
                        
                        if(layout[i][j]==0){
                            System.out.print(ANSI_RED_BACKGROUND + "O " + ANSI_RESET); //Seat is available
                        }
                        else if(layout[i][j]==1) {
                            System.out.print(ANSI_RED_BACKGROUND + "X " + ANSI_RESET); //Seat is not available
                        }
                    }

                }

                else{
                    if(j==3){
                        if(layout[i][j]==0){
                            System.out.print("O   ||    "); //Seat is available
                        }
                        else if(layout[i][j]==1) {
                            System.out.print("X   ||    "); //Seat is not available
                        }
                    }
                    else{
                        if(j==0){
                            System.out.print(i + "    ");
                        }
                        
                        if(layout[i][j]==0){
                            System.out.print("O "); //Seat is available
                        }
                        else if(layout[i][j]==1) {
                            System.out.print("X "); //Seat is not available
                        }
                    }

                }
               
                
            }
            System.out.print("\n");
        }
        System.out.println("\n");
    }

    /**
     * BookSeat function will help to book the seat. 
     * If seat is already taken then will return false 
     * If seat is not taken then set the array to 1 and return true
     * @param row
     * @param col
     * @return true or false
     */
    public boolean BookSeat(int row, int col){
        if(layout[row][col]==0){
            layout[row][col]=1;
            Empty = Empty - 1;
            System.out.println("Seats is being booked");
            return true;
        }
        else{
            System.out.println("Seat has already been booked");
            return false;
        }
    }

    /**
     * Returns the total number of seats that is computed by size * size 
     * Since is a square layout
     * @return total seats
     */
    public int getTotalSeats(){
        return size*size;
    }

    /**
     * Returns the attribute Empty to find the total number of empty seats
     * @return Empty attribute
     */
    public int getNumEmptySeats(){
        return Empty;
    }

    /**
     * Returns boolean function
     * If all seats are already taken then return true
     * Else return false
     * @return true or false
     */
    public boolean isFullyBooked() {
        if(Empty == 0){
            //System.out.println("Sorry, Is fully booked");
            return true;
        }
        else{
            //System.out.println("Not fully booked");
            return false;
        }
    }
}
