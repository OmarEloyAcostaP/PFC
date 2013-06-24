package tafat.metamodel.handler;

import tafat.engine.Time;
import tafat.engine.social.ActionMaker;
import tafat.engine.social.DeviceHandler;
import tafat.engine.social.RecipeLine;
import tafat.engine.timeout.TimeoutHandler;
import tafat.engine.timeout.TimeoutManager;
import tafat.metamodel.entity.RefrigeratorFull;

public class RefrigeratorFullHandler extends DeviceHandler {

	RefrigeratorFull refrigerator;
	int mission;
	int actionId;
	boolean notify;
	
	public RefrigeratorFullHandler (ActionMaker actionMaker, RefrigeratorFull refrigerator, int mission, boolean notify){
		this.actionMakerCaller = actionMaker;
		this.refrigerator = refrigerator;
		this.mission = mission;
		this.notify = notify;
	}
	
	@Override
	public void startDevice(RecipeLine recipeLine) {
		String[] specialHandling = (String[]) recipeLine.getSpecialHandling();
		if (recipeLine.getStartTime() == 0){
			if (specialHandling[0].equals("OFF"))
				refrigerator.mode = RefrigeratorFull.Mode.OFF;
			else if (specialHandling[0].equals("ON"))
				refrigerator.mode = RefrigeratorFull.Mode.ON;
			else if (specialHandling[0].equals("STANDBY"))
				refrigerator.mode = RefrigeratorFull.Mode.STANDBY;
		}
		else{
			Object[] data = {specialHandling[0], recipeLine.getDurationTime()};
			TimeoutHandler timeoutOn = new TimeoutHandler() {
				
				@Override
				public void execute(Object data) {
					String specialHandling = (String) ((Object[]) data)[0];
					int durationTime = (Integer) ((Object[]) data)[1];
					if (specialHandling.equals("OFF"))
						refrigerator.mode = RefrigeratorFull.Mode.OFF;
					else if (specialHandling.equals("ON"))
						refrigerator.mode = RefrigeratorFull.Mode.ON;
					else if (specialHandling.equals("STANDBY"))
						refrigerator.mode = RefrigeratorFull.Mode.STANDBY;
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
		if (recipeLine.getDurationTime() == -1){
			if (notify){
				Object[] dataToSend = {"FINISHED", mission};
				actionMakerCaller.receiveMessage(dataToSend);
			}
			return;
		}
		
		TimeoutHandler timeoutOn = new TimeoutHandler() {
			
			@Override
			public void execute(Object data) {
				String specialHandling = (String) data;
				if (specialHandling.equals("OFF"))
					refrigerator.mode = RefrigeratorFull.Mode.OFF;
				else if (specialHandling.equals("ON"))
					refrigerator.mode = RefrigeratorFull.Mode.ON;
				else if (specialHandling.equals("STANDBY"))
					refrigerator.mode = RefrigeratorFull.Mode.STANDBY;
				if (notify){
					Object[] dataToSend = {"FINISHED", mission};
					actionMakerCaller.receiveMessage(dataToSend);
				}
			}
			
		};
		TimeoutManager.getInstance().add((recipeLine.getStartTime() + recipeLine.getDurationTime()) * Time.getInstance().minute, timeoutOn, specialHandling[1]);
	}

}
