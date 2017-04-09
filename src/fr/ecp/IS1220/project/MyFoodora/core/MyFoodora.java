package fr.ecp.IS1220.project.MyFoodora.core;

import java.util.ArrayList;
import java.util.HashMap;

import fr.ecp.IS1220.project.MyFoodora.core.policy.DeliveryPolicy;
import fr.ecp.IS1220.project.MyFoodora.core.policy.TargetPolicy;

public class MyFoodora {
	private HashMap<Long, User> userList;
	private ArrayList<Order> completedOrder_List;
	private ArrayList<Order> currentOrder_List;
	private double serviceFee;
	private double markupPourcentage;
	private double deliveryCost;
	private TargetPolicy targetPolicy;
	private DeliveryPolicy deliveryPolicy;
	private ArrayList<Customer> observers;

	// Constructor
	public MyFoodora(double serviceFee, double markupPourcentage, double deliveryCost) {
		super();
		this.serviceFee = serviceFee;
		this.markupPourcentage = markupPourcentage;
		this.deliveryCost = deliveryCost;
		this.userList = new HashMap<Long, User>();
		this.completedOrder_List = new ArrayList<Order>();
		this.currentOrder_List = new ArrayList<Order>();
	}

	public void give(double price) {
		// Registered customers make their own selection and they are charged a
		// total fee which is cashed by MyFoodora and that includes also the
		// cost of delivery. The total fee is broken down into: 1) the price of
		// the order (which is set by each restaurant) plus 2) a service-fee
		// which is set by the MyFoodora manager. In order to guarantee an
		// income MyFoodora also apply a markup percentage (“percentage de
		// marge”) to the price of an order. The markup percentage represents
		// the percentage of money retained by MyFoodora from the price of an
		// order placed to a given restaurant. The MyFoodora system must. then
		// payback both the restaurants as well as the courriers. Restaurants
		// compile their own menus and may set up special offers. Once an order
		// is placed (and payed for) the system is in charge for managing the
		// delivery of the order, that is, the system will find an available
		// deliverer amongst a fleet of available couriers.
	}

	public void registerObserver(Customer c) {
		if (observers.contains(c)) {
			c.notify("You have already accepted to be notified whenever a new special offer is set by any restaurant");
		} else {
			observers.add(c);
			c.notify("You accepted to be notified whenever a new special offer is set by any restaurant");
		}
	}

	public void unregisterObserver(Customer c) {
		if (observers.contains(c)) {
			observers.remove(c);
			c.notify("You refused to be notified whenever a new special offer is set by any restaurant");
		} else {
			c.notify("You have already refused to be notified whenever a new special offer is set by any restaurant");
		}
	}
	
	public void notifyObservers(String message) {
		for (Customer c : observers) {
			c.notify(message);
		}
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
		for (Order order : completedOrder_List) {
			income += order.getPrice() * order.getMarkupPourcentage() + order.getServiceFee();
		}
		return income;
	}

	public double computeTotalProfit(Time begin, Time end) {
		double profit = 0;
		for (Order order : completedOrder_List) {
			profit += order.getPrice() * order.getMarkupPourcentage() + order.getServiceFee() - order.getDeliveryCost();
		}
		return profit;
	}

	public void setTargetPolicy(TargetPolicy targetPolicy) {
		this.targetPolicy = targetPolicy;
	}

	public TargetPolicy getTargetPolicy() {
		return targetPolicy;
	}

	public ArrayList<Courier> getCourierList() {
		ArrayList<Courier> courierList = new ArrayList<Courier>();
		for (User user : userList.values()) {
			if (user instanceof Courier) {
				courierList.add((Courier) user);
			}
		}
		return courierList;
	}

	public Courier mostActiveCourier() {
		HashMap<Long, Integer> activeCourier = new HashMap<Long, Integer>();
		for (Courier courier : getCourierList()) {
			activeCourier.put(courier.getiD(), 0);
		}
		for (Order order : getCompletedOrder_List()) {
			long id = order.getCourier().getiD();
			if (activeCourier.containsKey(id)) {
				activeCourier.put(id, activeCourier.get(id) + 1);
			}
			activeCourier.put(id, 1);
		}
		long idm = -1;
		double m = -1;
		for (Long id : activeCourier.keySet()) {
			if (idm < 0 || activeCourier.get(id) > m) {
				m = activeCourier.get(id);
				idm = id;
			}
		}
		return (Courier) userList.get(idm);
	}

	public Courier leastActiveCourier() {
		HashMap<Long, Integer> activeCourier = new HashMap<Long, Integer>();
		for (Courier courier : getCourierList()) {
			activeCourier.put(courier.getiD(), 0);
		}
		for (Order order : getCompletedOrder_List()) {
			long id = order.getCourier().getiD();
			if (activeCourier.containsKey(id)) {
				activeCourier.put(id, activeCourier.get(id) + 1);
			}
			activeCourier.put(id, 1);
		}
		long idm = -1;
		double m = -1;
		for (Long id : activeCourier.keySet()) {
			if (idm < 0 || activeCourier.get(id) < m) {
				m = activeCourier.get(id);
				idm = id;
			}
		}
		return (Courier) userList.get(idm);
	}

	public DeliveryPolicy getDeliveryPolicy() {
		return deliveryPolicy;
	}

	public void setDeliveryPolicy(DeliveryPolicy deliveryPolicy) {
		this.deliveryPolicy = deliveryPolicy;
	}

}