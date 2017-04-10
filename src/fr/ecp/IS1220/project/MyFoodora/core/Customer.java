package fr.ecp.IS1220.project.MyFoodora.core;

import java.util.ArrayList;

import fr.ecp.IS1220.project.MyFoodora.core.cards.BasicFidelityCard;
import fr.ecp.IS1220.project.MyFoodora.core.cards.FidelityCard;

public class Customer extends User {
	private String surname;
	private FidelityCard fidelityCard = new BasicFidelityCard();
	private ArrayList<Order> orders = new ArrayList<Order>();
	private String notifyMean;

	// Constructor
	public Customer(String name, String surname, String username, double addressX, double addressY, String email,
			String phoneNumber) {
		super(name, surname, addressX, addressY);
		this.surname = surname;
		setEmail(email);
		setPhoneNumber(phoneNumber);
		notifyMean = email;
	}
	public Customer(String name, String surname, String username, double addressX, double addressY) {
		super(name, surname, addressX, addressY);
		this.surname = surname;
	}

	public String getAccountInfo() {
		String info = new String();
		info += "Name : " + getName() + "/nSurname : " + surname + "/nEmail : " + getEmail() + "/nPhone number : " + getPhoneNumber()
				+ "/nFidelity card : " + fidelityCard.toString() + "/nOrders :/n";
		for (Order o : orders) {
			info += o.toString();
			info += "/n";
		}
		return info;
	}

	public void notify(String message) {
		// Sending Offer
		if (getNotifyMean() != null) {
			System.out.println("Offer sent to " + getNotifyMean() + " :");
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
		double price = order.getPrice()*(1+order.getMarkupPourcentage())+order.getServiceFee();
		System.out.println(order.getCustomer()+" : paid"+price);
		myFoodora.give(order);
		// Once the order is paid
		orders.add(order);
	}

	// Getters an setters


	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public ArrayList<Order> getOrders() {
		return orders;
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
	
	

}
