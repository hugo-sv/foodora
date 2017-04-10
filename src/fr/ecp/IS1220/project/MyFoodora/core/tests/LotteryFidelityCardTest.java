package fr.ecp.IS1220.project.MyFoodora.core.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.ecp.IS1220.project.MyFoodora.core.Courier;
import fr.ecp.IS1220.project.MyFoodora.core.Customer;
import fr.ecp.IS1220.project.MyFoodora.core.Manager;
import fr.ecp.IS1220.project.MyFoodora.core.MyFoodora;
import fr.ecp.IS1220.project.MyFoodora.core.Order;
import fr.ecp.IS1220.project.MyFoodora.core.Restaurant;
import fr.ecp.IS1220.project.MyFoodora.core.cards.LotteryFidelityCard;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Dessert;
import fr.ecp.IS1220.project.MyFoodora.core.menu.FullMeal;
import fr.ecp.IS1220.project.MyFoodora.core.menu.HalfMeal;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Item;
import fr.ecp.IS1220.project.MyFoodora.core.menu.MainDish;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Meal;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Starter;
import fr.ecp.IS1220.project.MyFoodora.core.policy.FastestPolicy;

public class LotteryFidelityCardTest {
	static MyFoodora foodora = new MyFoodora(0.1, 0.1, 0.1);

	static Manager Johna = new Manager("John", "jo", "john");
	static Manager CEO = new Manager("Mary", "mary", "boss47");
	static Manager Deputy = new Manager("John", "john", "jojojo");

	static Courier Fred = new Courier("Fred", "fredo", "fred", 0, 10, "Fred@laposte.net", "0612345678");
	static Courier Fredi = new Courier("Fred", "fredo", "fred", 0, 10, "Fred@laposte.net", "0612345678");
	static Courier Carole = new Courier("Carole", "Coco", "~Xxcaroledu58xX~", 0, 10, "Carole@laposte.net",
			"0612345678");

	static Customer A1 = new Customer("A", "A", "a", 22, -24, "0654312456", "A@laposte.net");
	static Customer A = new Customer("A", "A", "a", 22, -24, "0654312456", "A@laposte.net");
	static Customer B = new Customer("B", "B", "b", 42, 14, "0654617456", "B@laposte.net");
	static Customer C = new Customer("C", "C", "c", 52, -14, "0654312456", "C@laposte.net");
	static Customer D = new Customer("D", "D", "d", -22, 42, "0658318456", "D@laposte.net");
	static Customer E = new Customer("E", "E", "e", -12, 64, "0654312956", "E@laposte.net");
	static Customer F = new Customer("F", "F", "f", -2, -4, "0614372456", "F@laposte.net");
	static Customer G = new Customer("G", "G", "g", 0, 47, "0654312456", "G@laposte.net");

	static Restaurant Bio = new Restaurant("BioFast", "biofast", -40, -10);
	static Restaurant Sushi = new Restaurant("SushiWorld", "sushi", 5, -50);
	static Restaurant Macdo = new Restaurant("MacDonald", "macdonald", 15, -20);
	static Restaurant Quick = new Restaurant("Quick", "quick", 105, 74);

	static Restaurant KFC = new Restaurant("KFC", "kfc", 40, 10);

	static MainDish Drink = new MainDish("Drink", 0.5, true, true);
	static MainDish BigMac = new MainDish("BigMac", 5, false, false);
	static Starter Salad = new Starter("Salad", 1, true, true);
	static Dessert MacFlurry = new Dessert("McFlurry", 2, true, false);
	static FullMeal F1 = new FullMeal("F1", Salad, BigMac, MacFlurry);
	static HalfMeal F2 = new HalfMeal("F2", Salad, Drink);

	static FullMeal F9 = new FullMeal("F9", new Starter("SaucissonBio", 4, false, true),
			new MainDish("ChickenBio", 4, false, true), new Dessert("IceCreamBio", 2, true, false));
	static HalfMeal F10 = new HalfMeal("F10", new MainDish("Chicken2Bio", 4, false, true),
			new Dessert("BetterIceCreamBio", 2, true, false));
	static FullMeal F7 = new FullMeal("F7", new Starter("Saucisson", 4, false, true),
			new MainDish("Chicken", 4, false, true), new Dessert("IceCream", 2, true, false));
	static HalfMeal F8 = new HalfMeal("F8", new MainDish("Chicken2", 4, false, true),
			new Dessert("BetterIceCream", 2, true, false));
	static FullMeal F5 = new FullMeal("F5", new Starter("Sushi2", 4, false, true),
			new MainDish("Sushi1", 4, false, true), new Dessert("Dessert", 2, true, false));
	static HalfMeal F6 = new HalfMeal("F6", new MainDish("Sushi3", 4, false, true),
			new Dessert("Dessert2", 2, true, false));
	static FullMeal F3 = new FullMeal("F3", new Starter("Salad", 1, true, true), new MainDish("Nuggets", 4, false, true),
			new Dessert("Donut", 2, true, false));
	static HalfMeal F4 = new HalfMeal("F4", new MainDish("Nuggets", 4, false, true),
			new Dessert("Donut", 2, true, false));

	@Before
	public void testManager() {
		foodora.addUser(Johna);
		foodora.addUser(CEO);
		foodora.addUser(Deputy);
		foodora.addUser(Macdo);
		Macdo.addMeal(F1);
		Macdo.addMeal(F2);
		foodora.addUser(Quick);
		Quick.addMeal(F3);
		Quick.addMeal(F4);
		foodora.addUser(Sushi);
		Sushi.addMeal(F5);
		Sushi.addMeal(F6);
		foodora.addUser(KFC);
		KFC.addMeal(F7);
		KFC.addMeal(F8);
		foodora.addUser(Bio);
		Bio.addMeal(F9);
		Bio.addMeal(F10);
		foodora.addUser(Fred);
		foodora.addUser(Fredi);
		foodora.addUser(A1);
		foodora.addUser(Carole);
		foodora.addUser(A);
		foodora.addUser(B);
		foodora.addUser(C);
		foodora.addUser(D);
		foodora.addUser(E);
		foodora.addUser(F);
		foodora.addUser(G);
		foodora.setDeliveryPolicy(new FastestPolicy());
	}
	@Test
	public void testGetOffer() {
		A.setFidelityCard(new LotteryFidelityCard());
		Order order = new Order(A, Macdo, foodora.getServiceFee(), foodora.getMarkupPourcentage(), foodora.getDeliveryCost());
		Courier courier = foodora.getDeliveryPolicy().chooseCourier(foodora, order);
		order.setCourier(courier);
		int i = 0;
		Meal chosenmeal = null;
		for (Meal meal : Macdo.getMenu().getMeals()) {
			if (i==0) {
				order.addOrderabe(meal);
				
				chosenmeal = meal;
				i++;
				
			}
		assertFalse(chosenmeal==null);
			
		}
		
		double totalprice = 0;
		for (Item item : chosenmeal.getItems()) {
			totalprice += item.getPrice();
		}
		
		assertEquals(0.95*totalprice, order.getPrice(), 1e-5);
		
	}

}
