package fr.ecp.IS1220.project.MyFoodora.core.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.ecp.IS1220.project.MyFoodora.core.MyFoodora;
import fr.ecp.IS1220.project.MyFoodora.core.Restaurant;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Dessert;
import fr.ecp.IS1220.project.MyFoodora.core.menu.FullMeal;
import fr.ecp.IS1220.project.MyFoodora.core.menu.HalfMeal;
import fr.ecp.IS1220.project.MyFoodora.core.menu.MainDish;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Starter;

public class RestaurantTest {
	static MyFoodora foodora = new MyFoodora(0.1, 0.1, 0.1);
	static Restaurant Macdo = new Restaurant("MacDonald", "macdonald", 15, -20);
	static MainDish Drink = new MainDish("Drink", 0.5, true, true);
	static MainDish BigMac = new MainDish("BigMac", 5, false, false);
	static Starter Salad = new Starter("Salad", 1, true, true);
	static Dessert MacFlurry = new Dessert("McFlurry", 2, true, false);
	static FullMeal F1 = new FullMeal("F1", Salad, BigMac, MacFlurry);
	static HalfMeal F2 = new HalfMeal("F2", Salad, Drink);
	
	@Before
	public void initialize(){
		foodora.addUser(Macdo);
		//Macdo.addMeal(F1);
		//Macdo.addMeal(F2);
	}
	
	@Test
	public void testAddItem() {
		Macdo.addItem(Salad);
		assertTrue(Macdo.getMenu().getItems().contains(Salad));
	}

	@Test
	public void testAddMeal() {
		Macdo.addMeal(F1);
		assertTrue(Macdo.getMenu().getMeals().contains(F1));
	}

	@Test
	public void testMealOfTheWeek() {
		Macdo.addMealOfTheWeek(F1);
		assertTrue(Macdo.getMealsOfTheWeek().contains(F1));
	}

	@Test
	public void testRemoveMealOfTheWeek() {
		Macdo.addMealOfTheWeek(F1);
		assertTrue(Macdo.getMealsOfTheWeek().contains(F1));
		Macdo.removeMealOfTheWeek(F1);
		assertTrue(!Macdo.getMealsOfTheWeek().contains(F1));
	}

}
