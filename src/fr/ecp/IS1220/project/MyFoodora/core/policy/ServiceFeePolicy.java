package fr.ecp.IS1220.project.MyFoodora.core.policy;

import fr.ecp.IS1220.project.MyFoodora.core.MyFoodora;
import fr.ecp.IS1220.project.MyFoodora.core.Order;

public class ServiceFeePolicy implements TargetPolicy {

	@Override
	public void setParameters(MyFoodora myFoodora, double targetProfit) {
		double averageOrderPrice = 0;
		long orderNumber = 0;
		for (Order order : myFoodora.getCompletedOrder_List()) {
			if (order.getOrderDate().isLessThanOneMonth()) {
				averageOrderPrice += order.getPrice();
				orderNumber++;
			}
		}
		averageOrderPrice /= orderNumber;
		myFoodora.setServiceFee(targetProfit/orderNumber+myFoodora.getDeliveryCost()-averageOrderPrice*myFoodora.getMarkupPourcentage());

	}

}
