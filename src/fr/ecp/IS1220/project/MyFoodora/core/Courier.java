package fr.ecp.IS1220.project.MyFoodora.core;

public class Courier extends User{
	private String surname;
	private boolean onDuty;
	private Order currentOrder;
	
	
	public Courier(String name, String surname, String username, double addressX, double addressY, String email, String phoneNumber) {
		super(name, username, addressX, addressY);
		this.surname = surname;
		setEmail(email);
		setPhoneNumber(phoneNumber);
		onDuty = false;
	}
	
	public Courier(String name, String surname, String username, double addressX, double addressY) {
		super(name, username, addressX, addressY);
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
		//to prevent him from receiving other orders while accepting or refusing
		setOnDuty(false);
		
	}
	
	public void accept() {
		if (currentOrder != null) {
			myFoodora.getCurrentOrder_List().remove(currentOrder);
			setAddress(currentOrder.getCustomer().getAddressX(), currentOrder.getCustomer().getAddressY());
			myFoodora.setMoney(myFoodora.getMoney()+currentOrder.getServiceFee()+currentOrder.getMarkupPourcentage()*currentOrder.getPrice());
			currentOrder.getRestaurant().setMoney(currentOrder.getRestaurant().getMoney()+currentOrder.getPrice()*(1-currentOrder.getMarkupPourcentage()));
			setMoney(getMoney()+currentOrder.getDeliveryCost());
			currentOrder.setDeliverDate();
			currentOrder = null;
			setOnDuty(true);
		} else {
			System.out.println("No current order proposed");
		}
	}
	
	public void refuse() {
		if (currentOrder != null) {
			//The courrier doesn't want to receive other order
			setOnDuty(false);
			myFoodora.give(currentOrder);
			currentOrder = null;
		} else {
			System.out.println("No current order proposed");
		}
	}
	
	public Order getCurrentOrder(){
		return currentOrder;
	}
	
	@Override
	public String toString() {
		return getName()+" "+getSurname();
	}
	

	
		 
}
