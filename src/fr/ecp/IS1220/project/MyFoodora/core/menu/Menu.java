package fr.ecp.IS1220.project.MyFoodora.core.menu;

import java.util.HashSet;
import java.util.Set;

public class Menu {
	// Set lists avoid doubles
	Set<Item> items = new HashSet<Item>();
	Set<Meal> meals = new HashSet<Meal>();

	public void addItem(Item item) {
		items.add(item);
	}

	public void addMeal(Meal meal) {
		// Add Meal's items to the item list
		for (Item item : meal.getItems()) {
			items.add(item);
		}
		meals.add(meal);
	}

	public void removeItem(Item item) {
		// Remove the item from the items set
		for (Meal meal : meals) {
			if (meal.getItems().contains(item)) {
				// The removed Item is used in a meal
				this.removeMeal(meal);
			}
		}
		if (items.contains(item)) {
			items.remove(item);
		}
	}

	public void removeMeal(Meal meal) {
		// Remove the meal from the meal set
		if (meals.contains(meal)) {
			meals.remove(meal);
		}
		// Meal's item are not removed
	}

}
