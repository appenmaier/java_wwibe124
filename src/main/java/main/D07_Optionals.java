package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Optionals
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class D07_Optionals {

   public static void main(String[] args) {
      /* Ohne Optionals */
      String text = getText();
      if (text != null) {
         System.out.println(text.toUpperCase());
      } else {
         System.out.println("null");
      }

      System.out.println(getTexts().size());

      /* Mit Optionals */
      Optional<String> optionalText = getOptionalText();
      // imperativ
      if (optionalText.isPresent()) {
         System.out.println(optionalText.get().toLowerCase());
      } else {
         System.out.println("empty");
      }
      // funktional
      optionalText.ifPresentOrElse(t -> System.out.println(t.toLowerCase()),
            () -> System.out.println("empty"));
   }

   private static String getText() {
      Random random = new Random();
      if (random.nextBoolean()) {
         return "Hello World";
      } else {
         return null;
      }
   }

   private static List<String> getTexts() {
      List<String> texts = new ArrayList<>();
      return texts;
   }

   private static Optional<String> getOptionalText() {
      Random random = new Random();
      if (random.nextBoolean()) {
         return Optional.of("Hello World");
      } else {
         return Optional.empty();
      }
   }

}
