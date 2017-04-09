package fr.ecp.IS1220.project.MyFoodora.core;

public class Courier extends User{
	private String name;
	private String surname;
	private String username;
	private String phoneNumber;
	private boolean onDuty;
	private Order currentOrder;
	
	
	public Courier(String name, String surname, String username, double addressX, double addressY, String phoneNumber) {
		super(addressX, addressY);
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.phoneNumber = phoneNumber;
		onDuty = false;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public boolean isOnDuty() {
		return onDuty;
	}

	public void setOnDuty(boolean onDuty) {
		this.onDuty = onDuty;
	}
	
	public void propose(Order order) {
		this.currentOrder = order;
	}
	
	public void accept() {
		if (currentOrder != null) {
			myFoodora.getCurrentOrder_List().remove(currentOrder);
			setAddress(currentOrder.getCustomer().getAddressX(), currentOrder.getCustomer().getAddressY());
			myFoodora.setMoney(myFoodora.getMoney()+currentOrder.getServiceFee()+currentOrder.getMarkupPourcentage()*currentOrder.getPrice());
			currentOrder.getRestaurant().setMoney(currentOrder.getRestaurant().getMoney()+currentOrder.getPrice()*(1-currentOrder.getMarkupPourcentage()));
			currentOrder = null;
		} else {
			System.out.println("No current order proposed");
		}
	}
	
	public void refuse() {
		if (currentOrder != null) {
			currentOrder = null;
			myFoodora.give(currentOrder);
		} else {
			System.out.println("No current order proposed");
		}
	}
	

	
		 
}
