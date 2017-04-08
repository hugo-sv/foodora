package fr.ecp.IS1220.project.MyFoodora.core;

import java.util.ArrayList;

import fr.ecp.IS1220.project.MyFoodora.core.menu.Meal;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Orderable;

public class Order {
	private Customer customer;
	private Restaurant restaurant;
	private Courier courier;
	private double serviceFee;
	private double markupPourcentage;
	private double deliveryCost;
	private ArrayList<Orderable> orderables;
	private Time orderDate;
	private Time deliverDate;

	public Order(Customer customer, Restaurant restaurant, Courier courier, double price, double serviceFee,
			double markupPourcentage, double deliveryCost) {
		super();
		this.customer = customer;
		this.restaurant = restaurant;
		this.courier = courier;
		this.serviceFee = serviceFee;
		this.markupPourcentage = markupPourcentage;
		this.deliveryCost = deliveryCost;
		this.orderDate = Time.getTime();

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
		double mealPrice = 0;
		double itemPrice = 0;
		double mealOfTheWeekPrice = 0;
		for (Orderable o : orderables) {
			if (o instanceof Meal) {
				if (o.equals(restaurant.getMealOfTheWeek())) {
					mealOfTheWeekPrice += o.getPrice();
				} else {
					mealPrice = mealPrice + o.getPrice();
				}
			} else {
				itemPrice += o.getPrice();
			}
		}
		return customer.getFidelityCard().getOffer(itemPrice, mealPrice, mealOfTheWeekPrice,
				restaurant.getGenericDiscountFactor(), restaurant.getSpecialDiscountFactor());
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

	public Time getOrderDate() {
		return orderDate;
	}

	public Time getDeliverDate() {
		return deliverDate;
	}

	public void setDeliverDate() {
		this.deliverDate = Time.getTime();
	}

}
