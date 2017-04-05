package fr.ecp.IS1220.project.MyFoodora.core;

import java.util.ArrayList;

import fr.ecp.IS1220.project.MyFoodora.core.menu.Visitable;

public class Customer implements User{
	//have a name, a surname, a unique ID, an address (expressed as a two
	//dimensional co-ordinate), an email address, a phone number and a username, the
	//latter used for logging in the system.
	private ArrayList<Visitable> shoppingCart = new ArrayList<Visitable>();
	private double shoppingCartPrice = 0;
	private static long genID = 0;
	private long iD;
	private String name;
	private String surname;
	private String username;
	private ArrayList<Double> address;
	private String eamil;
	private String phoneNumber;
	private boolean fidelityCard=false;
	
	
	public Customer(long iD, String name, String surname, String username) {
		super();
		this.iD = genID;
		genID++;
		this.name = name;
		this.surname = surname;
		this.username = username;
	}
	
	public void visit(Visitable v){
		shoppingCart.add(v);
		shoppingCartPrice=shoppingCartPrice+v.getPrice();
		}
	
	public  double getPrice(){
		double Price =0;
		for (Visitable v:shoppingCart){
			Price=Price+v.getPrice();
		}
		return Price;
	}

	public long getiD() {
		return iD;
	}

	public void setiD(long iD) {
		this.iD = iD;
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

	public boolean isFidelityCard() {
		return fidelityCard;
	}

	public void setFidelityCard(boolean fidelityCard) {
		this.fidelityCard = fidelityCard;
	}

	public ArrayList<Visitable> getShoppingCart() {
		return shoppingCart;
	}

	public double getShoppingCartPrice() {
		return shoppingCartPrice;
	}
	
	
	
}
