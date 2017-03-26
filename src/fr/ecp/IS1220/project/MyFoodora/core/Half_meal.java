package fr.ecp.IS1220.project.MyFoodora.core;

public class Half_meal extends Meal{
	
	
	public Half_meal(Starter entry, Main_dish main, boolean mealOfTheWeek ) {
		super(mealOfTheWeek);
		this.setEntry(entry);
		this.setMain(main);
		
	}
	
	public Half_meal(Main_dish main, Dessert dessert, boolean mealOfTheWeek ) {
		super(mealOfTheWeek);
		this.setDessert(dessert);
		this.setMain(main);
		
	}

}
