package main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

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

      /* filter, findAny/findFirst */
      getDrama().ifPresent(System.out::println);
      System.out.println();

      /* anyMatch/allMatch/noneMatch */
      System.out.println(doesExistMovieBefore1982());
      System.out.println();

      /* map, distinct, sorted, toList */
      allYearsAsSortedList().forEach(System.out::println);
      System.out.println();

      /* collect */
      getAllMoviesByYear().forEach((year, movies) -> System.out.println(year + ": " + movies));
      System.out.println();

      /* Java Stream API bei Maps */
      Map<String, List<Movie>> allMoviesByYear = getAllMoviesByYear();

      Optional<String> year = allMoviesByYear.keySet().stream().findAny();
      year.ifPresent(System.out::println);

      long numberOfValues =
            allMoviesByYear.values().stream().filter(movies -> movies.size() > 2).count();
      System.out.println(numberOfValues);

      allMoviesByYear.entrySet()
            .stream()
            .filter(entry -> entry.getValue().size() > 2)
            .map(Entry::getKey)
            .forEach(System.out::println);
   }

   private static Map<String, List<Movie>> getAllMoviesByYear() {
      System.out.println("Alle Filme gruppiert nach Jahr: ");

      Map<String, List<Movie>> allMoviesByYear = new HashMap<>();
      allMoviesByYear = movies.stream().collect(Collectors.groupingBy(Movie::year)); // .collect(Collectors.groupingBy(movie
                                                                                     // ->
                                                                                     // movie.year()));
      return allMoviesByYear;
   }

   private static List<String> allYearsAsSortedList() {
      System.out.println("Alle Jahre: ");

      List<String> allYears = new ArrayList<>();
      allYears = movies.stream()
            .map(Movie::year) // .map(movie -> movie.year())
            .distinct()
            .sorted()
            .toList()
            .reversed();
      return allYears;
   }

   private static boolean doesExistMovieBefore1982() {
      System.out.print("Film vor 1982?: ");

      boolean exists = false;
      exists = movies.stream().anyMatch(movie -> movie.year().compareTo("1982") < 0);
      return exists;
   }

   private static Optional<Movie> getDrama() {
      System.out.print("Ein Drama: ");

      Optional<Movie> drama = Optional.empty();
      drama = movies.stream().filter(movie -> movie.genres().contains(Genre.DRAMA)).findAny(); // .findFirst()
      return drama;
   }

   private static Optional<Movie> getLongestMovie() {
      System.out.print("Der längste Film: ");

      /* Variante A */
      // Optional<Movie> longestMovie = Optional.empty();
      // longestMovie = movies.stream()
      // .max((movie1, movie2) -> Integer.compare(movie1.runtimeInMinutes(),
      // movie2.runtimeInMinutes()));
      // return longestMovie;

      /* Variante B */
      return movies.stream()
            .max((movie1, movie2) -> Integer.compare(movie1.runtimeInMinutes(),
                  movie2.runtimeInMinutes()));
   }

   private static void printTop5HorrorMovies() {
      System.out.println("Die Top 5 Horror-Filme:");

      movies.stream()
            .filter(movie -> movie.genres().contains(Genre.HORROR))
            .sorted((movie1, movie2) -> Double.compare(movie2.rating(), movie1.rating()))
            .limit(5)
            .forEach(System.out::println);
   }

   private static OptionalDouble getAverageOfAllMovies() {
      System.out.print("Die Durchschnittsbewertung aller Filme: ");

      OptionalDouble averageOfAllMovies = OptionalDouble.empty();
      averageOfAllMovies = movies.stream()
            .mapToDouble(movie -> movie.rating()) // .mapToDouble(Movie::rating)
            .average();
      return averageOfAllMovies;
   }

   private static void printAllThrillersWithRatingGE7() {
      System.out
            .println("Alle Thriller mit einer Bewertung von min. 7 in der Form [Title] ([Jahr]):");

      movies.stream()
            .filter(movie -> movie.genres().contains(Genre.THRILLER))
            .filter(movie -> movie.rating() >= 7)
            /* Variante A */
            .map(movie -> movie.title() + " (" + movie.year() + ")")
            .forEach(System.out::println);
      /* Variante B */
      // .forEach(movie -> System.out.println(movie.title() + " (" + movie.year() + ")"));
   }

}
