package tafat.engine;

import java.util.Calendar;
import java.util.Date;

public class Time {
	final public int minute = 60;
	final public int hour = 3600;
	final public int day = 86400;

	private Date initialDate;
	private Date finishDate;
	
	private long initialTimeMilliseconds;
	private long finishTimeMilliseconds;
	
	private int durationInTicks;
	private int currentTick = -1;
	
	
	private static Time instance = null;
	
	private Time (Date initialDate, Date finishDate){
		this.initialDate = initialDate;
		this.finishDate = finishDate;
		this.initialTimeMilliseconds = initialDate.getTime();
		this.finishTimeMilliseconds = finishDate.getTime();
		this.durationInTicks = (int) (finishTimeMilliseconds - initialTimeMilliseconds) / 1000;
		this.currentTick = -1;
	}
	
	public static void createInstance(Date initialDate, Date finishDate){
		if (instance == null){
			instance = new Time (initialDate, finishDate);
		}
	}
	
	public static Time getInstance (){
		return instance;
	}
	
	public int getSimulationSeconds(){
		return currentTick;
	}
	
	public int getSimulationMinutes(){
		return currentTick / minute;
	}
	
	public int getSimulationHours(){
		return currentTick / hour;
	}
	
	public int getSimulationDays(){
		return currentTick / day;
	}
	
	public Date getSimulationDate(){
		if (currentTick == -1)
			return new Date(initialTimeMilliseconds);
		long time = initialTimeMilliseconds + (currentTick * 1000);
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(time);
		return calendar.getTime();
	}
	
	public Date getFinishSimulationDate(){
		return finishDate;
	}
	
	public Date getInitialSimulationDate(){
		return initialDate;
	}
	
	public int getSimulationDurationTicks(){
		return durationInTicks;
	}
	
	public int getSimulationTick(){
		return currentTick;
	}
	
	public void tick(){
		currentTick++;
	}
	
	public static void clear() {
		instance = null;
	}
	
}
