package fr.ecp.IS1220.project.MyFoodora.core;

public abstract class Item {
	private String name;
	private double price;
	private boolean vegetarian;
	private boolean gluten_free;

	public Item(String name, double price, boolean vegetarian, boolean gluten_free) {
		super();
		this.name = name;
		this.price = price;
		this.vegetarian = vegetarian;
		this.gluten_free = gluten_free;
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

	public boolean isGluten_free() {
		return gluten_free;
	}

	public void setGluten_free(boolean gluten_free) {
		this.gluten_free = gluten_free;
	}

	@Override
	public String toString() {
		return "Item [Price=" + price + ", vegetarian=" + vegetarian + ", gluten_free=" + gluten_free + "]";
	}

}
