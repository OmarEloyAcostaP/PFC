package tafat.engine.social;

import java.util.ArrayList;


public abstract class Recipe {

	protected ArrayList <RecipeLine> recipe;
	protected boolean synchronization;
	
	public RecipeLine getRecipeLine (int line){
		return recipe.get(line);
	}
	
	public int getRecipeLenght(){
		return recipe.size();
	}
	
	public boolean isSynchronized (){
		return synchronization;
	}
	
/*	public void execute(){
		for (RecipeLine recipeLine : recipe){
			executeLine(recipeLine);
		}
	}
	
	private void executeLine(RecipeLine recipeLine) {
		if (recipeLine.powerConsumer == PowerConsumer.class){
			if (recipeLine.startTime == -1){
				if (recipeLine.rangeStartTime.length == 1)
					recipeLine.startTime = recipeLine.rangeStartTime[0];
				else{
					Console.out("Warning, startTime not set, choosing randomly");
					recipeLine.startTime = randomInRangeInt(recipeLine.rangeStartTime[0], recipeLine.rangeStartTime[1]);
				}
			}
			if (recipeLine.durationTime == -1){
				if (recipeLine.rangeDurationTime.length == 1)
					recipeLine.durationTime = recipeLine.rangeDurationTime[0];
				else{
					Console.out("Warning, durationTime not set, choosing randomly");
					recipeLine.durationTime = randomInRangeInt(recipeLine.rangeDurationTime[0], recipeLine.rangeDurationTime[1]);
				}
			}
			sendToExecute(recipeLine);
		}
		else {
			if (recipeLine.powerConsumer == Recipe.class){
				// HANDLING RECURSIVE RECIPES
			}
			else
				Console.error("class is not a PowerConsumer or Recipe");
		}
	}

	private void sendToExecute(RecipeLine recipeLine) {
		if ((recipeLine.powerConsumer == Lighting.class) && (currentPowerConsumer.getClass() == Lighting.class))
			lightingHandling(recipeLine);
		else if ((recipeLine.powerConsumer == ElectricalTools.class) && (currentPowerConsumer.getClass() == ElectricalTools.class))
			electricalToolHandling(recipeLine);
		else if ((recipeLine.powerConsumer == Microwave.class) && (currentPowerConsumer.getClass() == Microwave.class))
			microwaveHandling(recipeLine);
		else
			Console.error("current power consumer does not match with the power consumer of the recipeLine");
	}

	private void microwaveHandling(RecipeLine recipeLine) {
		// TODO Auto-generated method stub
		
	}

	private void electricalToolHandling(RecipeLine recipeLine) {
		// TODO Auto-generated method stub
		
	}

	private void lightingHandling(RecipeLine recipeLine) {
		Lighting lighting = (Lighting) currentPowerConsumer;
		if (recipeLine.startTime == 0){
			lighting.mode = Lighting.Mode.ON;
			double[] intensityRateRange = (double[]) recipeLine.specialHandling;
			lighting.intensityRate = randomInRangeDouble (intensityRateRange[0], intensityRateRange[1]);
		}
		else{
			TimeoutHandler timeoutOn = new TimeoutHandler() {
				
				@Override
				public void execute(Object data) {
					// TODO Auto-generated method stub
					
				}
				
			};
		}
	}

	public void setCurrentPowerConsumer (PowerConsumer powerConsumer){
		currentPowerConsumer = powerConsumer;
	}*/
}
