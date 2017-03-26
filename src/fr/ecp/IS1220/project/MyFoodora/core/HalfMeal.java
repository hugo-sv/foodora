package fr.ecp.IS1220.project.MyFoodora.core;

public class HalfMeal extends Meal{
	
	
	public HalfMeal(String name, Starter entry, MainDish main, boolean mealOfTheWeek ) {
		super(name, mealOfTheWeek);
		this.setEntry(entry);
		this.setMain(main);
		
	}
	
	public HalfMeal(String name, MainDish main, Dessert dessert, boolean mealOfTheWeek ) {
		super(name, mealOfTheWeek);
		this.setDessert(dessert);
		this.setMain(main);
		
	}

}
