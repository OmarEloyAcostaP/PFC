package tafat.metamodel.handler;

import tafat.engine.Time;
import tafat.engine.social.ActionMaker;
import tafat.engine.social.DeviceHandler;
import tafat.engine.social.RecipeLine;
import tafat.engine.timeout.TimeoutHandler;
import tafat.engine.timeout.TimeoutManager;
import tafat.metamodel.entity.WashingMachineFull;

public class WashingMachineFullHandler extends DeviceHandler {

	WashingMachineFull washingMachine;
	int mission;
	int actionId;
	boolean notify;
	
	public WashingMachineFullHandler (ActionMaker actionMaker, WashingMachineFull washingMachine, int mission, boolean notify){
		this.actionMakerCaller = actionMaker;
		this.washingMachine = washingMachine;
		this.mission = mission;
		this.notify = notify;
	}
	
	@Override
	public void startDevice(RecipeLine recipeLine) {
		String specialHandling = (String) recipeLine.getSpecialHandling();
		if (recipeLine.getStartTime() == 0){
			if (specialHandling.equals("OFF"))
				washingMachine.mode = WashingMachineFull.Mode.OFF;
			else if (specialHandling.equals("ON40"))
				washingMachine.mode = WashingMachineFull.Mode.ON40;
			else if (specialHandling.equals("ON60"))
				washingMachine.mode = WashingMachineFull.Mode.ON60;
			else if (specialHandling.equals("ON95"))
				washingMachine.mode = WashingMachineFull.Mode.ON95;
		}
		else{
			TimeoutHandler timeoutOn = new TimeoutHandler() {
				
				@Override
				public void execute(Object data) {
					String specialHandling = (String)data;
					if (specialHandling.equals("OFF"))
						washingMachine.mode = WashingMachineFull.Mode.OFF;
					else if (specialHandling.equals("ON40"))
						washingMachine.mode = WashingMachineFull.Mode.ON40;
					else if (specialHandling.equals("ON60"))
						washingMachine.mode = WashingMachineFull.Mode.ON60;
					else if (specialHandling.equals("ON95"))
						washingMachine.mode = WashingMachineFull.Mode.ON95;
				}
				
			};
			TimeoutManager.getInstance().add(recipeLine.getStartTime() * Time.getInstance().minute, timeoutOn, specialHandling);
		}
	}

}
