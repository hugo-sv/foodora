package fr.ecp.IS1220.project.MyFoodora.core;

public class Courier extends User{
	private String name;
	private String surname;
	private String username;
	private double x;
	private double y;
	private int phoneNumber;
	private int deliveredOrders;
	private boolean onDuty;
	
	
	public Courier(String name, String surname, String username, double x, double y, int phoneNumber) {
		super();
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.x = x;
		this.y = y;
		this.phoneNumber = phoneNumber;
		deliveredOrders = 0;
		onDuty = true;
	}
	
	public void register(MyFoodora myFoodora) {
		myFoodora.addCourier(this);
	}
	
	public void unregister(MyFoodora myFoodora) {
		myFoodora.removeCourier(this);
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

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public boolean isOnDuty() {
		return onDuty;
	}

	public void setOnDuty(boolean onDuty) {
		this.onDuty = onDuty;
	}


	
		 
}
