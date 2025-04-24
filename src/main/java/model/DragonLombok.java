package model;

import lombok.Data;

/**
 * Dragon
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
// @RequiredArgsConstructor
// @Getter
// @Setter
// @ToString
// @EqualsAndHashCode
@Data
public class DragonLombok {

   private final String name;
   private final DragonType type;
   private int age;

}
