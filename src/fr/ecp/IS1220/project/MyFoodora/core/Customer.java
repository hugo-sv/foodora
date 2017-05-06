package fr.ecp.IS1220.project.MyFoodora.core;

import java.util.ArrayList;

import fr.ecp.IS1220.project.MyFoodora.core.cards.BasicFidelityCard;
import fr.ecp.IS1220.project.MyFoodora.core.cards.FidelityCard;

public class Customer extends User {
	private String surname;
	private FidelityCard fidelityCard = new BasicFidelityCard();
	private ArrayList<Order> completedOrders = new ArrayList<Order>();
	private ArrayList<Order> currentOrders = new ArrayList<Order>();
	private String notifyMean;
	

	// Constructor
	public Customer(String name, String surname, String username, double addressX, double addressY, String email,
			String phoneNumber) {
		super(name, username, addressX, addressY);
		this.surname = surname;
		setEmail(email);
		setPhoneNumber(phoneNumber);
		notifyMean = email;
	}

	public Customer(String name, String surname, String username, double addressX, double addressY) {
		super(name, username, addressX, addressY);
		this.surname = surname;
	}

	public String getAccountInfo() {
		String info = new String();
		info += "Name : " + getName() + "\nSurname : " + surname + "\nEmail : " + getEmail() + "\nPhone number : "
				+ getPhoneNumber() + "\nFidelity card : " + fidelityCard.toString() + "\nOrders :\n";
		for (Order o : completedOrders) {
			info += o.toString();
			info += "\n";
		}
		return info;
	}

	public void notify(String message) {
		// Sending Offer
		if (getNotifyMean() != null) {
			System.out.println("Message sent to " + getName() + "'s " + getNotifyMean() + " :");
			System.out.println(message);
		}
	}

	public void register() {
		myFoodora.registerObserver(this);
	}

	public void unregister() {
		myFoodora.unregisterObserver(this);
	}

	public void payOrder(Order order) {
		double price = order.getPrice() * (1 + order.getMarkupPourcentage()) + order.getServiceFee();
		System.out.println(order.getCustomer() + " : paid " + price);
		myFoodora.give(order);
		order.setOrderDate();
		// Once the order is paid
		completedOrders.add(order);
		currentOrders.remove(order);
	}

	// Getters an setters

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public ArrayList<Order> getOrders() {
		return completedOrders;
	}

	public FidelityCard getFidelityCard() {
		return fidelityCard;
	}

	public void setFidelityCard(FidelityCard fidelityCard) {
		this.fidelityCard = fidelityCard;
	}

	public String getNotifyMean() {
		return notifyMean;
	}

	public void setNotifyMean(String notifyMean) {
		this.notifyMean = notifyMean;
	}
	
	public void addOrder(Order order) {
		currentOrders.add(order);
	}

	public ArrayList<Order> getCurrentOrders() {
		return currentOrders;
	}
	
	@Override
	public String toString() {
		return getName()+" "+getSurname();
	}

}
