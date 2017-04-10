package fr.ecp.IS1220.project.MyFoodora.core.cards;

public class PointFidelityCard implements FidelityCard {
	// A client can select to have this fidelity card. Instead of having
	// the special offer she will gain a point for each 10 euros spent in the
	// restaurant. Once
	// she will reach 100 points she will receive a 10% discount on the next
	// order.

	private double points;

	@Override
	public double getOffer(Double itemPrice, Double mealPrice, Double mealOfTheWeekPrice, Float genericDiscountFactor,
			Float specialDiscountFactor) {
		double price = 0;
		price += itemPrice;
		price += (mealPrice + mealOfTheWeekPrice);
		if (points > 100)
			;
		{
			price *= 0.9;
			points = 0;
		}
		points += price / 10;
		return price;

	}

	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "Point fidelity card with " + getPoints() + " points.";
	}

}
