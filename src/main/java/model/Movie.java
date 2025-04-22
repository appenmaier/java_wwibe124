package model;

import java.util.Objects;

/**
 * Movie
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class Movie {

   private final String title;
   private final String publishingYear;
   private final double averageRating;

   public Movie(String title, String publishingYear, double averageRating) {
      this.title = title;
      this.publishingYear = publishingYear;
      this.averageRating = averageRating;
   }

   public String getTitle() {
      return title;
   }

   public String getPublishingYear() {
      return publishingYear;
   }

   public double getAverageRating() {
      return averageRating;
   }

   @Override
   public String toString() {
      return "Movie [title=" + title + ", publishingYear=" + publishingYear + ", averageRating="
            + averageRating + "]";
   }

   @Override
   public int hashCode() {
      return Objects.hash(averageRating, publishingYear, title);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (obj == null) {
         return false;
      }
      if (getClass() != obj.getClass()) {
         return false;
      }
      Movie other = (Movie) obj;
      return Double.doubleToLongBits(averageRating) == Double.doubleToLongBits(other.averageRating)
            && Objects.equals(publishingYear, other.publishingYear)
            && Objects.equals(title, other.title);
   }

}
