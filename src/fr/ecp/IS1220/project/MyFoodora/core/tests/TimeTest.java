package fr.ecp.IS1220.project.MyFoodora.core.tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

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
		Time.setAuto(false);
		Time t1 = Time.getTime();
		Time.addTime((long) 20);
		Time t2 = Time.getTime();
		Time.addTime((long) 100);
		assertTrue(t1.getSeconds() + 20 == t2.getSeconds());
	}

	@Test
	public void testAddTime() {
		Time.setAuto(false);
		Time t1 = Time.getTime();
		Time.addTime((long) 70);
		Time t2 = Time.getTime();
		Time.addTime((long) 100);
		assertTrue(t1.getSeconds() + 70 == t2.getSeconds());
	}

	@Test
	public void testCompareTo() {
		Time.setAuto(false);
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
	@Test
	public void testDate() {
		//Simulate as if the current actual time was "07/05/2017 15:54:12"
		Time current=new Time("07/05/2017 15:54:12");
		Time.addTime(-Time.getTime().getSeconds()+current.getSeconds());
		Time.setAuto(false);
		Time t7 = new Time("01/01/1970 01:00:00");
		assertTrue(t7.getSeconds()==0);
		Time t8 = new Time("19/11/2015 00:00:00");
		assertTrue(!t8.isLessThanOneMonth());
		Time t9 = new Time("25/04/2017 00:00:00");
		assertTrue(t9.isLessThanOneMonth());
		Time t10 = new Time("23/04/2017 00:00:00");
		assertTrue(t10.getSeconds()-1492898400==0);
		Time.addTime(-Time.getTime().getSeconds());
		assertTrue(Time.getTime().getSeconds()==0);
		System.out.println(Time.getTime().getSeconds());
	}
	
	@Test
	public void testAuto() throws InterruptedException {
		Time.setAuto(true);
		Time t11 = Time.getTime();
		TimeUnit.SECONDS.sleep(2);
		Time t12 = Time.getTime();
		assertTrue(t12.getSeconds()-t11.getSeconds()>0);
	}

}
