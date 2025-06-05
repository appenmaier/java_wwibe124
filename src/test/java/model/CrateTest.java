package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * CrateTest
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class CrateTest {

   private Crate crate;
   @Mock
   private Sphere sphere3;
   @Mock
   private Sphere sphere5;
   @Mock
   private Sphere sphere1;
   @Mock
   private Body body;

   @BeforeEach
   void setUp() {
      MockitoAnnotations.openMocks(this);

      crate = new Crate(new ArrayList<>());
      // sphere3 = new Sphere(3);
      // sphere5 = new Sphere(5);
      // sphere1 = new Sphere(1);
      // body = () -> 2.0;
   }

   @Test
   void testAddBody() {
      crate.addBody(sphere3);
      crate.addBody(sphere5);

      assertTrue(crate.bodies().size() == 2);
      assertEquals(sphere3, crate.bodies().get(0));
      assertEquals(sphere5, crate.bodies().get(1));
   }

   @Test
   void testAddBody2() {
      assertThrows(NullPointerException.class, () -> crate.addBody(null));
   }

   @Test
   void testGetBodyWithHighestVolume() {
      when(sphere3.getVolume()).thenReturn(3.0);
      when(sphere5.getVolume()).thenReturn(5.0);
      when(sphere1.getVolume()).thenReturn(1.0);
      when(body.getVolume()).thenReturn(2.0);

      crate.bodies().add(sphere3);
      crate.bodies().add(sphere5);
      crate.bodies().add(sphere1);
      crate.bodies().add(body);

      assertEquals(Optional.of(sphere5), crate.getBodyWithHighestVolume());
   }

   @Test
   void testGetBodyWithHighestVolume2() {
      assertEquals(Optional.empty(), crate.getBodyWithHighestVolume());
   }

   @Test
   void testGetAllSpheres() {
      crate.bodies().add(sphere3);
      crate.bodies().add(body);
      crate.bodies().add(sphere5);
      crate.bodies().add(sphere1);

      assertEquals(3, crate.getAllSpheres().size());
   }

   @Test
   void testGetAllSpheres2() {
      assertEquals(0, crate.getAllSpheres().size());
   }

}
