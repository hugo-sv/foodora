package fr.ecp.IS1220.project.MyFoodora.core;

public class Courier extends User{
	private String surname;
	private boolean onDuty;
	private Order currentOrder;
	
	
	public Courier(String name, String surname, String username, double addressX, double addressY, String email, String phoneNumber) {
		super(name, surname, addressX, addressY);
		this.surname = surname;
		setEmail(email);
		setPhoneNumber(phoneNumber);
		onDuty = false;
	}
	
	public Courier(String name, String surname, String username, double addressX, double addressY) {
		super(name, surname, addressX, addressY);
		this.surname = surname;
		onDuty = false;
	}
	
	public void register(MyFoodora myFoodora) {
		myFoodora.addCourier(this);
	}
	
	public void unregister(MyFoodora myFoodora) {
		myFoodora.removeCourier(this);
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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
			setMoney(getMoney()+currentOrder.getDeliveryCost());
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
