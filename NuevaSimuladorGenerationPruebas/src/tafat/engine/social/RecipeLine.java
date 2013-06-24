package tafat.engine.social;

public class RecipeLine {
	Class<?> powerConsumer;
	int [] rangeStartTime;
	int startTime = -1;
	int [] rangeDurationTime;
	int durationTime = -1;
	Object specialHandling;
	
	public RecipeLine(Class<?> powerConsumer, int[] startTime, int[] durationTime, Object specialHandling){
		this.powerConsumer = powerConsumer;
		this.rangeStartTime = startTime;
		this.rangeDurationTime = durationTime;
		this.specialHandling = specialHandling;
	}
	
	public RecipeLine(Class<?> powerConsumer, int startTime, int durationTime, Object specialHandling){
		this.powerConsumer = powerConsumer;
		this.startTime = startTime;
		this.durationTime = durationTime;
		this.specialHandling = specialHandling;
	}
	
	public Class<?> getPowerConsumer(){
		return powerConsumer;
	}
	
	public int[] getStartTimeRange(){
		return rangeStartTime;
	}
	
	public int getStartTime(){
		return startTime;
	}
	
	public int[] getDurationTimeRange(){
		return  rangeDurationTime;
	}
	
	public int getDurationTime(){
		return durationTime;
	}
	
	public void setDurationTime(int time){
		durationTime = time;
	}
	
	public void setStartTime(int time){
		startTime = time;
	}
	
	public Object getSpecialHandling(){
		return specialHandling;
	}
}
