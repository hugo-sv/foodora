package fr.ecp.IS1220.project.MyFoodora.core.policy;

import fr.ecp.IS1220.project.MyFoodora.core.Courier;
import fr.ecp.IS1220.project.MyFoodora.core.Customer;
import fr.ecp.IS1220.project.MyFoodora.core.MyFoodora;
import fr.ecp.IS1220.project.MyFoodora.core.Order;
import fr.ecp.IS1220.project.MyFoodora.core.Restaurant;

public class FastestPolicy implements DeliveryPolicy {

	@Override
	public Courier chooseCourier(MyFoodora myFoodora, Order order) {
		Courier bestCourier = null;
		double distance = -1;
		System.out.println(order);
		Restaurant restaurant = order.getRestaurant();
		Customer customer = order.getCustomer();

		for (Courier courier : myFoodora.getCourierList()) {
			double distance1 = Math.pow(courier.getAddressX() - restaurant.getAddressX(), 2)
					+ Math.pow(courier.getAddressY() - restaurant.getAddressY(), 2);
			double distance2 = Math.pow(restaurant.getAddressX() - customer.getAddressX(), 2)
					+ Math.pow(restaurant.getAddressY() - customer.getAddressY(), 2);
			if ((courier.getCurrentOrder() == null && courier.isOnDuty()) && (distance < 0 || (distance > distance1 + distance2))) {
				distance = distance1 + distance2;
				bestCourier = courier;
			}
		}
		return bestCourier;
	}

}
