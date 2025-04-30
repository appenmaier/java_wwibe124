package main;

import java.util.ArrayList;

import model.Movie;
import model.Movie.Genre;
import model.Movie.Rating;

/**
 * Member Classes
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class D04_MemberClasses {

   public static void main(String[] args) {
      Movie movie = new Movie("John Wick 4", "2023", Genre.ACTION, 8.4, new ArrayList<>());
      Rating rating = movie.new Rating("Daniel", 8);
      movie.getRatings().add(rating);
      System.out.println(movie);
   }

}
