package tafat.metamodel.handler;

import tafat.engine.Time;
import tafat.engine.social.ActionMaker;
import tafat.engine.social.DeviceHandler;
import tafat.engine.social.RecipeLine;
import tafat.engine.timeout.TimeoutHandler;
import tafat.engine.timeout.TimeoutManager;
import tafat.metamodel.entity.DishwasherFull;

public class DishwasherFullHandler extends DeviceHandler {

	DishwasherFull dishwasher;
	int mission;
	int actionId;
	boolean notify;
	
	public DishwasherFullHandler (ActionMaker actionMaker, DishwasherFull dishwasher, int mission, boolean notify){
		this.actionMakerCaller = actionMaker;
		this.dishwasher = dishwasher;
		this.mission = mission;
		this.notify = notify;
	}
	
	@Override
	public void startDevice(RecipeLine recipeLine) {
		String specialHandling = (String) recipeLine.getSpecialHandling();
		if (recipeLine.getStartTime() == 0){
			if (specialHandling.equals("OFF"))
				dishwasher.mode = DishwasherFull.Mode.OFF;
			else if (specialHandling.equals("ON_ECO"))
				dishwasher.mode = DishwasherFull.Mode.ON_ECO;
			else if (specialHandling.equals("ON_INTENSIVE"))
				dishwasher.mode = DishwasherFull.Mode.ON_INTENSIVE;
			else if (specialHandling.equals("ON_NORMAL"))
				dishwasher.mode = DishwasherFull.Mode.ON_NORMAL;
		}
		else{
			TimeoutHandler timeoutOn = new TimeoutHandler() {
				
				@Override
				public void execute(Object data) {
					String specialHandling = (String)data;
					if (specialHandling.equals("OFF"))
						dishwasher.mode = DishwasherFull.Mode.OFF;
					else if (specialHandling.equals("ON_ECO"))
						dishwasher.mode = DishwasherFull.Mode.ON_ECO;
					else if (specialHandling.equals("ON_INTENSIVE"))
						dishwasher.mode = DishwasherFull.Mode.ON_INTENSIVE;
					else if (specialHandling.equals("ON_NORMAL"))
						dishwasher.mode = DishwasherFull.Mode.ON_NORMAL;
				}
				
			};
			TimeoutManager.getInstance().add(recipeLine.getStartTime() * Time.getInstance().minute, timeoutOn, specialHandling);
		}
	}

}
