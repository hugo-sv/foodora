package fr.ecp.IS1220.project.MyFoodora.core;

public class FullMeal extends Meal {

	public FullMeal(String name, Starter entry, MainDish main, Dessert dessert, boolean mealOfTheWeek) {
		super(name, mealOfTheWeek);
		this.setDessert(dessert);
		this.setEntry(entry);
		this.setMain(main);

	}

}
