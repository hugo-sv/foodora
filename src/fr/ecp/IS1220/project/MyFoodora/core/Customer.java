package fr.ecp.IS1220.project.MyFoodora.core;

import java.util.ArrayList;

import fr.ecp.IS1220.project.MyFoodora.core.cards.FidelityCard;

public class Customer extends User {
	// have a name, a surname, a unique ID, an address (expressed as a two
	// dimensional co-ordinate), an email address, a phone number and a
	// username, the
	// latter used for logging in the system.
	private ArrayList<Order> orders = new ArrayList<Order>();
	private String name;
	private String surname;
	private String username;
	private String email;
	private String phoneNumber;
	private FidelityCard fidelityCard;

	public Customer(String name, String surname, String username, double addressX, double addressY, String email,
			String phoneNumber) {
		super(addressX, addressY);
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public double getPrice() {
		double Price = 0;
		for (Order v : orders) {
			Price = Price + v.getPrice();
		}
		return Price;
	}

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