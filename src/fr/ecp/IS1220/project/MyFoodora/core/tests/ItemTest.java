package fr.ecp.IS1220.project.MyFoodora.core.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.ecp.IS1220.project.MyFoodora.core.menu.Dessert;

public class ItemTest {
	static Dessert dessert = new Dessert("Tarte à la rubarbe", 23, true, false);

	@Test
	public void testGetName() {
		assertEquals("Tarte à la rubarbe", dessert.getName());
	}

	@Test
	public void testSetName() {
		dessert.setName("Tarte pas bonne");
		assertEquals("Tarte pas bonne", dessert.getName());
	}

	@Test
	public void testGetPrice() {
		assertTrue(dessert.getPrice() == 23);
	}

	@Test
	public void testSetPrice() {
		dessert.setPrice(58);
		assertTrue(dessert.getPrice() == 58);
	}

	@Test
	public void testIsVegetarian() {
		assertTrue(dessert.isVegetarian());
	}

	@Test
	public void testIsStandard() {
		assertFalse(dessert.isStandard());
	}

	@Test
	public void testIsGlutenFree() {
		assertFalse(dessert.isGlutenFree());
	}

}
