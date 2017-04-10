package fr.ecp.IS1220.project.MyFoodora.core.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.ecp.IS1220.project.MyFoodora.core.Courier;
import fr.ecp.IS1220.project.MyFoodora.core.Customer;
import fr.ecp.IS1220.project.MyFoodora.core.MyFoodora;

public class CustomerTest {
	static MyFoodora foodora = new MyFoodora(0.1, 0.1, 0.1);
	static Customer Michel = new Customer("Michel", "Michou", "michmich", 0, 10, "michel@laposte.net", "0612345678");

	@Test
	public void testGetAccountInfo() {
		assertEquals("Name : Michel\nSurname : Michou\nEmail : michel@laposte.net\nPhone number : 0612345678\nFidelity card : Basic fidelity card\nOrders :",Michel.getAccountInfo());
	}

	@Test
	public void testNotifyString() {
		fail("Not yet implemented");
	}

	@Test
	public void testRegister() {
		fail("Not yet implemented");
	}

	@Test
	public void testUnregister() {
		fail("Not yet implemented");
	}

	@Test
	public void testPayOrder() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSurname() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSurname() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOrders() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFidelityCard() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetFidelityCard() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNotifyMean() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNotifyMean() {
		fail("Not yet implemented");
	}
}