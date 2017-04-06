package fr.ecp.IS1220.project.MyFoodora.core;

public interface FidelityCard {
	public default double getOffer(double price){
		return price;
	}
}
