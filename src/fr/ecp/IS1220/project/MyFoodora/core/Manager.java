package fr.ecp.IS1220.project.MyFoodora.core;

import java.util.ArrayList;
import java.util.HashMap;

import fr.ecp.IS1220.project.MyFoodora.core.policy.DeliveryPolicy;

public class Manager extends User {
	private String surname;
	
	
	public Manager(String name, String surname, String username) {
		super(name,username);
		this.surname = surname;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void addUser(User user) {
		myFoodora.addUser(user);
		user.myFoodora = myFoodora;
	}
	
	public void removeUser(User user) {
		myFoodora.removeUser(user);
		user.myFoodora = null;
	}
	
	public void activate(User user) {
		myFoodora.activateUser(user);
	}
	
	public void disactivate(User user) {
		myFoodora.activateUser(user);
	}
	
	public void setServiceFee(double serviceFee) {
		myFoodora.setServiceFee(serviceFee);
	}
	
	public void setMarkupPourcentage(double markupPourcentage) {
		this.myFoodora.setMarkupPourcentage(markupPourcentage);
	}
	
	public void setDeliveryCost(double deliveryCost) {
		this.myFoodora.setDeliveryCost(deliveryCost);
	}
	
	public double computeIncome(Time begin, Time end) {
		double income = 0;
		for ( Order order : myFoodora.getCompletedOrder_List()) {
			if (order.getOrderDate().compareTo(begin)>0 && order.getOrderDate().compareTo(end)<0) {
				income += order.getPrice()*order.getMarkupPourcentage()+order.getServiceFee();
			}
		}
		return income;
	}
	
	public double computeProfit(Time begin, Time end) {
		double profit = 0;
		for ( Order order : myFoodora.getCompletedOrder_List()) {
			if (order.getOrderDate().compareTo(begin)>0 && order.getOrderDate().compareTo(end)<0) {
				profit += order.getPrice()*order.getMarkupPourcentage()+order.getServiceFee()-order.getDeliveryCost();
			}
		}
		return profit;
	}
	public double computeAverageIncome(Time begin, Time end) {
		double income = 0;
		ArrayList<Long> customerList = new ArrayList<Long>();
		for ( Order order : myFoodora.getCompletedOrder_List()) {
			if (order.getOrderDate().compareTo(begin)>0 && order.getOrderDate().compareTo(end)<0) {
				income += order.getPrice()*order.getMarkupPourcentage()+order.getServiceFee();
				if (!customerList.contains(order.getCustomer().getiD())) {
					customerList.add(order.getCustomer().getiD());
				}
			}
		}
		return income/customerList.size();
	}
	
	public double computeAverageProfit(Time begin, Time end) {
		double profit = 0;
		ArrayList<Long> customerList = new ArrayList<Long>();
		for ( Order order : myFoodora.getCompletedOrder_List()) {
			if (order.getOrderDate().compareTo(begin)>0 && order.getOrderDate().compareTo(end)<0) {
				profit += order.getPrice()*order.getMarkupPourcentage()+order.getServiceFee()-order.getDeliveryCost();
				if (!customerList.contains(order.getCustomer().getiD())) {
					customerList.add(order.getCustomer().getiD());
				}
			}
		}
		return profit/customerList.size();
	}
	
	public void targetProfit(double profit) {
		myFoodora.getTargetPolicy().setParameters(myFoodora, profit);
	}
	
	public long mostSellingRestaurant() {
		HashMap<Long, Double> restaurantSell = new HashMap<Long, Double>();
		for (Order order : myFoodora.getCompletedOrder_List()) {
			long id = order.getRestaurant().getiD();
			if (restaurantSell.containsKey(id)) {
				restaurantSell.put(id, restaurantSell.get(id)+order.getPrice());
			}
			restaurantSell.put(id, order.getPrice());
		}
		long idm = -1;
		double m = -1;
		for (Long id : restaurantSell.keySet()) {
			if (idm <0 || restaurantSell.get(id) > m) {
				m = restaurantSell.get(id);
				idm = id;
			}
		}
		return idm;
	}
	
	public long leastSellingRestaurant() {
		HashMap<Long, Double> restaurantSell = new HashMap<Long, Double>();
		for (Order order : myFoodora.getCompletedOrder_List()) {
			long id = order.getRestaurant().getiD();
			if (restaurantSell.containsKey(id)) {
				restaurantSell.put(id, restaurantSell.get(id)+order.getPrice());
			}
			restaurantSell.put(id, order.getPrice());
		}
		long idm = -1;
		double m = -1;
		for (Long id : restaurantSell.keySet()) {
			if (idm < 0 || restaurantSell.get(id) < m) {
				m = restaurantSell.get(id);
				idm = id;
			}
		}
		return idm;
	}
	
	public long mostActiveCourier() {
		return myFoodora.mostActiveCourier().getiD();
	}
	
	public long leastActiveCourier() {
		return myFoodora.leastActiveCourier().getiD();
	}
	
	public void setDeliveryPolicy(DeliveryPolicy deliveryPolicy) {
		myFoodora.setDeliveryPolicy(deliveryPolicy);
	}


}
