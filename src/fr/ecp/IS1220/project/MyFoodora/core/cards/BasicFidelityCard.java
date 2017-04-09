package fr.ecp.IS1220.project.MyFoodora.core.cards;

public class BasicFidelityCard implements FidelityCard {

	@Override
	public double getOffer(Double itemPrice, Double mealPrice, Double mealOfTheWeekPrice, Float genericDiscountFactor,
			Float specialDiscountFactor) {
		double price = 0;
		price += itemPrice;
		price += mealPrice;//already mutiplied by genericDiscountFactor
		price += mealOfTheWeekPrice*(1-specialDiscountFactor)/(1-genericDiscountFactor);
		return price;
	}

}
