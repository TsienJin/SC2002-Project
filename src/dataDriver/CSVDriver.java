package dataDriver;

import java.util.ArrayList;

import Movie.Movie;
import Movie.MovieBuilder;

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

}
