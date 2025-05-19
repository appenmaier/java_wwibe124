package model;

/**
 * Fast Food
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public record FastFood(String name, FastFoodCategory fastFoodCategory, double calorificValueInKcal,
      boolean isVegetarian) implements Comparable<FastFood> { // 2

   @Override // +0,25
   public int compareTo(FastFood otherFastFood) { // 0,5
      return Double.compare(otherFastFood.calorificValueInKcal, calorificValueInKcal); // 1,5
   } // 2

} // 4
