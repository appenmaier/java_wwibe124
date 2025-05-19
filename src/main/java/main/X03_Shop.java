package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import model.FastFood;
import model.FastFoodCategory;
import model.InvalidRatingException;
import model.NoProductFoundException;
import model.Shop;

/**
 * Shop
 *
 * @author Daniel Appenmaier
 * @version 1.0
 *
 */
public class X03_Shop {

   public static void main(String[] args) {
      List<FastFood> fastFood = new ArrayList<>();

      FastFood fastFood1 = new FastFood("Hamburger", FastFoodCategory.BURGER, 750, false);
      FastFood fastFood2 = new FastFood("Pommes", FastFoodCategory.FRIES, 600, true);
      FastFood fastFood3 = new FastFood("Pizza Margherita", FastFoodCategory.PIZZA, 1000, true);

      fastFood.add(fastFood1);
      fastFood.add(fastFood2);
      fastFood.add(fastFood3);

      Collections.sort(fastFood);
      fastFood.forEach(System.out::println);
      System.out.println();

      Shop<FastFood> shop = new Shop<>("Burger Queen", new HashMap<>());
      shop.addProduct(fastFood1);
      shop.addProduct(fastFood2);
      shop.addProduct(fastFood3);
      shop.addProduct(fastFood1);

      try {
         shop.rateProduct(fastFood1, 4);
         shop.rateProduct(fastFood1, 3);
         shop.rateProduct(fastFood1, 5);
         shop.rateProduct(fastFood3, 1);
         shop.rateProduct(fastFood3, 2);
         // shop.rateProduct(fastFood2, 10);
         // shop.rateProduct(fastFood2, 0);
         // shop.rateProduct(new FastFood("VeggieBurger", FastFoodCategory.BURGER, 500, true), 3);
      } catch (NoProductFoundException | InvalidRatingException e) {
         e.printStackTrace();
      }

      shop.assortment().forEach((p, rs) -> System.out.println(p + ": " + rs));
      System.out.println();

      Optional<FastFood> bestRatedProduct = shop.getBestRatedProduct();
      bestRatedProduct.ifPresent(System.out::println);
      System.out.println();

      shop.getAllProductsSortedByNaturalOrdering().forEach(System.out::println);
   }

}
