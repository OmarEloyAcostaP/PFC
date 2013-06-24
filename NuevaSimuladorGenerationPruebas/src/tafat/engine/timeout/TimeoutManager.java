package tafat.engine.timeout;

import java.util.ArrayList;

import tafat.engine.Console;

public class TimeoutManager {
	private ArrayList <Timeout> timeoutList = new ArrayList <Timeout> ();
	private static TimeoutManager instance = null;
	private int idToReturn = -1; 
	
	private TimeoutManager(){
		this.timeoutList.clear();
		this.idToReturn = -1;
	}
	
	public static void createInstance(){
		if (instance == null)
			instance = new TimeoutManager();
	}
	
	public static TimeoutManager getInstance(){
		return instance;
	}
	
	public static void clear (){
		instance = null;
	}
	public void tick(){
		ArrayList <Timeout> timeoutToRemove = new ArrayList <Timeout> ();
		for (Timeout timeout : instance.timeoutList){
			if(timeout.stopped) continue;
			timeout.time--;
			if (timeout.time == 0){
				//timeout.handler.execute(timeout.data);
				timeoutToRemove.add(timeout);
			}
		}
		for (Timeout timeout : timeoutToRemove){
			timeout.handler.execute(timeout.data);
			instance.timeoutList.remove(timeout);
		}
	}
	
	public int add (int time, TimeoutHandler handler, Object data){
		/* To DISCUSS, if time == 0, execute handler NOW and not Adding */
		if (time<0){
			Console.error("Timeout with negative time, not ADDED");
			return -1;
		}
		idToReturn++;
		if (time==0){
			handler.execute(data);
			return idToReturn;
		}
		synchronized(timeoutList){
			timeoutList.add(new Timeout(idToReturn, time, handler, data));
		}
		return idToReturn;
	}
	
	public void stopTimeout (int id){
		synchronized(timeoutList){
			for (Timeout timeout : timeoutList){
				if (timeout.id == id){
					timeout.stopped = true;
					return;
				}
			}
		}
	}
	
	public void continueTimeout (int id){
		synchronized(timeoutList){
			for (Timeout timeout : timeoutList){
				if (timeout.id == id){
					timeout.stopped = false;
					return;
				}
			}
		}
	}
}
