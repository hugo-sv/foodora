package fr.ecp.IS1220.project.MyFoodora.core.cards;

import fr.ecp.IS1220.project.MyFoodora.core.Time;

public class LotteryFidelityCard implements FidelityCard {
	// A member that has this card will not access to any offer nor
	// gain any points but will have a certain probability to gain her meal for
	// free each day

	private Time lastTime;
	private float randomNumber;

	@Override
	public double getOffer(Double itemPrice, Double mealPrice, Double mealOfTheWeekPrice, Float genericDiscountFactor,
			Float specialDiscountFactor) {

		//si difference de plus d'un jour ou None
		////tirer un random
		if(lastTime.isLessThanOneDay()){
			lastTime=Time.getTime();
			//Change to a random number
			randomNumber=(float) Math.random();
		}
		else{
			randomNumber=0;
		}
		double price = 0;
		price += itemPrice;
		price += (mealPrice + mealOfTheWeekPrice);
		if (randomNumber>0.9);{
			price=0;
			randomNumber=0;
		}
		return price;

	}
}
