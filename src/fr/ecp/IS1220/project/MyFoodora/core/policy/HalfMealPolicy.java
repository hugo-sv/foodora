package fr.ecp.IS1220.project.MyFoodora.core.policy;

import java.util.ArrayList;
import java.util.HashMap;

import fr.ecp.IS1220.project.MyFoodora.core.MyFoodora;
import fr.ecp.IS1220.project.MyFoodora.core.Order;
import fr.ecp.IS1220.project.MyFoodora.core.Restaurant;
import fr.ecp.IS1220.project.MyFoodora.core.menu.HalfMeal;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Meal;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Orderable;

public class HalfMealPolicy implements OrderSortingPolicy {

	@Override
	public void least(MyFoodora myFoodora, Restaurant restaurant) {
		HashMap<HalfMeal,Integer> halfMeals = new HashMap<HalfMeal, Integer>();
		ArrayList<HalfMeal> halfMealList = new ArrayList<HalfMeal>();
		for (Meal meal : restaurant.getMenu().getMeals()) {
			if (meal instanceof HalfMeal) {
				halfMeals.put((HalfMeal) meal, 0); 
				halfMealList.add((HalfMeal) meal);
			}
		}
		for (Order order : myFoodora.getCompletedOrder_List()) {
			
			if (order.getRestaurant().getiD() == restaurant.getiD()) {
				
				for (Orderable orderable : order.getOrderables()) {
					
					if (orderable instanceof HalfMeal) {
						halfMeals.put((HalfMeal) orderable, halfMeals.get((HalfMeal) orderable) + 1);
					}
				}
			}
		}
		
		halfMealList.sort(new HalfMealComparator(halfMeals));
		
		for (HalfMeal halfMeal : halfMealList) {
			System.out.println(halfMeal.toString());
		}
		
		
		

	}

	@Override
	public void most(MyFoodora myFoodora, Restaurant restaurant) {
		HashMap<HalfMeal,Integer> halfMeals = new HashMap<HalfMeal, Integer>();
		ArrayList<HalfMeal> halfMealList = new ArrayList<HalfMeal>();
		for (Meal meal : restaurant.getMenu().getMeals()) {
			if (meal instanceof HalfMeal) {
				halfMeals.put((HalfMeal) meal, 0); 
				halfMealList.add((HalfMeal) meal);
			}
		}
		for (Order order : myFoodora.getCompletedOrder_List()) {
			
			if (order.getRestaurant().getiD() == restaurant.getiD()) {
				
				for (Orderable orderable : order.getOrderables()) {
					
					if (orderable instanceof HalfMeal) {
						halfMeals.put((HalfMeal) orderable, halfMeals.get((HalfMeal) orderable) + 1);
					}
				}
			}
		}
		
		halfMealList.sort(new HalfMealComparator(halfMeals, true));
		
		for (HalfMeal halfMeal : halfMealList) {
			System.out.println(halfMeal.toString());
		}
		
		
		

	}

}
