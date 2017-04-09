package fr.ecp.IS1220.project.MyFoodora.core.cards;

public interface FidelityCard {
	public double getOffer(Double itemPrice, Double mealPrice, Double mealOfTheWeekPrice, Float genericDiscountFactor,
			Float specialDiscountFactor);
	@Override
	public String toString();
}
