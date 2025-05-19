package main;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import model.Movie;
import model.Movie.Genre;
import model.Movies;

/**
 * Java Stream API
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class D09_JavaStreamApi {

   private static List<Movie> movies;

   public static void main(String[] args) throws FileNotFoundException {
      movies = Movies.getMovies(50, 100_000);
      movies.forEach(System.out::println);
      System.out.println();

      /* filter, map, forEach */
      printAllThrillersWithRatingGE7();
      System.out.println();

      /* mapToDouble/mapToInt/mapToLong, average/sum */
      getAverageOfAllMovies().ifPresent(System.out::println);
      System.out.println();

      /* filter, sorted, limit/skip, forEach */
      printTop5HorrorMovies();
      System.out.println();

      /* max/min/count */
      getLongestMovie().ifPresent(System.out::println);;
      System.out.println();
   }

   private static Optional<Movie> getLongestMovie() {
      System.out.print("Der längste Film: ");
      Optional<Movie> longestMovie = Optional.empty();
      longestMovie = movies.stream()
            .max((m1, m2) -> Integer.compare(m1.runtimeInMinutes(), m2.runtimeInMinutes()));
      return longestMovie;
   }

   private static void printTop5HorrorMovies() {
      System.out.println("Die Top 5 Horror-Filme:");
      movies.stream()
            .filter(m -> m.genres().contains(Genre.HORROR))
            .sorted((m1, m2) -> Double.compare(m2.rating(), m1.rating()))
            .limit(5)
            .forEach(System.out::println);
   }

   private static OptionalDouble getAverageOfAllMovies() {
      System.out.print("Die Durchschnittsbewertung aller Filme: ");
      OptionalDouble averageOfAllMovies = OptionalDouble.empty();
      averageOfAllMovies = movies.stream()
            .mapToDouble(m -> m.rating()) // .mapToDouble(Movie::rating)
            .average();
      return averageOfAllMovies;
   }

   private static void printAllThrillersWithRatingGE7() {
      System.out
            .println("Alle Thriller mit einer Bewertung von min. 7 in der Form [Title] ([Jahr]):");
      movies.stream()
            .filter(m -> m.genres().contains(Genre.THRILLER))
            .filter(m -> m.rating() >= 7)
            /* Variante A */
            .map(m -> m.title() + " (" + m.year() + ")")
            .forEach(System.out::println);
      /* Variante B */
      // .forEach(m -> System.out.println(m.title() + " (" + m.year() + ")"));
   }

}
