package model;

import java.util.Random;

/**
 * Dice
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class D6Dice {

   private int value;

   public D6Dice() {
      rollTheDice();
   }

   public void rollTheDice() {
      Random random = new Random();
      value = random.nextInt(1, 7);
   }

   public int getValue() {
      return value;
   }

}
