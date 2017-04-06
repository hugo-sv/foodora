package fr.ecp.IS1220.project.MyFoodora.core;

abstract public class User {
	protected MyFoodora myFoodora = null;
	private static long genID = 0;
	private long iD;
	
	public User() {
		this.iD = genID;
		genID++;
	}

	public long getiD() {
		return iD;
	}
	
	
}
