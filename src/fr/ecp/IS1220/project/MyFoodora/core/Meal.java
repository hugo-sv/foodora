package fr.ecp.IS1220.project.MyFoodora.core;

public abstract class Meal {
	private Dessert dessert;
	private Starter entry;
	private Main_dish main;
	private boolean mealOfTheWeek;
	
	public Meal(boolean mealOfTheWeek) {
		this.mealOfTheWeek = mealOfTheWeek;
		dessert = null;
		entry = null;
		main = null;
	}
	
	public Dessert getDessert() {
		return dessert;
	}

	public void setDessert(Dessert dessert) {
		this.dessert = dessert;
	}

	public Starter getEntry() {
		return entry;
	}

	public void setEntry(Starter entry) {
		this.entry = entry;
	}

	public Main_dish getMain() {
		return main;
	}

	public void setMain(Main_dish main) {
		this.main = main;
	}

	public boolean isMealOfTheWeek() {
		return mealOfTheWeek;
	}

	public void setMealOfTheWeek(boolean mealOfTheWeek) {
		this.mealOfTheWeek = mealOfTheWeek;
	}

	abstract double get_price();
	
	abstract boolean is_vegie();
			
}
