package fr.ecp.IS1220.project.MyFoodora.core.menu;

import java.util.HashSet;
import java.util.Set;

public class Menu {
	// Set lists don't allow doubles
	Set<Item> items = new HashSet<Item>();
	Set<Meal> meals = new HashSet<Meal>();

	public void addItem(Item item) {
		items.add(item);
	}
	public void addMeal(Meal meal) {
		
		for(Item item:meal.getItems()){
			items.add(item);}
		meals.add(meal);
	}

}
