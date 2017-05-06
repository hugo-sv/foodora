package fr.ecp.IS1220.project.MyFoodora.core;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
	/*
	 * This class allow manual time managment
	 */
	private static long currentTime=System.currentTimeMillis() / 1000;
	private Long seconds;
	// If the time is automatically updated
	static boolean auto = new Boolean(true);
	// In order to add time to an automatically updated time
	static long lastUnixTime = System.currentTimeMillis() / 1000;

	public Time(Long seconds) {
		this.seconds = seconds;
	}

	public Time(String dateString) {
		// Return a Time instance at the given date, considering that 0 seconds
		// corresponds to the 01/01/1970 at 01:00:00
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date;
		try {
			date = dateFormat.parse(dateString);
			this.seconds=date.getTime()/1000;
		} catch (ParseException e) {
			System.out.println("Wrong time input ( dd/mm/yyyy hh:mm:ss expected ).");
			this.seconds=Time.getCurrentSeconds();
		}
	}

	private static Long getCurrentSeconds() {
		if (auto) {
			currentTime+=(System.currentTimeMillis() / 1000 - lastUnixTime);
			lastUnixTime = System.currentTimeMillis() / 1000;
		}
		return currentTime;
	}

	static public Time getTime() {
		return new Time(getCurrentSeconds());
	}

	public static boolean isAuto() {
		return auto;
	}

	public static void setAuto(boolean auto) {
		Time.auto = auto;
	}

	static public void addTime(Long seconds) {
		currentTime+=seconds;
	}

	static public void addSeconds(int seconds) {
		Time.addTime((long) seconds);
	}

	static public void addMinutes(int minutes) {
		Time.addTime((long) minutes * 60);
	}

	static public void addHours(int hours) {
		Time.addTime((long) hours * 60 * 60);
	}

	static public void addDays(int days) {
		Time.addTime((long) days * 24 * 60 * 60);
	}

	static public void addMonths(int months) {
		Time.addTime((long) months * 30 * 24 * 60 * 60);
	}

	public Long getSeconds() {
		return this.seconds;
	}

	public long compareTo(Time time) {
		return this.getSeconds() - time.getSeconds();
	}

	public boolean isLessThanOneDay() {
		long difference = getCurrentSeconds() - seconds;
		return difference < 24*60*60 && difference>0;
	}

	public boolean isLessThanOneMonth() {
		long difference = getCurrentSeconds() - seconds;
		return difference < 30*24*60*60 && difference>0;
	}

	@Override
	public String toString() {
		return new Date(seconds*1000).toString();
	}

}
