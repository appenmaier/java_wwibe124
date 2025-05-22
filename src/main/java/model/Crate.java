package model;

import java.util.List;
import java.util.Optional;

/**
 * Crate
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public record Crate(List<Body> bodies) {

   public void addBody(Body body) throws NullPointerException {
      if (body == null) {
         throw new NullPointerException();
      }
      bodies.add(body);
   }

   public Optional<Body> getBodyWithHighestVolume() {
      return null;
   }

   public List<Sphere> getAllSpheres() {
      return null;
   }

}
