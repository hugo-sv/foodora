package fr.ecp.IS1220.project.MyFoodora.core;

import java.util.ArrayList;

public class MyFoodora {
	private ArrayList<Manager> managerList;
	private ArrayList<Customer> customerList;
	private ArrayList<Restaurant> restaurantList;
	private ArrayList<Courier> courierList;
	private ArrayList<Order> completedOrder_List;
	private double serviceFee;
	private double markupPourcentage;
	private double deliveryCost;
	public MyFoodora(double serviceFee, double markupPourcentage, double deliveryCost) {
		super();
		this.serviceFee = serviceFee;
		this.markupPourcentage = markupPourcentage;
		this.deliveryCost = deliveryCost;
		this.managerList = new ArrayList<Manager>();
		this.customerList = new ArrayList<Customer>();
		this.restaurantList = new ArrayList<Restaurant>();
		this.courierList = new ArrayList<Courier>();
		this.completedOrder_List = new ArrayList<Order>();
	}
	
	public void addManager(Manager manager) {
		managerList.add(manager);
	}
	
	public void removeManager(Manager manager) {
		managerList.remove(manager);
	}
	
	public void addCustomer(Customer customer) {
		customerList.add(customer);
	}
	
	public void removeCustomer(Customer customer) {
		customerList.remove(customer);
	}
	
	public void addRestaurant(Restaurant restaurant) {
		restaurantList.add(restaurant);
	}
	
	public void removeRestaurant(Restaurant restaurant) {
		restaurantList.remove(restaurant);
	}
	
	
}