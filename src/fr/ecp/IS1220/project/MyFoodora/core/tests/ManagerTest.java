package fr.ecp.IS1220.project.MyFoodora.core.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.ecp.IS1220.project.MyFoodora.core.Courier;
import fr.ecp.IS1220.project.MyFoodora.core.Customer;
import fr.ecp.IS1220.project.MyFoodora.core.Manager;
import fr.ecp.IS1220.project.MyFoodora.core.MyFoodora;
import fr.ecp.IS1220.project.MyFoodora.core.UseCase;
import fr.ecp.IS1220.project.MyFoodora.core.menu.MainDish;

public class ManagerTest {
	static MyFoodora foodora = new MyFoodora(0.1, 0.1, 0.1);
	static Manager Johna = new Manager("John", "jo", "john");
	static Courier Fredi = new Courier("Fred", "fredo", "fred", 0, 10, "Fred@laposte.net", "0612345678");
	static Customer A1 = new Customer("A", "A", "a", 22, -24, "0654312456", "A@laposte.net");

	@Before
	public void testManager() {
		foodora.addUser(Johna);
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
		assertTrue(foodora.getServiceFee()==0.5);
		assertTrue(foodora.getMarkupPourcentage()==0.6);
		assertTrue(foodora.getDeliveryCost()==0.8);
	}

	@Test
	public void testComputeIncome() {
		UseCase.setEnvironementForTest(foodora);
		
		fail("Not yet implemented");
	}

	@Test
	public void testComputeProfit() {
		fail("Not yet implemented");
	}

	@Test
	public void testComputeAverageIncome() {
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