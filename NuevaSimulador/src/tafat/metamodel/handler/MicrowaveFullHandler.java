package tafat.metamodel.handler;

import tafat.engine.Time;
import tafat.engine.social.ActionMaker;
import tafat.engine.social.DeviceHandler;
import tafat.engine.social.RecipeLine;
import tafat.engine.timeout.TimeoutHandler;
import tafat.engine.timeout.TimeoutManager;
import tafat.metamodel.entity.MicrowaveFull;

public class MicrowaveFullHandler extends DeviceHandler {

	MicrowaveFull microwave;
	int mission;
	boolean notify;
	
	public MicrowaveFullHandler (ActionMaker actionMaker, MicrowaveFull microwave, int mission, boolean notify){
		this.actionMakerCaller = actionMaker;
		this.microwave = microwave;
		this.mission = mission;
		this.notify = notify;
	}
	
	@Override
	public void startDevice(RecipeLine recipeLine) {
		String[] specialHandling = (String[]) recipeLine.getSpecialHandling();
		if (recipeLine.getStartTime() == 0){
			if (specialHandling[0].equals("OFF"))
				microwave.mode = MicrowaveFull.Mode.OFF;
			else if (specialHandling[0].equals("ON800"))
				microwave.mode = MicrowaveFull.Mode.ON_800;
			else if (specialHandling[0].equals("ON900"))
				microwave.mode = MicrowaveFull.Mode.ON_900;
			else if (specialHandling[0].equals("ON1000"))
				microwave.mode = MicrowaveFull.Mode.ON_1000;
			else if (specialHandling[0].equals("ONDEFROST"))
				microwave.mode = MicrowaveFull.Mode.ON_DEFROST;
			else if (specialHandling[0].equals("STANDBY"))
				microwave.mode = MicrowaveFull.Mode.STANDBY;
		}
		else{
			Object[] data = {specialHandling[0], recipeLine.getDurationTime()};
			TimeoutHandler timeoutOn = new TimeoutHandler() {
				
				@Override
				public void execute(Object data) {
					String specialHandling = (String) ((Object[]) data)[0];
					int durationTime = (Integer) ((Object[]) data)[1];
					if (specialHandling.equals("OFF"))
						microwave.mode = MicrowaveFull.Mode.OFF;
					else if (specialHandling.equals("ON800"))
						microwave.mode = MicrowaveFull.Mode.ON_800;
					else if (specialHandling.equals("ON900"))
						microwave.mode = MicrowaveFull.Mode.ON_900;
					else if (specialHandling.equals("ON1000"))
						microwave.mode = MicrowaveFull.Mode.ON_1000;
					else if (specialHandling.equals("ONDEFROST"))
						microwave.mode = MicrowaveFull.Mode.ON_DEFROST;
					else if (specialHandling.equals("STANDBY"))
						microwave.mode = MicrowaveFull.Mode.STANDBY;
					if (durationTime == -1){
						if (notify){
							Object[] dataToSend = {"FINISHED", mission};
							actionMakerCaller.receiveMessage(dataToSend);
						}
					}
				}
				
			};
			TimeoutManager.getInstance().add(recipeLine.getStartTime() * Time.getInstance().minute, timeoutOn, data);
		}
		if (recipeLine.getDurationTime() == -1)
			return;
		
		TimeoutHandler timeoutOn = new TimeoutHandler() {
			
			@Override
			public void execute(Object data) {
				String specialHandling = (String) data;
				if (specialHandling.equals("OFF"))
					microwave.mode = MicrowaveFull.Mode.OFF;
				else if (specialHandling.equals("ON800"))
					microwave.mode = MicrowaveFull.Mode.ON_800;
				else if (specialHandling.equals("ON900"))
					microwave.mode = MicrowaveFull.Mode.ON_900;
				else if (specialHandling.equals("ON1000"))
					microwave.mode = MicrowaveFull.Mode.ON_1000;
				else if (specialHandling.equals("ONDEFROST"))
					microwave.mode = MicrowaveFull.Mode.ON_DEFROST;
				else if (specialHandling.equals("STANDBY"))
					microwave.mode = MicrowaveFull.Mode.STANDBY;
				if (notify){
					Object[] dataToSend = {"FINISHED", mission};
					actionMakerCaller.receiveMessage(dataToSend);
				}
			}
			
		};
		TimeoutManager.getInstance().add((recipeLine.getStartTime() + recipeLine.getDurationTime()) * Time.getInstance().minute, timeoutOn, specialHandling[1]);
	}

}
