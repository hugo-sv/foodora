package fr.ecp.IS1220.project.MyFoodora.core;

public class PointFidelityCard implements FidelityCard {
	//A client can select to have this fidelity card. Instead of having
	//the special offer she will gain a point for each 10 euros spent in the restaurant. Once
	//she will reach 100 points she will receive a 10% discount on the next order.
	
	private double points;
	
	
	
	
	@Override
	public double getOffer(double price) {

		return 0;
	}

}
