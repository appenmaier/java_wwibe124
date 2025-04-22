package model;

/**
 * Present
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public abstract class Present implements Wrappable {

   private boolean isWrapped;

   public boolean isWrapped() {
      return isWrapped;
   }

   @Override
   public void wrap() {
      isWrapped = true;
   }

   @Override
   public void unwrap() {
      isWrapped = false;
   }

}
