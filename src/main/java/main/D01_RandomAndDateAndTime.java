package main;

import model.D6Dice;

/**
 * Pseudo Randoms, Date and Time
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class D01_RandomAndDateAndTime {

   public static void main(String[] args) {
      D6Dice dice = new D6Dice();

      for (int i = 0; i < 100; i++) {
         dice.rollTheDice();
         System.out.println(dice.getValue());
      }
   }

}
