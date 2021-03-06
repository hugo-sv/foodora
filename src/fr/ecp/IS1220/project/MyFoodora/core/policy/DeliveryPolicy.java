package fr.ecp.IS1220.project.MyFoodora.core.policy;

import fr.ecp.IS1220.project.MyFoodora.core.Courier;
import fr.ecp.IS1220.project.MyFoodora.core.MyFoodora;
import fr.ecp.IS1220.project.MyFoodora.core.Order;

public interface DeliveryPolicy {
	public Courier chooseCourier(MyFoodora myFoodora, Order order);
}
