package fr.ecp.IS1220.project.MyFoodora.core;

public class Time {
	private static Time currentTime=new Time(0);
	private double seconds;
	private Time(double seconds){
		this.seconds=seconds;
	}
	public Time getTime(){
		return new Time(currentTime.getSeconds());
	}
	public double getSeconds(){
		return this.seconds;
	}
	public void addTime(double seconds){
		currentTime.setSeconds(seconds+currentTime.getSeconds());
	}
	private void setSeconds(double seconds) {
		this.seconds=seconds;
	}
}
