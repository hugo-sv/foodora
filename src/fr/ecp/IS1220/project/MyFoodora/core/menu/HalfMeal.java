package fr.ecp.IS1220.project.MyFoodora.core.menu;

public class HalfMeal extends Meal{
	
	
	public HalfMeal(String name, Starter entry, MainDish main) {
		super(name);
		this.setEntry(entry);
		this.setMain(main);
		
	}
	
	public HalfMeal(String name, MainDish main, Dessert dessert) {
		super(name);
		this.setDessert(dessert);
		this.setMain(main);
		
	}

}
