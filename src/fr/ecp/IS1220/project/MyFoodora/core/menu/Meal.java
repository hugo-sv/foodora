package fr.ecp.IS1220.project.MyFoodora.core.menu;

import java.util.ArrayList;

public abstract class Meal implements Orderable {
	private String name;
	private Dessert dessert;
	private Starter entry;
	private MainDish main;
	private Menu menu;

	public Meal(String name) {
		this.name = name;
		dessert = null;
		entry = null;
		main = null;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public MainDish getMain() {
		return main;
	}

	public void setMain(MainDish main) {
		this.main = main;
	}

	public double getPrice() {
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
		menu.getRestaurant();
		return price * (1 - menu.getRestaurant().getGenericDiscountFactor());
	}

	public boolean isVegetarian() {
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

	public boolean isGlutenFree() {
		boolean g = true;
		if (entry != null) {
			g = g && entry.isGlutenFree();
		}
		if (main != null) {
			g = g && main.isGlutenFree();
		}
		if (dessert != null) {
			g = g && dessert.isGlutenFree();
		}
		return g;
	}

	public ArrayList<Item> getItems() {
		// Return a list of meal's items
		ArrayList<Item> items = new ArrayList<Item>();
		if (entry != null) {
			items.add(entry);
		}
		if (main != null) {
			items.add(main);
		}
		if (dessert != null) {
			items.add(dessert);
		}
		return items;
	}

	@Override
	public String toString() {
		return name+" :\n - "+entry.getName()+"\n - "+main.getName()+"\n - "+dessert.getName();
	}

}
