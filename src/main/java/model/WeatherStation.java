package model;

import java.util.ArrayList;
import java.util.List;

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
      // if (measurementValues[measurementValues.length - 1] != null) {
      // MeasurementValue[] temp = new MeasurementValue[measurementValues.length + 2];
      // for (int i = 0; i < measurementValues.length; i++) {
      // temp[i] = measurementValues[i];
      // }
      // measurementValues = temp;
      // }
      // for (int i = 0; i < measurementValues.length; i++) {
      // if (measurementValues[i] == null) {
      // measurementValues[i] = measurementValue;
      // return;
      // }
      // }
   }

}
