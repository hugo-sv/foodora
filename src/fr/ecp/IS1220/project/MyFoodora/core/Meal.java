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

	double getPrice() {
		double price = 0;
		if (entry != null) {
			price += entry.getPrice();
		}
		if (main != null) {
			price += main.getPrice();
		}
		if (dessert != null) {
			price += dessert.getPrice();
		}
		if (mealOfTheWeek) {
			price = 0.9 * price;
		} else {
			price = 0.95 * price;
		}
		return price;
	}
	
	double getPrice(double discountFactor) {
		double price = 0;
		if (entry != null) {
			price += entry.getPrice();
		}
		if (main != null) {
			price += main.getPrice();
		}
		if (dessert != null) {
			price += dessert.getPrice();
		}
		if (mealOfTheWeek) {
			price = discountFactor * price;
		} else {
			price = 0.95 * price;
		}
		return price;
	}
	
	boolean isVegetarian() {
		boolean v = true;
		if (entry != null) {
			v = v && entry.isVegetarian();
		}
		if (main != null) {
			v = v && main.isVegetarian();
		}
		if (dessert != null) {
			v = v && dessert.isVegetarian();
		}
		return v;
	}
	
	boolean isGlutenFree() {
		boolean g = true;
		if (entry != null) {
			g = g && entry.isGluten_free();
		}
		if (main != null) {
			g = g && main.isGluten_free();
		}
		if (dessert != null) {
			g = g && dessert.isGluten_free();
		}
		return g;
	}
			
}
