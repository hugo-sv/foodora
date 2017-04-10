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
import fr.ecp.IS1220.project.MyFoodora.core.Time;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Dessert;
import fr.ecp.IS1220.project.MyFoodora.core.menu.FullMeal;
import fr.ecp.IS1220.project.MyFoodora.core.menu.HalfMeal;
import fr.ecp.IS1220.project.MyFoodora.core.menu.MainDish;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Starter;

public class ManagerTest {
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
	static FullMeal F3 = new FullMeal("F3", Salad, new MainDish("Nuggets", 4, false, true),
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
		foodora.addUser(Carole);
		foodora.addUser(A);
		foodora.addUser(B);
		foodora.addUser(C);
		foodora.addUser(D);
		foodora.addUser(E);
		foodora.addUser(F);
		foodora.addUser(G);
	}

	@Test
	public void testGetSurname() {
		System.out.println("Mansghgdsdfghgfdst.main()");
		assertEquals("jo", Johna.getSurname());
	}

	@Test
	public void testSetSurname() {
		Johna.setSurname("jojo");
		assertEquals("jojo", Johna.getSurname());
		Johna.setSurname("jo");
	}

	@Test
	public void testAddUser() {
		Johna.addUser(Fredi);
		assertTrue(foodora.getUserList().containsValue(Fredi));
		Johna.addUser(A1);
		assertTrue(foodora.getUserList().containsValue(A1));
	}

	@Test
	public void testRemoveUser() {
		Johna.addUser(Fredi);
		assertTrue(foodora.getUserList().containsValue(Fredi));
		Johna.removeUser(Fredi);
		assertTrue(!foodora.getUserList().containsValue(Fredi));
		Johna.addUser(Fredi);
	}

	@Test
	public void testActivate() {
		Johna.disactivate(A1);
		Johna.activate(A1);
		assertTrue(A1.isActivated());
	}

	@Test
	public void testDisactivate() {
		Johna.activate(A1);
		Johna.disactivate(A1);
		assertTrue(!A1.isActivated());
	}

	@Test
	public void testSetParameters() {
		Johna.setServiceFee(0.5);
		Johna.setMarkupPourcentage(0.6);
		Johna.setDeliveryCost(0.8);
		assertTrue(foodora.getServiceFee() == 0.5);
		assertTrue(foodora.getMarkupPourcentage() == 0.6);
		assertTrue(foodora.getDeliveryCost() == 0.8);
	}

	@Test
	public void testComputeIncome() {
		// Order(Customer customer, Restaurant restaurant, Courier courier,
		// double serviceFee, double markupPourcentage, double
		// deliveryCost)
		Order order = new Order(A, Macdo,Fred,0.1,0.1,0.1);
		A.payOrder(order);
		System.out.println("aa");//Johna.computeIncome(Time.getTime(), Time.getTime()));
		fail("Not yet implemented");
	}

	@Test
	public void testComputeProfit() {
		Order order = new Order(A, Macdo,Fred,0.1,0.1,0.1);
		A.payOrder(order);
		fail("Not yet implemented");
	}

	@Test
	public void testComputeAverageIncome() {
		Order order = new Order(A, Macdo,Fred,0.1,0.1,0.1);
		A.payOrder(order);
		fail("Not yet implemented");
	}

	@Test
	public void testComputeAverageProfit() {
		fail("Not yet implemented");
	}

	@Test
	public void testTargetProfit() {
		fail("Not yet implemented");
	}

	@Test
	public void testMostSellingRestaurant() {
		fail("Not yet implemented");
	}

	@Test
	public void testLeastSellingRestaurant() {
		fail("Not yet implemented");
	}

	@Test
	public void testMostActiveCourier() {
		fail("Not yet implemented");
	}

	@Test
	public void testLeastActiveCourier() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDeliveryPolicy() {
		fail("Not yet implemented");
	}

	@Test
	public void testUserStringString() {
		fail("Not yet implemented");
	}
}