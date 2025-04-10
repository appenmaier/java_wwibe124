package model;

/**
 * ValueFileNotFoundException
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class ValueFileNotFoundException extends Exception {

   private static final long serialVersionUID = 1L;

   public ValueFileNotFoundException(String path) {
      super("File " + path + " does not exist");
   }

}
