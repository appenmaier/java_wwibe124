package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * ShopTest
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class ShopTest {

   private Shop<FastFood> shop;
   @Mock
   private FastFood fastFood1;
   @Mock
   private FastFood fastFood2;
   @Mock
   private FastFood fastFood3;

   @BeforeEach
   void setUp() {
      MockitoAnnotations.openMocks(this);

      shop = new Shop<>("Burger Queen", new HashMap<>());
   }

   @Test
   void testAddProduct() {
      shop.addProduct(fastFood1);
      shop.addProduct(fastFood2);
      shop.addProduct(fastFood3);
      shop.addProduct(fastFood1);

      assertEquals(3, shop.assortment().keySet().size());
      assertTrue(shop.assortment().containsKey(fastFood1));
      assertTrue(shop.assortment().containsKey(fastFood2));
      assertTrue(shop.assortment().containsKey(fastFood3));
   }

   @Test
   void testRateProduct() {
      shop.addProduct(fastFood1);
      shop.addProduct(fastFood2);

      assertThrows(NoProductFoundException.class, () -> shop.rateProduct(fastFood3, 4));
      assertThrows(InvalidRatingException.class, () -> shop.rateProduct(fastFood2, 0));
      assertThrows(InvalidRatingException.class, () -> shop.rateProduct(fastFood2, 10));
   }

   @Test
   void testGetBestRatedProduct() {
      shop.assortment().put(fastFood1, List.of(2));
      shop.assortment().put(fastFood2, List.of(5, 3, 4));
      shop.assortment().put(fastFood3, List.of(1, 5, 1, 5, 1));

      assertEquals(Optional.of(fastFood2), shop.getBestRatedProduct());
   }

   @Test
   void testGetAllProductsSortedByNaturalOrdering() {
      shop.assortment().put(fastFood1, new ArrayList<>());
      shop.assortment().put(fastFood2, new ArrayList<>());
      shop.assortment().put(fastFood3, new ArrayList<>());

      when(fastFood1.compareTo(fastFood2)).thenReturn(-1);
      when(fastFood1.compareTo(fastFood3)).thenReturn(-1);
      when(fastFood2.compareTo(fastFood1)).thenReturn(1);
      when(fastFood2.compareTo(fastFood3)).thenReturn(1);
      when(fastFood3.compareTo(fastFood1)).thenReturn(1);
      when(fastFood3.compareTo(fastFood2)).thenReturn(-1);

      assertEquals(List.of(fastFood1, fastFood3, fastFood2),
            shop.getAllProductsSortedByNaturalOrdering());
   }

}
