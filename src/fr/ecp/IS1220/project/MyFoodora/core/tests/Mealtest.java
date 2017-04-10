package fr.ecp.IS1220.project.MyFoodora.core.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.ecp.IS1220.project.MyFoodora.core.Restaurant;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Dessert;
import fr.ecp.IS1220.project.MyFoodora.core.menu.FullMeal;
import fr.ecp.IS1220.project.MyFoodora.core.menu.HalfMeal;
import fr.ecp.IS1220.project.MyFoodora.core.menu.MainDish;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Starter;

public class Mealtest {
	public static Restaurant restaurant = new Restaurant("Le RU", "ru", 15, 25);
	public static Dessert chocolat = new Dessert("Chocolat", 2, true, false);
	public static MainDish pates = new MainDish("pates", 3, true, true);
	public static Starter saucisson = new Starter("saucisson", 5, false, true);
	public static FullMeal plat1 = new FullMeal("plat1", saucisson, pates, chocolat);
	public static HalfMeal plat2 = new HalfMeal("plat2", pates, chocolat);
	public static HalfMeal plat3 = new HalfMeal("plat3", saucisson, pates);

	@Test
	public void testGetPrice() {
		restaurant.addMeal(plat1);
		restaurant.addMeal(plat2);
		restaurant.addMeal(plat3);
		
		System.out.println(plat1.getMenu());
		System.out.println(restaurant.getMenu());
		
		System.out.println(plat1.getPrice());
		assertEquals(plat1.getPrice(), 9.5, 0.001);
		assertEquals(plat2.getPrice(), 4.75, 0.001);
		assertEquals(plat3.getPrice(), 7.2, 0.001);
	}

	@Test
	public void testIsVegetarian() {
		assertFalse(plat1.isVegetarian());
		assertTrue(plat2.isVegetarian());
		assertFalse(plat3.isVegetarian());
	}

	@Test
	public void testIsGlutenFree() {
		assertFalse(plat1.isGlutenFree());
		assertTrue(plat3.isGlutenFree());
		assertFalse(plat2.isGlutenFree());
	}

}
