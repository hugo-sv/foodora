package fr.ecp.IS1220.project.MyFoodora.core;

abstract public class User {
	protected MyFoodora myFoodora = null;
	private static long genID = 0;
	private long iD;
	private boolean activated;
	private double addressX = 0;
	private double addressY = 0;
	private double money = 0;
	
	public User() {
		this.iD = genID;
		genID++;
		activated = true;
	}
	
	public void setMyFoodora(MyFoodora myFoodora) {
		this.myFoodora = myFoodora;
	}

	public User(double addressX, double addressY) {
		this.iD = genID;
		genID++;
		activated = true;
		this.setAddressX(addressX);
		this.setAddressY(addressY);
	}

	public long getiD() {
		return iD;
	}
	
	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public double getAddressX() {
		return addressX;
	}

	public double getAddressY() {
		return addressY;
	}
	
	public void setAddress(double addressX, double addressY) {
		this.setAddressX(addressX);
		this.setAddressY(addressY);
	}

	public void setAddressX(double addressX) {
		this.addressX = addressX;
	}

	public void setAddressY(double addressY) {
		this.addressY = addressY;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	
}
