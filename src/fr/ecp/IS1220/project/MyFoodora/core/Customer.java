package fr.ecp.IS1220.project.MyFoodora.core;

import java.util.ArrayList;

import fr.ecp.IS1220.project.MyFoodora.core.cards.BasicFidelityCard;
import fr.ecp.IS1220.project.MyFoodora.core.cards.FidelityCard;

public class Customer extends User {
	private String name;
	private String surname;
	private String username;
	private String email;
	private String phoneNumber;
	private FidelityCard fidelityCard = new BasicFidelityCard();
	private ArrayList<Order> orders = new ArrayList<Order>();

	// Constructor
	public Customer(String name, String surname, String username, double addressX, double addressY, String email,
			String phoneNumber) {
		super(addressX, addressY);
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public void notify(String message) {
		// Sending Email
		System.out.println("Email sent to " + email + " :");
		System.out.println(message);
	}

	public void register() {
		myFoodora.registerObserver(this);
	}

	public void unregister() {
		myFoodora.unregisterObserver(this);
	}

	public void payOrder(Order order) {
		myFoodora.give(order.getPrice());
		// Once the order is paid
		orders.add(order);
	}

	// Getters an setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
