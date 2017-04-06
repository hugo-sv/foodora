package fr.ecp.IS1220.project.MyFoodora.core;

public class Manager extends User {
	private static long genID = 0;
	private long iD;
	private String Name;
	private String Surname;
	private String Username;
	private MyFoodora myFoodora;
	
	
	public Manager(long iD, String name, String surname, String username) {
		super();
		Name = name;
		Surname = surname;
		Username = username;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getSurname() {
		return Surname;
	}


	public void setSurname(String surname) {
		Surname = surname;
	}


	public String getUsername() {
		return Username;
	}


	public void setUsername(String username) {
		Username = username;
	}
	
	public void addUser(User user) {
		myFoodora.addUser(user);
		user.myFoodora = myFoodora;
	}
	
	public void removeUser(User user) {
		myFoodora.removeUser(user);
		user.myFoodora = null;
	}
	
	public void activate(User user) {
		myFoodora.activateUser(user);
	}
	
	public void disactivate(User user) {
		myFoodora.activateUser(user);
	}
	
	public void setServiceFee(double serviceFee) {
		myFoodora.setServiceFee(serviceFee);
	}
	
	public void setMarkupPourcentage(double markupPourcentage) {
		this.myFoodora.setMarkupPourcentage(markupPourcentage);
	}
	
	public void setDeliveryCost(double deliveryCost) {
		this.myFoodora.setDeliveryCost(deliveryCost);
	}
	
	public double computeIncome(Time begin, Time end) {
		double income = 0;
		for ( Order order : myFoodora.getCompletedOrder_List()) {
			if (order.getOrderDate().compareTo(begin)>0 && order.getOrderDate().compareTo(end)<0) {
				income += order.getPrice()*order.getMarkupPourcentage()+order.getServiceFee();
			}
		}
		return income;
	}
	
	public double computeProfit(Time begin, Time end) {
		double profit = 0;
		for ( Order order : myFoodora.getCompletedOrder_List()) {
			if (order.getOrderDate().compareTo(begin)>0 && order.getOrderDate().compareTo(end)<0) {
				profit += order.getPrice()*order.getMarkupPourcentage()+order.getServiceFee()-order.getDeliveryCost();
			}
		}
		return profit;
	}
	
}
