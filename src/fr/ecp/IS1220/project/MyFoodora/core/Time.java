package fr.ecp.IS1220.project.MyFoodora.core;

public class Time {
	private static Time currentTime = new Time(System.currentTimeMillis() / 1000);
	private Long seconds;
	// If the time is automatically updated
	static boolean auto = new Boolean(true);
	static long lastUnixTime=System.currentTimeMillis() / 1000;

	public Time(Long seconds) {
		this.seconds = seconds;
	}

	public Time(String date) {
		// Return a Time instance at the given date, considering that 0 seconds
		// corresponds to the 01/01/2017 at 00:00
		Long seconds = new Long(0);
		for (int i = 0; i < date.length(); i++) {
			if (i == 0) {// Dealing with days
				seconds += Integer.parseInt(Character.toString(date.charAt(i))) * 10 * 24 * 3600;
			} else if (i == 1) {// Dealing with days (months starts at day 1)
				seconds += (Integer.parseInt(Character.toString(date.charAt(i))) - 1) * 24 * 3600;
			} else if (i == 3) {// Dealing with months (considering that months
								// all last 30 days)
				seconds += Integer.parseInt(Character.toString(date.charAt(i))) * 10 * 30 * 24 * 3600;
			} else if (i == 4) {// Dealing with months (years starts at month 1)
				seconds += (Integer.parseInt(Character.toString(date.charAt(i))) - 1) * 30 * 24 * 3600;
			} else if (i == 6) {// Dealing with years (considering that they all
								// last 365 days
				// the 01/01/2017 at 00:00 corresponds to 0 seconds
				seconds += (Integer.parseInt(Character.toString(date.charAt(i))) - 2) * 1000 * 365 * 24 * 3600;
			} else if (i == 7) {// Dealing with years
				seconds += (Integer.parseInt(Character.toString(date.charAt(i)))) * 100 * 365 * 24 * 3600;
			} else if (i == 8) {// Dealing with years
				seconds += (Integer.parseInt(Character.toString(date.charAt(i))) - 1) * 10 * 365 * 24 * 3600;
			} else if (i == 9) {// Dealing with years
				seconds += (Integer.parseInt(Character.toString(date.charAt(i))) - 7) * 365 * 24 * 3600;
			}
		}
		this.seconds = seconds;
	}

	static public Time getTime() {
		if (auto){
			Time.addTime(System.currentTimeMillis() / 1000-lastUnixTime);
			lastUnixTime=System.currentTimeMillis() / 1000;
		}
		return new Time(currentTime.getSeconds());
	}

	public Long getSeconds() {
		return this.seconds;
	}

	static public void addTime(Long seconds) {
		currentTime.setSeconds(seconds + currentTime.getSeconds());
	}

	static public void addSeconds(int seconds) {
		Time.addTime((long) seconds);
	}

	static public void addMinutes(int minutes) {
		Time.addTime((long) minutes * 60 );
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

	private void setSeconds(Long seconds) {
		this.seconds = seconds;
	}

	public long compareTo(Time time) {
		return this.getSeconds() - time.getSeconds();
	}

	public boolean isLessThanOneDay() {
		return currentTime.getSeconds() - seconds < 2592000 / 30;
	}

	public boolean isLessThanOneMonth() {
		return currentTime.getSeconds() - seconds < 2592000;
	}

	public static boolean isAuto() {
		return auto;
	}

	public static void setAuto(boolean auto) {
		Time.auto = auto;
	}

}
