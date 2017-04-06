package fr.ecp.IS1220.project.MyFoodora.core;

public class LotteryFidelityCard implements FidelityCard {
	//A member that has this card will not access to any offer nor
	//gain any points but will have a certain probability to gain her meal for free each day
	@Override
	public double getOffer(double price) {

		return 0;
	}
}
