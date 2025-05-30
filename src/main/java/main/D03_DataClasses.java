package main;

import model.DragonClass;
import model.DragonLombok;
import model.DragonRecord;
import model.DragonType;

/**
 * Data Classes
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class D03_DataClasses {

   public static void main(String[] args) {
      /* Normal Class */
      DragonClass fafnir1 = new DragonClass("Fafnir", DragonType.FIRE);
      DragonClass fafnir2 = new DragonClass("Fafnir", DragonType.FIRE);

      System.out.println(fafnir1.equals(fafnir2));
      System.out.println(fafnir1.hashCode());
      System.out.println(fafnir2.hashCode());
      System.out.println(fafnir1);

      fafnir1.setAge(500);
      System.out.println(fafnir1.getAge());

      /* Record */
      DragonRecord fafnir3 = new DragonRecord("Fafnir", DragonType.FIRE, 500);
      DragonRecord fafnir4 = new DragonRecord("Fafnir", DragonType.FIRE, 500);

      System.out.println(fafnir3.equals(fafnir4));
      System.out.println(fafnir3.hashCode());
      System.out.println(fafnir4.hashCode());
      System.out.println(fafnir3);

      // fafnir3.setAge(500);
      System.out.println(fafnir3.age());

      /* Lombok */
      DragonLombok fafnir5 = new DragonLombok("Fafnir", DragonType.FIRE);
      DragonLombok fafnir6 = new DragonLombok("Fafnir", DragonType.FIRE);

      System.out.println(fafnir5.equals(fafnir6));
      System.out.println(fafnir5.hashCode());
      System.out.println(fafnir6.hashCode());
      System.out.println(fafnir5);

      fafnir5.setAge(500);
      System.out.println(fafnir5.getAge());
   }

}
