package model;

import java.util.ArrayList;
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
      /* Variante A */
      // Body bodyWithHighestVolume = null;
      // double highestVolume = 0;
      //
      // for (Body b : bodies) {
      // if (b.getVolume() > highestVolume) {
      // highestVolume = b.getVolume();
      // bodyWithHighestVolume = b;
      // }
      // }
      //
      // return Optional.ofNullable(bodyWithHighestVolume);

      /* Variante B */
      // Optional<Body> bodyWithHighestVolume = Optional.empty();
      // double highestVolume = 0;
      //
      // for (Body b : bodies) {
      // if (b.getVolume() > highestVolume) {
      // highestVolume = b.getVolume();
      // bodyWithHighestVolume = Optional.of(b);
      // }
      // }
      //
      // return bodyWithHighestVolume;

      /* Variante C */
      return bodies.stream()
            .max((body1, body2) -> Double.compare(body1.getVolume(), body2.getVolume()));
   }

   public List<Sphere> getAllSpheres() {
      List<Sphere> spheres = new ArrayList<>();

      for (Body b : bodies) {
         if (b instanceof Sphere s) {
            spheres.add(s);
         }
      }

      return spheres;
   }

}
