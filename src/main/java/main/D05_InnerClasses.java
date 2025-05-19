package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import model.MovieOld;
import model.MovieOld.Genre;
import model.MovieOld.MovieByRatingDescendingComparator;

/**
 * Inner Classes
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class D05_InnerClasses {

   public static void main(String[] args) {
      List<MovieOld> movies = new ArrayList<>();

      movies.add(new MovieOld("John Wick 4", "2023", Genre.ACTION, 8.4, new ArrayList<>()));
      movies.add(new MovieOld("Disaster Movie", "2008", Genre.COMEDY, 2.1, new ArrayList<>()));
      movies.add(new MovieOld("Der Pate", "1972", Genre.DRAMA, 9.2, new ArrayList<>()));

      /* Outer Class */
      Collections.sort(movies, new MovieByRatingDescendingComparator());
      System.out.println("Outer Class (Rating DESC)");
      for (MovieOld m : movies) {
         System.out.println(m);
      }
      System.out.println();

      /* Local Class */
      class MovieByRatingAscendingComparator implements Comparator<MovieOld> {

         @Override
         public int compare(MovieOld movie1, MovieOld movie2) {
            return Double.compare(movie1.getAverageRating(), movie2.getAverageRating());
         }

      }
      Collections.sort(movies, new MovieByRatingAscendingComparator());
      System.out.println("Local Class (Rating ASC)");
      class MoviePrinterConsumer implements Consumer<MovieOld> {

         @Override
         public void accept(MovieOld movie) {
            System.out.println(movie);
         }

      }
      movies.forEach(new MoviePrinterConsumer());
      System.out.println();

      /* Anonymous Class */
      Collections.sort(movies, new Comparator<>() {

         @Override
         public int compare(MovieOld movie1, MovieOld movie2) {
            return movie2.getTitle().compareTo(movie1.getTitle());
         }

      });
      System.out.println("Anonymous Class (Title DESC)");
      movies.forEach(new Consumer<>() {

         @Override
         public void accept(MovieOld movie) {
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
