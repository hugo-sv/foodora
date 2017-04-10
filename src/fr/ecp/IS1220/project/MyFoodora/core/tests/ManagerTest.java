package fr.ecp.IS1220.project.MyFoodora.core.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.ecp.IS1220.project.MyFoodora.core.Courier;
import fr.ecp.IS1220.project.MyFoodora.core.Customer;
import fr.ecp.IS1220.project.MyFoodora.core.Manager;
import fr.ecp.IS1220.project.MyFoodora.core.MyFoodora;
import fr.ecp.IS1220.project.MyFoodora.core.menu.MainDish;

public class ManagerTest {
	static MyFoodora foodora = new MyFoodora(0.1, 0.1, 0.1);
	static Manager John = new Manager("John", "jo", "john");
	static Courier Fred = new Courier("Fred", "fredo", "fred", 0, 10, "Fred@laposte.net", "0612345678");
	static Customer A = new Customer("A", "A", "a", 22, -24, "0654312456", "A@laposte.net");

	@Before
	public void testManager() {
		foodora.addUser(John);
	}

	@Test
	public void testGetSurname() {
		System.out.println("Mansghgdsdfghgfdst.main()");
		assertEquals("jo", John.getSurname());
	}

	@Test
	public void testSetSurname() {
		John.setSurname("jojo");
		assertEquals("jojo", John.getSurname());
		John.setSurname("jo");
	}

	@Test
	public void testAddUser() {
		John.addUser(Fred);
		assertTrue(foodora.getUserList().containsValue(Fred));
		John.addUser(A);
		assertTrue(foodora.getUserList().containsValue(A));
	}

	@Test
	public void testRemoveUser() {
		John.addUser(Fred);
		assertTrue(foodora.getUserList().containsValue(Fred));
		John.removeUser(Fred);
		assertTrue(!foodora.getUserList().containsValue(Fred));
		John.addUser(Fred);
	}

	@Test
	public void testActivate() {
		John.disactivate(A);
		John.activate(A);
		assertTrue(A.isActivated());
	}

	@Test
	public void testDisactivate() {
		John.activate(A);
		John.disactivate(A);
		assertTrue(!A.isActivated());
	}

	@Test
	public void testSetParameters() {
		John.setServiceFee(0.5);
		John.setMarkupPourcentage(0.6);
		John.setDeliveryCost(0.8);
		assertTrue(foodora.getServiceFee()==0.5);
		assertTrue(foodora.getMarkupPourcentage()==0.6);
		assertTrue(foodora.getDeliveryCost()==0.8);
	}

	@Test
	public void testComputeIncome() {
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