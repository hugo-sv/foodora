package fr.ecp.IS1220.project.MyFoodora.core;

public class Manager implements User {
	private static long genID = 0;
	private long iD;
	private String Name;
	private String Surname;
	private String Username;
	
	
	public Manager(long iD, String name, String surname, String username) {
		super();
		iD = genID;
		genID++;
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


	public long getiD() {
		return iD;
	}

	
}
