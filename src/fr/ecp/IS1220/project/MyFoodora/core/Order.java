package fr.ecp.IS1220.project.MyFoodora.core;

public class Order {
	private static int genID = 0;
	private int ID;
	private Customer customer;
	private Restaurant restaurant;
	private Courier courier;
	private int price;
	public Order(Customer customer, Restaurant restaurant, Courier courier, int price) {
		super();
		this.ID = genID;
		genID++;
		this.customer = customer;
		this.restaurant = restaurant;
		this.courier = courier;
		this.price = price;
	}
	public int getID() {
		return ID;
	}
	public Customer getCustomer() {
		return customer;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public Courier getCourier() {
		return courier;
	}
	public int getPrice() {
		return price;
	}
	
	
}
