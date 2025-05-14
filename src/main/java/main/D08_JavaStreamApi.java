package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.Person;

/**
 * Java Stream API
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class D08_JavaStreamApi {

   public static void main(String[] args) {
      List<Person> persons = Arrays.asList(new Person("Hans", 18, 'm'),
            new Person("Peter", 27, 'm'),
            new Person("Lisa", 43, 'w'),
            new Person("Max", 19, 'm'),
            new Person("Heidi", 19, 'w'),
            new Person("Philipp", 22, 'm'),
            new Person("Maria", 17, 'w'));

      /* imperative Lösung */
      List<String> names = new ArrayList<>();
      for (Person p : persons) {
         if (p.gender() == 'w' && p.name().length() == 5) {
            String name = p.name().toUpperCase();
            names.add(name);
         }
      }

      Collections.sort(names, new Comparator<String>() {

         @Override
         public int compare(String name1, String name2) {
            return name2.compareTo(name1);
         }

      });

      System.out.println(names);

      /* Funktionale Lösung */
      names = persons.stream()
            .filter(p -> p.gender() == 'w')
            .filter(p -> p.name().length() == 5)
            .map(p -> p.name().toUpperCase())
            .sorted((name1, name2) -> name2.compareTo(name1))
            .toList();
      System.out.println(names);

      persons.stream()
            .filter(p -> p.gender() == 'w')
            .filter(p -> p.name().length() == 5)
            .map(p -> p.name().toUpperCase())
            .sorted((name1, name2) -> name2.compareTo(name1))
            .forEach(System.out::println);
   }

}
