package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Movie;
import model.MovieByRatingDescendingComparator;

/**
 * Comparators
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class D02_Comparators {

   public static void main(String[] args) {
      List<Integer> numbers = new ArrayList<>();
      List<String> names = new ArrayList<>();
      List<Movie> movies = new ArrayList<>();

      numbers.add(5);
      numbers.add(9);
      numbers.add(2);

      names.add("Hans");
      names.add("Peter");
      names.add("Lisa");

      movies.add(new Movie("John Wick 4", "2023", 8.4));
      movies.add(new Movie("Disaster Movie", "2008", 2.1));
      movies.add(new Movie("Der Pate", "1972", 9.2));

      System.out.println(numbers);
      System.out.println(names);
      System.out.println(movies);

      Collections.sort(numbers);
      Collections.sort(names);
      Collections.sort(movies);

      System.out.println(numbers);
      System.out.println(names);
      System.out.println(movies);

      Collections.sort(movies, new MovieByRatingDescendingComparator());
      System.out.println(movies);
   }

}
