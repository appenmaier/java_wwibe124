package main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

import model.D6Dice;

/**
 * Pseudo Randoms, Date and Time
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class D01_RandomAndDateAndTime {

   @SuppressWarnings("resource")
   public static void main(String[] args) {
      /* Pseudo Randoms */
      D6Dice dice = new D6Dice();

      for (int i = 0; i < 100; i++) {
         dice.rollTheDice();
         System.out.println(dice.getValue());
      }

      /* Date and Time */
      LocalDateTime now = LocalDateTime.now();
      System.out.println(now);
      System.out.println(now.getDayOfYear());
      System.out.println(now.getMonth());
      System.out.println(now.getHour());
      LocalDate christmasEve = LocalDate.of(2025, 12, 24);
      LocalDate newYearsEve = LocalDate.parse("2025-12-31");
      System.out.println(christmasEve);
      System.out.println(newYearsEve);

      /* Console Inputs */
      Scanner scanner = new Scanner(System.in);

      System.out.print("Ganze Zahl: ");
      int i1 = scanner.nextInt();
      System.out.println(i1);

      System.out.print("Kommazahl: ");
      double d1 = scanner.nextDouble();
      System.out.println(d1);

      System.out.print("Boolscher Wert: ");
      boolean b1 = scanner.nextBoolean();
      System.out.println(b1);

      System.out.print("Zeichen: ");
      char c1 = scanner.next().charAt(0);
      System.out.println(c1);

      System.out.print("Vorname: ");
      String firstName = scanner.next();
      System.out.println(firstName);

      System.out.print("Vor und Nachname: ");
      scanner.nextLine();
      String firstAndFamilyName = scanner.nextLine();
      System.out.println(firstAndFamilyName);

      /* Switch Case Expression */
      String text;
      switch (c1) {
         case 'x':
         case 'X':
            text = "Satz mit X";
            break;
         case '?':
            text = "Fragezeichen";
            break;
         case 'Y':
            text = "Y";
            break;
         default:
            text = "default";
            break;
      }
      System.out.println(text);

      text = switch (c1) {
         case 'x', 'X' -> "Satz mit X";
         case '?'      -> "Fragezeichen";
         case 'Y'      -> "Y";
         default       -> "default";
      };
      System.out.println(text);
   }

}
