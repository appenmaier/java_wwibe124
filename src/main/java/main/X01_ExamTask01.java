package main;

import java.util.List;

import model.MeasurementValue;
import model.Sensor;
import model.WeatherStation;

/**
 * Klausuraufgabe 1 (Wetterstation)
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class X01_ExamTask01 {

   public static void main(String[] args) {
      long now = System.currentTimeMillis();
      MeasurementValue value1 = new MeasurementValue(now, 16, Sensor.TEMPERATURE);
      MeasurementValue value2 = new MeasurementValue(now, 20, Sensor.HUMIDITY);
      MeasurementValue value3 = new MeasurementValue(now - 1000, 19, Sensor.HUMIDITY);

      WeatherStation station = new WeatherStation("MP312");
      station.addMeasurementValue(value1);
      station.addMeasurementValue(value2);
      station.addMeasurementValue(value3);

      List<MeasurementValue> values = station.getMeasurementValues();
      for (int i = 0; i < values.size(); i++) {
         MeasurementValue value = values.get(i);
         System.out.println(value.getValue());
      }
   }

}
