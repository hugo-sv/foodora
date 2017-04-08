package fr.ecp.IS1220.project.MyFoodora.core;

public class Courier extends User{
	private String name;
	private String surname;
	private String username;
	private int phoneNumber;
	private boolean onDuty;
	
	
	public Courier(String name, String surname, String username, double addressX, double addressY, int phoneNumber) {
		super(addressX, addressY);
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.phoneNumber = phoneNumber;
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
