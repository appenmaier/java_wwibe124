package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.MovieOld;
import model.MovieOld.Genre;
import model.MovieOld.MovieByRatingDescendingComparator;

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
      List<MovieOld> movies = new ArrayList<>();

      numbers.add(5);
      numbers.add(9);
      numbers.add(2);

      names.add("Hans");
      names.add("Peter");
      names.add("Lisa");

      movies.add(new MovieOld("John Wick 4", "2023", Genre.ACTION, 8.4, new ArrayList<>()));
      movies.add(new MovieOld("Disaster Movie", "2008", Genre.COMEDY, 2.1, new ArrayList<>()));
      movies.add(new MovieOld("Der Pate", "1972", Genre.DRAMA, 9.2, new ArrayList<>()));

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
