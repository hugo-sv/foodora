package fr.ecp.IS1220.project.MyFoodora.core;

public class Time {
	private static Time currentTime=new Time(new Long(0));
	private Long seconds;
	private Time(Long seconds){
		this.seconds=seconds;
	}
	static public Time getTime(){
		return new Time(currentTime.getSeconds());
	}
	public Long getSeconds(){
		return this.seconds;
	}
	public void addTime(Long seconds){
		currentTime.setSeconds(seconds+currentTime.getSeconds());
	}
	private void setSeconds(Long seconds) {
		this.seconds=seconds;
	}
	
	public int compareTo(Time time) {
		return this.getSeconds().compareTo(time.getSeconds());
	}
}
