package fr.ecp.IS1220.project.MyFoodora.core.menu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import fr.ecp.IS1220.project.MyFoodora.core.Restaurant;

public class Menu {
	// Set lists avoid doubles
	private Set<Item> items = new HashSet<Item>();
	private Set<Meal> meals = new HashSet<Meal>();
	// Restaurant of the Menu
	private Restaurant restaurant;

	public Menu(Restaurant restaurant) {
		super();
		this.setRestaurant(restaurant);
	}

	public void addItem(Item item) {
		item.setMenu(this);
		items.add(item);
	}

	public void addMeal(Meal meal) {
		// Add Meal's items to the item list
		for (Item item : meal.getItems()) {
			this.addItem(item);
		}
		meal.setMenu(this);
		meals.add(meal);
	}

	public void removeItem(Item item) {
		// Remove the item from the items set
		ArrayList<Meal> mealToRemove = new ArrayList<Meal>();
		for (Meal meal : meals) {
			if (meal.getItems().contains(item)) {
				// The removed Item is used in a meal
				mealToRemove.add(meal);
			}
		}
		for (Meal meal : mealToRemove) {
			this.removeMeal(meal);
		}
		if (items.contains(item)) {
			items.remove(item);
			item.setMenu(null);
		}
	}

	public void removeMeal(Meal meal) {
		// Remove the meal from the meal set
		if (meals.contains(meal)) {
			meals.remove(meal);
			meal.setMenu(null);
		}
		// Meal's item are not removed
	}

	public void removeMealAndItems(Meal meal) {
		// Remove the meal from the meal set
		this.removeMeal(meal);
		for (Item item : meal.getItems()) {
			this.removeItem(item);
		}
		// Meal's item are not removed
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Set<Item> getItems() {
		return items;
	}

	public Set<Meal> getMeals() {
		return meals;
	}

}
