package tafat.metamodel.handler;

import tafat.engine.Time;
import tafat.engine.social.ActionMaker;
import tafat.engine.social.DeviceHandler;
import tafat.engine.social.RecipeLine;
import tafat.engine.timeout.TimeoutHandler;
import tafat.engine.timeout.TimeoutManager;
import tafat.metamodel.entity.DryerFull;

public class DryerFullHandler extends DeviceHandler {

	DryerFull dryer;
	int mission;
	int actionId;
	boolean notify;
	
	public DryerFullHandler (ActionMaker actionMaker, DryerFull dryer, int mission, boolean notify){
		this.actionMakerCaller = actionMaker;
		this.dryer = dryer;
		this.mission = mission;
		this.notify = notify;
	}
	
	@Override
	public void startDevice(RecipeLine recipeLine) {
		String specialHandling = (String) recipeLine.getSpecialHandling();
		if (recipeLine.getStartTime() == 0){
			if (specialHandling.equals("OFF"))
				dryer.mode = DryerFull.Mode.OFF;
			else if (specialHandling.equals("ON"))
				dryer.mode = DryerFull.Mode.ON;
		}
		else{
			TimeoutHandler timeoutOn = new TimeoutHandler() {
				
				@Override
				public void execute(Object data) {
					String specialHandling = (String)data;
					if (specialHandling.equals("OFF"))
						dryer.mode = DryerFull.Mode.OFF;
					else if (specialHandling.equals("ON"))
						dryer.mode = DryerFull.Mode.ON;
				}
				
			};
			TimeoutManager.getInstance().add(recipeLine.getStartTime() * Time.getInstance().minute, timeoutOn, specialHandling);
		}
	}

}
