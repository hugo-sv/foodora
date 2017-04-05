package fr.ecp.IS1220.project.MyFoodora.core;

import java.util.ArrayList;
import java.util.HashMap;

import fr.ecp.IS1220.project.MyFoodora.core.policy.TargetPolicy;

public class MyFoodora {
	private HashMap<Long,Manager> managerList;
	private HashMap<Long,Customer> customerList;
	private HashMap<Long,Restaurant> restaurantList;
	private HashMap<Long,Courier> courierList;
	private ArrayList<Order> completedOrder_List;
	private double serviceFee;
	private double markupPourcentage;
	private double deliveryCost;
	private TargetPolicy targetPolicy;
	
	public MyFoodora(double serviceFee, double markupPourcentage, double deliveryCost) {
		super();
		this.serviceFee = serviceFee;
		this.markupPourcentage = markupPourcentage;
		this.deliveryCost = deliveryCost;
		this.managerList = new HashMap<Long,Manager>();
		this.customerList = new HashMap<Long,Customer>();
		this.restaurantList = new HashMap<Long,Restaurant>();
		this.courierList = new HashMap<Long,Courier>();
		this.completedOrder_List = new ArrayList<Order>();
	}
	
	public void addManager(Manager manager) {
		managerList.put(manager.getiD(), manager);
	}
	
	public void removeManager(Manager manager) {
		managerList.remove(manager.getiD());
	}
	
	public void addCustomer(Customer customer) {
		customerList.put(customer.getiD(),customer);
	}
	
	public void removeCustomer(Customer customer) {
		customerList.remove(customer.getiD());
	}
	
	public void addRestaurant(Restaurant restaurant) {
		restaurantList.put(restaurant.getiD(), restaurant);
	}
	
	public void removeRestaurant(Restaurant restaurant) {
		restaurantList.remove(restaurant.getiD());
	}
	
	public void addCourier(Courier courier) {
		courierList.put(courier.getiD(), courier);
	}
	
	public void removeCourier(Courier courier) {
		courierList.remove(courier.getiD());
	}
	
}