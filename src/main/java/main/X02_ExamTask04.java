package main;

import model.Book;
import model.Present;
import model.SantaClaus;
import model.Toy;

/**
 * Exam Task 4 (Santa Claus)
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class X02_ExamTask04 {

   public static void main(String[] args) {
      Book book = new Book("Es", "Stephen King");
      Toy toy = new Toy("Spielzeugeisenbahn", 299.99);

      SantaClaus santaClaus = new SantaClaus();
      santaClaus.addPresent(toy); // Upcast
      santaClaus.addPresent(book); // Upcast

      for (Present p : santaClaus.getPresents()) {
         System.out.println(p.getDescription()); // Dynamische Polymorphie
      }
   }

}
