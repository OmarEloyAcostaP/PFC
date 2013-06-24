package tafat.metamodel.handler;

import tafat.engine.Time;
import tafat.engine.Tools;
import tafat.engine.social.ActionMaker;
import tafat.engine.social.DeviceHandler;
import tafat.engine.social.RecipeLine;
import tafat.engine.timeout.TimeoutHandler;
import tafat.engine.timeout.TimeoutManager;
import tafat.metamodel.entity.LightingFull;

public class LightingFullHandler extends DeviceHandler {

	LightingFull lighting;
	int mission;
	boolean notify;
	
	public LightingFullHandler (ActionMaker actionMaker, LightingFull lighting, int mission, boolean notify){
		this.actionMakerCaller = actionMaker;
		this.lighting = lighting;
		this.mission = mission;
		this.notify = notify;
	}
	
	@Override
	public void startDevice(RecipeLine recipeLine) {
		double[] installedPowerUsageRateRange = (double[]) recipeLine.getSpecialHandling();
		double installedPowerUsageRate = Tools.randomInRangeDouble (installedPowerUsageRateRange[0], installedPowerUsageRateRange[1]);
		if (recipeLine.getStartTime() == 0){
			lighting.installedPowerUsageRate = installedPowerUsageRate;
			if (lighting.installedPowerUsageRate == 0)
				lighting.mode = LightingFull.Mode.OFF;
			else
				lighting.mode = LightingFull.Mode.ON;
		}
		else{
			Object[] data = {installedPowerUsageRate, recipeLine.getDurationTime()};
			
			TimeoutHandler timeoutOn = new TimeoutHandler() {
				
				@Override
				public void execute(Object data) {
					lighting.installedPowerUsageRate = (Double) ((Object[]) data)[0];
					int durationTime = (Integer) ((Object[]) data)[1];
					if (lighting.installedPowerUsageRate == 0)
						lighting.mode = LightingFull.Mode.OFF;
					else
						lighting.mode = LightingFull.Mode.ON;
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
		
		installedPowerUsageRate = Tools.randomInRangeDouble (installedPowerUsageRateRange[2], installedPowerUsageRateRange[3]);
		
		TimeoutHandler timeoutOn = new TimeoutHandler() {
			
			@Override
			public void execute(Object data) {
				lighting.installedPowerUsageRate = (Double) data;
				lighting.mode = LightingFull.Mode.OFF;
				if (notify){
					Object[] dataToSend = {"FINISHED", mission};
					actionMakerCaller.receiveMessage(dataToSend);
				}
			}
			
		};
		TimeoutManager.getInstance().add((recipeLine.getStartTime() + recipeLine.getDurationTime()) * Time.getInstance().minute, timeoutOn, installedPowerUsageRate);
	}
}
