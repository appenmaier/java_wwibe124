package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import model.Exam;
import model.Student;

/**
 * Maps
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class D06_Maps {

   public static void main(String[] args) {
      Map<Student, Exam> studentsWithExam = new HashMap<>();

      /* Werte setze */
      studentsWithExam.put(new Student("1", "Hans"), new Exam("Mathe", 3.5));
      studentsWithExam.put(new Student("2", "Lisa"), new Exam("Mathe", 1.7));
      studentsWithExam.put(new Student("3", "Max"), new Exam("Mathe", 2.5));

      /* Werte lesen */
      System.out.println("Max: " + studentsWithExam.get(new Student("3", "Max")));

      /* Inhalte prüfen */
      System.out.println("Max?: " + studentsWithExam.containsKey(new Student("3", "Max")));
      System.out.println("Peter?: " + studentsWithExam.containsKey(new Student("4", "Peter")));
      System.out.println("1.0?: " + studentsWithExam.containsValue(new Exam("Mathe", 1.0)));
      System.out.println("2.5?: " + studentsWithExam.containsValue(new Exam("Mathe", 2.5)));

      /* Werte überschreiben */
      System.out.println(
            "Hans, alt: " + studentsWithExam.put(new Student("1", "Hans"), new Exam("Mathe", 3.3)));
      System.out.println("Hans, neu: " + studentsWithExam.get(new Student("1", "Hans")));
      System.out.println();

      /* Werte ausgeben */
      System.out.println(studentsWithExam);
      System.out.println();

      /* Datensammlung: Die Menge aller Schlüssel */
      System.out.println("Anwesenheitsliste:");
      for (Student s : studentsWithExam.keySet()) {
         System.out.printf("%-10s [ ]%n", s.name());
      }
      System.out.println();

      /* Datensammlung: Sammlung aller Werte */
      double total = 0;
      int counter = 0;
      for (Exam e : studentsWithExam.values()) {
         if (e.getLecture().equals("Mathe")) {
            total += e.getGrade();
            counter++;
         }
      }
      System.out.println("Durchschnittsnote Mathe: " + total / counter);
      System.out.println();

      /* Datensammlung: Menge aller Schlüssel-Wert-Paare/Einträge */
      System.out.println("Ergebnisse der Matheklausur:");
      for (Entry<Student, Exam> entry : studentsWithExam.entrySet()) {
         Student student = entry.getKey();
         Exam exam = entry.getValue();
         System.out.println(student.id() + ": " + exam.getGrade());
      }
      System.out.println();

      /* Probleme der TreeMap */
      studentsWithExam = new TreeMap<>(studentsWithExam);

      studentsWithExam.put(new Student("4", "Hans"), new Exam("Mathe", 5.0));
      System.out.println(studentsWithExam);

      System.out.println(studentsWithExam.get(new Student("1", "Hans")));
   }

}
