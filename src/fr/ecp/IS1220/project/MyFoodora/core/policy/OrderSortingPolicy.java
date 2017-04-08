package fr.ecp.IS1220.project.MyFoodora.core.policy;

import fr.ecp.IS1220.project.MyFoodora.core.MyFoodora;
import fr.ecp.IS1220.project.MyFoodora.core.Restaurant;

public interface OrderSortingPolicy {
	public void least(MyFoodora myFoodora, Restaurant restaurant);
	public void most(MyFoodora myFoodora, Restaurant restaurant);

}
