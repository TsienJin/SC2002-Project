package dataDriver;

import java.util.ArrayList;

import Movie.Movie;
import Movie.MovieBuilder;
import ShowTime.ShowtimeBuilder;
import ShowTime.showtime;

public abstract class CSVDriver{

    protected FileIO fileio = new FileIO();

    
    public void listTopMoviesBySales(){
    }

    public void listTopMoviesByRating(){

    }

    public void listAllMovies(){

        this.fileio.readFromFile(EnumDataFiles.Movie.toString()).forEach(movie -> {
            System.out.println(new MovieBuilder(movie).build().toString());
        });
        
    }

    public void listMovieFromRegex(String rgx){
        ArrayList<String> found = this.fileio.regexMatch(EnumDataFiles.Movie.toString(), rgx);
        if(found.size()>0){
            found.forEach(movie->{
                System.out.println(new MovieBuilder(movie).build().toString());
            });
        } else {
            System.out.println("No movies found!");
        }
    }


    public void listAllShowtimes(){
        this.fileio.readFromFile(EnumDataFiles.Showtime.toString()).forEach(line->{
            System.out.println(line);
        });
    }

    public boolean listShowtimeFromRegex(String rgx){
        ArrayList<String> found = this.fileio.regexMatch(EnumDataFiles.Showtime.toString(), rgx);
        if(found.size()>0){
            found.forEach(line->{
                ShowtimeBuilder showtiming = new ShowtimeBuilder(line);
                showtime buildtime = new showtime(showtiming);
                buildtime.printShowTime();
            });
            return true;
        }
        else{
            System.out.println("No showtime found");
            return false;
        }
    }

    public String findCinema(String rgx){
        ArrayList<String> found = this.fileio.regexMatch(EnumDataFiles.Cinema.toString(),rgx);
        String line = found.get(0);
        return line;
    }

    public void updateBookedSeats(String ID,String rgx) {
        
        this.fileio.updateKeyInFile(ID, rgx);
    }

}
