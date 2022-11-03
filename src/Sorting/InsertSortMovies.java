package Sorting;

import java.util.ArrayList;
import java.util.Collections;

import Movie.Movie;

public class InsertSortMovies {

    ArrayList<Movie> movies = new ArrayList<>();

    public InsertSortMovies(ArrayList<Movie> movies){
        this.movies = movies;
    }

    public int size(){
        return movies.size();
    }

    public ArrayList<Movie> sortByRating(){
        if(this.movies.size()>1){
            for(int i=1; i<movies.size(); i++){
                int j = i-1;
                while(j>=0 && movies.get(j+1).compareRatingTo(movies.get(j))>0){
                    Collections.swap(movies, j+1, j);
                    j--;
                }
            }
        }

        return this.movies;
    }

    public ArrayList<Movie> sortBySales(){
        if(this.movies.size()>1){
            for(int i=1; i<movies.size(); i++){
                int j = i-1;
                // System.out.println(movies.get(j+1).getMovieTitle());
                while(j>=0 && movies.get(j+1).compareSalesTo(movies.get(j))>0){
                    Collections.swap(movies, j+1, j);
                    j--;
                }
            }
        }
        
        return this.movies;
    }
    
}
