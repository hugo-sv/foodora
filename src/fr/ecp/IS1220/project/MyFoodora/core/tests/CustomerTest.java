package fr.ecp.IS1220.project.MyFoodora.core.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.ecp.IS1220.project.MyFoodora.core.Customer;
import fr.ecp.IS1220.project.MyFoodora.core.MyFoodora;
import fr.ecp.IS1220.project.MyFoodora.core.cards.BasicFidelityCard;
import fr.ecp.IS1220.project.MyFoodora.core.cards.LotteryFidelityCard;

public class CustomerTest {
	static MyFoodora foodora = new MyFoodora(0.1, 0.1, 0.1);
	static Customer Michel = new Customer("Michel", "Michou", "michmich", 0, 10, "michel@laposte.net", "0612345678");

	@Before
	public void testCustomer() {
		foodora.addUser(Michel);
	}

	@Test
	public void testNotifyString() {
		Michel.notify("This is a test");
	}

	@Test
	public void testRegister() {
		Michel.register();
		assertTrue(foodora.getObservers().contains(Michel));
	}

	@Test
	public void testUnregister() {
		Michel.unregister();
		assertFalse(foodora.getObservers().contains(Michel));
	}

	@Test
	public void testGetSurname() {
		assertEquals("Michou", Michel.getSurname());
	}

	@Test
	public void testSetSurname() {
		Michel.setSurname("Mich");
		assertEquals("Mich", Michel.getSurname());

	}

	@Test
	public void testGetOrders() {
		assertTrue(Michel.getOrders().isEmpty());
	}

	@Test
	public void testGetFidelityCard() {
		assertTrue(Michel.getFidelityCard() instanceof BasicFidelityCard);
	}

	@Test
	public void testSetFidelityCard() {
		Michel.setFidelityCard(new LotteryFidelityCard());
		assertTrue(Michel.getFidelityCard() instanceof LotteryFidelityCard);

	}

	@Test
	public void testGetNotifyMean() {
		assertEquals(Michel.getEmail(), Michel.getNotifyMean());
	}

	@Test
	public void testSetNotifyMean() {
		Michel.setNotifyMean(Michel.getPhoneNumber());
		assertEquals(Michel.getPhoneNumber(), Michel.getNotifyMean());
	}
}