package fr.ecp.IS1220.project.MyFoodora.core.menu;

public abstract class Item implements Orderable{
	private String name;
	private double price;
	private boolean vegetarian;
	private boolean glutenFree;
	private Menu menu;

	public Item(String name, double price, boolean vegetarian, boolean glutenFree) {
		super();
		this.name = name;
		this.price = price;
		this.vegetarian = vegetarian;
		this.glutenFree = glutenFree;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}
	
	public boolean isStandard() {
		return ! vegetarian;
	}

	public void setVegetarian(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}

	public boolean isGlutenFree() {
		return glutenFree;
	}

	public void setGluten_free(boolean glutenFree) {
		this.glutenFree = glutenFree;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + "]";
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	
}
