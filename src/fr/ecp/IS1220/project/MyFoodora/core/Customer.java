package fr.ecp.IS1220.project.MyFoodora.core;

import java.util.ArrayList;

import fr.ecp.IS1220.project.MyFoodora.core.menu.Visitable;

public class Customer implements User{
	//A compléter
	private ArrayList<Visitable> shoppingCart = new ArrayList<Visitable>();
	private double shoppingCartPrice = 0;
	static long genID = 0;
	long ID;
	String Name;
	String Surname;
	String Username;
	
	
	public Customer(long iD, String name, String surname, String username) {
		super();
		ID = genID;
		genID++;
		Name = name;
		Surname = surname;
		Username = username;
	}
	
	public void visit(Visitable v){
		shoppingCart.add(v);
		shoppingCartPrice=shoppingCartPrice+v.getPrice();
		}

	
}
