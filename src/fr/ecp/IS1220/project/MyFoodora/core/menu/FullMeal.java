package fr.ecp.IS1220.project.MyFoodora.core.menu;

public class FullMeal extends Meal {

	public FullMeal(String name, Starter entry, MainDish main, Dessert dessert) {
		super(name);
		this.setDessert(dessert);
		this.setEntry(entry);
		this.setMain(main);

	}

}
