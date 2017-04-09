package fr.ecp.IS1220.project.MyFoodora.core;

import java.util.ArrayList;

import fr.ecp.IS1220.project.MyFoodora.core.menu.Item;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Meal;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Menu;

public class Restaurant extends User {
	private String name;
	private String username;
	private Menu menu;
	// At least one meal amongst those offered by a restaurant is offered as a
	// meal-of-the-week special offer
	private ArrayList<Meal> mealsOfTheWeek;
	private float genericDiscountFactor=(float) 0.05;
	private float specialDiscountFactor=(float) 0.95;

	public Restaurant(String name, String username, double addressX, double addressY) {
		super(addressX, addressY);
		this.name = name;
		this.username = username;
		this.setAddressX(addressX);
		this.setAddressY(addressY);
		this.menu = new Menu(this);
	}

	public void addItem(Item item) {
		menu.addItem(item);
	}

	public void addMeal(Meal meal) {
		menu.addMeal(meal);
		// this.menu = new Menu();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

}
