package fr.ecp.IS1220.project.MyFoodora.core.policy;

import java.util.HashMap;

import fr.ecp.IS1220.project.MyFoodora.core.Courier;
import fr.ecp.IS1220.project.MyFoodora.core.MyFoodora;
import fr.ecp.IS1220.project.MyFoodora.core.Order;

public class FairOccupationPolicy implements DeliveryPolicy {

	@Override
	public Courier chooseCourier(MyFoodora myFoodora, Order order) {
		HashMap<Long, Integer> activeCourier = new HashMap<Long, Integer>();
		for (Courier courier : myFoodora.getCourierList()) {
			if (courier.isOnDuty()) {
				activeCourier.put(courier.getiD(), 0);
			}
		}
		for (Order order1 : myFoodora.getCompletedOrder_List()) {
			long id = order1.getCourier().getiD();
			if (activeCourier.containsKey(id)) {
				activeCourier.put(id, activeCourier.get(id) + 1);
			}
			activeCourier.put(id, 1);
		}
		long idm = -1;
		double m = -1;
		for (Long id : activeCourier.keySet()) {
			if (idm < 0 || activeCourier.get(id) < m) {
				m = activeCourier.get(id);
				idm = id;
			}
		}
		return (Courier) myFoodora.getUserList().get(idm);
	}
}
