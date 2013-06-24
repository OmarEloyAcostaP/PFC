package tafat.engine.statechart;

import tafat.engine.timeout.TimeoutHandler;
import tafat.engine.timeout.TimeoutManager;

public abstract class Transition {

	public int source;
	public int destination;
	@SuppressWarnings("unused")
	private int idTimeout;
	public int time;
	public TimeoutHandler timeoutHandler = null;
	protected boolean condition = false;
	private boolean activated = false;
	
	public Transition(int source, int destination) {
		this.source = source;
		this.destination = destination;
	}
	
	// To use this constructor is recommended to have automatic update in the statechart
	public Transition(int source, int destination, int time) {
		this.source = source;
		this.destination = destination;
		this.time = time;
		timeoutHandler = new TimeoutHandler(){
			@Override
			public void execute(Object data) {
				condition = true;
				activated = false;
			}
			
		};
	}
	
	public void activate(){
		if (timeoutHandler != null){
			if (!activated){
				condition = false;
				idTimeout = TimeoutManager.getInstance().add(time, timeoutHandler, null);
				activated = true;
			}
		}
	}
	
	public boolean condition (){
		return condition;
	}
	
	public abstract void action();
}
