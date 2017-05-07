package fr.ecp.IS1220.project.MyFoodora.core;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
	/*
	 * This class allow manual time managment
	 */
	private static long currentTime = System.currentTimeMillis() / 1000;
	private Long seconds;
	// If the time is automatically updated
	static boolean auto = new Boolean(true);
	// In order to add time to an automatically updated time
	static long lastUnixTime = System.currentTimeMillis() / 1000;

	/**
	 * Constructs a Time object representing a date.
	 *
	 * @param seconds
	 *            Seconds spent since 01/01/1970 at 01:00:00
	 */
	public Time(Long seconds) {
		this.seconds = seconds;
	}

	/**
	 * Constructs a Time object representing a date.
	 *
	 * @param dateString
	 *            String representing the date in the format : dd/MM/yyyy
	 *            HH:mm:ss
	 */
	public Time(String dateString) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date;
		try {
			date = dateFormat.parse(dateString);
			this.seconds = date.getTime() / 1000;
		} catch (ParseException e) {
			System.out.println("Wrong time input ( dd/mm/yyyy hh:mm:ss expected ).");
			this.seconds = Time.getCurrentSeconds();
		}
	}

	/**
	 * Returns current simulated time's seconds. Update current simulated time
	 * if auto parameter is True.
	 *
	 * @return Seconds spent since 01/01/1970 at 01:00:00 according to simulated
	 *         current time
	 */
	private static Long getCurrentSeconds() {
		if (auto) {
			currentTime += (System.currentTimeMillis() / 1000 - lastUnixTime);
			lastUnixTime = System.currentTimeMillis() / 1000;
		}
		return currentTime;
	}

	/**
	 * Returns an instance of Time at current simulated time. It won't update
	 * anymore.
	 *
	 * @return Time instance at current simulated time
	 */
	static public Time getTime() {
		return new Time(getCurrentSeconds());
	}

	/**
	 * Returns auto parameter. If True, current simulated time is updated
	 * following actual current time.
	 *
	 * @return auto parameter
	 */
	public static boolean isAuto() {
		return auto;
	}

	/**
	 * Set auto parameter. If True, current simulated time is updated following
	 * actual current time.
	 *
	 * @param auto
	 *            boolean required parameter
	 */
	public static void setAuto(boolean auto) {
		Time.auto = auto;
	}

	/**
	 * Add secconds to the current simulated time
	 *
	 * @param seconds
	 *            Seconds (Long) to be added
	 */
	static public void addTime(Long seconds) {
		currentTime += seconds;
	}

	/**
	 * Add minutes to the current simulated time
	 *
	 * @param minutes
	 *            Minutes (int) to be added
	 */
	static public void addMinutes(int minutes) {
		Time.addTime((long) minutes * 60);
	}

	/**
	 * Add hours to the current simulated time
	 *
	 * @param hours
	 *            Hours (int) to be added
	 */
	static public void addHours(int hours) {
		Time.addTime((long) hours * 60 * 60);
	}

	/**
	 * Add days to the current simulated time
	 *
	 * @param days
	 *            Days (int) to be added
	 */
	static public void addDays(int days) {
		Time.addTime((long) days * 24 * 60 * 60);
	}

	/**
	 * Return seconds spent since 01/01/1970 at 01:00:00 for the instance of
	 * Time.
	 *
	 * @return Long seconds spent since 01/01/1970 at 01:00:00 for the instance
	 *         of Time.
	 */
	public Long getSeconds() {
		return this.seconds;
	}

	/**
	 * Compares the time instance to another one
	 *
	 * @param time
	 *            Time instance to compare
	 * @return Long seconds Difference between the two instances second
	 *         parameter
	 */
	public long compareTo(Time time) {
		return this.getSeconds() - time.getSeconds();
	}

	/**
	 * Return true if the time instance is less than one day before the current
	 * simulated instance
	 *
	 * @return boolean true if the time instance is less than one day before the
	 *         current simulated instance
	 *
	 */
	public boolean isLessThanOneDay() {
		long difference = getCurrentSeconds() - seconds;
		return difference < 24 * 60 * 60 && difference > 0;
	}

	/**
	 * Return true if the time instance is less than one month (30 days) before
	 * the current simulated instance
	 *
	 * @return boolean true if the time instance is less than one month before
	 *         the current simulated instance
	 *
	 */
	public boolean isLessThanOneMonth() {
		long difference = getCurrentSeconds() - seconds;
		return difference < 30 * 24 * 60 * 60 && difference > 0;
	}

	/**
	 * Return String representation of Time instance
	 *
	 * @return String representation of Time instance
	 *
	 */
	@Override
	public String toString() {
		return new Date(seconds * 1000).toString();
	}

}
