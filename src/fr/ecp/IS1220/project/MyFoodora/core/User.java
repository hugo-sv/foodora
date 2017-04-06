package fr.ecp.IS1220.project.MyFoodora.core;

abstract public class User {
	protected MyFoodora myFoodora = null;
	private static long genID = 0;
	private long iD;
	private boolean activated;
	
	public User() {
		this.iD = genID;
		genID++;
		activated = true;
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
	
}
