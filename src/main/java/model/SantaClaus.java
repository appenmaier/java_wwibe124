package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Santa Claus
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class SantaClaus {

   private final List<Present> presents;

   public SantaClaus() {
      presents = new ArrayList<>();
   }

   public void addPresent(Present present) {
      presents.add(present);
   }

   public void wrapAllPresents() {
      for (Present p : presents) {
         p.wrap();
      }
   }

   public int getNumberOfToys() {
      int numberOfToys = 0;
      double totalPriceInEuro = 0;

      for (Present p : presents) {
         if (p instanceof Toy t) {
            numberOfToys++;
            // Toy t = (Toy) p;
            totalPriceInEuro += t.getPriceInEuro();
         }
      }

      System.out.println(totalPriceInEuro);
      return numberOfToys;
   }

   public List<Present> getPresents() {
      return presents;
   }

}
