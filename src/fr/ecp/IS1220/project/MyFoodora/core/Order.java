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
	private ArrayList<Orderable> orderables = new ArrayList<Orderable>();
	private String name;
	private Time orderDate;
	private Time deliverDate;

	public Order(Customer customer, Restaurant restaurant, Courier courier, double serviceFee, double markupPourcentage,
			double deliveryCost) {
		super();
		this.customer = customer;
		this.restaurant = restaurant;
		this.courier = courier;
		this.serviceFee = serviceFee;
		this.markupPourcentage = markupPourcentage;
		this.deliveryCost = deliveryCost;
		this.orderDate = Time.getTime();

	}

	public Order(String name, Customer customer, Restaurant restaurant, double serviceFee, double markupPourcentage,
			double deliveryCost) {
		super();
		this.name = name;
		this.customer = customer;
		this.restaurant = restaurant;
		this.courier = null;
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
		ArrayList<Meal> mealsOfTheWeek = restaurant.getMealsOfTheWeek();
		for (Orderable o : orderables) {
			if (o instanceof Meal) {
				if (mealsOfTheWeek.contains(o)) {
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

	public void setOrderDate() {
		this.orderDate = Time.getTime();
	}

	public Time getDeliverDate() {
		return deliverDate;
	}

	public void setDeliverDate() {
		this.deliverDate = Time.getTime();
	}

	public void addOrderable(Orderable orderable) {
		orderables.add(orderable);
	}

	public ArrayList<Orderable> getOrderables() {
		return orderables;
	}

	public void setCourier(Courier courier) {
		this.courier = courier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name + " :\nrestaurant : " + restaurant.getName() + " ( " + restaurant.getAddressX() + " , "
				+ restaurant.getAddressY() + " )" + "\ncustomer : " + customer.getName() + " ( " + customer.getAddressX()
				+ " , " + customer.getAddressY() + " )" + "\norderables :\n" + orderables + "\norderDate : "
				+ orderDate.toString();
	}

}
