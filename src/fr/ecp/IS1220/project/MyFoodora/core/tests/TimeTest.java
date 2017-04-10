package fr.ecp.IS1220.project.MyFoodora.core.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.ecp.IS1220.project.MyFoodora.core.Time;

public class TimeTest {

	@Test
	public void testGetTime() {
		Time t0 = Time.getTime();
		assertEquals(Time.getTime().getSeconds(),t0.getSeconds(), 0.0001);
	}

	@Test
	public void testGetSeconds() {
		Time t1 = Time.getTime();
		Time.addTime((long) 20);
		Time t2 = Time.getTime();
		Time.addTime((long) 100);
		assertTrue(t1.getSeconds() + 20 == t2.getSeconds());
	}

	@Test
	public void testAddTime() {
		Time t1 = Time.getTime();
		Time.addTime((long) 70);
		Time t2 = Time.getTime();
		Time.addTime((long) 100);
		assertTrue(t1.getSeconds() + 70 == t2.getSeconds());
	}

	@Test
	public void testCompareTo() {
		Time t3 = Time.getTime();
		Time.addTime((long) 7000);
		Time t4 = Time.getTime();
		Time.addTime((long) 1000);
		assertTrue(t3.compareTo(t4) == -7000);
	}

	@Test
	public void testIsLessThanOneDay() {
		Time t5 = Time.getTime();
		Time.addTime((long) 7000);
		assertTrue(t5.isLessThanOneDay());
		Time.addTime((long) 86400);
		assertTrue(!t5.isLessThanOneDay());
	}

	@Test
	public void testIsLessThanOneMonth() {
		Time t6 = Time.getTime();
		Time.addTime((long) 7000);
		assertTrue(t6.isLessThanOneMonth());
		Time.addTime((long) 86400);
		assertTrue(t6.isLessThanOneMonth());
		Time.addTime((long) 86400*31);
		assertTrue(!t6.isLessThanOneMonth());
	}

}
