package model;

/**
 * Messwert
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class MeasurementValue {

   private final long timestamp;
   private final double value;
   private final Sensor sensor;

   public MeasurementValue(long timestamp, double value, Sensor sensor) {
      this.timestamp = timestamp;
      this.value = value;
      this.sensor = sensor;
   }

   public long getTimestamp() {
      return timestamp;
   }

   public double getValue() {
      return value;
   }

   public Sensor getSensor() {
      return sensor;
   }

}
