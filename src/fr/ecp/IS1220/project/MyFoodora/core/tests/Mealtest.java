package fr.ecp.IS1220.project.MyFoodora.core.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.ecp.IS1220.project.MyFoodora.core.Dessert;
import fr.ecp.IS1220.project.MyFoodora.core.FullMeal;
import fr.ecp.IS1220.project.MyFoodora.core.HalfMeal;
import fr.ecp.IS1220.project.MyFoodora.core.MainDish;
import fr.ecp.IS1220.project.MyFoodora.core.Starter;

public class Mealtest {
	Dessert chocolat = new Dessert("Chocolat", 2, true, false);
	MainDish pates = new MainDish("pates", 3, true, true);
	Starter saucisson = new Starter("saucisson", 5, false, true);

	FullMeal plat1 = new FullMeal("plat1",saucisson, pates, chocolat, true);
	HalfMeal plat2 = new HalfMeal("plat2",pates, chocolat, false);
	HalfMeal plat3 = new HalfMeal("plat3",saucisson, pates, true);

	@Test
	public void testIsMealOfTheWeek() {
		assertTrue(plat1.isMealOfTheWeek());
		assertFalse(plat2.isMealOfTheWeek());
		assertTrue(plat3.isMealOfTheWeek());
	}

	@Test
	public void testGetPrice() {
		assertEquals(plat1.getPrice(), 9,0.001);
		assertEquals(plat1.getPrice(0.5), 5,0.001);
		assertEquals(plat2.getPrice(),4.75,0.001);
		assertEquals(plat2.getPrice(0.5), 4.75,0.001);
		assertEquals(plat3.getPrice(), 7.2,0.001);
		assertEquals(plat3.getPrice(0.5), 4,0.001);
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
