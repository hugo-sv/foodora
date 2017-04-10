package fr.ecp.IS1220.project.MyFoodora.core.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.ecp.IS1220.project.MyFoodora.core.Courier;
import fr.ecp.IS1220.project.MyFoodora.core.MyFoodora;

public class CourierTest {
	static MyFoodora foodora = new MyFoodora(0.1, 0.1, 0.1);
	static Courier Fred = new Courier("Fred", "fredo", "fred", 0, 10, "Fred@laposte.net", "0612345678");

	@Test
	public void testRegister() {
		Fred.register(foodora);
		assertTrue(foodora.getUserList().containsValue(Fred));
	}

	@Test
	public void testUnregister() {
		Fred.register(foodora);
		assertTrue(foodora.getUserList().containsValue(Fred));
		Fred.unregister(foodora);
		assertTrue(!foodora.getUserList().containsValue(Fred));
	}

	@Test
	public void testGetSurname() {
		assertEquals("fredo",Fred.getSurname());
	}

	@Test
	public void testSetSurname() {
		Fred.setSurname("fredo2");
		assertEquals("fredo2",Fred.getSurname());
		Fred.setSurname("fredo");
		assertEquals("fredo",Fred.getSurname());
	}

	@Test
	public void testOnDuty() {
		Fred.setOnDuty(true);
		assertTrue(Fred.isOnDuty());
	}
}
