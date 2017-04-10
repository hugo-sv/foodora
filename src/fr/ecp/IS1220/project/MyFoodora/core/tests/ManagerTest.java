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
	}

	@Test
	public void testActivate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDisactivate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetServiceFee() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMarkupPourcentage() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDeliveryCost() {
		fail("Not yet implemented");
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

	@Test
	public void testSetMyFoodora() {
		fail("Not yet implemented");
	}

	@Test
	public void testUserStringStringDoubleDouble() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetiD() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsActivated() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetActivated() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAddressX() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAddressY() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetAddress() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetAddressX() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetAddressY() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMoney() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMoney() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUsername() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetUsername() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEmail() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEmail() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPhoneNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPhoneNumber() {
		fail("Not yet implemented");
	}

}
