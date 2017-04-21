	package fr.ecp.IS1220.project.MyFoodora.CLUI;

import java.util.Comparator;

import fr.ecp.IS1220.project.MyFoodora.core.MyFoodora;
import fr.ecp.IS1220.project.MyFoodora.core.Order;
import fr.ecp.IS1220.project.MyFoodora.core.Restaurant;

public class RestaurantComparator implements Comparator<Restaurant> {
	MyFoodora foodora;
	boolean reverse;
	
	

	public RestaurantComparator(MyFoodora foodora) {
		super();
		this.foodora = foodora;
		boolean reverse = false;
	}
	public RestaurantComparator(MyFoodora foodora, boolean reverse) {
		super();
		this.foodora = foodora;
		this.reverse = reverse;
	}



	@Override
	public int compare(Restaurant arg0, Restaurant arg1) {
		int orderNumber0 = 0;
		int orderNumber1 = 0;
		for (Order order : foodora.getCompletedOrder_List()) {
			if (arg0.getiD() == order.getRestaurant().getiD()) {
				orderNumber0++;
			} else if (arg1.getiD() == order.getRestaurant().getiD()) {
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
