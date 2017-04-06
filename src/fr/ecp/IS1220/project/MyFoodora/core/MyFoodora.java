package fr.ecp.IS1220.project.MyFoodora.core;

import java.util.ArrayList;
import java.util.HashMap;

import fr.ecp.IS1220.project.MyFoodora.core.policy.TargetPolicy;

public class MyFoodora {
	private HashMap<Long,User> userList;
	private ArrayList<Order> completedOrder_List;
	private ArrayList<Order> currentOrder_List;
	private double serviceFee;
	private double markupPourcentage;
	private double deliveryCost;
	private TargetPolicy targetPolicy;
	
	public MyFoodora(double serviceFee, double markupPourcentage, double deliveryCost) {
		super();
		this.serviceFee = serviceFee;
		this.markupPourcentage = markupPourcentage;
		this.deliveryCost = deliveryCost;
		this.userList = new HashMap<Long,User>();
		this.completedOrder_List = new ArrayList<Order>();
		this.currentOrder_List = new ArrayList<Order>();
	}

	public void addUser(Manager manager, User user) {
		if (userList.containsKey(manager.getiD())) {
			userList.put(user.getiD(), user);
		}
	}
	
	public void removeUser(Manager manager, User user) {
		if (userList.containsKey(manager.getiD())) {
			userList.remove(user.getiD());
		}
	}
	
	public void addCourier(Courier courier) {
		userList.put(courier.getiD(), courier);
	}
	
	public void removeCourier(Courier courier) {
		userList.remove(courier.getiD());
	}
	
	
}