package fr.ecp.IS1220.project.MyFoodora.core.policy;

import java.util.Comparator;
import java.util.HashMap;

import fr.ecp.IS1220.project.MyFoodora.core.menu.HalfMeal;

public class HalfMealComparator implements Comparator<HalfMeal> {
	HashMap<HalfMeal,Integer> halfMeals;
	boolean reverse = false;

	public HalfMealComparator(HashMap<HalfMeal, Integer> halfMeals) {
		super();
		this.halfMeals = halfMeals;
	}
	
	public HalfMealComparator(HashMap<HalfMeal, Integer> halfMeals, boolean reverse) {
		super();
		this.halfMeals = halfMeals;
		this.reverse = reverse;
	}



	@Override
	public int compare(HalfMeal o1, HalfMeal o2) {
		if (reverse) {
			return halfMeals.get(o2)-halfMeals.get(o1);
		} else {
			return halfMeals.get(o1)-halfMeals.get(o2);
		}
	}

}
