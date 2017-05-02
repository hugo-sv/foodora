package fr.ecp.IS1220.project.MyFoodora.core;

import java.util.ArrayList;

import fr.ecp.IS1220.project.MyFoodora.core.menu.Item;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Meal;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Menu;

public class Restaurant extends User {
	private Menu menu;
	// At least one meal amongst those offered by a restaurant is offered as a
	// meal-of-the-week special offer
	private ArrayList<Meal> mealsOfTheWeek = new ArrayList<Meal>();
	private float genericDiscountFactor=(float) 0.05;
	private float specialDiscountFactor=(float) 0.1;

	public Restaurant(String name, String username, double addressX, double addressY) {
		super(name, username, addressX, addressY);
		this.setAddressX(addressX);
		this.setAddressY(addressY);
		this.menu = new Menu(this);
	}

	public void addItem(Item item) {
		menu.addItem(item);
	}

	public void addMeal(Meal meal) {
		menu.addMeal(meal);
	}

	public Menu getMenu() {
		return menu;
	}

	public ArrayList<Meal> getMealsOfTheWeek() {
		return mealsOfTheWeek;
	}

	public void addMealOfTheWeek(Meal meal) {
		if (!mealsOfTheWeek.contains(meal)) {
			mealsOfTheWeek.add(meal);
			//Add meal to the list of meals
			this.addMeal(meal);
			String message = new String("");
			message += "The restaurant " + this.getName() + " set a new offer : The " + meal.getName() + " gets a "
					+ this.getSpecialDiscountFactor() + " discount !";
			myFoodora.notifyObservers(message);
		}
	}
	
	public void removeMealOfTheWeek(Meal meal) {
		if (mealsOfTheWeek.contains(meal)) {
			mealsOfTheWeek.remove(meal);
			//Don't notify users
			//not removed from the meal list
		}
	}

	public float getGenericDiscountFactor() {
		return genericDiscountFactor;
	}

	public void setGenericDiscountFactor(float genericDiscountFactor) {
		this.genericDiscountFactor = genericDiscountFactor;
	}

	public float getSpecialDiscountFactor() {
		return specialDiscountFactor;
	}

	public void setSpecialDiscountFactor(float specialDiscountFactor) {
		this.specialDiscountFactor = specialDiscountFactor;
	}
	
	@Override
	public String toString() {
		return getName();
	}

}
