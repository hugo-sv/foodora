package fr.ecp.IS1220.project.MyFoodora.core.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fr.ecp.IS1220.project.MyFoodora.core.Restaurant;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Dessert;
import fr.ecp.IS1220.project.MyFoodora.core.menu.HalfMeal;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Item;
import fr.ecp.IS1220.project.MyFoodora.core.menu.MainDish;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Meal;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Menu;

public class MenuTest {
	public static Restaurant restaurant = new Restaurant("Le RU", "ru", 15, 25);
	public static Menu menu = new Menu(restaurant);
	@Test
	public void testAddItem() {
		Item dessert = new Dessert("Gâteau", 15, true, false);
		menu.addItem(dessert);
		assertTrue(dessert.getMenu().equals(menu));
		assertTrue(menu.getItems().contains(dessert));
	}

	@Test
	public void testAddMeal() {
		MainDish main = new MainDish("Steak", 25, false, true);
		Dessert dessert = new Dessert("Gâteau", 15, true, false);
		Meal meal = new HalfMeal("menunul", main, dessert);
		menu.addMeal(meal);
		assertTrue(meal.getMenu().equals(menu));
		assertTrue(menu.getMeals().contains(meal));
	}

	@Test
	public void testRemoveItem() {
		ArrayList<Item> itemList = new ArrayList<Item>();
		for (Item item : menu.getItems()) {
			itemList.add(item);
		}
		for (Item item : itemList) {
			menu.removeItem(item);
		}
		assertTrue(menu.getItems().isEmpty());
		
	}

	@Test
	public void testRemoveMeal() {
		ArrayList<Meal> mealList = new ArrayList<Meal>();
		for (Meal meal : menu.getMeals()) {
			mealList.add(meal);
		}
		for (Meal meal : mealList) {
			menu.removeMeal(meal);
		}
		assertTrue(menu.getMeals().isEmpty());
	}

	@Test
	public void testRemoveMealAndItems() {
		MainDish main = new MainDish("Steak", 25, false, true);
		Dessert dessert = new Dessert("Gâteau", 15, true, false);
		Meal meal = new HalfMeal("menunul", main, dessert);
		menu.addMeal(meal);
		menu.removeMealAndItems(meal);
		assertTrue(menu.getMeals().isEmpty());
		assertTrue(menu.getItems().isEmpty());
		
		
	}

	@Test
	public void testGetRestaurant() {
		assertTrue(menu.getRestaurant().equals(restaurant));
	}

	@Test
	public void testSetRestaurant() {
		Restaurant restaurant2 = new Restaurant("La Neb", "neb" , 25, 48);
		menu.setRestaurant(restaurant2);
		assertTrue(menu.getRestaurant().equals(restaurant2));
	}

	@Test
	public void testGetItems() {
		MainDish main = new MainDish("Steak", 25, false, true);
		Dessert dessert = new Dessert("Gâteau", 15, true, false);
		menu.addItem(dessert);
		menu.addItem(main);
		assertTrue(menu.getItems().contains(dessert));
		assertTrue(menu.getItems().contains(main));
		
	}

	@Test
	public void testGetMeals() {
		MainDish main = new MainDish("Steak", 25, false, true);
		Dessert dessert = new Dessert("Gâteau", 15, true, false);
		Meal meal = new HalfMeal("menunul", main, dessert);
		menu.addMeal(meal);
		assertTrue(menu.getMeals().contains(meal));
	}

}
