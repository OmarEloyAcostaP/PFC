package tafat.metamodel.handler;

import tafat.engine.Time;
import tafat.engine.social.ActionMaker;
import tafat.engine.social.DeviceHandler;
import tafat.engine.social.RecipeLine;
import tafat.engine.timeout.TimeoutHandler;
import tafat.engine.timeout.TimeoutManager;
import tafat.metamodel.entity.CoffeeMakerFull;

public class CoffeeMakerFullHandler extends DeviceHandler {

	CoffeeMakerFull coffeeMaker;
	int mission;
	int actionId;
	boolean notify;
	
	public CoffeeMakerFullHandler (ActionMaker actionMaker, CoffeeMakerFull coffeeMaker, int mission, boolean notify){
		this.actionMakerCaller = actionMaker;
		this.coffeeMaker = coffeeMaker;
		this.mission = mission;
		this.notify = notify;
	}
	
	@Override
	public void startDevice(RecipeLine recipeLine) {
		String specialHandling = (String) recipeLine.getSpecialHandling();
		if (recipeLine.getStartTime() == 0){
			if (specialHandling.equals("OFF"))
				coffeeMaker.mode = CoffeeMakerFull.Mode.OFF;
			else if (specialHandling.equals("STANDBY"))
				coffeeMaker.mode = CoffeeMakerFull.Mode.STANDBY;
			else if (specialHandling.equals("ON"))
				coffeeMaker.mode = CoffeeMakerFull.Mode.ON;
		}
		else{
			TimeoutHandler timeoutOn = new TimeoutHandler() {
				
				@Override
				public void execute(Object data) {
					String specialHandling = (String)data;
					if (specialHandling.equals("OFF"))
						coffeeMaker.mode = CoffeeMakerFull.Mode.OFF;
					else if (specialHandling.equals("STANDBY"))
						coffeeMaker.mode = CoffeeMakerFull.Mode.STANDBY;
					else if (specialHandling.equals("ON"))
						coffeeMaker.mode = CoffeeMakerFull.Mode.ON;
				}
				
			};
			TimeoutManager.getInstance().add(recipeLine.getStartTime() * Time.getInstance().minute, timeoutOn, specialHandling);
		}
	}

}
