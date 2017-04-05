package fr.ecp.IS1220.project.MyFoodora.core;

public class Courier implements User{
	private static long genID = 0;
	private long ID;
	private String name;
	private String surname;
	private String username;
	private double x;
	private double y;
	private int phoneNumber;
	private int deliveredOrders;
	private boolean state;
	
	public Courier(String name, String surname, String username, double x, double y, int phoneNumber) {
		super();
		this.ID = genID;
		genID++;
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.x = x;
		this.y = y;
		this.phoneNumber = phoneNumber;
		deliveredOrders = 0;
	}
	
	public void register(MyFoodora myFoodora) {
		
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

	public long getID() {
		return ID;
	}
	
	
	
	
	
}
