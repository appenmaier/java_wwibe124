package model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Exam
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Exam {

   private final String lecture;
   private double grade;

}
