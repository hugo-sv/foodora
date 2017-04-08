package fr.ecp.IS1220.project.MyFoodora.core.policy;

import java.util.ArrayList;
import java.util.HashMap;

import fr.ecp.IS1220.project.MyFoodora.core.MyFoodora;
import fr.ecp.IS1220.project.MyFoodora.core.Order;
import fr.ecp.IS1220.project.MyFoodora.core.Restaurant;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Item;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Orderable;

public class ItemPolicy implements OrderSortingPolicy {

	@Override
	public void least(MyFoodora myFoodora, Restaurant restaurant) {
		HashMap<Item,Integer> items = new HashMap<Item, Integer>();
		ArrayList<Item> itemList = new ArrayList<Item>();
		for (Item item : restaurant.getMenu().getItems()) {
			items.put(item, 0); 
			itemList.add(item);
		}

		for (Order order : myFoodora.getCompletedOrder_List()) {

			if (order.getRestaurant().getiD() == restaurant.getiD()) {

				for (Orderable orderable : order.getOrderables()) {

					if (orderable instanceof Item) {
						items.put((Item) orderable, items.get((Item) orderable) + 1);
					}
				}
			}
		}

		itemList.sort(new ItemComparator(items));

		for (Item item : itemList) {
			System.out.println(item.toString());
		}

	}

	@Override
	public void most(MyFoodora myFoodora, Restaurant restaurant) {
		HashMap<Item,Integer> items = new HashMap<Item, Integer>();
		ArrayList<Item> itemList = new ArrayList<Item>();
		for (Item item : restaurant.getMenu().getItems()) {
			items.put(item, 0); 
			itemList.add(item);
		}

		for (Order order : myFoodora.getCompletedOrder_List()) {

			if (order.getRestaurant().getiD() == restaurant.getiD()) {

				for (Orderable orderable : order.getOrderables()) {

					if (orderable instanceof Item) {
						items.put((Item) orderable, items.get((Item) orderable) + 1);
					}
				}
			}
		}

		itemList.sort(new ItemComparator(items, true));

		for (Item item : itemList) {
			System.out.println(item.toString());
		}

	}

}
