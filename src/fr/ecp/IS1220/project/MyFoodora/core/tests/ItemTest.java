package fr.ecp.IS1220.project.MyFoodora.core.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.ecp.IS1220.project.MyFoodora.core.menu.Dessert;

public class ItemTest {
	static Dessert dessert = new Dessert("Tarte à la rubarbe", 23, true, false);
	@Test
	public void testIsVegetarian() {
		assertTrue(dessert.isVegetarian());
	}

}
