package fr.ecp.IS1220.project.MyFoodora.core.policy;

import java.util.Comparator;
import java.util.HashMap;

import fr.ecp.IS1220.project.MyFoodora.core.menu.Item;

public class ItemComparator implements Comparator<Item> {
	HashMap<Item,Integer> items;
	boolean reverse = false;

	public ItemComparator(HashMap<Item, Integer> items) {
		super();
		this.items = items;
	}
	
	public ItemComparator(HashMap<Item, Integer> items, boolean reverse) {
		super();
		this.items = items;
		this.reverse = reverse;
	}



	@Override
	public int compare(Item o1, Item o2) {
		if (reverse) {
			return items.get(o2)-items.get(o1);
		} else {
			return items.get(o1)-items.get(o2);
		}
	}

}
