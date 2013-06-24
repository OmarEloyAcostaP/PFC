package tafat.metamodel.handler;

import tafat.engine.Time;
import tafat.engine.social.ActionMaker;
import tafat.engine.social.DeviceHandler;
import tafat.engine.social.RecipeLine;
import tafat.engine.timeout.TimeoutHandler;
import tafat.engine.timeout.TimeoutManager;
import tafat.metamodel.entity.AudioHifiFull;

public class AudioHifiFullHandler extends DeviceHandler {

	AudioHifiFull audioHifi;
	int mission;
	int actionId;
	boolean notify;
	
	public AudioHifiFullHandler (ActionMaker actionMaker, AudioHifiFull audioHifi, int mission, boolean notify){
		this.actionMakerCaller = actionMaker;
		this.audioHifi = audioHifi;
		this.mission = mission;
		this.notify = notify;
	}
	
	@Override
	public void startDevice(RecipeLine recipeLine) {
		String[] specialHandling = (String[]) recipeLine.getSpecialHandling();
		if (recipeLine.getStartTime() == 0){
			if (specialHandling[0].equals("OFF"))
				audioHifi.mode = AudioHifiFull.Mode.OFF;
			else if (specialHandling[0].equals("ON"))
				audioHifi.mode = AudioHifiFull.Mode.ON;
			else if (specialHandling[0].equals("STANDBY"))
				audioHifi.mode = AudioHifiFull.Mode.STANDBY;
		}
		else{
			Object[] data = {specialHandling[0], recipeLine.getDurationTime()};
			TimeoutHandler timeoutOn = new TimeoutHandler() {
				
				@Override
				public void execute(Object data) {
					String specialHandling = (String) ((Object[]) data)[0];
					int durationTime = (Integer) ((Object[]) data)[1];
					if (specialHandling.equals("OFF"))
						audioHifi.mode = AudioHifiFull.Mode.OFF;
					else if (specialHandling.equals("ON"))
						audioHifi.mode = AudioHifiFull.Mode.ON;
					else if (specialHandling.equals("STANDBY"))
						audioHifi.mode = AudioHifiFull.Mode.STANDBY;
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
					audioHifi.mode = AudioHifiFull.Mode.OFF;
				else if (specialHandling.equals("ON"))
					audioHifi.mode = AudioHifiFull.Mode.ON;
				else if (specialHandling.equals("STANDBY"))
					audioHifi.mode = AudioHifiFull.Mode.STANDBY;
				if (notify){
					Object[] dataToSend = {"FINISHED", mission};
					actionMakerCaller.receiveMessage(dataToSend);
				}
			}
			
		};
		TimeoutManager.getInstance().add((recipeLine.getStartTime() + recipeLine.getDurationTime()) * Time.getInstance().minute, timeoutOn, specialHandling[1]);
	}

}
