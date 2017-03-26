package fr.ecp.IS1220.project.MyFoodora.core;

public class Full_meal extends Meal{
	

	public Full_meal(Starter entry, Main_dish main, Dessert dessert, boolean mealOfTheWeek ) {
		super(mealOfTheWeek);
		this.setDessert(dessert);
		this.setEntry(entry);
		this.setMain(main);
		
	}


}
