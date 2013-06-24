package tafat.metamodel.handler;

import tafat.engine.Time;
import tafat.engine.social.ActionMaker;
import tafat.engine.social.DeviceHandler;
import tafat.engine.social.RecipeLine;
import tafat.engine.timeout.TimeoutHandler;
import tafat.engine.timeout.TimeoutManager;
import tafat.metamodel.entity.ElectricalToolFull;

public class ElectricalToolsFullHandler extends DeviceHandler {

	ElectricalToolFull electricalTool;
	int mission;
	boolean notify;
	
	public ElectricalToolsFullHandler (ActionMaker actionMaker, ElectricalToolFull electricalTool, int mission, boolean notify){
		this.actionMakerCaller = actionMaker;
		this.electricalTool = electricalTool;
		this.mission = mission;
		this.notify = notify;
	}
	
	@Override
	public void startDevice(RecipeLine recipeLine) {
		if (recipeLine.getStartTime() == 0){
			electricalTool.mode = ElectricalToolFull.Mode.ON;
		}
		else{
			TimeoutHandler timeoutOn = new TimeoutHandler() {
				
				@Override
				public void execute(Object data) {
					int durationTime = (Integer)data;
					electricalTool.mode = ElectricalToolFull.Mode.ON;
					if (durationTime == -1){
						if (notify){
							Object[] dataToSend = {"FINISHED", mission};
							actionMakerCaller.receiveMessage(dataToSend);
						}
					}
				}
				
			};
			TimeoutManager.getInstance().add(recipeLine.getStartTime() * Time.getInstance().minute, timeoutOn, recipeLine.getDurationTime());
		}
		if (recipeLine.getDurationTime() == -1)
			return;
		
		TimeoutHandler timeoutOn = new TimeoutHandler() {
			
			@Override
			public void execute(Object data) {
				electricalTool.mode = ElectricalToolFull.Mode.OFF;
				if (notify){
					Object[] dataToSend = {"FINISHED", mission};
					actionMakerCaller.receiveMessage(dataToSend);
				}
			}
			
		};
		TimeoutManager.getInstance().add((recipeLine.getStartTime() + recipeLine.getDurationTime()) * Time.getInstance().minute, timeoutOn, null);
	}

}
