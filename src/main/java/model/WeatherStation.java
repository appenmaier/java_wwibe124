package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Wetterstation
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class WeatherStation {

   private final int id;
   private final String location;
   private List<MeasurementValue> measurementValues;
   private static int counter;

   public WeatherStation(String location) {
      counter++;
      this.location = location;
      measurementValues = new ArrayList<>();
      id = counter;
   }

   public int getId() {
      return id;
   }

   public String getLocation() {
      return location;
   }

   public List<MeasurementValue> getMeasurementValues() {
      return measurementValues;
   }

   public void addMeasurementValue(MeasurementValue measurementValue) {
      measurementValues.add(measurementValue);
   }

   public double getAverageValueBySensor(Sensor sensor, long start, long end) {
      double averageValue = 0;
      double total = 0;
      int counter = 0;

      for (MeasurementValue value : measurementValues) {
         if (value.getSensor().equals(sensor) && value.getTimestamp() >= start
               && value.getTimestamp() <= end) {
            total += value.getValue();
            counter++;
         }
      }

      averageValue = total / counter;
      return averageValue;
   }

}
