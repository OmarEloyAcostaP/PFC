package tafat.engine.timeout;

public abstract class TimeoutCyclic {

	TimeoutHandler timeoutHandler;
	int times;
	int step;
	
	public TimeoutCyclic (int stepin, int timesin) {
		
		this.step = stepin;
		this.times = timesin;
	
		timeoutHandler = new TimeoutHandler(){

			@Override
			public void execute(Object data) {
				if (times > 0){
					action();
					TimeoutManager.getInstance().add (step, this, null);
					times--;
				}
			}
			
		};
		TimeoutManager.getInstance().add (step, timeoutHandler, null);
	}
	
	public TimeoutCyclic (int stepin) {
		this.step = stepin;
		timeoutHandler = new TimeoutHandler(){

			@Override
			public void execute(Object data) {
				action();
				TimeoutManager.getInstance().add (step, this, null);
			}
		};
		TimeoutManager.getInstance().add (step, timeoutHandler, null);
	}
	
	public abstract void action();
}
