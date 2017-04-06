package fr.ecp.IS1220.project.MyFoodora.core;

import java.util.ArrayList;

import fr.ecp.IS1220.project.MyFoodora.core.menu.Orderable;

public class Order {
	private static int genID = 0;
	private int ID;
	private Customer customer;
	private Restaurant restaurant;
	private Courier courier;
	private double serviceFee;
	private double markupPourcentage;
	private double deliveryCost;
	private ArrayList<Orderable> orderables;
	private Time orderDate;
	private Time deliverDate;
	
	public Time getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Time orderDate) {
		this.orderDate = orderDate;
	}

	public Time getDeliverDate() {
		return deliverDate;
	}

	public void setDeliverDate(Time deliverDate) {
		this.deliverDate = deliverDate;
	}

	public Order(Customer customer, Restaurant restaurant, Courier courier, double serviceFee,
			double markupPourcentage, double deliveryCost) {
		super();
		this.customer = customer;
		this.restaurant = restaurant;
		this.courier = courier;
		this.serviceFee = serviceFee;
		this.markupPourcentage = markupPourcentage;
		this.deliveryCost = deliveryCost;
	}
	
	public int getID() {
		return ID;
	}
	public Customer getCustomer() {
		return customer;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public Courier getCourier() {
		return courier;
	}
	public double getPrice() {
		double price=0;
		
		for orderables
		
		
		
		return price;
	}

	public double getServiceFee() {
		return serviceFee;
	}

	public double getMarkupPourcentage() {
		return markupPourcentage;
	}

	public double getDeliveryCost() {
		return deliveryCost;
	}
	
	
}
