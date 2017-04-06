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

	public void addUser(User user) {
			userList.put(user.getiD(), user);
	}
	
	public void removeUser(User user) {
			userList.remove(user.getiD());
	}
	public void activateUser(User user) {
		if (userList.containsKey(user.getiD())) {
			user.setActivated(true);
		}
	}
	
	public void disactivateUser(User user) {
		if (userList.containsKey(user.getiD())) {
			user.setActivated(false);
		}
	}
	public void addCourier(Courier courier) {
		userList.put(courier.getiD(), courier);
	}
	
	public void removeCourier(Courier courier) {
		userList.remove(courier.getiD());
	}

	public double getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(double serviceFee) {
		this.serviceFee = serviceFee;
	}

	public double getMarkupPourcentage() {
		return markupPourcentage;
	}

	public void setMarkupPourcentage(double markupPourcentage) {
		this.markupPourcentage = markupPourcentage;
	}

	public double getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(double deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	public ArrayList<Order> getCompletedOrder_List() {
		return completedOrder_List;
	}

	public ArrayList<Order> getCurrentOrder_List() {
		return currentOrder_List;
	}
	
	public double computeTotalIncome(Time begin, Time end) {
		double income = 0;
		for ( Order order : completedOrder_List) {
			income += order.getPrice()*order.getMarkupPourcentage()+order.getServiceFee();
		}
		return income;
	}
	
	public double computeTotalProfit(Time begin, Time end) {
		double profit = 0;
		for ( Order order : completedOrder_List) {
			profit += order.getPrice()*order.getMarkupPourcentage()+order.getServiceFee()-order.getDeliveryCost();
		}
		return profit;
	}

	public void setTargetPolicy(TargetPolicy targetPolicy) {
		this.targetPolicy = targetPolicy;
	}

	public TargetPolicy getTargetPolicy() {
		return targetPolicy;
	}
	
	
}