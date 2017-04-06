package fr.ecp.IS1220.project.MyFoodora.core;

import fr.ecp.IS1220.project.MyFoodora.core.menu.Meal;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Menu;

public class Restaurant extends User {
	private static long genID = 0;
	private long iD;
	private String name;
	private String username;
	private double addressX;
	private double addressY;
	private Menu restaurantMenu;
	private Meal mealOfTheWeek;
	private float genericDiscountFactor;
	private float specialDiscountFactor;

	public Restaurant(String name, String username, double addressX, double addressY) {
		super();
		this.name = name;
		this.username = username;
		this.addressX = addressX;
		this.addressY = addressY;
		this.restaurantMenu = new Menu();
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

	public double getAddressX() {
		return addressX;
	}

	public void setAddressX(double addressX) {
		this.addressX = addressX;
	}

	public double getAddressY() {
		return addressY;
	}

	public void setAddressY(double addressY) {
		this.addressY = addressY;
	}

	public Menu getRestaurantMenu() {
		return restaurantMenu;
	}

	public Meal getMealOfTheWeek() {
		return mealOfTheWeek;
	}

	public void setMealOfTheWeek(Meal mealOfTheWeek) {
		this.mealOfTheWeek = mealOfTheWeek;
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
