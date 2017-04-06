package fr.ecp.IS1220.project.MyFoodora.core;

public class BasicFidelityCard implements FidelityCard {

	@Override
	public double getOffer(Double itemPrice, Double mealPrice, Double mealOfTheWeekPrice, Float genericDiscountFactor,
			Float specialDiscountFactor) {
		double price = 0;
		price += itemPrice;
		price += mealPrice * genericDiscountFactor;
		price += mealOfTheWeekPrice*specialDiscountFactor;
		return price;
	}

}
