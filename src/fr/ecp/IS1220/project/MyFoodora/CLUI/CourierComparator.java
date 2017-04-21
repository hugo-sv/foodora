package fr.ecp.IS1220.project.MyFoodora.CLUI;

import java.util.Comparator;

import fr.ecp.IS1220.project.MyFoodora.core.Courier;
import fr.ecp.IS1220.project.MyFoodora.core.MyFoodora;
import fr.ecp.IS1220.project.MyFoodora.core.Order;

public class CourierComparator implements Comparator<Courier> {
	MyFoodora foodora;
	boolean reverse;
	
	

	public CourierComparator(MyFoodora foodora) {
		super();
		this.foodora = foodora;
		boolean reverse = false;
	}
	public CourierComparator(MyFoodora foodora, boolean reverse) {
		super();
		this.foodora = foodora;
		this.reverse = reverse;
	}



	@Override
	public int compare(Courier arg0, Courier arg1) {
		int orderNumber0 = 0;
		int orderNumber1 = 0;
		for (Order order : foodora.getCompletedOrder_List()) {
			if (arg0.getiD() == order.getCourier().getiD()) {
				orderNumber0++;
			} else if (arg1.getiD() == order.getCourier().getiD()) {
				orderNumber1++;
			}
		}
		if (reverse) {
			return orderNumber1-orderNumber0;
		} else {
			return orderNumber0-orderNumber1;
		}
		
	}

}
