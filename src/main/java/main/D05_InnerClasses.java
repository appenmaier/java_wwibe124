package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import model.Movie;
import model.Movie.Genre;
import model.Movie.MovieByRatingDescendingComparator;

/**
 * Inner Classes
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class D05_InnerClasses {

   public static void main(String[] args) {
      List<Movie> movies = new ArrayList<>();

      movies.add(new Movie("John Wick 4", "2023", Genre.ACTION, 8.4, new ArrayList<>()));
      movies.add(new Movie("Disaster Movie", "2008", Genre.COMEDY, 2.1, new ArrayList<>()));
      movies.add(new Movie("Der Pate", "1972", Genre.DRAMA, 9.2, new ArrayList<>()));

      /* Outer Class */
      Collections.sort(movies, new MovieByRatingDescendingComparator());
      System.out.println("Outer Class (Rating DESC)");
      for (Movie m : movies) {
         System.out.println(m);
      }
      System.out.println();

      /* Local Class */
      class MovieByRatingAscendingComparator implements Comparator<Movie> {

         @Override
         public int compare(Movie movie1, Movie movie2) {
            return Double.compare(movie1.getAverageRating(), movie2.getAverageRating());
         }

      }
      Collections.sort(movies, new MovieByRatingAscendingComparator());
      System.out.println("Local Class (Rating ASC)");
      class MoviePrinterConsumer implements Consumer<Movie> {

         @Override
         public void accept(Movie movie) {
            System.out.println(movie);
         }

      }
      movies.forEach(new MoviePrinterConsumer());
      System.out.println();

      /* Anonymous Class */
      Collections.sort(movies, new Comparator<>() {

         @Override
         public int compare(Movie movie1, Movie movie2) {
            return movie2.getTitle().compareTo(movie1.getTitle());
         }

      });
      System.out.println("Anonymous Class (Title DESC)");
      movies.forEach(new Consumer<>() {

         @Override
         public void accept(Movie movie) {
            System.out.println(movie);
         }

      });
      System.out.println();

      /* Lambda Expression */
      Collections.sort(movies,
            (movie1, movie2) -> movie1.getPublishingYear().compareTo(movie2.getPublishingYear()));
      System.out.println("Lambda Expression (Publishing Year ASC)");
      movies.forEach(movie -> System.out.println(movie));
      System.out.println();

      /* Method Reference */
      System.out.println("Method Reference");
      movies.forEach(System.out::println);
   }

}
