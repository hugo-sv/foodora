package fr.ecp.IS1220.project.MyFoodora.core;

abstract public class User {
	protected MyFoodora myFoodora = null;
	private static long genID = 0;
	private long iD;
	private String name;
	private String username;
	private String password;
	private String email;
	private String phoneNumber;
	private boolean activated;
	private double addressX = 0;
	private double addressY = 0;
	private double money = 0;
	
	public User(String name, String username) {
		this.iD = genID;
		genID++;
		this.name = name;
		this.username = username;
		activated = true;
	}
	
	public void setMyFoodora(MyFoodora myFoodora) {
		this.myFoodora = myFoodora;
	}

	public User(String name, String username, double addressX, double addressY) {
		this.iD = genID;
		genID++;
		this.name = name;
		this.username = username;
		activated = true;
		this.setAddressX(addressX);
		this.setAddressY(addressY);
		//default password
		this.password = "password";
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
