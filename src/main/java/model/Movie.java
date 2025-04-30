package model;

import java.util.Comparator;
import java.util.List;

import lombok.Data;

/**
 * Movie
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
@Data
public class Movie implements Comparable<Movie> {

   private final String title;
   private final String publishingYear;
   private final Genre genre;
   private final double averageRating;
   private final List<Rating> ratings;

   @Override
   public int compareTo(Movie otherMovie) {
      return title.compareTo(otherMovie.title);
   }

   /**
    * Movie Rating
    *
    * @author Daniel Appenmaier
    * @version 1.0
    *
    */
   @Data
   public class Rating {

      private final String userName;
      private final int rating;

   }

   /**
    * Genre
    *
    * @author Daniel Appenmaier
    * @version 1.0
    *
    */
   public static enum Genre {
      ACTION, THRILLER, DRAMA, COMEDY, SCIFI
   }

   /**
    * MovieByRatingDescendingComparator
    *
    * @author Daniel Appenmaier
    * @version 1.0
    *
    */
   public static class MovieByRatingDescendingComparator implements Comparator<Movie> {

      @Override
      public int compare(Movie movie1, Movie movie2) {
         /* Option A */
         // double rating1 = movie1.getRating();
         // double rating2 = movie2.getRating();
         //
         // if (rating1 > rating2) {
         // return -1;
         // } else if (rating1 < rating2) {
         // return 1;
         // } else {
         // return 0;
         // }

         /* Option B */
         // Double rating1 = movie1.getRating();
         // Double rating2 = movie2.getRating();
         // return rating2.compareTo(rating1);

         /* Option C */
         return Double.compare(movie2.getAverageRating(), movie1.getAverageRating());
      }

   }

}
