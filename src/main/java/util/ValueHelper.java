package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.MeasurementValue;
import model.Sensor;
import model.ValueFileNotFoundException;

/**
 * Measurement Value Helper
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class ValueHelper {

   public static List<MeasurementValue> getValues(File file) throws ValueFileNotFoundException {
      List<MeasurementValue> values = new ArrayList<>();

      try {
         Scanner scanner = new Scanner(file);
         while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] tokens = line.split(";");

            long timestamp = Long.valueOf(tokens[0]);
            double value = Double.valueOf(tokens[1]);
            Sensor sensor = Sensor.valueOf(tokens[2]);

            MeasurementValue measurementValue = new MeasurementValue(timestamp, value, sensor);
            values.add(measurementValue);
         }
         scanner.close();
      } catch (FileNotFoundException e) {
         throw new ValueFileNotFoundException(file.getPath());
      }

      return values;
   }

}
