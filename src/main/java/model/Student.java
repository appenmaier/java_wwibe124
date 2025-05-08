package model;

/**
 * Student
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public record Student(String id, String name) implements Comparable<Student> {

   @Override
   public int compareTo(Student other) {
      return other.name.compareTo(name);
   }

}
