package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * CrateTest
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class CrateTest {

   @Test
   void testAddBody() {
      Crate crate = new Crate(new ArrayList<>());
      Sphere sphere1 = new Sphere(3);
      Sphere sphere2 = new Sphere(1);
      crate.addBody(sphere1);
      crate.addBody(sphere2);
      assertTrue(crate.bodies().size() == 2);
      assertEquals(sphere1, crate.bodies().get(0));
      assertEquals(sphere2, crate.bodies().get(1));
   }

   @Test
   void testAddBody2() {
      Crate crate = new Crate(new ArrayList<>());
      assertThrows(NullPointerException.class, () -> crate.addBody(null));
   }

}
