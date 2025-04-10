package main;

import java.io.File;
import java.util.List;

import model.MeasurementValue;
import model.Sensor;
import model.ValueFileNotFoundException;
import model.WeatherStation;
import util.ValueHelper;

/**
 * Exam Task 1 (Weather Station)
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class X01_ExamTask01 {

   public static void main(String[] args) {
      /* Enumerations */
      long now = System.currentTimeMillis();
      MeasurementValue value1 = new MeasurementValue(now, 16, Sensor.TEMPERATURE);
      MeasurementValue value2 = new MeasurementValue(now, 20, Sensor.HUMIDITY);
      MeasurementValue value3 = new MeasurementValue(now - 1000, 18, Sensor.TEMPERATURE);
      MeasurementValue value4 = new MeasurementValue(now, 16, Sensor.TEMPERATURE);

      /* Lists */
      WeatherStation station = new WeatherStation("MP312");
      station.addMeasurementValue(value1);
      station.addMeasurementValue(value2);
      station.addMeasurementValue(value3);
      station.addMeasurementValue(value4);

      List<MeasurementValue> values = station.getMeasurementValues();

      System.out.println("Average Temperature: "
            + station.getAverageValueBySensor(Sensor.TEMPERATURE, now - 1000, now)
            + Sensor.TEMPERATURE.getUnitOfMeasure());

      /* For-Each-Loop */
      for (int i = 0; i < values.size(); i++) {
         MeasurementValue value = values.get(i);
         System.out.println(value.getValue());
      }
      System.out.println();

      for (MeasurementValue v : values) {
         System.out.println(v.getValue());
      }

      /* Conditional Operator */
      String text;
      if (values.isEmpty()) {
         text = "Die Messwertliste ist leer";
      } else {
         text = "Die Messwertliste ist nicht leer";
      }
      System.out.println(text);

      text = values.isEmpty() ? "Die Messwertliste ist leer" : "Die Messwertliste ist nicht leer";
      System.out.println(text);

      /* Object-Methods: String toString() */
      System.out.println(value1);
      System.out.println(value2);
      System.out.println(value3);
      System.out.println(value4);
      System.out.println(values);

      /* Object-Methods: boolean equals() */
      if (value1 == value4) {
         System.out.println("Die Messwerte sind identisch");
      }

      if (value1.equals(value4)) {
         System.out.println("Die Messwerte sind gleich");
      }

      /* Object-Methods: int hashCode() */
      System.out.println(value1.hashCode());
      System.out.println(value2.hashCode());
      System.out.println(value3.hashCode());
      System.out.println(value4.hashCode());

      /* Scanner, File and Wrappers */
      try {
         values = ValueHelper.getValues(new File("src/main/resources/values.txt"));
         System.out.println(values);
      } catch (ValueFileNotFoundException e) {
         System.err.println(e.getMessage());
      }
   }

}
