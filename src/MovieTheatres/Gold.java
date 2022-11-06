package MovieTheatres;

public class Gold extends Theatre{
    private static final int size = 6;
    private String bookedSeat;

    private int Empty = size*size;
    private int[][] layout = new int[size][size];

    //Constructor for regular class
    public Gold(String bookedSeat){
        super(bookedSeat);
        //Call the superclass's (Cinema) constructor
        //Initialisation of regular cinema array
        //So if the integer is 0 means the spot is not being booked yet (available)
        //Else if integer increments to 1, means the spot is being booked (not available)
        //this.bookedSeat = bookedSeat;

        for(int i = 0; i<size ;i++){
            for(int j = 0; j<size ; j++){
                layout[i][j] = 0;
            }
        }
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

    //Implementation of all the abstract class

    //showLayout() function: It will show the seat availability for the customers
    //'O' means available
    //'X' means not available
    public void showLayout(){
        System.out.println("Layout of Movie Theatre");
        for(int i = 0; i<size; i++){
            if(i==0){
                System.out.println("     0 1 2   ||    3 4 5");
            }
            for(int j = 0; j<size; j++){
                
                if(j==2){
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
            System.out.print("\n");
        }
        System.out.println("\n");
    }

    public boolean BookSeat(int row, int col){
        if(layout[row][col]==0){
            layout[row][col]=1;
            Empty = Empty - 1;
            System.out.println("Seats is being booked");
            return true;
        }
        else{
            System.out.println("Seat has already been booked, please try again");
            return false;
        }
    }

    public int getTotalSeats(){
        return size*size;
    }

    public int getNumEmptySeats(){
        return Empty;
    }

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

